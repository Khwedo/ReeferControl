package com.oceanbyte.reefercontrol.ui.fragments;

import android.app.AlertDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.models.MalfunctionReport;
import com.oceanbyte.reefercontrol.models.Reefer;
import com.oceanbyte.reefercontrol.models.Alarm;
import com.oceanbyte.reefercontrol.models.ReeferChatMessage;
import com.oceanbyte.reefercontrol.session.UserSession;
import com.oceanbyte.reefercontrol.ui.adapters.AlarmAdapter;
import com.oceanbyte.reefercontrol.ui.adapters.ChatAdapter;
import com.oceanbyte.reefercontrol.utils.DateConverter;
import com.oceanbyte.reefercontrol.viewmodel.ReeferChatViewModel;
import com.oceanbyte.reefercontrol.viewmodel.ReeferChatViewModelFactory;
import com.oceanbyte.reefercontrol.viewmodel.ReeferDetailViewModel;


import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;

public class ReeferDetailFragment extends Fragment {

    private String reeferId;
    private ReeferDetailViewModel viewModel; // ViewModel для получения данных о контейнере
    private ReeferChatViewModel chatViewModel; // ViewModel для получения данных о чате
    private Reefer currentReefer; // Текущий контейнер, загруженный из ViewModel
    // UI поля
    private TextView textContainerNumber, textPosition,
            textLoadingPort, textATD, textDischargePort, textETA, textStatus,
            textSupplyTemp, textReturnTemp, textSetPoint, textLastUpdate,textViewNoAlarms;
    private LinearLayout reportContainer;
    private Button buttonAddAlarm, buttonUpdateTemperature, buttonSendChat;
    private EditText editTextChatMessage;

    private AlarmAdapter alarmAdapter;
    private ChatAdapter chatAdapter;
    private RecyclerView recyclerViewAlarms, recyclerViewChat;
    private String userRole;


    public ReeferDetailFragment() {
        // Обязательный пустой конструктор
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reefer_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Получаем ID из аргументов
        reeferId = getArguments() != null ? getArguments().getString("containerNumber") : null;

        // Привязка UI
        textContainerNumber = view.findViewById(R.id.textContainerNumber);
        textPosition = view.findViewById(R.id.textPosition);
        textLoadingPort = view.findViewById(R.id.textLoadingPort);
        textATD = view.findViewById(R.id.textATD);
        textDischargePort = view.findViewById(R.id.textDischargePort);
        textETA = view.findViewById(R.id.textETA);
        textStatus = view.findViewById(R.id.textStatus);
        textSupplyTemp = view.findViewById(R.id.textSupplyTemp);
        textReturnTemp = view.findViewById(R.id.textReturnTemp);
        textSetPoint = view.findViewById(R.id.textSetPoint);
        textLastUpdate = view.findViewById(R.id.textLastUpdate);
        buttonUpdateTemperature = view.findViewById(R.id.buttonUpdateTemperature);
        textViewNoAlarms = view.findViewById(R.id.textViewNoAlarms);
        recyclerViewAlarms = view.findViewById(R.id.recyclerViewAlarms);
        buttonAddAlarm = view.findViewById(R.id.buttonAddAlarm);
        editTextChatMessage = view.findViewById(R.id.editTextChatMessage);
        buttonSendChat = view.findViewById(R.id.buttonSendChat);
        recyclerViewChat = view.findViewById(R.id.recyclerViewChat);
        reportContainer = view.findViewById(R.id.reportContainer);


        // Инициализация ViewModel
        viewModel = new ViewModelProvider(this).get(ReeferDetailViewModel.class);
        if (reeferId != null && !reeferId.isEmpty()) {
            viewModel.loadReeferById(reeferId);
        } else {
            textContainerNumber.setText("Ошибка: номер контейнера не получен");
            return;
        }
        viewModel.reefer.observe(getViewLifecycleOwner(), reefer -> {
            if (reefer != null) {
                currentReefer = reefer;
                updateUI(reefer);
                // На случай, если роль ещё не подтянули выше
                if (userRole == null) {
                    userRole = UserSession.getInstance().getRole();
                }
                applyRolePermissionsIfReady();
            } else {
                textContainerNumber.setText("Контейнер не найден");
            }
        });

        // Загрузка активных сигнализаций
        AppDatabase db = AppDatabase.getInstance(requireContext());

        Executors.newSingleThreadExecutor().execute(() -> {
            List<Alarm> alarms = db.alarmDao().getActiveAlarmsForReefer(reeferId);
            requireActivity().runOnUiThread(() -> displayAlarms(alarms));
        });

        recyclerViewAlarms.setLayoutManager(new LinearLayoutManager(requireContext()));

        alarmAdapter = new AlarmAdapter();
        recyclerViewAlarms.setAdapter(alarmAdapter);

        alarmAdapter.setOnAlarmClickListener(alarm -> {
            if (alarm.isActive && userRole.equals("ELECTRIC")) {
                navigateToCreateMalfunctionReport(alarm);
            }
        });

        alarmAdapter.setOnAlarmLongClickListener(alarm -> {
            if (alarm.isActive && (userRole.equals("READER") || userRole.equals("ELECTRIC"))) {
                showDeleteDialog(alarm);
            }
        });

        // Загрузка Malfunction репортов для рифера
        Executors.newSingleThreadExecutor().execute(() -> {
            List<MalfunctionReport> reports = AppDatabase.getInstance(requireContext())
                    .malfunctionReportDao()
                    .getByReeferId(reeferId);

            requireActivity().runOnUiThread(() -> displayReports(reports));
        });

        // Загрузка чата
        if (userRole == null) {
            userRole = UserSession.getInstance().getRole();
        }
        chatAdapter = new ChatAdapter();
        recyclerViewChat.setAdapter(chatAdapter);
        recyclerViewChat.setLayoutManager(new LinearLayoutManager(requireContext()));
        ReeferChatViewModelFactory factory = new ReeferChatViewModelFactory(
                AppDatabase.getInstance(requireContext()),
                reeferId
        );
        chatAdapter.setCurrentUserRole(userRole); // userRole — твоя переменная роли пользователя


        chatViewModel = new ViewModelProvider(this, factory).get(ReeferChatViewModel.class);
        chatViewModel.getMessages().observe(getViewLifecycleOwner(), messages -> {
            chatAdapter.setMessages(messages);
            recyclerViewChat.scrollToPosition(messages.size() - 1); // автоскролл вниз

            Executors.newSingleThreadExecutor().execute(() -> {
                for (ReeferChatMessage msg : messages) {
                    if (!msg.senderRole.equals(userRole) &&
                            (msg.readBy == null || !msg.readBy.contains(userRole))) {

                        if (msg.readBy == null) {
                            msg.readBy = userRole;
                        } else {
                            msg.readBy += "," + userRole;
                        }

                        AppDatabase.getInstance(requireContext()).reeferChatDao().update(msg);
                    }
                }
            });
        });


        buttonSendChat.setOnClickListener(v -> {
            String messageText = editTextChatMessage.getText().toString().trim();
            if (!messageText.isEmpty()) {
                chatViewModel.sendMessage(reeferId, userRole, messageText);
                editTextChatMessage.setText("");
            }
        });



    }

    private void updateUI(Reefer reefer) {
        if (reefer != null) {
            currentReefer = reefer; // Сохраняем текущий контейнер
            textContainerNumber.setText("Container: " + reefer.containerNumber); // Отображаем номер контейнера
            textPosition.setText("Position: " + reefer.position);
            textLoadingPort.setText("Loading Port: " + reefer.loadingPort);
            textATD.setText("ATD: " + reefer.atd);
            textDischargePort.setText("Discharge Port: " + reefer.dischargePort);
            textETA.setText("ETA: " + reefer.eta);

            textStatus.setText("Status: " + reefer.status);
            textSupplyTemp.setText("Supply: " + reefer.temperatureSupply + "°C");
            textReturnTemp.setText("Return: " + reefer.temperatureReturn + "°C");
            textSetPoint.setText("Set Point: " + reefer.setPoint + "°C");
            textLastUpdate.setText("Last update: " + reefer.lastTemperatureUpdate + ", By: " + reefer.updatedBy);


            // Цвет по статусу
            int color;
            switch (reefer.status.toUpperCase()) {
                case "WARNING":
                    color = requireContext().getColor(android.R.color.holo_orange_dark);
                    break;
                case "DANGER":
                    color = requireContext().getColor(android.R.color.holo_red_dark);
                    break;
                default:
                    color = requireContext().getColor(android.R.color.holo_green_dark);
                    break;
            }
            textStatus.setTextColor(color);

        } else {
            textContainerNumber.setText("Контейнер не найден");
        }
    }
    // Метод для отображения активных сигнализаций

    private void displayAlarms(List<Alarm> alarms) {
        alarmAdapter.setAlarmList(alarms);
        if (alarms == null || alarms.isEmpty()) {
            textViewNoAlarms.setVisibility(View.VISIBLE);
        } else {
            textViewNoAlarms.setVisibility(View.GONE);
        }
    }
    // Метод для отображения диалога добавления новой сигнализации
    // Здесь пользователь может ввести код сигнализации и описание
    // После добавления сигнализация сразу же отображается в списке
    private void showAddAlarmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Add Alarm");

        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_alarm, null);
        EditText editCode = dialogView.findViewById(R.id.editAlarmCode);
        EditText editDesc = dialogView.findViewById(R.id.editAlarmDescription);

        builder.setView(dialogView);
        builder.setPositiveButton("Add", (dialog, which) -> {
            String code = editCode.getText().toString().trim();
            String desc = editDesc.getText().toString().trim();

            if (!code.isEmpty()) {
                Alarm alarm = new Alarm();
                alarm.reeferId = reeferId;
                alarm.alarmCode = code;
                alarm.description = desc;
                alarm.isActive = true;
                alarm.createdAt = getCurrentDateTime();
                alarm.createdBy = UserSession.getInstance().getRole();

                Executors.newSingleThreadExecutor().execute(() -> {
                    AppDatabase.getInstance(requireContext()).alarmDao().insert(alarm);
                    List<Alarm> updated = AppDatabase.getInstance(requireContext())
                            .alarmDao().getActiveAlarmsForReefer(reeferId);
                    updateReeferStatusIfNeeded(currentReefer);
                    requireActivity().runOnUiThread(() -> displayAlarms(updated));
                });
                Toast.makeText(requireContext(), "Введите код тревоги", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
    // Метод для применения разрешений в зависимости от роли пользователя
    private void applyRolePermissionsIfReady() {
        if (userRole == null || currentReefer == null) {
            Log.d("ROLE_CHECK", "Ожидаем: userRole=" + userRole + ", currentReefer=" + currentReefer);
            return;
        }

        Log.d("ROLE_CHECK", "Права применяются: " + userRole);

        if (userRole != null) {
            switch (userRole.toUpperCase()) {
                case "READER":
                    buttonAddAlarm.setVisibility(View.VISIBLE);
                    buttonAddAlarm.setOnClickListener(v -> showAddAlarmDialog());
                    buttonUpdateTemperature.setVisibility(View.VISIBLE);
                    buttonUpdateTemperature.setOnClickListener(v -> showUpdateTemperatureDialog());
                    break;
                case "ELECTRIC":
                    buttonAddAlarm.setVisibility(View.VISIBLE);
                    buttonAddAlarm.setOnClickListener(v -> showAddAlarmDialog());
                    buttonUpdateTemperature.setVisibility(View.VISIBLE);
                    buttonUpdateTemperature.setOnClickListener(v -> showUpdateTemperatureDialog());
                    break;
                default:
                    buttonAddAlarm.setVisibility(View.GONE);
                    buttonUpdateTemperature.setVisibility(View.GONE);
                    break;
            }
        } else {
            buttonAddAlarm.setVisibility(View.GONE);
        }
    }
    private void displayReports(List<MalfunctionReport> reports) {
        reportContainer.removeAllViews();

        if (reports.isEmpty()) {
            TextView empty = new TextView(requireContext());
            empty.setText("No malfunction reports.");
            empty.setTextColor(getResources().getColor(android.R.color.darker_gray));
            reportContainer.addView(empty);
            return;
        }

        for (MalfunctionReport report : reports) {
            TextView reportView = new TextView(requireContext());

            String formattedDate = DateConverter.fromDate(report.createdAt);
            reportView.setText("🛠 Report #" + report.reportNumber + "\n" +
                    "Created: " + formattedDate);
            reportView.setTextSize(14f);
            reportView.setPadding(0, 8, 0, 8);

            reportView.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putLong("reportId", report.id);  // Передаём ID отчёта
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_reeferDetailFragment_to_malfunctionReportDetailFragment, bundle);
            });

            reportContainer.addView(reportView);
        }
    }

    private void navigateToCreateMalfunctionReport(Alarm alarm) {
        Bundle bundle = new Bundle();
        bundle.putString("containerNumber", reeferId);
        bundle.putString("alarmCode", alarm.alarmCode);
        bundle.putString("alarmDescription", alarm.description);

        NavHostFragment.findNavController(this)
                .navigate(R.id.action_reeferDetail_to_malfunctionReport, bundle);
    }

    private void showDeleteDialog(Alarm alarm) {
        new AlertDialog.Builder(requireContext())
                .setTitle("Удалить тревогу?")
                .setMessage(alarm.alarmCode + ": " + alarm.description)
                .setPositiveButton("Удалить", (dialog, which) -> {
                    Executors.newSingleThreadExecutor().execute(() -> {
                        AppDatabase.getInstance(requireContext()).alarmDao().delete(alarm);
                        List<Alarm> updated = AppDatabase.getInstance(requireContext())
                                .alarmDao().getActiveAlarmsForReefer(reeferId);
                        requireActivity().runOnUiThread(() -> displayAlarms(updated));
                    });
                })
                .setNegativeButton("Отмена", null)
                .show();
    }
    private void showUpdateTemperatureDialog() {
        View dialogView = LayoutInflater.from(requireContext())
                .inflate(R.layout.dialog_update_temperature, null);

        EditText editSupply = dialogView.findViewById(R.id.editSupplyTemp);
        EditText editReturn = dialogView.findViewById(R.id.editReturnTemp);
        EditText editSetPoint = dialogView.findViewById(R.id.editSetPoint);

        // Показываем текущие значения (преобразуем double → String)
        editSupply.setText(String.valueOf(currentReefer.temperatureSupply));
        editReturn.setText(String.valueOf(currentReefer.temperatureReturn));
        editSetPoint.setText(String.valueOf(currentReefer.setPoint));

        new AlertDialog.Builder(requireContext())
                .setTitle("Update Temperatures")
                .setView(dialogView)
                .setPositiveButton("Save", (dialog, which) -> {
                    String newSupplyStr = editSupply.getText().toString().trim();
                    String newReturnStr = editReturn.getText().toString().trim();
                    String newSetPointStr = editSetPoint.getText().toString().trim();

                    if (!newSupplyStr.isEmpty() && !newReturnStr.isEmpty() && !newSetPointStr.isEmpty()) {
                        try {
                            double newSupply = Double.parseDouble(newSupplyStr);
                            double newReturn = Double.parseDouble(newReturnStr);
                            double newSetPoint = Double.parseDouble(newSetPointStr);

                            currentReefer.temperatureSupply = newSupply;
                            currentReefer.temperatureReturn = newReturn;
                            currentReefer.setPoint = newSetPoint;
                            currentReefer.lastTemperatureUpdate = getCurrentDateTime();
                            currentReefer.updatedBy = UserSession.getInstance().getRole();

                            Executors.newSingleThreadExecutor().execute(() -> {
                                AppDatabase.getInstance(requireContext())
                                        .reeferDao()
                                        .update(currentReefer);

                                updateReeferStatusIfNeeded(currentReefer); // 👈 логика пересчёта статуса

                                requireActivity().runOnUiThread(() -> updateUI(currentReefer));
                            });

                        } catch (NumberFormatException e) {
                            Toast.makeText(requireContext(), "Введите корректные числовые значения", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(requireContext(), "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        return sdf.format(new Date());
    }
    private void updateReeferStatusIfNeeded(Reefer currentReefer) {
        Executors.newSingleThreadExecutor().execute(() -> {
            AppDatabase db = AppDatabase.getInstance(requireContext());
            Reefer reefer = db.reeferDao().getByIdNow(reeferId); // ⚠️ создать метод getByIdNow(String id)

            if (reefer == null) return;

            boolean hasActiveAlarms = db.alarmDao().hasActiveAlarms(reeferId); // ⚠️ создать метод
            String newStatus;

            if (hasActiveAlarms) {
                newStatus = "DANGER";
            } else if (reefer.temperatureSupply < reefer.setPoint) {
                newStatus = "WARNING";
            } else {
                newStatus = "NORMAL";
            }

            if (!newStatus.equals(reefer.status)) {
                reefer.status = newStatus;
                db.reeferDao().update(reefer); // ⚠️ убедись, что update() есть
            }
        });
    }
}

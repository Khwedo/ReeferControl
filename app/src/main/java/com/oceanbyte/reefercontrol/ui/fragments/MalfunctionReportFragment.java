package com.oceanbyte.reefercontrol.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.models.MalfunctionReport;
import com.oceanbyte.reefercontrol.session.UserSession;

import java.util.Date;
import java.util.concurrent.Executors;

public class MalfunctionReportFragment extends Fragment {

    private String containerNumber;

    private EditText editTempBefore, editPressureBefore, editHumidityBefore;
    private EditText editTempAfter, editPressureAfter, editHumidityAfter;
    private EditText editSpareParts, editNotes, editTextAlarm;
    private CheckBox checkExport;

    private String alarmCodeFromIntent = null;
    private String alarmDescriptionFromIntent = null;
    private Button buttonSave;

    public MalfunctionReportFragment() {}



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_malfunction_report, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        containerNumber = getArguments() != null ? getArguments().getString("containerNumber") : null;

        if (TextUtils.isEmpty(containerNumber)) {
            Toast.makeText(requireContext(), "Container number is missing", Toast.LENGTH_LONG).show();
            return;
        }

        // Привязка UI
        editTempBefore = view.findViewById(R.id.editTempBefore);
        editPressureBefore = view.findViewById(R.id.editPressureBefore);
        editHumidityBefore = view.findViewById(R.id.editHumidityBefore);

        editTempAfter = view.findViewById(R.id.editTempAfter);
        editPressureAfter = view.findViewById(R.id.editPressureAfter);
        editHumidityAfter = view.findViewById(R.id.editHumidityAfter);

        editTextAlarm = view.findViewById(R.id.editTextAlarm);
        editSpareParts = view.findViewById(R.id.editSpareParts);
        editNotes = view.findViewById(R.id.editNotes);

        checkExport = view.findViewById(R.id.checkExport);
        buttonSave = view.findViewById(R.id.buttonSaveReport);

        buttonSave.setOnClickListener(v -> saveReport());

        long reportId = getArguments() != null ? getArguments().getLong("reportId", -1) : -1;
        if (reportId != -1) {
            // загрузить отчет по reportId
        }

        // прикрепить Аларм к отчету и удалить со списка
        if (getArguments() != null) {
            containerNumber = getArguments().getString("containerNumber");
            alarmCodeFromIntent = getArguments().getString("alarmCode");
            alarmDescriptionFromIntent = getArguments().getString("alarmDescription");

            if (alarmCodeFromIntent != null && alarmDescriptionFromIntent != null) {
                // Автозаполнение
                editTextAlarm.setText(alarmCodeFromIntent + ": " + alarmDescriptionFromIntent);
            }
        }

    }

    private void saveReport() {
        MalfunctionReport report = new MalfunctionReport();
        report.reeferId = containerNumber;
        report.createdAt = new Date();
        report.reportNumber = "MR-" + System.currentTimeMillis();

        try {
            report.tempBefore = parseFloat(editTempBefore.getText().toString());
            report.pressureBefore = parseFloat(editPressureBefore.getText().toString());
            report.humidityBefore = parseFloat(editHumidityBefore.getText().toString());

            report.tempAfter = parseFloat(editTempAfter.getText().toString());
            report.pressureAfter = parseFloat(editPressureAfter.getText().toString());
            report.humidityAfter = parseFloat(editHumidityAfter.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(requireContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        report.sparePartsUsed = editSpareParts.getText().toString().trim();
        report.notes = editNotes.getText().toString().trim();
        report.exportToFinalReport = checkExport.isChecked();

        Executors.newSingleThreadExecutor().execute(() -> {
            report.createdBy = UserSession.getInstance().getFullName();
            AppDatabase.getInstance(requireContext())
                    .malfunctionReportDao()
                    .insert(report);

            if (alarmCodeFromIntent != null && containerNumber != null) {
                AppDatabase.getInstance(requireContext())
                        .alarmDao()
                        .deleteByReeferIdAndCode(containerNumber, alarmCodeFromIntent);
            }

            requireActivity().runOnUiThread(() -> {
                Toast.makeText(requireContext(), "Report saved", Toast.LENGTH_SHORT).show();
                requireActivity().onBackPressed(); // Возврат назад
            });
        });
    }

    private Float parseFloat(String value) throws NumberFormatException {
        return TextUtils.isEmpty(value) ? null : Float.parseFloat(value);
    }
}

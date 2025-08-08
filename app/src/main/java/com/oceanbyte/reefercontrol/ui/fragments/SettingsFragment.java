package com.oceanbyte.reefercontrol.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.models.SparePartStock;
import com.oceanbyte.reefercontrol.session.UserSession;

import java.io.InputStream;
import java.util.concurrent.Executors;

public class SettingsFragment extends Fragment {

    private TextView textUsername, textRole;
    private Button buttonLogout, importButton;

    private static final int REQUEST_CODE_IMPORT_SPARE_PARTS = 101;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        textUsername = view.findViewById(R.id.textUsername);
        textRole = view.findViewById(R.id.textRole);
        importButton = view.findViewById(R.id.buttonImportSpareParts);
        buttonLogout = view.findViewById(R.id.buttonLogout);

        UserSession session = UserSession.getInstance();
        textUsername.setText("Имя: " + session.getFullName());
        textRole.setText("Роль: " + session.getRole());

        // Кнопка импорта запчастей
        importButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            startActivityForResult(intent, REQUEST_CODE_IMPORT_SPARE_PARTS);
        });

        buttonLogout.setOnClickListener(v -> {
            UserSession.getInstance().logout(requireContext());
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_settings_to_login);
        });

        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_IMPORT_SPARE_PARTS && resultCode == Activity.RESULT_OK && data != null) {
            Uri uri = data.getData();
            if (uri != null) {
                importSparePartsFromExcel(uri);
            }
        }
    }

    private void importSparePartsFromExcel(Uri uri) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try (InputStream inputStream = requireContext().getContentResolver().openInputStream(uri)) {
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(0);

                AppDatabase db = AppDatabase.getInstance(requireContext());
                for (Row row : sheet) {
                    if (row.getRowNum() == 0) continue; // skip header

                    SparePartStock part = new SparePartStock();
                    part.maker = row.getCell(0).getStringCellValue();
                    part.model = row.getCell(1).getStringCellValue();
                    part.partNumber = row.getCell(2).getStringCellValue();
                    part.description = row.getCell(3).getStringCellValue();
                    part.quantity = (int) row.getCell(4).getNumericCellValue();

                    db.sparePartStockDao().insert(part);
                }

                requireActivity().runOnUiThread(() ->
                        Toast.makeText(requireContext(), "Импорт завершён", Toast.LENGTH_SHORT).show()
                );
            } catch (Exception e) {
                requireActivity().runOnUiThread(() ->
                        Toast.makeText(requireContext(), "Ошибка импорта: " + e.getMessage(), Toast.LENGTH_LONG).show()
                );
            }
        });
    }
}
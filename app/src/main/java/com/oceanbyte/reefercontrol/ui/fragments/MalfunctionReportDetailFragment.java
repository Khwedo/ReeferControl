package com.oceanbyte.reefercontrol.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.oceanbyte.reefercontrol.session.UserSession;


import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.models.MalfunctionReport;
import com.oceanbyte.reefercontrol.viewmodel.MalfunctionReportDetailViewModel;

public class MalfunctionReportDetailFragment extends Fragment {

    private MalfunctionReportDetailViewModel viewModel;
    private long reportId;
    private String userRole;
    private MalfunctionReport currentReport;

    private EditText editTempBefore, editTempAfter, editSpareParts, editNotes;
    private Button buttonSave;

    public MalfunctionReportDetailFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_malfunction_report_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        userRole = UserSession.getInstance().getRole();

        reportId = getArguments() != null ? getArguments().getLong("reportId", -1) : -1;
        if (reportId == -1) {
            Toast.makeText(requireContext(), "Invalid report ID", Toast.LENGTH_SHORT).show();
            return;
        }



        editTempBefore = view.findViewById(R.id.editTempBefore);
        editTempAfter = view.findViewById(R.id.editTempAfter);
        editSpareParts = view.findViewById(R.id.editSparePartsUsed);
        editNotes = view.findViewById(R.id.editNotes);
        buttonSave = view.findViewById(R.id.buttonSaveReportChanges);

        viewModel = new ViewModelProvider(this).get(MalfunctionReportDetailViewModel.class);
        viewModel.report.observe(getViewLifecycleOwner(), report -> {
            if (report != null) {
                currentReport = report;
                applyRolePermissions();
                fillForm(report);

            }
        });

        viewModel.loadById(reportId);

        buttonSave.setOnClickListener(v -> {
            if (currentReport != null) {
                currentReport.tempBefore = parseFloat(editTempBefore.getText().toString());
                currentReport.tempAfter = parseFloat(editTempAfter.getText().toString());
                currentReport.sparePartsUsed = editSpareParts.getText().toString();
                currentReport.notes = editNotes.getText().toString();

                viewModel.saveChanges(currentReport);
                Toast.makeText(requireContext(), "Report updated", Toast.LENGTH_SHORT).show();
                requireActivity().onBackPressed();
            }
        });
    }

    private void fillForm(MalfunctionReport report) {
        editTempBefore.setText(String.valueOf(report.tempBefore != null ? report.tempBefore : ""));
        editTempAfter.setText(String.valueOf(report.tempAfter != null ? report.tempAfter : ""));
        editSpareParts.setText(report.sparePartsUsed != null ? report.sparePartsUsed : "");
        editNotes.setText(report.notes != null ? report.notes : "");
    }

    private Float parseFloat(String value) {
        try {
            return Float.parseFloat(value);
        } catch (Exception e) {
            return null;
        }
    }

    private void applyRolePermissions() {
        if (!"ELECTRIC".equalsIgnoreCase(userRole)) {
            // Блокируем редактирование
            editTempBefore.setEnabled(false);
            editTempAfter.setEnabled(false);
            editSpareParts.setEnabled(false);
            editNotes.setVisibility(View.GONE);
            buttonSave.setVisibility(View.GONE);
        }
    }
}
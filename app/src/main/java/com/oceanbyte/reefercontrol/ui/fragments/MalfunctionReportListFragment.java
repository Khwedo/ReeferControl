package com.oceanbyte.reefercontrol.ui.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.*;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.*;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.models.MalfunctionReport;
import com.oceanbyte.reefercontrol.viewmodel.MalfunctionReportListViewModel;
import com.oceanbyte.reefercontrol.ui.adapters.MalfunctionReportAdapter;

import java.util.*;

public class MalfunctionReportListFragment extends Fragment {

    private MalfunctionReportListViewModel viewModel;
    private MalfunctionReportAdapter adapter;
    private EditText searchInput;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_malfunction_report_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MalfunctionReportListViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerMalfunctionReports);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new MalfunctionReportAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.reports.observe(getViewLifecycleOwner(), adapter::setReports);

        searchInput = view.findViewById(R.id.editSearchReports);
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.searchReports(s.toString().trim());
            }
        });

        viewModel.loadAllReports();
    }

}

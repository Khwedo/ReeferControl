package com.oceanbyte.reefercontrol.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.models.Reefer;
import com.oceanbyte.reefercontrol.ui.adapters.ReeferAdapter;
import com.oceanbyte.reefercontrol.viewmodel.ReeferListViewModel;

import java.util.List;

public class ReeferListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ReeferAdapter adapter;
    private ReeferListViewModel viewModel;

    public ReeferListFragment() {
        // Пустой конструктор по требованию Android
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reefer_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerReefers);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new ReeferAdapter();
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(ReeferListViewModel.class);
        viewModel.reefers.observe(getViewLifecycleOwner(), this::updateList);

        // Логика поиска
        EditText editSearch = view.findViewById(R.id.editSearch);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.search(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        // Обработка клика по элементу списка
        adapter.setOnItemClickListener(reefer -> {
            Bundle args = new Bundle();
            args.putString("containerNumber", reefer.containerNumber);
            Navigation.findNavController(view).navigate(R.id.action_reeferList_to_reeferDetail, args);
        });
    }

    private void updateList(List<Reefer> reefers) {
        adapter.submitList(reefers);
    }
}
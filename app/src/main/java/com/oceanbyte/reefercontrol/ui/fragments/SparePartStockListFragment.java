package com.oceanbyte.reefercontrol.ui.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.models.SparePartStock;
import com.oceanbyte.reefercontrol.ui.adapters.SparePartStockAdapter;
import com.oceanbyte.reefercontrol.viewmodel.SparePartStockListViewModel;
import com.oceanbyte.reefercontrol.viewmodel.SparePartStockListViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class SparePartStockListFragment extends Fragment {

    private SparePartStockListViewModel viewModel;
    private SparePartStockAdapter adapter;
    private EditText editTextSearch;
    private Spinner spinnerMaker, spinnerModel;

    public SparePartStockListFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spare_part_stock_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        AppDatabase db = AppDatabase.getInstance(requireContext());
        SparePartStockListViewModelFactory factory = new SparePartStockListViewModelFactory(db);

        viewModel = new ViewModelProvider(this, factory)
                .get(SparePartStockListViewModel.class);

        editTextSearch = view.findViewById(R.id.editTextSearch);
        spinnerMaker = view.findViewById(R.id.spinnerMaker);
        spinnerModel = view.findViewById(R.id.spinnerModel);
        Button buttonAdd = view.findViewById(R.id.buttonAddSparePart);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewSpareParts);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new SparePartStockAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(part -> {
            Bundle bundle = new Bundle();
            bundle.putLong("partId", part.id);
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_sparePartStockListFragment_to_sparePartStockDetailFragment, bundle);
        });

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setQuery(s.toString());
            }
            @Override public void afterTextChanged(Editable s) {}
        });

        viewModel.getFilteredParts().observe(getViewLifecycleOwner(), parts -> {
            adapter.setParts(parts);
        });

        // Подгружаем значения Maker

        db.sparePartStockDao().getAllMakers().observe(getViewLifecycleOwner(), makers -> {
            List<String> makerList = new ArrayList<>();
            makerList.add("All"); // добавляем "All" первым
            makerList.addAll(makers);


            ArrayAdapter<String> makerAdapter = new ArrayAdapter<>(requireContext(),
                    android.R.layout.simple_spinner_item, makerList);
            makerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerMaker.setAdapter(makerAdapter);

            spinnerMaker.setSelection(0); // выбираем "All" по умолчанию
        });



        // Подгружаем Model при выборе Maker
        spinnerMaker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedMaker = (String) spinnerMaker.getSelectedItem();

                if (!selectedMaker.equals("All")) {
                viewModel.setMakerFilter(selectedMaker);

                db.sparePartStockDao().getModelsForMaker(selectedMaker)
                        .observe(getViewLifecycleOwner(), models -> {
                            List<String> modelList = new ArrayList<>();
                            modelList.add("All");
                            modelList.addAll(models);


                            ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(requireContext(),
                                    android.R.layout.simple_spinner_item, modelList);
                            modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinnerModel.setAdapter(modelAdapter);
                            spinnerModel.setSelection(0);
                        });
                } else {
                    viewModel.setMakerFilter(""); // пустая строка = все
                    viewModel.setModelFilter(""); // сброс модели
                    spinnerModel.setAdapter(null); // обнуляем модели
                }
            }

            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinnerModel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedModel = (String) spinnerModel.getSelectedItem();
                if (!selectedModel.equals("All")) {
                viewModel.setModelFilter(selectedModel);
                } else {
                    viewModel.setModelFilter(""); // "" значит "все"
                }
            }

            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        buttonAdd.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_sparePartStockListFragment_to_sparePartStockDetailFragment);
        });
    }
}

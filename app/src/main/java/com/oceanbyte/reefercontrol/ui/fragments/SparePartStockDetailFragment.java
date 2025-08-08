package com.oceanbyte.reefercontrol.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.models.SparePartStock;

import java.util.concurrent.Executors;

public class SparePartStockDetailFragment extends Fragment {

    private EditText editMaker, editModel, editPartNumber, editDescription, editQuantity;
    private Button buttonSave, buttonDelete;

    private long partId = -1;
    private SparePartStock currentPart;

    public SparePartStockDetailFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spare_part_stock_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        editMaker = view.findViewById(R.id.editMaker);
        editModel = view.findViewById(R.id.editModel);
        editPartNumber = view.findViewById(R.id.editPartNumber);
        editDescription = view.findViewById(R.id.editDescription);
        editQuantity = view.findViewById(R.id.editQuantity);
        buttonSave = view.findViewById(R.id.buttonSaveSparePart);
        buttonDelete = view.findViewById(R.id.buttonDeleteSparePart);

        AppDatabase db = AppDatabase.getInstance(requireContext());

        if (getArguments() != null && getArguments().containsKey("partId")) {
            partId = getArguments().getLong("partId");
        }

        if (partId != 0) {
            // Редактирование
            db.sparePartStockDao().getById(partId).observe(getViewLifecycleOwner(), part -> {
                if (part != null) {
                    currentPart = part;
                    editMaker.setText(part.maker);
                    editModel.setText(part.model);
                    editPartNumber.setText(part.partNumber);
                    editDescription.setText(part.description);
                    editQuantity.setText(String.valueOf(part.quantity));
                }
            });
            buttonDelete.setVisibility(View.VISIBLE);
        } else {
            // Новый элемент
            currentPart = null;
            buttonDelete.setVisibility(View.GONE);
        }

        buttonSave.setOnClickListener(v -> {
            String maker = editMaker.getText().toString().trim();
            String model = editModel.getText().toString().trim();
            String partNumber = editPartNumber.getText().toString().trim();
            String description = editDescription.getText().toString().trim();
            int quantity = TextUtils.isEmpty(editQuantity.getText()) ? 0 :
                    Integer.parseInt(editQuantity.getText().toString());

            if (maker.isEmpty() || model.isEmpty() || partNumber.isEmpty() || description.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            SparePartStock part = new SparePartStock();
            part.id = partId;
            part.maker = maker;
            part.model = model;
            part.partNumber = partNumber;
            part.description = description;
            part.quantity = quantity;

            Executors.newSingleThreadExecutor().execute(() -> {
                db.sparePartStockDao().insert(part);
                requireActivity().runOnUiThread(() -> {
                    Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(this).popBackStack();
                });
            });
        });

        buttonDelete.setOnClickListener(v -> {
            if (currentPart == null) return;
            Executors.newSingleThreadExecutor().execute(() -> {
                db.sparePartStockDao().delete(currentPart);
                requireActivity().runOnUiThread(() -> {
                    Toast.makeText(requireContext(), "Deleted", Toast.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(this).popBackStack();
                });
            });
        });
    }
}
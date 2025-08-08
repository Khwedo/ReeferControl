package com.oceanbyte.reefercontrol.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.oceanbyte.reefercontrol.database.AppDatabase;

public class SparePartStockListViewModelFactory implements ViewModelProvider.Factory {

    private final AppDatabase database;

    public SparePartStockListViewModelFactory(AppDatabase database) {
        this.database = database;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SparePartStockListViewModel.class)) {
            return (T) new SparePartStockListViewModel(database);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
package com.oceanbyte.reefercontrol.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.oceanbyte.reefercontrol.database.AppDatabase;

public class ReeferChatViewModelFactory implements ViewModelProvider.Factory {

    private final AppDatabase database;
    private final String reeferId;

    public ReeferChatViewModelFactory(AppDatabase database, String reeferId) {
        this.database = database;
        this.reeferId = reeferId;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ReeferChatViewModel.class)) {
            return (T) new ReeferChatViewModel(database, reeferId);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

package com.oceanbyte.reefercontrol.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.database.dao.ReeferDao;
import com.oceanbyte.reefercontrol.models.Reefer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReeferListViewModel extends AndroidViewModel {

    private final ReeferDao reeferDao;
    private final ExecutorService executorService;

    private final MutableLiveData<List<Reefer>> _reefers = new MutableLiveData<>();
    public LiveData<List<Reefer>> reefers = _reefers;

    public ReeferListViewModel(@NonNull Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(application);
        reeferDao = db.reeferDao();
        executorService = Executors.newSingleThreadExecutor();
        loadAllReefers();
    }

    /**
     * Загружает все активные контейнеры
     */
    public void loadAllReefers() {
        executorService.execute(() -> {
            List<Reefer> list = reeferDao.getActiveReefers();
            _reefers.postValue(list);
        });
    }

    /**
     * Поиск по номеру контейнера
     */
    public void search(String query) {
        executorService.execute(() -> {
            if (query == null || query.trim().isEmpty()) {
                loadAllReefers();
            } else {
                String searchQuery = "%" + query.trim() + "%";
                List<Reefer> filtered = reeferDao.searchByContainerOrPosition(searchQuery);
                _reefers.postValue(filtered);
            }
        });
    }

    /**
     * Очистка списка (например, при сбросе фильтра)
     */
    public void clearList() {
        _reefers.setValue(new ArrayList<>());
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        executorService.shutdown();
    }
}
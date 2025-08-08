package com.oceanbyte.reefercontrol.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.database.dao.AlarmDao;
import com.oceanbyte.reefercontrol.database.dao.ReeferDao;
import com.oceanbyte.reefercontrol.models.Alarm;
import com.oceanbyte.reefercontrol.models.Reefer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReeferDetailViewModel extends AndroidViewModel {

    private final ReeferDao reeferDao;
    private final ExecutorService executorService;

    private final MutableLiveData<Reefer> _reefer = new MutableLiveData<>();
    public LiveData<Reefer> reefer = _reefer;

    public ReeferDetailViewModel(@NonNull Application application) {
        super(application);
        AppDatabase db = AppDatabase.getInstance(application);
        reeferDao = db.reeferDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void loadReeferById(String containerNumber) {
        executorService.execute(() -> {
            Reefer found = reeferDao.getByContainerNumber(containerNumber);
            _reefer.postValue(found);
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        executorService.shutdown();
    }


}

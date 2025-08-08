package com.oceanbyte.reefercontrol.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.database.dao.MalfunctionReportDao;
import com.oceanbyte.reefercontrol.models.MalfunctionReport;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MalfunctionReportDetailViewModel extends AndroidViewModel {

    private final MalfunctionReportDao reportDao;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private final MutableLiveData<MalfunctionReport> _report = new MutableLiveData<>();
    public LiveData<MalfunctionReport> report = _report;

    public MalfunctionReportDetailViewModel(@NonNull Application application) {
        super(application);
        reportDao = AppDatabase.getInstance(application).malfunctionReportDao();
    }

    public void loadById(long reportId) {
        executor.execute(() -> {
            MalfunctionReport result = reportDao.getById(reportId);
            _report.postValue(result);
        });
    }

    public void saveChanges(MalfunctionReport updated) {
        executor.execute(() -> reportDao.update(updated));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        executor.shutdown();
    }
}

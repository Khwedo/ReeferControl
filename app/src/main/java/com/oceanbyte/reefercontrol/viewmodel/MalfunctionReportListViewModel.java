package com.oceanbyte.reefercontrol.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.models.relations.MalfunctionReportWithReefer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MalfunctionReportListViewModel extends AndroidViewModel {

    private final AppDatabase db;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private final MutableLiveData<List<MalfunctionReportWithReefer>> _reports = new MutableLiveData<>();
    public LiveData<List<MalfunctionReportWithReefer>> reports = _reports;

    public MalfunctionReportListViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getInstance(application);
    }

    public void loadAllReports() {
        executor.execute(() -> {
            List<MalfunctionReportWithReefer> all = db.malfunctionReportDao().getAllWithReefer();
            _reports.postValue(all);
        });
    }

    public void searchReports(String query) {
        executor.execute(() -> {
            List<MalfunctionReportWithReefer> filtered = db.malfunctionReportDao().searchWithReefer(query);
            _reports.postValue(filtered);
        });
    }

    @Override
    protected void onCleared() {
        executor.shutdown();
        super.onCleared();
    }
}

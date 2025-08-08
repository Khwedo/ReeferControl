package com.oceanbyte.reefercontrol.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.models.SparePartStock;

import java.util.List;

public class SparePartStockListViewModel extends ViewModel {

    private final MutableLiveData<String> query = new MutableLiveData<>("");
    private final MutableLiveData<String> makerFilter = new MutableLiveData<>("");
    private final MutableLiveData<String> modelFilter = new MutableLiveData<>();

    private final MediatorLiveData<List<SparePartStock>> filteredParts = new MediatorLiveData<>();

    private AppDatabase db;

    public SparePartStockListViewModel(AppDatabase database) {
        this.db = database;

        // следим за всеми источниками
        filteredParts.addSource(query, s -> reload());
        filteredParts.addSource(makerFilter, s -> reload());
        filteredParts.addSource(modelFilter, s -> reload());

        // инициализируем
        modelFilter.setValue(""); // изначально тоже "все"
        reload();
    }

    private void reload() {
        String q = query.getValue() != null ? query.getValue() : "";
        String maker = makerFilter.getValue() != null ? makerFilter.getValue() : "";
        String model = modelFilter.getValue() != null ? modelFilter.getValue() : "";

        LiveData<List<SparePartStock>> source;

        if (!maker.isEmpty() && !model.isEmpty()) {
            source = db.sparePartStockDao().filterByMakerAndModel(maker, model);
        } else if (!maker.isEmpty()) {
            source = db.sparePartStockDao().filterByMaker(maker);
        } else if (!q.isEmpty()) {
            source = db.sparePartStockDao().search(q);
        } else {
            source = db.sparePartStockDao().getAll();
        }

        source.observeForever(filteredParts::setValue);
    }

    public LiveData<List<SparePartStock>> getFilteredParts() {
        return filteredParts;
    }

    public void setQuery(String q) {
        query.setValue(q);
    }

    public void setMakerFilter(String maker) {
        makerFilter.setValue(maker);
    }

    public void setModelFilter(String model) {
        modelFilter.setValue(model);
    }
}


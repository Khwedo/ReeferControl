package com.oceanbyte.reefercontrol.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.oceanbyte.reefercontrol.models.SparePartStock;

import java.util.List;

@Dao
public interface SparePartStockDao {
    @Query("SELECT * FROM spare_part_stock ORDER BY description ASC")
    LiveData<List<SparePartStock>> getAll();

    @Query("SELECT * FROM spare_part_stock WHERE description LIKE '%' || :query || '%' OR partNumber LIKE '%' || :query || '%' ORDER BY description")
    LiveData<List<SparePartStock>> search(String query);

    @Query("SELECT DISTINCT maker FROM spare_part_stock ORDER BY maker")
    LiveData<List<String>> getAllMakers();

    @Query("SELECT DISTINCT model FROM spare_part_stock WHERE maker = :maker ORDER BY model")
    LiveData<List<String>> getModelsForMaker(String maker);

    @Query("SELECT * FROM spare_part_stock WHERE maker = :maker ORDER BY description")
    LiveData<List<SparePartStock>> filterByMaker(String maker);
    @Query("SELECT * FROM spare_part_stock WHERE maker = :maker AND model = :model ORDER BY description")
    LiveData<List<SparePartStock>> filterByMakerAndModel(String maker, String model);

    @Query("SELECT * FROM spare_part_stock WHERE id = :id")
    LiveData<SparePartStock> getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SparePartStock part);

    @Update
    void update(SparePartStock part);

    @Delete
    void delete(SparePartStock part);
}

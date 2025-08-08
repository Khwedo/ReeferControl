package com.oceanbyte.reefercontrol.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;

import com.oceanbyte.reefercontrol.models.Reefer;

import java.util.List;

@Dao
public interface ReeferDao {

    // Вставить один или несколько контейнеров
    @Insert
    long insert(Reefer reefer);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Reefer> reefers);

    // Обновить контейнер
    @Update
    int update(Reefer reefer);

    // Удалить контейнер
    @Delete
    int delete(Reefer reefer);

    // Получить все контейнеры
    @Query("SELECT * FROM reefers ORDER BY container_number ASC")
    List<Reefer> getAll();

    // Найти по id
    @Query("SELECT * FROM reefers WHERE container_number = :containerNumber")
    Reefer getByContainerNumber(String containerNumber);

    // Найти по номеру контейнера или позиции
    @Query("SELECT * FROM reefers " +
            "WHERE container_number LIKE :query OR position LIKE :query " +
            "ORDER BY container_number ASC")
    List<Reefer> searchByContainerOrPosition(String query);

    // Получить только активные
    @Query("SELECT * FROM reefers WHERE is_active = 1 ORDER BY container_number ASC")
    List<Reefer> getActiveReefers();

    // Очистить таблицу
    @Query("DELETE FROM reefers")
    void clear();

    @Query("SELECT * FROM reefers ORDER BY container_number")
    LiveData<List<Reefer>> getAllLive();

    @Query("SELECT * FROM reefers WHERE container_number = :containerNumber LIMIT 1")
    Reefer getByIdNow(String containerNumber);
}
package com.oceanbyte.reefercontrol.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;

import com.oceanbyte.reefercontrol.models.Alarm;

import java.util.List;

@Dao
public interface AlarmDao {

    @Insert
    long insert(Alarm alarm);

    @Query("SELECT * FROM alarms WHERE reeferId = :reeferId AND isActive = 1")
    List<Alarm> getActiveAlarmsForReefer(String reeferId);

    @Delete
    void delete(Alarm alarm);
    @Query("DELETE FROM alarms WHERE reeferId = :reeferId AND alarmCode = :alarmCode")
    void deleteByReeferIdAndCode(String reeferId, String alarmCode);

    @Query("SELECT EXISTS(SELECT 1 FROM alarms WHERE reeferId = :reeferId AND isActive = 1)")
    boolean hasActiveAlarms(String reeferId);

}
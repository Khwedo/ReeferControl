package com.oceanbyte.reefercontrol.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.oceanbyte.reefercontrol.models.ReeferChatMessage;

import java.util.List;

@Dao
public interface ReeferChatDao {

    @Query("SELECT * FROM reefer_chat WHERE reeferId = :reeferId ORDER BY timestamp ASC")
    LiveData<List<ReeferChatMessage>> getMessagesForReefer(String reeferId);

    @Insert
    void insert(ReeferChatMessage message);
    @Update
    void update(ReeferChatMessage message);

}
package com.oceanbyte.reefercontrol.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reefer_chat")
public class ReeferChatMessage {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String reeferId; // ID контейнера

    @NonNull
    public String senderRole; // READER, ELECTRIC, MASTER

    @NonNull
    public String message;

    @NonNull
    public String timestamp;

    @Nullable
    public String readBy; // Например: "READER,ELECTRIC"
}

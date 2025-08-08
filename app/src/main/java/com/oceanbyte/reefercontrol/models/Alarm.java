package com.oceanbyte.reefercontrol.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "alarms",
        foreignKeys = @ForeignKey(
                entity = Reefer.class,
                parentColumns = "container_number",
                childColumns = "reeferId",
                onDelete = ForeignKey.CASCADE
        )
)
public class Alarm {

    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(name = "reeferId")
    @NonNull
    public String reeferId; // внешний ключ

    @NonNull
    public String alarmCode; // например, A07, A21

    @Nullable
    public String description;

    public boolean isActive = true;
    @NonNull
    @ColumnInfo(name = "createdAt")
    public String createdAt;

    @NonNull
    @ColumnInfo(name = "createdBy")
    public String createdBy;


}
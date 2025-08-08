package com.oceanbyte.reefercontrol.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "spare_part_stock")
public class SparePartStock {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String maker; // Производитель рифера

    @NonNull
    public String model; // Модель рифера

    @NonNull
    public String partNumber;

    @NonNull
    public String description;

    public int quantity; // Кол-во в наличии
}
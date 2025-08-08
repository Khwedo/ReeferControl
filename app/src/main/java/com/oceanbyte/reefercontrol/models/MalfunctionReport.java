package com.oceanbyte.reefercontrol.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
        tableName = "malfunction_reports",
        foreignKeys = @ForeignKey(
                entity = Reefer.class,
                parentColumns = "container_number",
                childColumns = "reeferId",
                onDelete = ForeignKey.CASCADE
        )
)
public class MalfunctionReport {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String reeferId; // containerNumber из Reefer

    @NonNull
    public String reportNumber; // например, MR-2025-001

    @NonNull
    public Date createdAt = new Date();

    @NonNull
    public String createdBy; // имя или email пользователя

    // Параметры до ремонта
    public Float tempBefore;
    public Float pressureBefore;
    public Float humidityBefore;

    // Параметры после ремонта
    public Float tempAfter;
    public Float pressureAfter;
    public Float humidityAfter;

    // Пути к фотографиям
    public String photoBeforePath;
    public String photoAfterPath;

    // Использованные запчасти
    public String sparePartsUsed;

    // Примечания
    public String notes;

    // Флаг для финального отчета
    public boolean exportToFinalReport = false;
}

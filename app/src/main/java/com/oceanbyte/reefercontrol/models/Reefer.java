package com.oceanbyte.reefercontrol.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "reefers")
public class Reefer {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "container_number")
    public String containerNumber; // Например, MSBU5287981

    @NonNull
    @ColumnInfo(name = "position")
    public String position; // Например, 501882

    @NonNull
    @ColumnInfo(name = "loading_port")
    public String loadingPort;

    @NonNull
    @ColumnInfo(name = "discharge_port")
    public String dischargePort;

    @NonNull
    @ColumnInfo(name = "atd") // Actual Time of Departure
    public String atd;

    @NonNull
    @ColumnInfo(name = "eta") // Estimated Time of Arrival
    public String eta;

    @NonNull
    @ColumnInfo(name = "operator") // Компания/оператор
    public String operator;

    @NonNull
    @ColumnInfo(name = "cargo_type")
    public String cargoType;

    @NonNull
    @ColumnInfo(name = "status") // например: NORMAL / WARNING / DANGER
    public String status;

    @NonNull
    @ColumnInfo(name = "is_active")
    public boolean isActive = true;

    // Поля для расширения функционала временно
    @NonNull
    @ColumnInfo(name = "temperature_supply")
    public double temperatureSupply;

    @NonNull
    @ColumnInfo(name = "temperature_return")
    public double temperatureReturn;

    @NonNull
    @ColumnInfo(name = "set_point")
    public double setPoint;

    @Nullable
    @ColumnInfo(name = "last_temperature_update")
    public String lastTemperatureUpdate;
    @Nullable
    @ColumnInfo(name = "updatedBy")
    public String updatedBy;



    // Возможность добавлять расширенные поля позже (например, location, syncedWithServer и т.п.)

    // Конструктор (если нужно использовать вручную)
    public Reefer(@NonNull String containerNumber,
                  @NonNull String position,
                  @NonNull String loadingPort,
                  @NonNull String dischargePort,
                  @NonNull String atd,
                  @NonNull String eta,
                  @NonNull String operator,
                  @NonNull String cargoType,
                  @NonNull String status,
                  boolean isActive,
                  @NonNull double temperatureSupply,
                  @NonNull double temperatureReturn,
                  @NonNull double setPoint,
                  @Nullable String lastTemperatureUpdate,
                  @Nullable String updatedBy) {
        this.containerNumber = containerNumber;
        this.position = position;
        this.loadingPort = loadingPort;
        this.dischargePort = dischargePort;
        this.atd = atd;
        this.eta = eta;
        this.operator = operator;
        this.cargoType = cargoType;
        this.status = status;
        this.isActive = isActive;
        this.temperatureSupply = temperatureSupply;
        this.temperatureReturn = temperatureReturn;
        this.setPoint = setPoint;
        this.lastTemperatureUpdate = lastTemperatureUpdate;
        this.updatedBy = updatedBy;
    }



    // Пустой конструктор можно опустить, если используем только @Entity + DAO
}
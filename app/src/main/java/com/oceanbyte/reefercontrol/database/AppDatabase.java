package com.oceanbyte.reefercontrol.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.oceanbyte.reefercontrol.database.dao.ReeferChatDao;
import com.oceanbyte.reefercontrol.models.ReeferChatMessage;
import com.oceanbyte.reefercontrol.utils.DateConverter;

import com.oceanbyte.reefercontrol.database.dao.ReeferDao;
import com.oceanbyte.reefercontrol.models.Reefer;
import com.oceanbyte.reefercontrol.models.Alarm;
import com.oceanbyte.reefercontrol.database.dao.AlarmDao;
import com.oceanbyte.reefercontrol.models.UserProfile;
import com.oceanbyte.reefercontrol.database.dao.UserProfileDao;
import com.oceanbyte.reefercontrol.models.MalfunctionReport;
import com.oceanbyte.reefercontrol.database.dao.MalfunctionReportDao;
import com.oceanbyte.reefercontrol.models.SparePartStock;
import com.oceanbyte.reefercontrol.database.dao.SparePartStockDao;


@Database(
        entities = {
                Reefer.class,
                Alarm.class,
                UserProfile.class, // Добавляем UserProfile для хранения информации о пользователе
                MalfunctionReport.class, // Добавляем MalfunctionReport для хранения отчетов о неисправностях
                SparePartStock.class, // Добавляем SparePartStock для хранения отчетов о неисправностях
                ReeferChatMessage.class

                // Добавим другие сущности позже (MalfunctionReport, Alarm и т.д.)
        },
        version = 17,
        exportSchema = false
)
@TypeConverters({ DateConverter.class }) // Конвертеры для работы с типами данных, такими как Date

public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    // DAO-интерфейсы
    public abstract ReeferDao reeferDao(); // DAO для работы с рефрижераторами (reefers)
    public abstract AlarmDao alarmDao(); // DAO для работы с тревогами (alarms)
    public abstract UserProfileDao userProfileDao(); // DAO для работы с профилем пользователя
    public abstract MalfunctionReportDao malfunctionReportDao(); // DAO для работы с отчетами о неисправностях
    public abstract SparePartStockDao sparePartStockDao(); // DAO для работы с складом запчастей

    public abstract ReeferChatDao reeferChatDao(); // DAO для работы с чатом

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "reefer_control.db"
                            )
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
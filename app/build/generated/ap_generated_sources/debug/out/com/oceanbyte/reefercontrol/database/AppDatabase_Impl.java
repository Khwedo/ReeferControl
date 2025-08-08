package com.oceanbyte.reefercontrol.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.oceanbyte.reefercontrol.database.dao.AlarmDao;
import com.oceanbyte.reefercontrol.database.dao.AlarmDao_Impl;
import com.oceanbyte.reefercontrol.database.dao.MalfunctionReportDao;
import com.oceanbyte.reefercontrol.database.dao.MalfunctionReportDao_Impl;
import com.oceanbyte.reefercontrol.database.dao.ReeferChatDao;
import com.oceanbyte.reefercontrol.database.dao.ReeferChatDao_Impl;
import com.oceanbyte.reefercontrol.database.dao.ReeferDao;
import com.oceanbyte.reefercontrol.database.dao.ReeferDao_Impl;
import com.oceanbyte.reefercontrol.database.dao.SparePartStockDao;
import com.oceanbyte.reefercontrol.database.dao.SparePartStockDao_Impl;
import com.oceanbyte.reefercontrol.database.dao.UserProfileDao;
import com.oceanbyte.reefercontrol.database.dao.UserProfileDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ReeferDao _reeferDao;

  private volatile AlarmDao _alarmDao;

  private volatile UserProfileDao _userProfileDao;

  private volatile MalfunctionReportDao _malfunctionReportDao;

  private volatile SparePartStockDao _sparePartStockDao;

  private volatile ReeferChatDao _reeferChatDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(17) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `reefers` (`container_number` TEXT NOT NULL, `position` TEXT NOT NULL, `loading_port` TEXT NOT NULL, `discharge_port` TEXT NOT NULL, `atd` TEXT NOT NULL, `eta` TEXT NOT NULL, `operator` TEXT NOT NULL, `cargo_type` TEXT NOT NULL, `status` TEXT NOT NULL, `is_active` INTEGER NOT NULL, `temperature_supply` REAL NOT NULL, `temperature_return` REAL NOT NULL, `set_point` REAL NOT NULL, `last_temperature_update` TEXT, `updatedBy` TEXT, PRIMARY KEY(`container_number`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `alarms` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `reeferId` TEXT NOT NULL, `alarmCode` TEXT NOT NULL, `description` TEXT, `isActive` INTEGER NOT NULL, `createdAt` TEXT NOT NULL, `createdBy` TEXT NOT NULL, FOREIGN KEY(`reeferId`) REFERENCES `reefers`(`container_number`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_profiles` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `email` TEXT NOT NULL, `password` TEXT NOT NULL, `fullName` TEXT NOT NULL, `role` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `malfunction_reports` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `reeferId` TEXT NOT NULL, `reportNumber` TEXT NOT NULL, `createdAt` TEXT NOT NULL, `createdBy` TEXT NOT NULL, `tempBefore` REAL, `pressureBefore` REAL, `humidityBefore` REAL, `tempAfter` REAL, `pressureAfter` REAL, `humidityAfter` REAL, `photoBeforePath` TEXT, `photoAfterPath` TEXT, `sparePartsUsed` TEXT, `notes` TEXT, `exportToFinalReport` INTEGER NOT NULL, FOREIGN KEY(`reeferId`) REFERENCES `reefers`(`container_number`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `spare_part_stock` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `maker` TEXT NOT NULL, `model` TEXT NOT NULL, `partNumber` TEXT NOT NULL, `description` TEXT NOT NULL, `quantity` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `reefer_chat` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `reeferId` TEXT NOT NULL, `senderRole` TEXT NOT NULL, `message` TEXT NOT NULL, `timestamp` TEXT NOT NULL, `readBy` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9d48ef0a89401a93e38376c839ed054a')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `reefers`");
        db.execSQL("DROP TABLE IF EXISTS `alarms`");
        db.execSQL("DROP TABLE IF EXISTS `user_profiles`");
        db.execSQL("DROP TABLE IF EXISTS `malfunction_reports`");
        db.execSQL("DROP TABLE IF EXISTS `spare_part_stock`");
        db.execSQL("DROP TABLE IF EXISTS `reefer_chat`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsReefers = new HashMap<String, TableInfo.Column>(15);
        _columnsReefers.put("container_number", new TableInfo.Column("container_number", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("position", new TableInfo.Column("position", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("loading_port", new TableInfo.Column("loading_port", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("discharge_port", new TableInfo.Column("discharge_port", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("atd", new TableInfo.Column("atd", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("eta", new TableInfo.Column("eta", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("operator", new TableInfo.Column("operator", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("cargo_type", new TableInfo.Column("cargo_type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("is_active", new TableInfo.Column("is_active", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("temperature_supply", new TableInfo.Column("temperature_supply", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("temperature_return", new TableInfo.Column("temperature_return", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("set_point", new TableInfo.Column("set_point", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("last_temperature_update", new TableInfo.Column("last_temperature_update", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReefers.put("updatedBy", new TableInfo.Column("updatedBy", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReefers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReefers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReefers = new TableInfo("reefers", _columnsReefers, _foreignKeysReefers, _indicesReefers);
        final TableInfo _existingReefers = TableInfo.read(db, "reefers");
        if (!_infoReefers.equals(_existingReefers)) {
          return new RoomOpenHelper.ValidationResult(false, "reefers(com.oceanbyte.reefercontrol.models.Reefer).\n"
                  + " Expected:\n" + _infoReefers + "\n"
                  + " Found:\n" + _existingReefers);
        }
        final HashMap<String, TableInfo.Column> _columnsAlarms = new HashMap<String, TableInfo.Column>(7);
        _columnsAlarms.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("reeferId", new TableInfo.Column("reeferId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("alarmCode", new TableInfo.Column("alarmCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarms.put("createdBy", new TableInfo.Column("createdBy", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlarms = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysAlarms.add(new TableInfo.ForeignKey("reefers", "CASCADE", "NO ACTION", Arrays.asList("reeferId"), Arrays.asList("container_number")));
        final HashSet<TableInfo.Index> _indicesAlarms = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlarms = new TableInfo("alarms", _columnsAlarms, _foreignKeysAlarms, _indicesAlarms);
        final TableInfo _existingAlarms = TableInfo.read(db, "alarms");
        if (!_infoAlarms.equals(_existingAlarms)) {
          return new RoomOpenHelper.ValidationResult(false, "alarms(com.oceanbyte.reefercontrol.models.Alarm).\n"
                  + " Expected:\n" + _infoAlarms + "\n"
                  + " Found:\n" + _existingAlarms);
        }
        final HashMap<String, TableInfo.Column> _columnsUserProfiles = new HashMap<String, TableInfo.Column>(5);
        _columnsUserProfiles.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("fullName", new TableInfo.Column("fullName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("role", new TableInfo.Column("role", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserProfiles = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserProfiles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserProfiles = new TableInfo("user_profiles", _columnsUserProfiles, _foreignKeysUserProfiles, _indicesUserProfiles);
        final TableInfo _existingUserProfiles = TableInfo.read(db, "user_profiles");
        if (!_infoUserProfiles.equals(_existingUserProfiles)) {
          return new RoomOpenHelper.ValidationResult(false, "user_profiles(com.oceanbyte.reefercontrol.models.UserProfile).\n"
                  + " Expected:\n" + _infoUserProfiles + "\n"
                  + " Found:\n" + _existingUserProfiles);
        }
        final HashMap<String, TableInfo.Column> _columnsMalfunctionReports = new HashMap<String, TableInfo.Column>(16);
        _columnsMalfunctionReports.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("reeferId", new TableInfo.Column("reeferId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("reportNumber", new TableInfo.Column("reportNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("createdBy", new TableInfo.Column("createdBy", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("tempBefore", new TableInfo.Column("tempBefore", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("pressureBefore", new TableInfo.Column("pressureBefore", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("humidityBefore", new TableInfo.Column("humidityBefore", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("tempAfter", new TableInfo.Column("tempAfter", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("pressureAfter", new TableInfo.Column("pressureAfter", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("humidityAfter", new TableInfo.Column("humidityAfter", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("photoBeforePath", new TableInfo.Column("photoBeforePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("photoAfterPath", new TableInfo.Column("photoAfterPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("sparePartsUsed", new TableInfo.Column("sparePartsUsed", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMalfunctionReports.put("exportToFinalReport", new TableInfo.Column("exportToFinalReport", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMalfunctionReports = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysMalfunctionReports.add(new TableInfo.ForeignKey("reefers", "CASCADE", "NO ACTION", Arrays.asList("reeferId"), Arrays.asList("container_number")));
        final HashSet<TableInfo.Index> _indicesMalfunctionReports = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMalfunctionReports = new TableInfo("malfunction_reports", _columnsMalfunctionReports, _foreignKeysMalfunctionReports, _indicesMalfunctionReports);
        final TableInfo _existingMalfunctionReports = TableInfo.read(db, "malfunction_reports");
        if (!_infoMalfunctionReports.equals(_existingMalfunctionReports)) {
          return new RoomOpenHelper.ValidationResult(false, "malfunction_reports(com.oceanbyte.reefercontrol.models.MalfunctionReport).\n"
                  + " Expected:\n" + _infoMalfunctionReports + "\n"
                  + " Found:\n" + _existingMalfunctionReports);
        }
        final HashMap<String, TableInfo.Column> _columnsSparePartStock = new HashMap<String, TableInfo.Column>(6);
        _columnsSparePartStock.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSparePartStock.put("maker", new TableInfo.Column("maker", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSparePartStock.put("model", new TableInfo.Column("model", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSparePartStock.put("partNumber", new TableInfo.Column("partNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSparePartStock.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSparePartStock.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSparePartStock = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSparePartStock = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSparePartStock = new TableInfo("spare_part_stock", _columnsSparePartStock, _foreignKeysSparePartStock, _indicesSparePartStock);
        final TableInfo _existingSparePartStock = TableInfo.read(db, "spare_part_stock");
        if (!_infoSparePartStock.equals(_existingSparePartStock)) {
          return new RoomOpenHelper.ValidationResult(false, "spare_part_stock(com.oceanbyte.reefercontrol.models.SparePartStock).\n"
                  + " Expected:\n" + _infoSparePartStock + "\n"
                  + " Found:\n" + _existingSparePartStock);
        }
        final HashMap<String, TableInfo.Column> _columnsReeferChat = new HashMap<String, TableInfo.Column>(6);
        _columnsReeferChat.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReeferChat.put("reeferId", new TableInfo.Column("reeferId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReeferChat.put("senderRole", new TableInfo.Column("senderRole", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReeferChat.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReeferChat.put("timestamp", new TableInfo.Column("timestamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReeferChat.put("readBy", new TableInfo.Column("readBy", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReeferChat = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReeferChat = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReeferChat = new TableInfo("reefer_chat", _columnsReeferChat, _foreignKeysReeferChat, _indicesReeferChat);
        final TableInfo _existingReeferChat = TableInfo.read(db, "reefer_chat");
        if (!_infoReeferChat.equals(_existingReeferChat)) {
          return new RoomOpenHelper.ValidationResult(false, "reefer_chat(com.oceanbyte.reefercontrol.models.ReeferChatMessage).\n"
                  + " Expected:\n" + _infoReeferChat + "\n"
                  + " Found:\n" + _existingReeferChat);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "9d48ef0a89401a93e38376c839ed054a", "b0fba21d7c49ee762db25352b43f69f4");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "reefers","alarms","user_profiles","malfunction_reports","spare_part_stock","reefer_chat");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `reefers`");
      _db.execSQL("DELETE FROM `alarms`");
      _db.execSQL("DELETE FROM `user_profiles`");
      _db.execSQL("DELETE FROM `malfunction_reports`");
      _db.execSQL("DELETE FROM `spare_part_stock`");
      _db.execSQL("DELETE FROM `reefer_chat`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ReeferDao.class, ReeferDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AlarmDao.class, AlarmDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserProfileDao.class, UserProfileDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MalfunctionReportDao.class, MalfunctionReportDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SparePartStockDao.class, SparePartStockDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ReeferChatDao.class, ReeferChatDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ReeferDao reeferDao() {
    if (_reeferDao != null) {
      return _reeferDao;
    } else {
      synchronized(this) {
        if(_reeferDao == null) {
          _reeferDao = new ReeferDao_Impl(this);
        }
        return _reeferDao;
      }
    }
  }

  @Override
  public AlarmDao alarmDao() {
    if (_alarmDao != null) {
      return _alarmDao;
    } else {
      synchronized(this) {
        if(_alarmDao == null) {
          _alarmDao = new AlarmDao_Impl(this);
        }
        return _alarmDao;
      }
    }
  }

  @Override
  public UserProfileDao userProfileDao() {
    if (_userProfileDao != null) {
      return _userProfileDao;
    } else {
      synchronized(this) {
        if(_userProfileDao == null) {
          _userProfileDao = new UserProfileDao_Impl(this);
        }
        return _userProfileDao;
      }
    }
  }

  @Override
  public MalfunctionReportDao malfunctionReportDao() {
    if (_malfunctionReportDao != null) {
      return _malfunctionReportDao;
    } else {
      synchronized(this) {
        if(_malfunctionReportDao == null) {
          _malfunctionReportDao = new MalfunctionReportDao_Impl(this);
        }
        return _malfunctionReportDao;
      }
    }
  }

  @Override
  public SparePartStockDao sparePartStockDao() {
    if (_sparePartStockDao != null) {
      return _sparePartStockDao;
    } else {
      synchronized(this) {
        if(_sparePartStockDao == null) {
          _sparePartStockDao = new SparePartStockDao_Impl(this);
        }
        return _sparePartStockDao;
      }
    }
  }

  @Override
  public ReeferChatDao reeferChatDao() {
    if (_reeferChatDao != null) {
      return _reeferChatDao;
    } else {
      synchronized(this) {
        if(_reeferChatDao == null) {
          _reeferChatDao = new ReeferChatDao_Impl(this);
        }
        return _reeferChatDao;
      }
    }
  }
}

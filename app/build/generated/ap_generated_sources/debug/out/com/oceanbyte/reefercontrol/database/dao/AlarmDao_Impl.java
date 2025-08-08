package com.oceanbyte.reefercontrol.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.oceanbyte.reefercontrol.models.Alarm;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDao_Impl implements AlarmDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Alarm> __insertionAdapterOfAlarm;

  private final EntityDeletionOrUpdateAdapter<Alarm> __deletionAdapterOfAlarm;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByReeferIdAndCode;

  public AlarmDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlarm = new EntityInsertionAdapter<Alarm>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `alarms` (`id`,`reeferId`,`alarmCode`,`description`,`isActive`,`createdAt`,`createdBy`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Alarm entity) {
        statement.bindLong(1, entity.id);
        if (entity.reeferId == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.reeferId);
        }
        if (entity.alarmCode == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.alarmCode);
        }
        if (entity.description == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.description);
        }
        final int _tmp = entity.isActive ? 1 : 0;
        statement.bindLong(5, _tmp);
        if (entity.createdAt == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.createdAt);
        }
        if (entity.createdBy == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.createdBy);
        }
      }
    };
    this.__deletionAdapterOfAlarm = new EntityDeletionOrUpdateAdapter<Alarm>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `alarms` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Alarm entity) {
        statement.bindLong(1, entity.id);
      }
    };
    this.__preparedStmtOfDeleteByReeferIdAndCode = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM alarms WHERE reeferId = ? AND alarmCode = ?";
        return _query;
      }
    };
  }

  @Override
  public long insert(final Alarm alarm) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfAlarm.insertAndReturnId(alarm);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Alarm alarm) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAlarm.handle(alarm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteByReeferIdAndCode(final String reeferId, final String alarmCode) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByReeferIdAndCode.acquire();
    int _argIndex = 1;
    if (reeferId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, reeferId);
    }
    _argIndex = 2;
    if (alarmCode == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, alarmCode);
    }
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteByReeferIdAndCode.release(_stmt);
    }
  }

  @Override
  public List<Alarm> getActiveAlarmsForReefer(final String reeferId) {
    final String _sql = "SELECT * FROM alarms WHERE reeferId = ? AND isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (reeferId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, reeferId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfReeferId = CursorUtil.getColumnIndexOrThrow(_cursor, "reeferId");
      final int _cursorIndexOfAlarmCode = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmCode");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
      final List<Alarm> _result = new ArrayList<Alarm>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Alarm _item;
        _item = new Alarm();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfReeferId)) {
          _item.reeferId = null;
        } else {
          _item.reeferId = _cursor.getString(_cursorIndexOfReeferId);
        }
        if (_cursor.isNull(_cursorIndexOfAlarmCode)) {
          _item.alarmCode = null;
        } else {
          _item.alarmCode = _cursor.getString(_cursorIndexOfAlarmCode);
        }
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _item.description = null;
        } else {
          _item.description = _cursor.getString(_cursorIndexOfDescription);
        }
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _item.isActive = _tmp != 0;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _item.createdAt = null;
        } else {
          _item.createdAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
          _item.createdBy = null;
        } else {
          _item.createdBy = _cursor.getString(_cursorIndexOfCreatedBy);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public boolean hasActiveAlarms(final String reeferId) {
    final String _sql = "SELECT EXISTS(SELECT 1 FROM alarms WHERE reeferId = ? AND isActive = 1)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (reeferId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, reeferId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if (_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

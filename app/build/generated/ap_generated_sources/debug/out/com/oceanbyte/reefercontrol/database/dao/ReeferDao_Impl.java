package com.oceanbyte.reefercontrol.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.oceanbyte.reefercontrol.models.Reefer;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ReeferDao_Impl implements ReeferDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Reefer> __insertionAdapterOfReefer;

  private final EntityInsertionAdapter<Reefer> __insertionAdapterOfReefer_1;

  private final EntityDeletionOrUpdateAdapter<Reefer> __deletionAdapterOfReefer;

  private final EntityDeletionOrUpdateAdapter<Reefer> __updateAdapterOfReefer;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  public ReeferDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReefer = new EntityInsertionAdapter<Reefer>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `reefers` (`container_number`,`position`,`loading_port`,`discharge_port`,`atd`,`eta`,`operator`,`cargo_type`,`status`,`is_active`,`temperature_supply`,`temperature_return`,`set_point`,`last_temperature_update`,`updatedBy`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Reefer entity) {
        if (entity.containerNumber == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.containerNumber);
        }
        if (entity.position == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.position);
        }
        if (entity.loadingPort == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.loadingPort);
        }
        if (entity.dischargePort == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.dischargePort);
        }
        if (entity.atd == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.atd);
        }
        if (entity.eta == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.eta);
        }
        if (entity.operator == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.operator);
        }
        if (entity.cargoType == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.cargoType);
        }
        if (entity.status == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.status);
        }
        final int _tmp = entity.isActive ? 1 : 0;
        statement.bindLong(10, _tmp);
        statement.bindDouble(11, entity.temperatureSupply);
        statement.bindDouble(12, entity.temperatureReturn);
        statement.bindDouble(13, entity.setPoint);
        if (entity.lastTemperatureUpdate == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.lastTemperatureUpdate);
        }
        if (entity.updatedBy == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.updatedBy);
        }
      }
    };
    this.__insertionAdapterOfReefer_1 = new EntityInsertionAdapter<Reefer>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `reefers` (`container_number`,`position`,`loading_port`,`discharge_port`,`atd`,`eta`,`operator`,`cargo_type`,`status`,`is_active`,`temperature_supply`,`temperature_return`,`set_point`,`last_temperature_update`,`updatedBy`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Reefer entity) {
        if (entity.containerNumber == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.containerNumber);
        }
        if (entity.position == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.position);
        }
        if (entity.loadingPort == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.loadingPort);
        }
        if (entity.dischargePort == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.dischargePort);
        }
        if (entity.atd == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.atd);
        }
        if (entity.eta == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.eta);
        }
        if (entity.operator == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.operator);
        }
        if (entity.cargoType == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.cargoType);
        }
        if (entity.status == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.status);
        }
        final int _tmp = entity.isActive ? 1 : 0;
        statement.bindLong(10, _tmp);
        statement.bindDouble(11, entity.temperatureSupply);
        statement.bindDouble(12, entity.temperatureReturn);
        statement.bindDouble(13, entity.setPoint);
        if (entity.lastTemperatureUpdate == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.lastTemperatureUpdate);
        }
        if (entity.updatedBy == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.updatedBy);
        }
      }
    };
    this.__deletionAdapterOfReefer = new EntityDeletionOrUpdateAdapter<Reefer>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `reefers` WHERE `container_number` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Reefer entity) {
        if (entity.containerNumber == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.containerNumber);
        }
      }
    };
    this.__updateAdapterOfReefer = new EntityDeletionOrUpdateAdapter<Reefer>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `reefers` SET `container_number` = ?,`position` = ?,`loading_port` = ?,`discharge_port` = ?,`atd` = ?,`eta` = ?,`operator` = ?,`cargo_type` = ?,`status` = ?,`is_active` = ?,`temperature_supply` = ?,`temperature_return` = ?,`set_point` = ?,`last_temperature_update` = ?,`updatedBy` = ? WHERE `container_number` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Reefer entity) {
        if (entity.containerNumber == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.containerNumber);
        }
        if (entity.position == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.position);
        }
        if (entity.loadingPort == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.loadingPort);
        }
        if (entity.dischargePort == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.dischargePort);
        }
        if (entity.atd == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.atd);
        }
        if (entity.eta == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.eta);
        }
        if (entity.operator == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.operator);
        }
        if (entity.cargoType == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.cargoType);
        }
        if (entity.status == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.status);
        }
        final int _tmp = entity.isActive ? 1 : 0;
        statement.bindLong(10, _tmp);
        statement.bindDouble(11, entity.temperatureSupply);
        statement.bindDouble(12, entity.temperatureReturn);
        statement.bindDouble(13, entity.setPoint);
        if (entity.lastTemperatureUpdate == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.lastTemperatureUpdate);
        }
        if (entity.updatedBy == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.updatedBy);
        }
        if (entity.containerNumber == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.containerNumber);
        }
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM reefers";
        return _query;
      }
    };
  }

  @Override
  public long insert(final Reefer reefer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfReefer.insertAndReturnId(reefer);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<Reefer> reefers) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfReefer_1.insert(reefers);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int delete(final Reefer reefer) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total += __deletionAdapterOfReefer.handle(reefer);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(final Reefer reefer) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total += __updateAdapterOfReefer.handle(reefer);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clear() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClear.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfClear.release(_stmt);
    }
  }

  @Override
  public List<Reefer> getAll() {
    final String _sql = "SELECT * FROM reefers ORDER BY container_number ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfContainerNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "container_number");
      final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
      final int _cursorIndexOfLoadingPort = CursorUtil.getColumnIndexOrThrow(_cursor, "loading_port");
      final int _cursorIndexOfDischargePort = CursorUtil.getColumnIndexOrThrow(_cursor, "discharge_port");
      final int _cursorIndexOfAtd = CursorUtil.getColumnIndexOrThrow(_cursor, "atd");
      final int _cursorIndexOfEta = CursorUtil.getColumnIndexOrThrow(_cursor, "eta");
      final int _cursorIndexOfOperator = CursorUtil.getColumnIndexOrThrow(_cursor, "operator");
      final int _cursorIndexOfCargoType = CursorUtil.getColumnIndexOrThrow(_cursor, "cargo_type");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
      final int _cursorIndexOfTemperatureSupply = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_supply");
      final int _cursorIndexOfTemperatureReturn = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_return");
      final int _cursorIndexOfSetPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "set_point");
      final int _cursorIndexOfLastTemperatureUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "last_temperature_update");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedBy");
      final List<Reefer> _result = new ArrayList<Reefer>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Reefer _item;
        final String _tmpContainerNumber;
        if (_cursor.isNull(_cursorIndexOfContainerNumber)) {
          _tmpContainerNumber = null;
        } else {
          _tmpContainerNumber = _cursor.getString(_cursorIndexOfContainerNumber);
        }
        final String _tmpPosition;
        if (_cursor.isNull(_cursorIndexOfPosition)) {
          _tmpPosition = null;
        } else {
          _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
        }
        final String _tmpLoadingPort;
        if (_cursor.isNull(_cursorIndexOfLoadingPort)) {
          _tmpLoadingPort = null;
        } else {
          _tmpLoadingPort = _cursor.getString(_cursorIndexOfLoadingPort);
        }
        final String _tmpDischargePort;
        if (_cursor.isNull(_cursorIndexOfDischargePort)) {
          _tmpDischargePort = null;
        } else {
          _tmpDischargePort = _cursor.getString(_cursorIndexOfDischargePort);
        }
        final String _tmpAtd;
        if (_cursor.isNull(_cursorIndexOfAtd)) {
          _tmpAtd = null;
        } else {
          _tmpAtd = _cursor.getString(_cursorIndexOfAtd);
        }
        final String _tmpEta;
        if (_cursor.isNull(_cursorIndexOfEta)) {
          _tmpEta = null;
        } else {
          _tmpEta = _cursor.getString(_cursorIndexOfEta);
        }
        final String _tmpOperator;
        if (_cursor.isNull(_cursorIndexOfOperator)) {
          _tmpOperator = null;
        } else {
          _tmpOperator = _cursor.getString(_cursorIndexOfOperator);
        }
        final String _tmpCargoType;
        if (_cursor.isNull(_cursorIndexOfCargoType)) {
          _tmpCargoType = null;
        } else {
          _tmpCargoType = _cursor.getString(_cursorIndexOfCargoType);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final double _tmpTemperatureSupply;
        _tmpTemperatureSupply = _cursor.getDouble(_cursorIndexOfTemperatureSupply);
        final double _tmpTemperatureReturn;
        _tmpTemperatureReturn = _cursor.getDouble(_cursorIndexOfTemperatureReturn);
        final double _tmpSetPoint;
        _tmpSetPoint = _cursor.getDouble(_cursorIndexOfSetPoint);
        final String _tmpLastTemperatureUpdate;
        if (_cursor.isNull(_cursorIndexOfLastTemperatureUpdate)) {
          _tmpLastTemperatureUpdate = null;
        } else {
          _tmpLastTemperatureUpdate = _cursor.getString(_cursorIndexOfLastTemperatureUpdate);
        }
        final String _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getString(_cursorIndexOfUpdatedBy);
        }
        _item = new Reefer(_tmpContainerNumber,_tmpPosition,_tmpLoadingPort,_tmpDischargePort,_tmpAtd,_tmpEta,_tmpOperator,_tmpCargoType,_tmpStatus,_tmpIsActive,_tmpTemperatureSupply,_tmpTemperatureReturn,_tmpSetPoint,_tmpLastTemperatureUpdate,_tmpUpdatedBy);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Reefer getByContainerNumber(final String containerNumber) {
    final String _sql = "SELECT * FROM reefers WHERE container_number = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (containerNumber == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, containerNumber);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfContainerNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "container_number");
      final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
      final int _cursorIndexOfLoadingPort = CursorUtil.getColumnIndexOrThrow(_cursor, "loading_port");
      final int _cursorIndexOfDischargePort = CursorUtil.getColumnIndexOrThrow(_cursor, "discharge_port");
      final int _cursorIndexOfAtd = CursorUtil.getColumnIndexOrThrow(_cursor, "atd");
      final int _cursorIndexOfEta = CursorUtil.getColumnIndexOrThrow(_cursor, "eta");
      final int _cursorIndexOfOperator = CursorUtil.getColumnIndexOrThrow(_cursor, "operator");
      final int _cursorIndexOfCargoType = CursorUtil.getColumnIndexOrThrow(_cursor, "cargo_type");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
      final int _cursorIndexOfTemperatureSupply = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_supply");
      final int _cursorIndexOfTemperatureReturn = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_return");
      final int _cursorIndexOfSetPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "set_point");
      final int _cursorIndexOfLastTemperatureUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "last_temperature_update");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedBy");
      final Reefer _result;
      if (_cursor.moveToFirst()) {
        final String _tmpContainerNumber;
        if (_cursor.isNull(_cursorIndexOfContainerNumber)) {
          _tmpContainerNumber = null;
        } else {
          _tmpContainerNumber = _cursor.getString(_cursorIndexOfContainerNumber);
        }
        final String _tmpPosition;
        if (_cursor.isNull(_cursorIndexOfPosition)) {
          _tmpPosition = null;
        } else {
          _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
        }
        final String _tmpLoadingPort;
        if (_cursor.isNull(_cursorIndexOfLoadingPort)) {
          _tmpLoadingPort = null;
        } else {
          _tmpLoadingPort = _cursor.getString(_cursorIndexOfLoadingPort);
        }
        final String _tmpDischargePort;
        if (_cursor.isNull(_cursorIndexOfDischargePort)) {
          _tmpDischargePort = null;
        } else {
          _tmpDischargePort = _cursor.getString(_cursorIndexOfDischargePort);
        }
        final String _tmpAtd;
        if (_cursor.isNull(_cursorIndexOfAtd)) {
          _tmpAtd = null;
        } else {
          _tmpAtd = _cursor.getString(_cursorIndexOfAtd);
        }
        final String _tmpEta;
        if (_cursor.isNull(_cursorIndexOfEta)) {
          _tmpEta = null;
        } else {
          _tmpEta = _cursor.getString(_cursorIndexOfEta);
        }
        final String _tmpOperator;
        if (_cursor.isNull(_cursorIndexOfOperator)) {
          _tmpOperator = null;
        } else {
          _tmpOperator = _cursor.getString(_cursorIndexOfOperator);
        }
        final String _tmpCargoType;
        if (_cursor.isNull(_cursorIndexOfCargoType)) {
          _tmpCargoType = null;
        } else {
          _tmpCargoType = _cursor.getString(_cursorIndexOfCargoType);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final double _tmpTemperatureSupply;
        _tmpTemperatureSupply = _cursor.getDouble(_cursorIndexOfTemperatureSupply);
        final double _tmpTemperatureReturn;
        _tmpTemperatureReturn = _cursor.getDouble(_cursorIndexOfTemperatureReturn);
        final double _tmpSetPoint;
        _tmpSetPoint = _cursor.getDouble(_cursorIndexOfSetPoint);
        final String _tmpLastTemperatureUpdate;
        if (_cursor.isNull(_cursorIndexOfLastTemperatureUpdate)) {
          _tmpLastTemperatureUpdate = null;
        } else {
          _tmpLastTemperatureUpdate = _cursor.getString(_cursorIndexOfLastTemperatureUpdate);
        }
        final String _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getString(_cursorIndexOfUpdatedBy);
        }
        _result = new Reefer(_tmpContainerNumber,_tmpPosition,_tmpLoadingPort,_tmpDischargePort,_tmpAtd,_tmpEta,_tmpOperator,_tmpCargoType,_tmpStatus,_tmpIsActive,_tmpTemperatureSupply,_tmpTemperatureReturn,_tmpSetPoint,_tmpLastTemperatureUpdate,_tmpUpdatedBy);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Reefer> searchByContainerOrPosition(final String query) {
    final String _sql = "SELECT * FROM reefers WHERE container_number LIKE ? OR position LIKE ? ORDER BY container_number ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfContainerNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "container_number");
      final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
      final int _cursorIndexOfLoadingPort = CursorUtil.getColumnIndexOrThrow(_cursor, "loading_port");
      final int _cursorIndexOfDischargePort = CursorUtil.getColumnIndexOrThrow(_cursor, "discharge_port");
      final int _cursorIndexOfAtd = CursorUtil.getColumnIndexOrThrow(_cursor, "atd");
      final int _cursorIndexOfEta = CursorUtil.getColumnIndexOrThrow(_cursor, "eta");
      final int _cursorIndexOfOperator = CursorUtil.getColumnIndexOrThrow(_cursor, "operator");
      final int _cursorIndexOfCargoType = CursorUtil.getColumnIndexOrThrow(_cursor, "cargo_type");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
      final int _cursorIndexOfTemperatureSupply = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_supply");
      final int _cursorIndexOfTemperatureReturn = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_return");
      final int _cursorIndexOfSetPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "set_point");
      final int _cursorIndexOfLastTemperatureUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "last_temperature_update");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedBy");
      final List<Reefer> _result = new ArrayList<Reefer>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Reefer _item;
        final String _tmpContainerNumber;
        if (_cursor.isNull(_cursorIndexOfContainerNumber)) {
          _tmpContainerNumber = null;
        } else {
          _tmpContainerNumber = _cursor.getString(_cursorIndexOfContainerNumber);
        }
        final String _tmpPosition;
        if (_cursor.isNull(_cursorIndexOfPosition)) {
          _tmpPosition = null;
        } else {
          _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
        }
        final String _tmpLoadingPort;
        if (_cursor.isNull(_cursorIndexOfLoadingPort)) {
          _tmpLoadingPort = null;
        } else {
          _tmpLoadingPort = _cursor.getString(_cursorIndexOfLoadingPort);
        }
        final String _tmpDischargePort;
        if (_cursor.isNull(_cursorIndexOfDischargePort)) {
          _tmpDischargePort = null;
        } else {
          _tmpDischargePort = _cursor.getString(_cursorIndexOfDischargePort);
        }
        final String _tmpAtd;
        if (_cursor.isNull(_cursorIndexOfAtd)) {
          _tmpAtd = null;
        } else {
          _tmpAtd = _cursor.getString(_cursorIndexOfAtd);
        }
        final String _tmpEta;
        if (_cursor.isNull(_cursorIndexOfEta)) {
          _tmpEta = null;
        } else {
          _tmpEta = _cursor.getString(_cursorIndexOfEta);
        }
        final String _tmpOperator;
        if (_cursor.isNull(_cursorIndexOfOperator)) {
          _tmpOperator = null;
        } else {
          _tmpOperator = _cursor.getString(_cursorIndexOfOperator);
        }
        final String _tmpCargoType;
        if (_cursor.isNull(_cursorIndexOfCargoType)) {
          _tmpCargoType = null;
        } else {
          _tmpCargoType = _cursor.getString(_cursorIndexOfCargoType);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final double _tmpTemperatureSupply;
        _tmpTemperatureSupply = _cursor.getDouble(_cursorIndexOfTemperatureSupply);
        final double _tmpTemperatureReturn;
        _tmpTemperatureReturn = _cursor.getDouble(_cursorIndexOfTemperatureReturn);
        final double _tmpSetPoint;
        _tmpSetPoint = _cursor.getDouble(_cursorIndexOfSetPoint);
        final String _tmpLastTemperatureUpdate;
        if (_cursor.isNull(_cursorIndexOfLastTemperatureUpdate)) {
          _tmpLastTemperatureUpdate = null;
        } else {
          _tmpLastTemperatureUpdate = _cursor.getString(_cursorIndexOfLastTemperatureUpdate);
        }
        final String _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getString(_cursorIndexOfUpdatedBy);
        }
        _item = new Reefer(_tmpContainerNumber,_tmpPosition,_tmpLoadingPort,_tmpDischargePort,_tmpAtd,_tmpEta,_tmpOperator,_tmpCargoType,_tmpStatus,_tmpIsActive,_tmpTemperatureSupply,_tmpTemperatureReturn,_tmpSetPoint,_tmpLastTemperatureUpdate,_tmpUpdatedBy);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Reefer> getActiveReefers() {
    final String _sql = "SELECT * FROM reefers WHERE is_active = 1 ORDER BY container_number ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfContainerNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "container_number");
      final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
      final int _cursorIndexOfLoadingPort = CursorUtil.getColumnIndexOrThrow(_cursor, "loading_port");
      final int _cursorIndexOfDischargePort = CursorUtil.getColumnIndexOrThrow(_cursor, "discharge_port");
      final int _cursorIndexOfAtd = CursorUtil.getColumnIndexOrThrow(_cursor, "atd");
      final int _cursorIndexOfEta = CursorUtil.getColumnIndexOrThrow(_cursor, "eta");
      final int _cursorIndexOfOperator = CursorUtil.getColumnIndexOrThrow(_cursor, "operator");
      final int _cursorIndexOfCargoType = CursorUtil.getColumnIndexOrThrow(_cursor, "cargo_type");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
      final int _cursorIndexOfTemperatureSupply = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_supply");
      final int _cursorIndexOfTemperatureReturn = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_return");
      final int _cursorIndexOfSetPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "set_point");
      final int _cursorIndexOfLastTemperatureUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "last_temperature_update");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedBy");
      final List<Reefer> _result = new ArrayList<Reefer>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Reefer _item;
        final String _tmpContainerNumber;
        if (_cursor.isNull(_cursorIndexOfContainerNumber)) {
          _tmpContainerNumber = null;
        } else {
          _tmpContainerNumber = _cursor.getString(_cursorIndexOfContainerNumber);
        }
        final String _tmpPosition;
        if (_cursor.isNull(_cursorIndexOfPosition)) {
          _tmpPosition = null;
        } else {
          _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
        }
        final String _tmpLoadingPort;
        if (_cursor.isNull(_cursorIndexOfLoadingPort)) {
          _tmpLoadingPort = null;
        } else {
          _tmpLoadingPort = _cursor.getString(_cursorIndexOfLoadingPort);
        }
        final String _tmpDischargePort;
        if (_cursor.isNull(_cursorIndexOfDischargePort)) {
          _tmpDischargePort = null;
        } else {
          _tmpDischargePort = _cursor.getString(_cursorIndexOfDischargePort);
        }
        final String _tmpAtd;
        if (_cursor.isNull(_cursorIndexOfAtd)) {
          _tmpAtd = null;
        } else {
          _tmpAtd = _cursor.getString(_cursorIndexOfAtd);
        }
        final String _tmpEta;
        if (_cursor.isNull(_cursorIndexOfEta)) {
          _tmpEta = null;
        } else {
          _tmpEta = _cursor.getString(_cursorIndexOfEta);
        }
        final String _tmpOperator;
        if (_cursor.isNull(_cursorIndexOfOperator)) {
          _tmpOperator = null;
        } else {
          _tmpOperator = _cursor.getString(_cursorIndexOfOperator);
        }
        final String _tmpCargoType;
        if (_cursor.isNull(_cursorIndexOfCargoType)) {
          _tmpCargoType = null;
        } else {
          _tmpCargoType = _cursor.getString(_cursorIndexOfCargoType);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final double _tmpTemperatureSupply;
        _tmpTemperatureSupply = _cursor.getDouble(_cursorIndexOfTemperatureSupply);
        final double _tmpTemperatureReturn;
        _tmpTemperatureReturn = _cursor.getDouble(_cursorIndexOfTemperatureReturn);
        final double _tmpSetPoint;
        _tmpSetPoint = _cursor.getDouble(_cursorIndexOfSetPoint);
        final String _tmpLastTemperatureUpdate;
        if (_cursor.isNull(_cursorIndexOfLastTemperatureUpdate)) {
          _tmpLastTemperatureUpdate = null;
        } else {
          _tmpLastTemperatureUpdate = _cursor.getString(_cursorIndexOfLastTemperatureUpdate);
        }
        final String _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getString(_cursorIndexOfUpdatedBy);
        }
        _item = new Reefer(_tmpContainerNumber,_tmpPosition,_tmpLoadingPort,_tmpDischargePort,_tmpAtd,_tmpEta,_tmpOperator,_tmpCargoType,_tmpStatus,_tmpIsActive,_tmpTemperatureSupply,_tmpTemperatureReturn,_tmpSetPoint,_tmpLastTemperatureUpdate,_tmpUpdatedBy);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Reefer>> getAllLive() {
    final String _sql = "SELECT * FROM reefers ORDER BY container_number";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"reefers"}, false, new Callable<List<Reefer>>() {
      @Override
      @Nullable
      public List<Reefer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfContainerNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "container_number");
          final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
          final int _cursorIndexOfLoadingPort = CursorUtil.getColumnIndexOrThrow(_cursor, "loading_port");
          final int _cursorIndexOfDischargePort = CursorUtil.getColumnIndexOrThrow(_cursor, "discharge_port");
          final int _cursorIndexOfAtd = CursorUtil.getColumnIndexOrThrow(_cursor, "atd");
          final int _cursorIndexOfEta = CursorUtil.getColumnIndexOrThrow(_cursor, "eta");
          final int _cursorIndexOfOperator = CursorUtil.getColumnIndexOrThrow(_cursor, "operator");
          final int _cursorIndexOfCargoType = CursorUtil.getColumnIndexOrThrow(_cursor, "cargo_type");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
          final int _cursorIndexOfTemperatureSupply = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_supply");
          final int _cursorIndexOfTemperatureReturn = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_return");
          final int _cursorIndexOfSetPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "set_point");
          final int _cursorIndexOfLastTemperatureUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "last_temperature_update");
          final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedBy");
          final List<Reefer> _result = new ArrayList<Reefer>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Reefer _item;
            final String _tmpContainerNumber;
            if (_cursor.isNull(_cursorIndexOfContainerNumber)) {
              _tmpContainerNumber = null;
            } else {
              _tmpContainerNumber = _cursor.getString(_cursorIndexOfContainerNumber);
            }
            final String _tmpPosition;
            if (_cursor.isNull(_cursorIndexOfPosition)) {
              _tmpPosition = null;
            } else {
              _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
            }
            final String _tmpLoadingPort;
            if (_cursor.isNull(_cursorIndexOfLoadingPort)) {
              _tmpLoadingPort = null;
            } else {
              _tmpLoadingPort = _cursor.getString(_cursorIndexOfLoadingPort);
            }
            final String _tmpDischargePort;
            if (_cursor.isNull(_cursorIndexOfDischargePort)) {
              _tmpDischargePort = null;
            } else {
              _tmpDischargePort = _cursor.getString(_cursorIndexOfDischargePort);
            }
            final String _tmpAtd;
            if (_cursor.isNull(_cursorIndexOfAtd)) {
              _tmpAtd = null;
            } else {
              _tmpAtd = _cursor.getString(_cursorIndexOfAtd);
            }
            final String _tmpEta;
            if (_cursor.isNull(_cursorIndexOfEta)) {
              _tmpEta = null;
            } else {
              _tmpEta = _cursor.getString(_cursorIndexOfEta);
            }
            final String _tmpOperator;
            if (_cursor.isNull(_cursorIndexOfOperator)) {
              _tmpOperator = null;
            } else {
              _tmpOperator = _cursor.getString(_cursorIndexOfOperator);
            }
            final String _tmpCargoType;
            if (_cursor.isNull(_cursorIndexOfCargoType)) {
              _tmpCargoType = null;
            } else {
              _tmpCargoType = _cursor.getString(_cursorIndexOfCargoType);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final double _tmpTemperatureSupply;
            _tmpTemperatureSupply = _cursor.getDouble(_cursorIndexOfTemperatureSupply);
            final double _tmpTemperatureReturn;
            _tmpTemperatureReturn = _cursor.getDouble(_cursorIndexOfTemperatureReturn);
            final double _tmpSetPoint;
            _tmpSetPoint = _cursor.getDouble(_cursorIndexOfSetPoint);
            final String _tmpLastTemperatureUpdate;
            if (_cursor.isNull(_cursorIndexOfLastTemperatureUpdate)) {
              _tmpLastTemperatureUpdate = null;
            } else {
              _tmpLastTemperatureUpdate = _cursor.getString(_cursorIndexOfLastTemperatureUpdate);
            }
            final String _tmpUpdatedBy;
            if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
              _tmpUpdatedBy = null;
            } else {
              _tmpUpdatedBy = _cursor.getString(_cursorIndexOfUpdatedBy);
            }
            _item = new Reefer(_tmpContainerNumber,_tmpPosition,_tmpLoadingPort,_tmpDischargePort,_tmpAtd,_tmpEta,_tmpOperator,_tmpCargoType,_tmpStatus,_tmpIsActive,_tmpTemperatureSupply,_tmpTemperatureReturn,_tmpSetPoint,_tmpLastTemperatureUpdate,_tmpUpdatedBy);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Reefer getByIdNow(final String containerNumber) {
    final String _sql = "SELECT * FROM reefers WHERE container_number = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (containerNumber == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, containerNumber);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfContainerNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "container_number");
      final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
      final int _cursorIndexOfLoadingPort = CursorUtil.getColumnIndexOrThrow(_cursor, "loading_port");
      final int _cursorIndexOfDischargePort = CursorUtil.getColumnIndexOrThrow(_cursor, "discharge_port");
      final int _cursorIndexOfAtd = CursorUtil.getColumnIndexOrThrow(_cursor, "atd");
      final int _cursorIndexOfEta = CursorUtil.getColumnIndexOrThrow(_cursor, "eta");
      final int _cursorIndexOfOperator = CursorUtil.getColumnIndexOrThrow(_cursor, "operator");
      final int _cursorIndexOfCargoType = CursorUtil.getColumnIndexOrThrow(_cursor, "cargo_type");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "is_active");
      final int _cursorIndexOfTemperatureSupply = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_supply");
      final int _cursorIndexOfTemperatureReturn = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature_return");
      final int _cursorIndexOfSetPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "set_point");
      final int _cursorIndexOfLastTemperatureUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "last_temperature_update");
      final int _cursorIndexOfUpdatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedBy");
      final Reefer _result;
      if (_cursor.moveToFirst()) {
        final String _tmpContainerNumber;
        if (_cursor.isNull(_cursorIndexOfContainerNumber)) {
          _tmpContainerNumber = null;
        } else {
          _tmpContainerNumber = _cursor.getString(_cursorIndexOfContainerNumber);
        }
        final String _tmpPosition;
        if (_cursor.isNull(_cursorIndexOfPosition)) {
          _tmpPosition = null;
        } else {
          _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
        }
        final String _tmpLoadingPort;
        if (_cursor.isNull(_cursorIndexOfLoadingPort)) {
          _tmpLoadingPort = null;
        } else {
          _tmpLoadingPort = _cursor.getString(_cursorIndexOfLoadingPort);
        }
        final String _tmpDischargePort;
        if (_cursor.isNull(_cursorIndexOfDischargePort)) {
          _tmpDischargePort = null;
        } else {
          _tmpDischargePort = _cursor.getString(_cursorIndexOfDischargePort);
        }
        final String _tmpAtd;
        if (_cursor.isNull(_cursorIndexOfAtd)) {
          _tmpAtd = null;
        } else {
          _tmpAtd = _cursor.getString(_cursorIndexOfAtd);
        }
        final String _tmpEta;
        if (_cursor.isNull(_cursorIndexOfEta)) {
          _tmpEta = null;
        } else {
          _tmpEta = _cursor.getString(_cursorIndexOfEta);
        }
        final String _tmpOperator;
        if (_cursor.isNull(_cursorIndexOfOperator)) {
          _tmpOperator = null;
        } else {
          _tmpOperator = _cursor.getString(_cursorIndexOfOperator);
        }
        final String _tmpCargoType;
        if (_cursor.isNull(_cursorIndexOfCargoType)) {
          _tmpCargoType = null;
        } else {
          _tmpCargoType = _cursor.getString(_cursorIndexOfCargoType);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        final boolean _tmpIsActive;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsActive);
        _tmpIsActive = _tmp != 0;
        final double _tmpTemperatureSupply;
        _tmpTemperatureSupply = _cursor.getDouble(_cursorIndexOfTemperatureSupply);
        final double _tmpTemperatureReturn;
        _tmpTemperatureReturn = _cursor.getDouble(_cursorIndexOfTemperatureReturn);
        final double _tmpSetPoint;
        _tmpSetPoint = _cursor.getDouble(_cursorIndexOfSetPoint);
        final String _tmpLastTemperatureUpdate;
        if (_cursor.isNull(_cursorIndexOfLastTemperatureUpdate)) {
          _tmpLastTemperatureUpdate = null;
        } else {
          _tmpLastTemperatureUpdate = _cursor.getString(_cursorIndexOfLastTemperatureUpdate);
        }
        final String _tmpUpdatedBy;
        if (_cursor.isNull(_cursorIndexOfUpdatedBy)) {
          _tmpUpdatedBy = null;
        } else {
          _tmpUpdatedBy = _cursor.getString(_cursorIndexOfUpdatedBy);
        }
        _result = new Reefer(_tmpContainerNumber,_tmpPosition,_tmpLoadingPort,_tmpDischargePort,_tmpAtd,_tmpEta,_tmpOperator,_tmpCargoType,_tmpStatus,_tmpIsActive,_tmpTemperatureSupply,_tmpTemperatureReturn,_tmpSetPoint,_tmpLastTemperatureUpdate,_tmpUpdatedBy);
      } else {
        _result = null;
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

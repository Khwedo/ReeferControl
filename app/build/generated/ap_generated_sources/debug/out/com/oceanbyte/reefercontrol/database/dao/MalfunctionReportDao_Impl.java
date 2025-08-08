package com.oceanbyte.reefercontrol.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.oceanbyte.reefercontrol.models.MalfunctionReport;
import com.oceanbyte.reefercontrol.models.Reefer;
import com.oceanbyte.reefercontrol.models.relations.MalfunctionReportWithReefer;
import com.oceanbyte.reefercontrol.utils.DateConverter;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import kotlin.Unit;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MalfunctionReportDao_Impl implements MalfunctionReportDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MalfunctionReport> __insertionAdapterOfMalfunctionReport;

  private final EntityDeletionOrUpdateAdapter<MalfunctionReport> __deletionAdapterOfMalfunctionReport;

  private final EntityDeletionOrUpdateAdapter<MalfunctionReport> __updateAdapterOfMalfunctionReport;

  public MalfunctionReportDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMalfunctionReport = new EntityInsertionAdapter<MalfunctionReport>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `malfunction_reports` (`id`,`reeferId`,`reportNumber`,`createdAt`,`createdBy`,`tempBefore`,`pressureBefore`,`humidityBefore`,`tempAfter`,`pressureAfter`,`humidityAfter`,`photoBeforePath`,`photoAfterPath`,`sparePartsUsed`,`notes`,`exportToFinalReport`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final MalfunctionReport entity) {
        statement.bindLong(1, entity.id);
        if (entity.reeferId == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.reeferId);
        }
        if (entity.reportNumber == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.reportNumber);
        }
        final String _tmp = DateConverter.fromDate(entity.createdAt);
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        if (entity.createdBy == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.createdBy);
        }
        if (entity.tempBefore == null) {
          statement.bindNull(6);
        } else {
          statement.bindDouble(6, entity.tempBefore);
        }
        if (entity.pressureBefore == null) {
          statement.bindNull(7);
        } else {
          statement.bindDouble(7, entity.pressureBefore);
        }
        if (entity.humidityBefore == null) {
          statement.bindNull(8);
        } else {
          statement.bindDouble(8, entity.humidityBefore);
        }
        if (entity.tempAfter == null) {
          statement.bindNull(9);
        } else {
          statement.bindDouble(9, entity.tempAfter);
        }
        if (entity.pressureAfter == null) {
          statement.bindNull(10);
        } else {
          statement.bindDouble(10, entity.pressureAfter);
        }
        if (entity.humidityAfter == null) {
          statement.bindNull(11);
        } else {
          statement.bindDouble(11, entity.humidityAfter);
        }
        if (entity.photoBeforePath == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.photoBeforePath);
        }
        if (entity.photoAfterPath == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.photoAfterPath);
        }
        if (entity.sparePartsUsed == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.sparePartsUsed);
        }
        if (entity.notes == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.notes);
        }
        final int _tmp_1 = entity.exportToFinalReport ? 1 : 0;
        statement.bindLong(16, _tmp_1);
      }
    };
    this.__deletionAdapterOfMalfunctionReport = new EntityDeletionOrUpdateAdapter<MalfunctionReport>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `malfunction_reports` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final MalfunctionReport entity) {
        statement.bindLong(1, entity.id);
      }
    };
    this.__updateAdapterOfMalfunctionReport = new EntityDeletionOrUpdateAdapter<MalfunctionReport>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `malfunction_reports` SET `id` = ?,`reeferId` = ?,`reportNumber` = ?,`createdAt` = ?,`createdBy` = ?,`tempBefore` = ?,`pressureBefore` = ?,`humidityBefore` = ?,`tempAfter` = ?,`pressureAfter` = ?,`humidityAfter` = ?,`photoBeforePath` = ?,`photoAfterPath` = ?,`sparePartsUsed` = ?,`notes` = ?,`exportToFinalReport` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final MalfunctionReport entity) {
        statement.bindLong(1, entity.id);
        if (entity.reeferId == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.reeferId);
        }
        if (entity.reportNumber == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.reportNumber);
        }
        final String _tmp = DateConverter.fromDate(entity.createdAt);
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        if (entity.createdBy == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.createdBy);
        }
        if (entity.tempBefore == null) {
          statement.bindNull(6);
        } else {
          statement.bindDouble(6, entity.tempBefore);
        }
        if (entity.pressureBefore == null) {
          statement.bindNull(7);
        } else {
          statement.bindDouble(7, entity.pressureBefore);
        }
        if (entity.humidityBefore == null) {
          statement.bindNull(8);
        } else {
          statement.bindDouble(8, entity.humidityBefore);
        }
        if (entity.tempAfter == null) {
          statement.bindNull(9);
        } else {
          statement.bindDouble(9, entity.tempAfter);
        }
        if (entity.pressureAfter == null) {
          statement.bindNull(10);
        } else {
          statement.bindDouble(10, entity.pressureAfter);
        }
        if (entity.humidityAfter == null) {
          statement.bindNull(11);
        } else {
          statement.bindDouble(11, entity.humidityAfter);
        }
        if (entity.photoBeforePath == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.photoBeforePath);
        }
        if (entity.photoAfterPath == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.photoAfterPath);
        }
        if (entity.sparePartsUsed == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.sparePartsUsed);
        }
        if (entity.notes == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.notes);
        }
        final int _tmp_1 = entity.exportToFinalReport ? 1 : 0;
        statement.bindLong(16, _tmp_1);
        statement.bindLong(17, entity.id);
      }
    };
  }

  @Override
  public long insert(final MalfunctionReport report) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfMalfunctionReport.insertAndReturnId(report);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final MalfunctionReport report) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMalfunctionReport.handle(report);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final MalfunctionReport report) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMalfunctionReport.handle(report);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<MalfunctionReport> getAllSortedByDate() {
    final String _sql = "SELECT * FROM malfunction_reports ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfReeferId = CursorUtil.getColumnIndexOrThrow(_cursor, "reeferId");
      final int _cursorIndexOfReportNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "reportNumber");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
      final int _cursorIndexOfTempBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "tempBefore");
      final int _cursorIndexOfPressureBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureBefore");
      final int _cursorIndexOfHumidityBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityBefore");
      final int _cursorIndexOfTempAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "tempAfter");
      final int _cursorIndexOfPressureAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureAfter");
      final int _cursorIndexOfHumidityAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityAfter");
      final int _cursorIndexOfPhotoBeforePath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoBeforePath");
      final int _cursorIndexOfPhotoAfterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoAfterPath");
      final int _cursorIndexOfSparePartsUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "sparePartsUsed");
      final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
      final int _cursorIndexOfExportToFinalReport = CursorUtil.getColumnIndexOrThrow(_cursor, "exportToFinalReport");
      final List<MalfunctionReport> _result = new ArrayList<MalfunctionReport>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final MalfunctionReport _item;
        _item = new MalfunctionReport();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfReeferId)) {
          _item.reeferId = null;
        } else {
          _item.reeferId = _cursor.getString(_cursorIndexOfReeferId);
        }
        if (_cursor.isNull(_cursorIndexOfReportNumber)) {
          _item.reportNumber = null;
        } else {
          _item.reportNumber = _cursor.getString(_cursorIndexOfReportNumber);
        }
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.createdAt = DateConverter.fromString(_tmp);
        if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
          _item.createdBy = null;
        } else {
          _item.createdBy = _cursor.getString(_cursorIndexOfCreatedBy);
        }
        if (_cursor.isNull(_cursorIndexOfTempBefore)) {
          _item.tempBefore = null;
        } else {
          _item.tempBefore = _cursor.getFloat(_cursorIndexOfTempBefore);
        }
        if (_cursor.isNull(_cursorIndexOfPressureBefore)) {
          _item.pressureBefore = null;
        } else {
          _item.pressureBefore = _cursor.getFloat(_cursorIndexOfPressureBefore);
        }
        if (_cursor.isNull(_cursorIndexOfHumidityBefore)) {
          _item.humidityBefore = null;
        } else {
          _item.humidityBefore = _cursor.getFloat(_cursorIndexOfHumidityBefore);
        }
        if (_cursor.isNull(_cursorIndexOfTempAfter)) {
          _item.tempAfter = null;
        } else {
          _item.tempAfter = _cursor.getFloat(_cursorIndexOfTempAfter);
        }
        if (_cursor.isNull(_cursorIndexOfPressureAfter)) {
          _item.pressureAfter = null;
        } else {
          _item.pressureAfter = _cursor.getFloat(_cursorIndexOfPressureAfter);
        }
        if (_cursor.isNull(_cursorIndexOfHumidityAfter)) {
          _item.humidityAfter = null;
        } else {
          _item.humidityAfter = _cursor.getFloat(_cursorIndexOfHumidityAfter);
        }
        if (_cursor.isNull(_cursorIndexOfPhotoBeforePath)) {
          _item.photoBeforePath = null;
        } else {
          _item.photoBeforePath = _cursor.getString(_cursorIndexOfPhotoBeforePath);
        }
        if (_cursor.isNull(_cursorIndexOfPhotoAfterPath)) {
          _item.photoAfterPath = null;
        } else {
          _item.photoAfterPath = _cursor.getString(_cursorIndexOfPhotoAfterPath);
        }
        if (_cursor.isNull(_cursorIndexOfSparePartsUsed)) {
          _item.sparePartsUsed = null;
        } else {
          _item.sparePartsUsed = _cursor.getString(_cursorIndexOfSparePartsUsed);
        }
        if (_cursor.isNull(_cursorIndexOfNotes)) {
          _item.notes = null;
        } else {
          _item.notes = _cursor.getString(_cursorIndexOfNotes);
        }
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfExportToFinalReport);
        _item.exportToFinalReport = _tmp_1 != 0;
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MalfunctionReport> getByReeferId(final String reeferId) {
    final String _sql = "SELECT * FROM malfunction_reports WHERE reeferId = ? ORDER BY createdAt DESC";
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
      final int _cursorIndexOfReportNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "reportNumber");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
      final int _cursorIndexOfTempBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "tempBefore");
      final int _cursorIndexOfPressureBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureBefore");
      final int _cursorIndexOfHumidityBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityBefore");
      final int _cursorIndexOfTempAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "tempAfter");
      final int _cursorIndexOfPressureAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureAfter");
      final int _cursorIndexOfHumidityAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityAfter");
      final int _cursorIndexOfPhotoBeforePath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoBeforePath");
      final int _cursorIndexOfPhotoAfterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoAfterPath");
      final int _cursorIndexOfSparePartsUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "sparePartsUsed");
      final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
      final int _cursorIndexOfExportToFinalReport = CursorUtil.getColumnIndexOrThrow(_cursor, "exportToFinalReport");
      final List<MalfunctionReport> _result = new ArrayList<MalfunctionReport>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final MalfunctionReport _item;
        _item = new MalfunctionReport();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfReeferId)) {
          _item.reeferId = null;
        } else {
          _item.reeferId = _cursor.getString(_cursorIndexOfReeferId);
        }
        if (_cursor.isNull(_cursorIndexOfReportNumber)) {
          _item.reportNumber = null;
        } else {
          _item.reportNumber = _cursor.getString(_cursorIndexOfReportNumber);
        }
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.createdAt = DateConverter.fromString(_tmp);
        if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
          _item.createdBy = null;
        } else {
          _item.createdBy = _cursor.getString(_cursorIndexOfCreatedBy);
        }
        if (_cursor.isNull(_cursorIndexOfTempBefore)) {
          _item.tempBefore = null;
        } else {
          _item.tempBefore = _cursor.getFloat(_cursorIndexOfTempBefore);
        }
        if (_cursor.isNull(_cursorIndexOfPressureBefore)) {
          _item.pressureBefore = null;
        } else {
          _item.pressureBefore = _cursor.getFloat(_cursorIndexOfPressureBefore);
        }
        if (_cursor.isNull(_cursorIndexOfHumidityBefore)) {
          _item.humidityBefore = null;
        } else {
          _item.humidityBefore = _cursor.getFloat(_cursorIndexOfHumidityBefore);
        }
        if (_cursor.isNull(_cursorIndexOfTempAfter)) {
          _item.tempAfter = null;
        } else {
          _item.tempAfter = _cursor.getFloat(_cursorIndexOfTempAfter);
        }
        if (_cursor.isNull(_cursorIndexOfPressureAfter)) {
          _item.pressureAfter = null;
        } else {
          _item.pressureAfter = _cursor.getFloat(_cursorIndexOfPressureAfter);
        }
        if (_cursor.isNull(_cursorIndexOfHumidityAfter)) {
          _item.humidityAfter = null;
        } else {
          _item.humidityAfter = _cursor.getFloat(_cursorIndexOfHumidityAfter);
        }
        if (_cursor.isNull(_cursorIndexOfPhotoBeforePath)) {
          _item.photoBeforePath = null;
        } else {
          _item.photoBeforePath = _cursor.getString(_cursorIndexOfPhotoBeforePath);
        }
        if (_cursor.isNull(_cursorIndexOfPhotoAfterPath)) {
          _item.photoAfterPath = null;
        } else {
          _item.photoAfterPath = _cursor.getString(_cursorIndexOfPhotoAfterPath);
        }
        if (_cursor.isNull(_cursorIndexOfSparePartsUsed)) {
          _item.sparePartsUsed = null;
        } else {
          _item.sparePartsUsed = _cursor.getString(_cursorIndexOfSparePartsUsed);
        }
        if (_cursor.isNull(_cursorIndexOfNotes)) {
          _item.notes = null;
        } else {
          _item.notes = _cursor.getString(_cursorIndexOfNotes);
        }
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfExportToFinalReport);
        _item.exportToFinalReport = _tmp_1 != 0;
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MalfunctionReport> searchByContainerOrPosition(final String search) {
    final String _sql = "SELECT * FROM malfunction_reports WHERE reeferId LIKE '%' || ? || '%' OR reeferId IN (SELECT container_number FROM reefers WHERE position LIKE '%' || ? || '%') ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (search == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search);
    }
    _argIndex = 2;
    if (search == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfReeferId = CursorUtil.getColumnIndexOrThrow(_cursor, "reeferId");
      final int _cursorIndexOfReportNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "reportNumber");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
      final int _cursorIndexOfTempBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "tempBefore");
      final int _cursorIndexOfPressureBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureBefore");
      final int _cursorIndexOfHumidityBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityBefore");
      final int _cursorIndexOfTempAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "tempAfter");
      final int _cursorIndexOfPressureAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureAfter");
      final int _cursorIndexOfHumidityAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityAfter");
      final int _cursorIndexOfPhotoBeforePath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoBeforePath");
      final int _cursorIndexOfPhotoAfterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoAfterPath");
      final int _cursorIndexOfSparePartsUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "sparePartsUsed");
      final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
      final int _cursorIndexOfExportToFinalReport = CursorUtil.getColumnIndexOrThrow(_cursor, "exportToFinalReport");
      final List<MalfunctionReport> _result = new ArrayList<MalfunctionReport>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final MalfunctionReport _item;
        _item = new MalfunctionReport();
        _item.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfReeferId)) {
          _item.reeferId = null;
        } else {
          _item.reeferId = _cursor.getString(_cursorIndexOfReeferId);
        }
        if (_cursor.isNull(_cursorIndexOfReportNumber)) {
          _item.reportNumber = null;
        } else {
          _item.reportNumber = _cursor.getString(_cursorIndexOfReportNumber);
        }
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.createdAt = DateConverter.fromString(_tmp);
        if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
          _item.createdBy = null;
        } else {
          _item.createdBy = _cursor.getString(_cursorIndexOfCreatedBy);
        }
        if (_cursor.isNull(_cursorIndexOfTempBefore)) {
          _item.tempBefore = null;
        } else {
          _item.tempBefore = _cursor.getFloat(_cursorIndexOfTempBefore);
        }
        if (_cursor.isNull(_cursorIndexOfPressureBefore)) {
          _item.pressureBefore = null;
        } else {
          _item.pressureBefore = _cursor.getFloat(_cursorIndexOfPressureBefore);
        }
        if (_cursor.isNull(_cursorIndexOfHumidityBefore)) {
          _item.humidityBefore = null;
        } else {
          _item.humidityBefore = _cursor.getFloat(_cursorIndexOfHumidityBefore);
        }
        if (_cursor.isNull(_cursorIndexOfTempAfter)) {
          _item.tempAfter = null;
        } else {
          _item.tempAfter = _cursor.getFloat(_cursorIndexOfTempAfter);
        }
        if (_cursor.isNull(_cursorIndexOfPressureAfter)) {
          _item.pressureAfter = null;
        } else {
          _item.pressureAfter = _cursor.getFloat(_cursorIndexOfPressureAfter);
        }
        if (_cursor.isNull(_cursorIndexOfHumidityAfter)) {
          _item.humidityAfter = null;
        } else {
          _item.humidityAfter = _cursor.getFloat(_cursorIndexOfHumidityAfter);
        }
        if (_cursor.isNull(_cursorIndexOfPhotoBeforePath)) {
          _item.photoBeforePath = null;
        } else {
          _item.photoBeforePath = _cursor.getString(_cursorIndexOfPhotoBeforePath);
        }
        if (_cursor.isNull(_cursorIndexOfPhotoAfterPath)) {
          _item.photoAfterPath = null;
        } else {
          _item.photoAfterPath = _cursor.getString(_cursorIndexOfPhotoAfterPath);
        }
        if (_cursor.isNull(_cursorIndexOfSparePartsUsed)) {
          _item.sparePartsUsed = null;
        } else {
          _item.sparePartsUsed = _cursor.getString(_cursorIndexOfSparePartsUsed);
        }
        if (_cursor.isNull(_cursorIndexOfNotes)) {
          _item.notes = null;
        } else {
          _item.notes = _cursor.getString(_cursorIndexOfNotes);
        }
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfExportToFinalReport);
        _item.exportToFinalReport = _tmp_1 != 0;
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public MalfunctionReport getById(final long reportId) {
    final String _sql = "SELECT * FROM malfunction_reports WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, reportId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfReeferId = CursorUtil.getColumnIndexOrThrow(_cursor, "reeferId");
      final int _cursorIndexOfReportNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "reportNumber");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
      final int _cursorIndexOfTempBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "tempBefore");
      final int _cursorIndexOfPressureBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureBefore");
      final int _cursorIndexOfHumidityBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityBefore");
      final int _cursorIndexOfTempAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "tempAfter");
      final int _cursorIndexOfPressureAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureAfter");
      final int _cursorIndexOfHumidityAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityAfter");
      final int _cursorIndexOfPhotoBeforePath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoBeforePath");
      final int _cursorIndexOfPhotoAfterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoAfterPath");
      final int _cursorIndexOfSparePartsUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "sparePartsUsed");
      final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
      final int _cursorIndexOfExportToFinalReport = CursorUtil.getColumnIndexOrThrow(_cursor, "exportToFinalReport");
      final MalfunctionReport _result;
      if (_cursor.moveToFirst()) {
        _result = new MalfunctionReport();
        _result.id = _cursor.getLong(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfReeferId)) {
          _result.reeferId = null;
        } else {
          _result.reeferId = _cursor.getString(_cursorIndexOfReeferId);
        }
        if (_cursor.isNull(_cursorIndexOfReportNumber)) {
          _result.reportNumber = null;
        } else {
          _result.reportNumber = _cursor.getString(_cursorIndexOfReportNumber);
        }
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _result.createdAt = DateConverter.fromString(_tmp);
        if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
          _result.createdBy = null;
        } else {
          _result.createdBy = _cursor.getString(_cursorIndexOfCreatedBy);
        }
        if (_cursor.isNull(_cursorIndexOfTempBefore)) {
          _result.tempBefore = null;
        } else {
          _result.tempBefore = _cursor.getFloat(_cursorIndexOfTempBefore);
        }
        if (_cursor.isNull(_cursorIndexOfPressureBefore)) {
          _result.pressureBefore = null;
        } else {
          _result.pressureBefore = _cursor.getFloat(_cursorIndexOfPressureBefore);
        }
        if (_cursor.isNull(_cursorIndexOfHumidityBefore)) {
          _result.humidityBefore = null;
        } else {
          _result.humidityBefore = _cursor.getFloat(_cursorIndexOfHumidityBefore);
        }
        if (_cursor.isNull(_cursorIndexOfTempAfter)) {
          _result.tempAfter = null;
        } else {
          _result.tempAfter = _cursor.getFloat(_cursorIndexOfTempAfter);
        }
        if (_cursor.isNull(_cursorIndexOfPressureAfter)) {
          _result.pressureAfter = null;
        } else {
          _result.pressureAfter = _cursor.getFloat(_cursorIndexOfPressureAfter);
        }
        if (_cursor.isNull(_cursorIndexOfHumidityAfter)) {
          _result.humidityAfter = null;
        } else {
          _result.humidityAfter = _cursor.getFloat(_cursorIndexOfHumidityAfter);
        }
        if (_cursor.isNull(_cursorIndexOfPhotoBeforePath)) {
          _result.photoBeforePath = null;
        } else {
          _result.photoBeforePath = _cursor.getString(_cursorIndexOfPhotoBeforePath);
        }
        if (_cursor.isNull(_cursorIndexOfPhotoAfterPath)) {
          _result.photoAfterPath = null;
        } else {
          _result.photoAfterPath = _cursor.getString(_cursorIndexOfPhotoAfterPath);
        }
        if (_cursor.isNull(_cursorIndexOfSparePartsUsed)) {
          _result.sparePartsUsed = null;
        } else {
          _result.sparePartsUsed = _cursor.getString(_cursorIndexOfSparePartsUsed);
        }
        if (_cursor.isNull(_cursorIndexOfNotes)) {
          _result.notes = null;
        } else {
          _result.notes = _cursor.getString(_cursorIndexOfNotes);
        }
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfExportToFinalReport);
        _result.exportToFinalReport = _tmp_1 != 0;
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
  public List<MalfunctionReportWithReefer> getAllWithReefer() {
    final String _sql = "SELECT * FROM malfunction_reports ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
        final int _cursorIndexOfReeferId = CursorUtil.getColumnIndexOrThrow(_cursor, "reeferId");
        final int _cursorIndexOfReportNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "reportNumber");
        final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
        final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
        final int _cursorIndexOfTempBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "tempBefore");
        final int _cursorIndexOfPressureBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureBefore");
        final int _cursorIndexOfHumidityBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityBefore");
        final int _cursorIndexOfTempAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "tempAfter");
        final int _cursorIndexOfPressureAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureAfter");
        final int _cursorIndexOfHumidityAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityAfter");
        final int _cursorIndexOfPhotoBeforePath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoBeforePath");
        final int _cursorIndexOfPhotoAfterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoAfterPath");
        final int _cursorIndexOfSparePartsUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "sparePartsUsed");
        final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
        final int _cursorIndexOfExportToFinalReport = CursorUtil.getColumnIndexOrThrow(_cursor, "exportToFinalReport");
        final ArrayMap<String, Reefer> _collectionReefer = new ArrayMap<String, Reefer>();
        while (_cursor.moveToNext()) {
          final String _tmpKey;
          if (_cursor.isNull(_cursorIndexOfReeferId)) {
            _tmpKey = null;
          } else {
            _tmpKey = _cursor.getString(_cursorIndexOfReeferId);
          }
          if (_tmpKey != null) {
            _collectionReefer.put(_tmpKey, null);
          }
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshipreefersAscomOceanbyteReefercontrolModelsReefer(_collectionReefer);
        final List<MalfunctionReportWithReefer> _result = new ArrayList<MalfunctionReportWithReefer>(_cursor.getCount());
        while (_cursor.moveToNext()) {
          final MalfunctionReportWithReefer _item;
          final MalfunctionReport _tmpReport;
          if (!(_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfReeferId) && _cursor.isNull(_cursorIndexOfReportNumber) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfCreatedBy) && _cursor.isNull(_cursorIndexOfTempBefore) && _cursor.isNull(_cursorIndexOfPressureBefore) && _cursor.isNull(_cursorIndexOfHumidityBefore) && _cursor.isNull(_cursorIndexOfTempAfter) && _cursor.isNull(_cursorIndexOfPressureAfter) && _cursor.isNull(_cursorIndexOfHumidityAfter) && _cursor.isNull(_cursorIndexOfPhotoBeforePath) && _cursor.isNull(_cursorIndexOfPhotoAfterPath) && _cursor.isNull(_cursorIndexOfSparePartsUsed) && _cursor.isNull(_cursorIndexOfNotes) && _cursor.isNull(_cursorIndexOfExportToFinalReport))) {
            _tmpReport = new MalfunctionReport();
            _tmpReport.id = _cursor.getLong(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfReeferId)) {
              _tmpReport.reeferId = null;
            } else {
              _tmpReport.reeferId = _cursor.getString(_cursorIndexOfReeferId);
            }
            if (_cursor.isNull(_cursorIndexOfReportNumber)) {
              _tmpReport.reportNumber = null;
            } else {
              _tmpReport.reportNumber = _cursor.getString(_cursorIndexOfReportNumber);
            }
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _tmpReport.createdAt = DateConverter.fromString(_tmp);
            if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
              _tmpReport.createdBy = null;
            } else {
              _tmpReport.createdBy = _cursor.getString(_cursorIndexOfCreatedBy);
            }
            if (_cursor.isNull(_cursorIndexOfTempBefore)) {
              _tmpReport.tempBefore = null;
            } else {
              _tmpReport.tempBefore = _cursor.getFloat(_cursorIndexOfTempBefore);
            }
            if (_cursor.isNull(_cursorIndexOfPressureBefore)) {
              _tmpReport.pressureBefore = null;
            } else {
              _tmpReport.pressureBefore = _cursor.getFloat(_cursorIndexOfPressureBefore);
            }
            if (_cursor.isNull(_cursorIndexOfHumidityBefore)) {
              _tmpReport.humidityBefore = null;
            } else {
              _tmpReport.humidityBefore = _cursor.getFloat(_cursorIndexOfHumidityBefore);
            }
            if (_cursor.isNull(_cursorIndexOfTempAfter)) {
              _tmpReport.tempAfter = null;
            } else {
              _tmpReport.tempAfter = _cursor.getFloat(_cursorIndexOfTempAfter);
            }
            if (_cursor.isNull(_cursorIndexOfPressureAfter)) {
              _tmpReport.pressureAfter = null;
            } else {
              _tmpReport.pressureAfter = _cursor.getFloat(_cursorIndexOfPressureAfter);
            }
            if (_cursor.isNull(_cursorIndexOfHumidityAfter)) {
              _tmpReport.humidityAfter = null;
            } else {
              _tmpReport.humidityAfter = _cursor.getFloat(_cursorIndexOfHumidityAfter);
            }
            if (_cursor.isNull(_cursorIndexOfPhotoBeforePath)) {
              _tmpReport.photoBeforePath = null;
            } else {
              _tmpReport.photoBeforePath = _cursor.getString(_cursorIndexOfPhotoBeforePath);
            }
            if (_cursor.isNull(_cursorIndexOfPhotoAfterPath)) {
              _tmpReport.photoAfterPath = null;
            } else {
              _tmpReport.photoAfterPath = _cursor.getString(_cursorIndexOfPhotoAfterPath);
            }
            if (_cursor.isNull(_cursorIndexOfSparePartsUsed)) {
              _tmpReport.sparePartsUsed = null;
            } else {
              _tmpReport.sparePartsUsed = _cursor.getString(_cursorIndexOfSparePartsUsed);
            }
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpReport.notes = null;
            } else {
              _tmpReport.notes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfExportToFinalReport);
            _tmpReport.exportToFinalReport = _tmp_1 != 0;
          } else {
            _tmpReport = null;
          }
          final Reefer _tmpReefer;
          final String _tmpKey_1;
          if (_cursor.isNull(_cursorIndexOfReeferId)) {
            _tmpKey_1 = null;
          } else {
            _tmpKey_1 = _cursor.getString(_cursorIndexOfReeferId);
          }
          if (_tmpKey_1 != null) {
            _tmpReefer = _collectionReefer.get(_tmpKey_1);
          } else {
            _tmpReefer = null;
          }
          _item = new MalfunctionReportWithReefer();
          _item.report = _tmpReport;
          _item.reefer = _tmpReefer;
          _result.add(_item);
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<MalfunctionReportWithReefer> searchWithReefer(final String search) {
    final String _sql = "SELECT * FROM malfunction_reports JOIN reefers ON malfunction_reports.reeferId = reefers.container_number WHERE reefers.container_number LIKE '%' || ? || '%'    OR reefers.position LIKE '%' || ? || '%' ORDER BY malfunction_reports.createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (search == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search);
    }
    _argIndex = 2;
    if (search == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search);
    }
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
        final int _cursorIndexOfReeferId = CursorUtil.getColumnIndexOrThrow(_cursor, "reeferId");
        final int _cursorIndexOfReportNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "reportNumber");
        final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
        final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
        final int _cursorIndexOfTempBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "tempBefore");
        final int _cursorIndexOfPressureBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureBefore");
        final int _cursorIndexOfHumidityBefore = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityBefore");
        final int _cursorIndexOfTempAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "tempAfter");
        final int _cursorIndexOfPressureAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "pressureAfter");
        final int _cursorIndexOfHumidityAfter = CursorUtil.getColumnIndexOrThrow(_cursor, "humidityAfter");
        final int _cursorIndexOfPhotoBeforePath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoBeforePath");
        final int _cursorIndexOfPhotoAfterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "photoAfterPath");
        final int _cursorIndexOfSparePartsUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "sparePartsUsed");
        final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
        final int _cursorIndexOfExportToFinalReport = CursorUtil.getColumnIndexOrThrow(_cursor, "exportToFinalReport");
        final ArrayMap<String, Reefer> _collectionReefer = new ArrayMap<String, Reefer>();
        while (_cursor.moveToNext()) {
          final String _tmpKey;
          if (_cursor.isNull(_cursorIndexOfReeferId)) {
            _tmpKey = null;
          } else {
            _tmpKey = _cursor.getString(_cursorIndexOfReeferId);
          }
          if (_tmpKey != null) {
            _collectionReefer.put(_tmpKey, null);
          }
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshipreefersAscomOceanbyteReefercontrolModelsReefer(_collectionReefer);
        final List<MalfunctionReportWithReefer> _result = new ArrayList<MalfunctionReportWithReefer>(_cursor.getCount());
        while (_cursor.moveToNext()) {
          final MalfunctionReportWithReefer _item;
          final MalfunctionReport _tmpReport;
          if (!(_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfReeferId) && _cursor.isNull(_cursorIndexOfReportNumber) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfCreatedBy) && _cursor.isNull(_cursorIndexOfTempBefore) && _cursor.isNull(_cursorIndexOfPressureBefore) && _cursor.isNull(_cursorIndexOfHumidityBefore) && _cursor.isNull(_cursorIndexOfTempAfter) && _cursor.isNull(_cursorIndexOfPressureAfter) && _cursor.isNull(_cursorIndexOfHumidityAfter) && _cursor.isNull(_cursorIndexOfPhotoBeforePath) && _cursor.isNull(_cursorIndexOfPhotoAfterPath) && _cursor.isNull(_cursorIndexOfSparePartsUsed) && _cursor.isNull(_cursorIndexOfNotes) && _cursor.isNull(_cursorIndexOfExportToFinalReport))) {
            _tmpReport = new MalfunctionReport();
            _tmpReport.id = _cursor.getLong(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfReeferId)) {
              _tmpReport.reeferId = null;
            } else {
              _tmpReport.reeferId = _cursor.getString(_cursorIndexOfReeferId);
            }
            if (_cursor.isNull(_cursorIndexOfReportNumber)) {
              _tmpReport.reportNumber = null;
            } else {
              _tmpReport.reportNumber = _cursor.getString(_cursorIndexOfReportNumber);
            }
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            _tmpReport.createdAt = DateConverter.fromString(_tmp);
            if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
              _tmpReport.createdBy = null;
            } else {
              _tmpReport.createdBy = _cursor.getString(_cursorIndexOfCreatedBy);
            }
            if (_cursor.isNull(_cursorIndexOfTempBefore)) {
              _tmpReport.tempBefore = null;
            } else {
              _tmpReport.tempBefore = _cursor.getFloat(_cursorIndexOfTempBefore);
            }
            if (_cursor.isNull(_cursorIndexOfPressureBefore)) {
              _tmpReport.pressureBefore = null;
            } else {
              _tmpReport.pressureBefore = _cursor.getFloat(_cursorIndexOfPressureBefore);
            }
            if (_cursor.isNull(_cursorIndexOfHumidityBefore)) {
              _tmpReport.humidityBefore = null;
            } else {
              _tmpReport.humidityBefore = _cursor.getFloat(_cursorIndexOfHumidityBefore);
            }
            if (_cursor.isNull(_cursorIndexOfTempAfter)) {
              _tmpReport.tempAfter = null;
            } else {
              _tmpReport.tempAfter = _cursor.getFloat(_cursorIndexOfTempAfter);
            }
            if (_cursor.isNull(_cursorIndexOfPressureAfter)) {
              _tmpReport.pressureAfter = null;
            } else {
              _tmpReport.pressureAfter = _cursor.getFloat(_cursorIndexOfPressureAfter);
            }
            if (_cursor.isNull(_cursorIndexOfHumidityAfter)) {
              _tmpReport.humidityAfter = null;
            } else {
              _tmpReport.humidityAfter = _cursor.getFloat(_cursorIndexOfHumidityAfter);
            }
            if (_cursor.isNull(_cursorIndexOfPhotoBeforePath)) {
              _tmpReport.photoBeforePath = null;
            } else {
              _tmpReport.photoBeforePath = _cursor.getString(_cursorIndexOfPhotoBeforePath);
            }
            if (_cursor.isNull(_cursorIndexOfPhotoAfterPath)) {
              _tmpReport.photoAfterPath = null;
            } else {
              _tmpReport.photoAfterPath = _cursor.getString(_cursorIndexOfPhotoAfterPath);
            }
            if (_cursor.isNull(_cursorIndexOfSparePartsUsed)) {
              _tmpReport.sparePartsUsed = null;
            } else {
              _tmpReport.sparePartsUsed = _cursor.getString(_cursorIndexOfSparePartsUsed);
            }
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpReport.notes = null;
            } else {
              _tmpReport.notes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfExportToFinalReport);
            _tmpReport.exportToFinalReport = _tmp_1 != 0;
          } else {
            _tmpReport = null;
          }
          final Reefer _tmpReefer;
          final String _tmpKey_1;
          if (_cursor.isNull(_cursorIndexOfReeferId)) {
            _tmpKey_1 = null;
          } else {
            _tmpKey_1 = _cursor.getString(_cursorIndexOfReeferId);
          }
          if (_tmpKey_1 != null) {
            _tmpReefer = _collectionReefer.get(_tmpKey_1);
          } else {
            _tmpReefer = null;
          }
          _item = new MalfunctionReportWithReefer();
          _item.report = _tmpReport;
          _item.reefer = _tmpReefer;
          _result.add(_item);
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipreefersAscomOceanbyteReefercontrolModelsReefer(
      @NonNull final ArrayMap<String, Reefer> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchArrayMap(_map, false, (map) -> {
        __fetchRelationshipreefersAscomOceanbyteReefercontrolModelsReefer(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `container_number`,`position`,`loading_port`,`discharge_port`,`atd`,`eta`,`operator`,`cargo_type`,`status`,`is_active`,`temperature_supply`,`temperature_return`,`set_point`,`last_temperature_update`,`updatedBy` FROM `reefers` WHERE `container_number` IN (");
    final int _inputSize = __mapKeySet == null ? 1 : __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (__mapKeySet == null) {
      _stmt.bindNull(_argIndex);
    } else {
      for (String _item : __mapKeySet) {
        if (_item == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _item);
        }
        _argIndex++;
      }
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "container_number");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfContainerNumber = 0;
      final int _cursorIndexOfPosition = 1;
      final int _cursorIndexOfLoadingPort = 2;
      final int _cursorIndexOfDischargePort = 3;
      final int _cursorIndexOfAtd = 4;
      final int _cursorIndexOfEta = 5;
      final int _cursorIndexOfOperator = 6;
      final int _cursorIndexOfCargoType = 7;
      final int _cursorIndexOfStatus = 8;
      final int _cursorIndexOfIsActive = 9;
      final int _cursorIndexOfTemperatureSupply = 10;
      final int _cursorIndexOfTemperatureReturn = 11;
      final int _cursorIndexOfSetPoint = 12;
      final int _cursorIndexOfLastTemperatureUpdate = 13;
      final int _cursorIndexOfUpdatedBy = 14;
      while (_cursor.moveToNext()) {
        final String _tmpKey;
        if (_cursor.isNull(_itemKeyIndex)) {
          _tmpKey = null;
        } else {
          _tmpKey = _cursor.getString(_itemKeyIndex);
        }
        if (_tmpKey != null) {
          if (_map.containsKey(_tmpKey)) {
            final Reefer _item_1;
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
            _item_1 = new Reefer(_tmpContainerNumber,_tmpPosition,_tmpLoadingPort,_tmpDischargePort,_tmpAtd,_tmpEta,_tmpOperator,_tmpCargoType,_tmpStatus,_tmpIsActive,_tmpTemperatureSupply,_tmpTemperatureReturn,_tmpSetPoint,_tmpLastTemperatureUpdate,_tmpUpdatedBy);
            _map.put(_tmpKey, _item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}

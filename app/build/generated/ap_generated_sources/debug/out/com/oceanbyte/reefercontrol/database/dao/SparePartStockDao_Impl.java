package com.oceanbyte.reefercontrol.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.oceanbyte.reefercontrol.models.SparePartStock;
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
public final class SparePartStockDao_Impl implements SparePartStockDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SparePartStock> __insertionAdapterOfSparePartStock;

  private final EntityDeletionOrUpdateAdapter<SparePartStock> __deletionAdapterOfSparePartStock;

  private final EntityDeletionOrUpdateAdapter<SparePartStock> __updateAdapterOfSparePartStock;

  public SparePartStockDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSparePartStock = new EntityInsertionAdapter<SparePartStock>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `spare_part_stock` (`id`,`maker`,`model`,`partNumber`,`description`,`quantity`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final SparePartStock entity) {
        statement.bindLong(1, entity.id);
        if (entity.maker == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.maker);
        }
        if (entity.model == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.model);
        }
        if (entity.partNumber == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.partNumber);
        }
        if (entity.description == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.description);
        }
        statement.bindLong(6, entity.quantity);
      }
    };
    this.__deletionAdapterOfSparePartStock = new EntityDeletionOrUpdateAdapter<SparePartStock>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `spare_part_stock` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final SparePartStock entity) {
        statement.bindLong(1, entity.id);
      }
    };
    this.__updateAdapterOfSparePartStock = new EntityDeletionOrUpdateAdapter<SparePartStock>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `spare_part_stock` SET `id` = ?,`maker` = ?,`model` = ?,`partNumber` = ?,`description` = ?,`quantity` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final SparePartStock entity) {
        statement.bindLong(1, entity.id);
        if (entity.maker == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.maker);
        }
        if (entity.model == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.model);
        }
        if (entity.partNumber == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.partNumber);
        }
        if (entity.description == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.description);
        }
        statement.bindLong(6, entity.quantity);
        statement.bindLong(7, entity.id);
      }
    };
  }

  @Override
  public void insert(final SparePartStock part) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSparePartStock.insert(part);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SparePartStock part) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSparePartStock.handle(part);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SparePartStock part) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSparePartStock.handle(part);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<SparePartStock>> getAll() {
    final String _sql = "SELECT * FROM spare_part_stock ORDER BY description ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"spare_part_stock"}, false, new Callable<List<SparePartStock>>() {
      @Override
      @Nullable
      public List<SparePartStock> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMaker = CursorUtil.getColumnIndexOrThrow(_cursor, "maker");
          final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
          final int _cursorIndexOfPartNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "partNumber");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final List<SparePartStock> _result = new ArrayList<SparePartStock>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SparePartStock _item;
            _item = new SparePartStock();
            _item.id = _cursor.getLong(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfMaker)) {
              _item.maker = null;
            } else {
              _item.maker = _cursor.getString(_cursorIndexOfMaker);
            }
            if (_cursor.isNull(_cursorIndexOfModel)) {
              _item.model = null;
            } else {
              _item.model = _cursor.getString(_cursorIndexOfModel);
            }
            if (_cursor.isNull(_cursorIndexOfPartNumber)) {
              _item.partNumber = null;
            } else {
              _item.partNumber = _cursor.getString(_cursorIndexOfPartNumber);
            }
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _item.description = null;
            } else {
              _item.description = _cursor.getString(_cursorIndexOfDescription);
            }
            _item.quantity = _cursor.getInt(_cursorIndexOfQuantity);
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
  public LiveData<List<SparePartStock>> search(final String query) {
    final String _sql = "SELECT * FROM spare_part_stock WHERE description LIKE '%' || ? || '%' OR partNumber LIKE '%' || ? || '%' ORDER BY description";
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
    return __db.getInvalidationTracker().createLiveData(new String[] {"spare_part_stock"}, false, new Callable<List<SparePartStock>>() {
      @Override
      @Nullable
      public List<SparePartStock> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMaker = CursorUtil.getColumnIndexOrThrow(_cursor, "maker");
          final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
          final int _cursorIndexOfPartNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "partNumber");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final List<SparePartStock> _result = new ArrayList<SparePartStock>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SparePartStock _item;
            _item = new SparePartStock();
            _item.id = _cursor.getLong(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfMaker)) {
              _item.maker = null;
            } else {
              _item.maker = _cursor.getString(_cursorIndexOfMaker);
            }
            if (_cursor.isNull(_cursorIndexOfModel)) {
              _item.model = null;
            } else {
              _item.model = _cursor.getString(_cursorIndexOfModel);
            }
            if (_cursor.isNull(_cursorIndexOfPartNumber)) {
              _item.partNumber = null;
            } else {
              _item.partNumber = _cursor.getString(_cursorIndexOfPartNumber);
            }
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _item.description = null;
            } else {
              _item.description = _cursor.getString(_cursorIndexOfDescription);
            }
            _item.quantity = _cursor.getInt(_cursorIndexOfQuantity);
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
  public LiveData<List<String>> getAllMakers() {
    final String _sql = "SELECT DISTINCT maker FROM spare_part_stock ORDER BY maker";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"spare_part_stock"}, false, new Callable<List<String>>() {
      @Override
      @Nullable
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
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
  public LiveData<List<String>> getModelsForMaker(final String maker) {
    final String _sql = "SELECT DISTINCT model FROM spare_part_stock WHERE maker = ? ORDER BY model";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (maker == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, maker);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"spare_part_stock"}, false, new Callable<List<String>>() {
      @Override
      @Nullable
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
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
  public LiveData<List<SparePartStock>> filterByMaker(final String maker) {
    final String _sql = "SELECT * FROM spare_part_stock WHERE maker = ? ORDER BY description";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (maker == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, maker);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"spare_part_stock"}, false, new Callable<List<SparePartStock>>() {
      @Override
      @Nullable
      public List<SparePartStock> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMaker = CursorUtil.getColumnIndexOrThrow(_cursor, "maker");
          final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
          final int _cursorIndexOfPartNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "partNumber");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final List<SparePartStock> _result = new ArrayList<SparePartStock>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SparePartStock _item;
            _item = new SparePartStock();
            _item.id = _cursor.getLong(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfMaker)) {
              _item.maker = null;
            } else {
              _item.maker = _cursor.getString(_cursorIndexOfMaker);
            }
            if (_cursor.isNull(_cursorIndexOfModel)) {
              _item.model = null;
            } else {
              _item.model = _cursor.getString(_cursorIndexOfModel);
            }
            if (_cursor.isNull(_cursorIndexOfPartNumber)) {
              _item.partNumber = null;
            } else {
              _item.partNumber = _cursor.getString(_cursorIndexOfPartNumber);
            }
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _item.description = null;
            } else {
              _item.description = _cursor.getString(_cursorIndexOfDescription);
            }
            _item.quantity = _cursor.getInt(_cursorIndexOfQuantity);
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
  public LiveData<List<SparePartStock>> filterByMakerAndModel(final String maker,
      final String model) {
    final String _sql = "SELECT * FROM spare_part_stock WHERE maker = ? AND model = ? ORDER BY description";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (maker == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, maker);
    }
    _argIndex = 2;
    if (model == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, model);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"spare_part_stock"}, false, new Callable<List<SparePartStock>>() {
      @Override
      @Nullable
      public List<SparePartStock> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMaker = CursorUtil.getColumnIndexOrThrow(_cursor, "maker");
          final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
          final int _cursorIndexOfPartNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "partNumber");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final List<SparePartStock> _result = new ArrayList<SparePartStock>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SparePartStock _item;
            _item = new SparePartStock();
            _item.id = _cursor.getLong(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfMaker)) {
              _item.maker = null;
            } else {
              _item.maker = _cursor.getString(_cursorIndexOfMaker);
            }
            if (_cursor.isNull(_cursorIndexOfModel)) {
              _item.model = null;
            } else {
              _item.model = _cursor.getString(_cursorIndexOfModel);
            }
            if (_cursor.isNull(_cursorIndexOfPartNumber)) {
              _item.partNumber = null;
            } else {
              _item.partNumber = _cursor.getString(_cursorIndexOfPartNumber);
            }
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _item.description = null;
            } else {
              _item.description = _cursor.getString(_cursorIndexOfDescription);
            }
            _item.quantity = _cursor.getInt(_cursorIndexOfQuantity);
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
  public LiveData<SparePartStock> getById(final long id) {
    final String _sql = "SELECT * FROM spare_part_stock WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[] {"spare_part_stock"}, false, new Callable<SparePartStock>() {
      @Override
      @Nullable
      public SparePartStock call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMaker = CursorUtil.getColumnIndexOrThrow(_cursor, "maker");
          final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
          final int _cursorIndexOfPartNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "partNumber");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final SparePartStock _result;
          if (_cursor.moveToFirst()) {
            _result = new SparePartStock();
            _result.id = _cursor.getLong(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfMaker)) {
              _result.maker = null;
            } else {
              _result.maker = _cursor.getString(_cursorIndexOfMaker);
            }
            if (_cursor.isNull(_cursorIndexOfModel)) {
              _result.model = null;
            } else {
              _result.model = _cursor.getString(_cursorIndexOfModel);
            }
            if (_cursor.isNull(_cursorIndexOfPartNumber)) {
              _result.partNumber = null;
            } else {
              _result.partNumber = _cursor.getString(_cursorIndexOfPartNumber);
            }
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _result.description = null;
            } else {
              _result.description = _cursor.getString(_cursorIndexOfDescription);
            }
            _result.quantity = _cursor.getInt(_cursorIndexOfQuantity);
          } else {
            _result = null;
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

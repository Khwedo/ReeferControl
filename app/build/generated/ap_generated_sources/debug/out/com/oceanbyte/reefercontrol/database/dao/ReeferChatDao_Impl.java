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
import com.oceanbyte.reefercontrol.models.ReeferChatMessage;
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
public final class ReeferChatDao_Impl implements ReeferChatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ReeferChatMessage> __insertionAdapterOfReeferChatMessage;

  private final EntityDeletionOrUpdateAdapter<ReeferChatMessage> __updateAdapterOfReeferChatMessage;

  public ReeferChatDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReeferChatMessage = new EntityInsertionAdapter<ReeferChatMessage>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `reefer_chat` (`id`,`reeferId`,`senderRole`,`message`,`timestamp`,`readBy`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final ReeferChatMessage entity) {
        statement.bindLong(1, entity.id);
        if (entity.reeferId == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.reeferId);
        }
        if (entity.senderRole == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.senderRole);
        }
        if (entity.message == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.message);
        }
        if (entity.timestamp == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.timestamp);
        }
        if (entity.readBy == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.readBy);
        }
      }
    };
    this.__updateAdapterOfReeferChatMessage = new EntityDeletionOrUpdateAdapter<ReeferChatMessage>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `reefer_chat` SET `id` = ?,`reeferId` = ?,`senderRole` = ?,`message` = ?,`timestamp` = ?,`readBy` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final ReeferChatMessage entity) {
        statement.bindLong(1, entity.id);
        if (entity.reeferId == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.reeferId);
        }
        if (entity.senderRole == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.senderRole);
        }
        if (entity.message == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.message);
        }
        if (entity.timestamp == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.timestamp);
        }
        if (entity.readBy == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.readBy);
        }
        statement.bindLong(7, entity.id);
      }
    };
  }

  @Override
  public void insert(final ReeferChatMessage message) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfReeferChatMessage.insert(message);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ReeferChatMessage message) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfReeferChatMessage.handle(message);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<ReeferChatMessage>> getMessagesForReefer(final String reeferId) {
    final String _sql = "SELECT * FROM reefer_chat WHERE reeferId = ? ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (reeferId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, reeferId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"reefer_chat"}, false, new Callable<List<ReeferChatMessage>>() {
      @Override
      @Nullable
      public List<ReeferChatMessage> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfReeferId = CursorUtil.getColumnIndexOrThrow(_cursor, "reeferId");
          final int _cursorIndexOfSenderRole = CursorUtil.getColumnIndexOrThrow(_cursor, "senderRole");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfReadBy = CursorUtil.getColumnIndexOrThrow(_cursor, "readBy");
          final List<ReeferChatMessage> _result = new ArrayList<ReeferChatMessage>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ReeferChatMessage _item;
            _item = new ReeferChatMessage();
            _item.id = _cursor.getLong(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfReeferId)) {
              _item.reeferId = null;
            } else {
              _item.reeferId = _cursor.getString(_cursorIndexOfReeferId);
            }
            if (_cursor.isNull(_cursorIndexOfSenderRole)) {
              _item.senderRole = null;
            } else {
              _item.senderRole = _cursor.getString(_cursorIndexOfSenderRole);
            }
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _item.message = null;
            } else {
              _item.message = _cursor.getString(_cursorIndexOfMessage);
            }
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _item.timestamp = null;
            } else {
              _item.timestamp = _cursor.getString(_cursorIndexOfTimestamp);
            }
            if (_cursor.isNull(_cursorIndexOfReadBy)) {
              _item.readBy = null;
            } else {
              _item.readBy = _cursor.getString(_cursorIndexOfReadBy);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

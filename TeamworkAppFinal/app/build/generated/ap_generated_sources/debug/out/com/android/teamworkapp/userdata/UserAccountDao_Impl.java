package com.android.teamworkapp.userdata;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public final class UserAccountDao_Impl implements UserAccountDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUserAccount;

  public UserAccountDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserAccount = new EntityInsertionAdapter<UserAccount>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `useraccounts`(`userId`,`password`,`emailId`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserAccount value) {
        if (value.getUserId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserId());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPassword());
        }
        if (value.getEmailId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmailId());
        }
      }
    };
  }

  @Override
  public void insert(UserAccount account) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserAccount.insert(account);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public UserAccount getAccount(String emailId) {
    final String _sql = "SELECT * FROM useraccounts WHERE useraccounts.emailId LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (emailId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, emailId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUserId = _cursor.getColumnIndexOrThrow("userId");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfEmailId = _cursor.getColumnIndexOrThrow("emailId");
      final UserAccount _result;
      if(_cursor.moveToFirst()) {
        _result = new UserAccount();
        final String _tmpUserId;
        _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
        _result.setUserId(_tmpUserId);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
        final String _tmpEmailId;
        _tmpEmailId = _cursor.getString(_cursorIndexOfEmailId);
        _result.setEmailId(_tmpEmailId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}

package com.android.teamworkapp.userdata;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.android.teamworkapp.userdata.UserAccount;

@Dao
public interface UserAccountDao {

	@Insert
	void insert(UserAccount account);

	@Query("SELECT * FROM useraccounts WHERE useraccounts.emailId LIKE :emailId")
	UserAccount getAccount(String emailId);
}

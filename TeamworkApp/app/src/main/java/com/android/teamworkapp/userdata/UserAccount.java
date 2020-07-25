package com.android.teamworkapp.userdata;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.android.teamworkapp.userdata.UserAccount.TABLE_NAME;


@Entity(tableName = TABLE_NAME)
public class UserAccount {

	public static final String TABLE_NAME = "useraccounts";

	@NonNull
	String userId;
	String password;

	@PrimaryKey @NonNull
	String emailId;

	public UserAccount() {

	}

	public UserAccount(String emailId, String userName, String password) {

		this.emailId = emailId;
		this.userId = userName;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(@NonNull String emailId) {
		this.emailId = emailId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(@NonNull String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

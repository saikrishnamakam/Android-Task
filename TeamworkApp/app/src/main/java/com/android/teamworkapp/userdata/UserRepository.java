package com.android.teamworkapp.userdata;

import androidx.lifecycle.LiveData;

public class UserRepository {

	private final UserAccountDao mUserAccountDao;
	private static UserRepository instance;
	private LiveData<UserAccount> mUserAccountLiveData;

	private UserRepository(UserAccountDao userAccountDao) {

		this.mUserAccountDao = userAccountDao;
	}

	public static UserRepository getInstance(UserAccountDao userAccountDao) {

		if(instance == null) {
			instance = new UserRepository(userAccountDao);
		}
		return instance;
	}

	public boolean isValidAccount(String emailId, final String password) {

		UserAccount userAccount = mUserAccountDao.getAccount(emailId);
		if(userAccount != null)
			return userAccount.getPassword().equals(password);
		else
			return false;
	}

	public void insertUser(String emailId, String userName, String password) {

		UserAccount account = new UserAccount(emailId, userName, password);
		mUserAccountDao.insert(account);
	}
}

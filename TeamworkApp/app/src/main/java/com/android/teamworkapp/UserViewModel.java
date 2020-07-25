package com.android.teamworkapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.android.teamworkapp.userdata.UserAccountDatabase;
import com.android.teamworkapp.userdata.UserRepository;

public class UserViewModel extends ViewModel {

	private UserRepository mUserRepository;

	public UserViewModel(Context context) {

		mUserRepository = UserRepository.getInstance(UserAccountDatabase.getAppDatabase(context).userAccountDao());
	}

	void createUser(String emailId, String userName, String password) {

		mUserRepository.insertUser(emailId, userName, password);
	}

	boolean checkValidLogin(String emailId, String password) {

		return mUserRepository.isValidAccount(emailId, password);
	}

	public static class Factory implements ViewModelProvider.Factory {

		private final Context context;

		Factory(Context context) {

			this.context = context;
		}

		@NonNull
		@Override
		public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
			return (T) new UserViewModel(context);
		}
	}
}

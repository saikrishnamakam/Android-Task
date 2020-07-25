package com.android.teamworkapp.userdata;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserAccount.class}, version = 1)
public abstract class UserAccountDatabase extends RoomDatabase {

	public static UserAccountDatabase INSTANCE;

	public abstract UserAccountDao userAccountDao();

	public static UserAccountDatabase getAppDatabase(Context context) {

		if(INSTANCE == null) {
			INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserAccountDatabase.class, "user-dataabase").allowMainThreadQueries().build();
		}
		return INSTANCE;
	}

	public static void destroyInstance() {
		INSTANCE = null;
	}
}

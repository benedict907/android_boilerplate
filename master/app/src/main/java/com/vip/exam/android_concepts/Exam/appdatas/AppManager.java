package com.vip.exam.android_concepts.Exam.appdatas;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;

import com.example.vipin.kotlindemo.model.manger_model.User;
import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

public class AppManager {

	private static AppManager uniqInstance;

	public User user = null;


	SharedPreferences mPrefs ;


	public Location location = null;

	public synchronized static AppManager getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new AppManager();
		}
		return uniqInstance;
	}


	public void saveUser(Context context) {
		 mPrefs = context.getSharedPreferences(AppConstants.getInstance().SHARED_PREFENCE_NAME, MODE_PRIVATE);
		SharedPreferences.Editor prefsEditor = mPrefs.edit();
		Gson gson = new Gson();
		String json = gson.toJson(user);
		prefsEditor.putString("PostaUser", json);
		prefsEditor.apply();
	}

	public void loadUser(Context context) {
		 mPrefs = context.getSharedPreferences(AppConstants.getInstance().SHARED_PREFENCE_NAME, MODE_PRIVATE);
		if (mPrefs.contains("PostaUser")) {
			Gson gson = new Gson();
			String json = mPrefs.getString("PostaUser", "");
			user = gson.fromJson(json, User.class);
		} else {
			user = new User();
		}

	}


	public void deleteSavedData(String key,Context context) {
		user = new User();
		mPrefs = context.getSharedPreferences("SHARED_PREFENCE_NAME", MODE_PRIVATE);
		mPrefs.edit().remove(key).apply();
	}
}

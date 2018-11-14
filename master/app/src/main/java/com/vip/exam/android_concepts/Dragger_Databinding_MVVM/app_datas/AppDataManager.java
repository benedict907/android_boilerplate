package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.app_datas;

import android.content.Context;
import android.content.SharedPreferences;


import com.google.gson.Gson;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.dragger.MyApp;

import javax.inject.Inject;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by vipin on 8/3/18.
 */

public class AppDataManager {

	@Inject
	Context mContext;

//	private Context mContext;

	@Inject
	public User user;

	@Inject
	SharedPreferences mPrefs;

	@Inject
	AppConstants appConstants;



	public AppDataManager(Context mContext) {

		this.mContext = mContext;

		((MyApp) mContext).getNetComponent().inject(this);

	}

	private SharedPreferences getSharedPreferences() {
		return mPrefs;
	}

	public void saveUser() {
		//SharedPreferences mPrefs = context.getSharedPreferences(AppConstants.getInstance().SHARED_PREFENCE_NAME, MODE_PRIVATE);
		SharedPreferences.Editor prefsEditor = getSharedPreferences().edit();
		Gson gson = new Gson();
		String json = gson.toJson(user);
		prefsEditor.putString("User", json);
		prefsEditor.apply();
	}

	public void loadUser() {
	//	SharedPreferences mPrefs = context.getSharedPreferences(AppConstants.getInstance().SHARED_PREFENCE_NAME, MODE_PRIVATE);
		if (mPrefs.contains("User")) {
			Gson gson = new Gson();
			String json = mPrefs.getString("User", "");
			user = gson.fromJson(json, User.class);
		} else {
			user = new User();
		}

	}


	public void deleteSavedData(String key,Context context) {
		user = new User();
		SharedPreferences mPrefs = context.getSharedPreferences(appConstants.SHARED_PREFENCE_NAME, MODE_PRIVATE);
		mPrefs.edit().remove(key).apply();
	}
}

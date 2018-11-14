package com.vip.exam.android_concepts.Exam.appdatas;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.example.vipin.kotlindemo.api_call_manager.ApiCleint;
import com.example.vipin.kotlindemo.api_call_manager.ApiDataManager;


public class App extends Application {

	private static App uniqInstance;
	ApiDataManager appDataManager;
	Activity mCurrentActivity = null;

	static
	{
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
	}

	@Override
	public void onCreate() {
		super.onCreate();


			AppManager.getInstance().loadUser(getApplicationContext());


		/***
		 * AppAPIClient initialization*/
		ApiCleint appAPIClient=new ApiCleint();

		/***
		 * ApiDataManager manger intialization
		 */
		appDataManager = new ApiDataManager(getApplicationContext());


	}


	public synchronized static App getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new App();
		}
		return uniqInstance;
	}


	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);

	}
}

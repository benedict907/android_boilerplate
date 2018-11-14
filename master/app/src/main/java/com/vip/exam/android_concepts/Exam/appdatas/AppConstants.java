package com.vip.exam.android_concepts.Exam.appdatas;

public class AppConstants {


    private static AppConstants appConstantsInstance;


	public synchronized static final AppConstants getInstance() {
		if (appConstantsInstance == null) {
			appConstantsInstance = new AppConstants();
		}
		return appConstantsInstance;
	}

	// Shared preference name is same as Application package name
	public String SHARED_PREFENCE_NAME = "ePosta";

}

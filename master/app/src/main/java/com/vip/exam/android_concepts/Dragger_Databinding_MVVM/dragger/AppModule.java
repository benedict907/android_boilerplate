package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.dragger;

import android.app.Application;
import android.content.Context;


import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.app_datas.AppConstants;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.app_datas.AppDataManager;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.app_datas.User;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.repository.MainRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vipin on 20/2/17.
 */

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    AppConstants provideConstants()
    {
        return new AppConstants();

    }

    // app storage class  **********

    @Provides
    @Singleton
    AppDataManager providePreference()
    {
        return new AppDataManager(mApplication);
             }


    @Provides
    @Singleton
    User providesUser() {
        return new User();
    }

    @Provides
    @Singleton
    MainRepository providesRepository() {
        return new MainRepository(mApplication);
    }


}
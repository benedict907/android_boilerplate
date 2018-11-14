package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.dragger;

import android.app.Application;
import android.content.Context;


import com.vip.exam.android_concepts.BuildConfig;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.app_datas.AppDataManager;

import javax.inject.Inject;

/**
 * Created by vipin on 20/2/17.
 */
public class MyApp extends Application {

    private NetComponent mNetComponent;

    @Inject
    AppDataManager appDataManager;

    @Override
    public void onCreate() {
        super.onCreate();


        // Dagger%COMPONENT_NAME%
        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule(BuildConfig.BASEURL,getApplicationContext()))
                .build();

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mNetComponent = com.codepath.dagger.components.DaggerNetComponent.create();

        getNetComponent().inject(this);

        appDataManager.loadUser();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }
}


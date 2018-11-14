package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.dragger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.utilities.InternetConnection;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vipin on 20/2/17.
 */
@Module
public class NetModule {

    String mBaseUrl;
    Context mcontext;

    // Constructor needs one parameter to instantiate.
    public NetModule(String baseUrl, Context applicationContext) {
        this.mBaseUrl = baseUrl;
        this.mcontext = applicationContext;

        Log.e("url",""+mBaseUrl);
    }


    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }


    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

// net work connection class *********************

    @Provides
    @Singleton
    InternetConnection provideConnection()
    {
        return new InternetConnection();

    }


//**********************
    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okClient())
                .build();

    }

    private OkHttpClient okClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(7, TimeUnit.SECONDS)
                .writeTimeout(7, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .readTimeout(7, TimeUnit.SECONDS)
                .build();
    }

}
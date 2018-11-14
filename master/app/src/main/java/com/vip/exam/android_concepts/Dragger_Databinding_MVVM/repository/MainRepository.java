package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.repository;


import android.app.Application;
import android.content.Context;
import android.util.Log;


import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.api_manager.ApiInterFace;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.dragger.MyApp;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.model.Notification;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.viewmodel.MainViewModel;
import com.vip.exam.android_concepts.R;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainRepository implements MainRepoInterface{

    ApiInterFace apiInterface;

   // @Inject Context mContext;

    Context mContext;

    @Inject Retrofit mRetrofit_base;

    public MainRepository(Application application) {

        // dragger
        ((MyApp) application).getNetComponent().inject(this);

        this.mContext = application;

        apiInterface = mRetrofit_base.create(ApiInterFace.class);
    }


    @Override
    public void CallNotificationList(final MainViewModel mainViewModel, int size) {

        String accessToken = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJFTVMyR28iLCJhdWQiOiJFTVMyR28iLCJpYXQiOjE1MzEyMTQ3ODQsIm5iZiI6MTUzMTIxNDc4NCwiZXhwIjoxNTMxMzAxMTg0LCJkYXRhIjp7InVzZXJJZCI6M319.iBTTMYwTa5nhNKO6n47gUBgj_6s3a3963d5tJmH9_jkj6f3jB_HG-ccN6a3PquAeHThaJNroV0AWCHCzoGZ4RMH4be9HDJmlo3ZQIFOpsuGpU4iypOE_704zpxRenMvEAXXEpwY0_--qCR8wI13vxuwtt1hxUKhbT-_vXRiTNM4";

        if (apiInterface == null) {
            apiInterface = mRetrofit_base.create(ApiInterFace.class);
        }

        Call<Notification> call = apiInterface.postNotificationDetails(accessToken, size, "10");

        call.enqueue(new Callback<Notification>() {
            @Override
            public void onResponse(Call<Notification> call, Response<Notification> response) {

                try {
                    if (response.isSuccessful())
                        try {
                            Log.e("data", "Notification data :" + response.body().getStatus());
                            if (response.body().getStatus().equals("success")) {

                                mainViewModel.setNotification(response.body().getNotifications());

                            } else if (response.body().getStatus().equals("failed")) {
                                mainViewModel.ShowErrorSnak(mContext.getResources().getString(R.string.api_error));
                            }


                        } catch (Exception e) {
                            Log.d("data", "Exception @ CallNotificationList " + e);
                        }
                } catch (Exception e) {

                    mainViewModel.ShowErrorSnak(mContext.getResources().getString(R.string.api_error));
                }
            }

            @Override
            public void onFailure(Call<Notification> call, Throwable t) {
                try {

                    mainViewModel.ShowErrorSnak(mContext.getResources().getString(R.string.api_error));
                } catch (NullPointerException e) {
                } catch (Exception e) {

                }
            }

        });

    }


}

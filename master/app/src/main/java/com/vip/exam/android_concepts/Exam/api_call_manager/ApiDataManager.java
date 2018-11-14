package com.vip.exam.android_concepts.Exam.api_call_manager;

import android.content.Context;
import android.util.Log;

import com.example.vipin.kotlindemo.R;
import com.example.vipin.kotlindemo.appdatas.AppManager;
import com.example.vipin.kotlindemo.model.pojo_model.Notification;
import com.example.vipin.kotlindemo.presenter.PresenterNotification;
import com.example.vipin.kotlindemo.utilities.AppDeviceInfoClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiDataManager {

    ApiInterFace apiInterface;
    private Context mContext;
    Retrofit mRetrofit_base;
    String deviceInfo;


    public ApiDataManager(Context mContext) {
        this.mContext = mContext;

        this.deviceInfo = AppDeviceInfoClass.getDeviceInfo(mContext);

        this.mRetrofit_base = ApiCleint.getClientServerApi();

        apiInterface = mRetrofit_base.create(ApiInterFace.class);
    }


    public void CallNotificationList(final PresenterNotification presenterNotification, String size) {

        if (apiInterface == null) {
            apiInterface = mRetrofit_base.create(ApiInterFace.class);
        }

        Call<Notification> call = apiInterface.postNotificationDetails(AppManager.getInstance().user.accessToken, size, "10");

        call.enqueue(new Callback<Notification>() {
            @Override
            public void onResponse(Call<Notification> call, Response<Notification> response) {

                try {
                    if (response.isSuccessful())
                        try {
                            Log.e("data", "Notification data :" + response.body().getStatus());
                            if (response.body().getStatus().equals("success")) {


                                AppManager.getInstance().user.userId = 10;
                                AppManager.getInstance().saveUser(mContext);

                                presenterNotification.setNotification(response.body().getNotifications());

                            } else if (response.body().getStatus().equals("failed")) {
                                presenterNotification.showerrorSnak(mContext.getResources().getString(R.string.api_error));
                            }


                        } catch (Exception e) {
                            Log.d("data", "Exception @ CallNotificationList " + e);
                        }
                } catch (Exception e) {

                    presenterNotification.showerrorSnak(mContext.getResources().getString(R.string.api_error));
                }
            }

            @Override
            public void onFailure(Call<Notification> call, Throwable t) {
                try {

                    presenterNotification.showerrorSnak(mContext.getResources().getString(R.string.api_error));
                } catch (NullPointerException e) {
                } catch (Exception e) {

                }
            }

        });

    }


    public void RxjavaCallNotificationList(final PresenterNotification presenterNotification, String size) {

        if (apiInterface == null) {
            apiInterface = mRetrofit_base.create(ApiInterFace.class);
        }

        apiInterface.postNotificationDetailsRX(AppManager.getInstance().user.accessToken, size, "10")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Notification>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        presenterNotification.showerrorSnak(mContext.getResources().getString(R.string.api_error));
                    }

                    @Override
                    public void onNext(Notification response) {

                        try {
                                    Log.e("data", "Notification data :" + response.getStatus());
                                    if (response.getStatus().equals("success")) {


                                        AppManager.getInstance().user.userId = 10;
                                        AppManager.getInstance().saveUser(mContext);

                                        presenterNotification.setNotification(response.getNotifications());

                                    } else if (response.getStatus().equals("failed")) {
                                        presenterNotification.showerrorSnak(mContext.getResources().getString(R.string.api_error));
                                    }

                        } catch (Exception e) {

                            presenterNotification.showerrorSnak(mContext.getResources().getString(R.string.api_error));
                        }

                    }


                });
    }
}
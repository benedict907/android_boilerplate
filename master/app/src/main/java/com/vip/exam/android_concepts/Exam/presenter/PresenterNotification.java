package com.vip.exam.android_concepts.Exam.presenter;

import android.content.Context;

import com.example.vipin.kotlindemo.api_call_manager.ApiDataManager;
import com.example.vipin.kotlindemo.contract.NotificationContract;
import com.example.vipin.kotlindemo.model.pojo_model.Notification_;

import java.util.List;


public class PresenterNotification implements NotificationContract.Presenter {

    private Context mContext;
    protected ApiDataManager appDataManager;
    protected NotificationContract.View mView;


    public PresenterNotification(Context context) {
        this.mContext = context;
        mView = (NotificationContract.View) context;
        appDataManager = new ApiDataManager(context);
    }



    @Override
    public void CallNotification(int size) {

            mView.showDialogbox();

            appDataManager.RxjavaCallNotificationList(this, String.valueOf(size));


    }

    @Override
    public void setNotification(List<Notification_> data) {

        mView.hideDialogbox();
        mView.SetNotification(data);
    }

    @Override
    public void showerrorSnak(String message) {

        mView.hideDialogbox();
        mView.showerrorSnak(message);
    }

}

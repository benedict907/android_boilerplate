package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;


import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.adapter.NotificationAdapter;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.app_datas.AppDataManager;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.dragger.MyApp;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.utilities.EndlessRecyclerOnScrollListener;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.utilities.InternetConnection;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.view.base.BaseActivity;
import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.viewmodel.MainViewModel;
import com.vip.exam.android_concepts.R;
import com.vip.exam.android_concepts.databinding.MyDataBinding;

import javax.inject.Inject;


public class MainActivityDragger extends BaseActivity {

    MyDataBinding activityMainBinding;

    NotificationAdapter mAdapter;

    @Inject
    InternetConnection connection;

    @Inject
    AppDataManager appDataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_dragger);

        activityMainBinding.setMainviewmodel(ViewModelProviders.of(this).get(MainViewModel.class));


        // dragger
        ((MyApp) getApplication()).getNetComponent().inject(this);


        setupRecyclerView();

        // session to value store use dragger injection object
        appDataManager.user.userName = "Vipin M T";
        appDataManager.saveUser();


        activityMainBinding.getMainviewmodel().CallNotification(0);

        Log.e("callt","create-"+appDataManager.user.userName);

        ObservedLoader();
    }

    private void ObservedLoader() {

        activityMainBinding.getMainviewmodel().isLoading.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean isLoading) {
                if (isLoading != null) {
                    if (isLoading)
                        showLoadingDialog(MainActivityDragger.this);
                    else
                        hideaLoadingDialog();

                }
            }
        });
    }

    private void setupRecyclerView() {
        mAdapter = new NotificationAdapter(this);
        activityMainBinding.dataList.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.dataList.setAdapter(mAdapter);

// page Nation recycle
        activityMainBinding.dataList.addOnScrollListener(new EndlessRecyclerOnScrollListener(new LinearLayoutManager(this)) {
            @Override
            public void onLoadMore(int totalItemCount) {

                Log.e("SCROLL","ON");

                if (activityMainBinding.getMainviewmodel().mDataList.size() >= totalItemCount) {
                    activityMainBinding.getMainviewmodel().CallNotification(activityMainBinding.getMainviewmodel().mDataList.size());
                }
            }

        });
    }


    public void errorSnack() {
      //  Snackbar.make(activityMainBinding.dataList, "Some Problem Occured", Snackbar.LENGTH_LONG).show();
    }
}

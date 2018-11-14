package com.vip.exam.android_concepts.Exam.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vipin.kotlindemo.R;
import com.example.vipin.kotlindemo.adapter.NotificationAdapter;
import com.example.vipin.kotlindemo.contract.NotificationContract;
import com.example.vipin.kotlindemo.model.pojo_model.Notification_;
import com.example.vipin.kotlindemo.presenter.PresenterNotification;

import java.util.ArrayList;
import java.util.List;


public class MainNotification extends BaseActivity implements NotificationContract.View {

    private  String FROM = "Home";
    private  String ORDER_ID = "101";

    NotificationAdapter notificationAdapter;
    public List<Notification_> notificationDataList = new ArrayList<>();
    private LinearLayoutManager mLayoutManager;


    RecyclerView recyclerView;

    PresenterNotification mPresenter;

    TextView noDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notification);


        setJobId(getIntent().getExtras());

        onInit();


        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

// This use to back arrow color change to white
           /* final Drawable upArrow = getResources().getDrawable(R.drawable.arrow);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);*/

            setTitle("My Activity");

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case android.R.id.home:

                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

            Bundle jobitemBundle = new Bundle();

            jobitemBundle.putString("ORDER_ID", ORDER_ID);
            jobitemBundle.putString("FROM", FROM);

            Intent i = new Intent(MainNotification.this, FragmentActivity.class);
            i.putExtras(jobitemBundle);
            startActivity(i);

    }



    @Override
    public void onInit() {
        super.onInit();

        Recyclerinit();

        if (mPresenter == null) {
            mPresenter = new PresenterNotification(this);
            mPresenter.CallNotification(0);
        }

    }

    private void Recyclerinit() {

        noDataList = findViewById(R.id.no_data_list);
        recyclerView = findViewById(R.id.notificationRecycler);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        notificationAdapter = new NotificationAdapter(this, notificationDataList);
        recyclerView.setAdapter(notificationAdapter);

// page Nation recycle

       // recyclerView.addOnScrollListener
    }

    @Override
    public void showDialogbox() {
        showLoadingDialog(MainNotification.this);
    }

    @Override
    public void hideDialogbox() {
        hideaLoadingDialog();
    }

    @Override
    public void showerrorSnak(String message) {

        noDataList.setVisibility(View.VISIBLE);

    }

    @Override
    public void SetNotification(List<Notification_> data) {

        try {

            this.notificationDataList.addAll(data);

            if (notificationDataList.size() > 0 ) {

        if (notificationDataList != null) {

            noDataList.setVisibility(View.GONE);

            notificationAdapter.notifyDataSetChanged();

        }} else {
            noDataList.setVisibility(View.VISIBLE);

        }

        } catch (Exception e) {
        }

    }

    @Override
    public void GotoDetailsPage(int position, String type) {

        Log.e("click _ ",""+position);

        Toast.makeText(MainNotification.this,"Click: "+position,Toast.LENGTH_SHORT).show();


    }



    private void setJobId(Bundle extras) {

        try {
            FROM = extras.getString("FROM");
            ORDER_ID = extras.getString("ORDER_ID");

            Log.e("click ",""+ORDER_ID);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}
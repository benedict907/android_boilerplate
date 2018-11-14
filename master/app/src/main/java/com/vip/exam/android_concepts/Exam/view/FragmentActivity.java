package com.vip.exam.android_concepts.Exam.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.example.vipin.kotlindemo.R;
import com.example.vipin.kotlindemo.view.fragment.Fragmentone;


public class FragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragmentactivity);


        onInit();


        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            setTitle("My Fragment");

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

            Intent i = new Intent(FragmentActivity.this, MainNotification.class);
            startActivity(i);

    }



    @Override
    public void onInit() {
        super.onInit();

        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .replace(R.id.main_activity_content_frame, Fragmentone.newInstance()).commit();

    }
}
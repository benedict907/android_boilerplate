package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.view.base;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.vip.exam.android_concepts.R;


public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();



    public void onInit() {
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


// This is for showing the progress

    public Dialog mLoadingDialog;

    public void showLoadingDialog(Context context) {
        mLoadingDialog = new Dialog(context);
        mLoadingDialog.setCancelable(false);
        mLoadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mLoadingDialog.setContentView(R.layout.dialogue_loading_layout);
        mLoadingDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);

        mLoadingDialog.show();

    }

    // This is for hiding the progress
    public void hideaLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.cancel();
            mLoadingDialog.getWindow().closeAllPanels();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
         super.onPause();
    }

}

package com.vip.exam.android_concepts.FBGOOGLEADDMOB;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


/**
 * Created by FieldPlex on 27/2/17.
 */

public class BaseActivity extends AppCompatActivity {

    private View snackBarView;
    public void showSnackBar(String Message) {
        Snackbar snackbar;
        snackbar = Snackbar.make(this.getSnackBarView(), Message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
    public View getSnackBarView() {
        return snackBarView;
    }
    public void setSnackBarView(View snackBarView) {
        this.snackBarView = snackBarView;
    }


    public void debugLogD(final String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }}

    public void debugLogE(final String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message);
        }}
}

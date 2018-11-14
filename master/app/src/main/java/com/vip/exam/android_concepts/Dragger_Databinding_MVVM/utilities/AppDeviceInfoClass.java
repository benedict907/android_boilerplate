package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.utilities;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by vipin on 7/3/17.
 */

public class AppDeviceInfoClass {


    public static String getDeviceInfo(Context context) {

        String currentVersion = null;
        try {
            currentVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Log.e("mobile info : ",""+android.os.Build.MODEL
                +" brand = "+android.os.Build.BRAND +
                " OS version = "+android.os.Build.VERSION.RELEASE +
                " SDK version = " +android.os.Build.VERSION.SDK_INT+
                "version aPP : "+currentVersion);

        String device_model = android.os.Build.MODEL;
        String device_brand = android.os.Build.BRAND;
        String device_version = android.os.Build.VERSION.RELEASE;
        String app_version = currentVersion;
        String device_id = Settings.Secure.getString(context.getContentResolver(),
        Settings.Secure.ANDROID_ID);

        JSONObject json = new JSONObject();

        try {
            json.put("device_name",device_brand);
            json.put("device_ver",device_version);
            json.put("app_ver",app_version);
            json.put("device_model",device_model);
            json.put("device_id", device_id);
            json.put("platform","android");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        String info = String.valueOf(json);

        Log.e("mobile json info : ",""+info);

        return info;
        }

}
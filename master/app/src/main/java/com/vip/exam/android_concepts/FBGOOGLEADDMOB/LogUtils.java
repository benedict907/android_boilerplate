package com.vip.exam.android_concepts.FBGOOGLEADDMOB;

import android.util.Log;

/**
 * Created by vipin on 26/7/18.
 */

public class LogUtils {

    public static void debugLogD(final String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }}

    public static void debugLogE(final String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message);
        }}
}
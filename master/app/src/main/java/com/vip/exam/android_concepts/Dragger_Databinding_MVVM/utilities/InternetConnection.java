package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by vipin on 20/2/17.
 */

public class InternetConnection {

    public boolean isConnected(Context context) {

        try {
            ConnectivityManager connectivity = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo[] info = connectivity.getAllNetworkInfo();
                if (info != null)
                    for (int i = 0; i < info.length; i++)
                        if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }
}

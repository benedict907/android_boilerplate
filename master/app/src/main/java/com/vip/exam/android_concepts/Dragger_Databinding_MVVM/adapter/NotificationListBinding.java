package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.adapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;


import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.model.Notification_;

import java.util.List;

public class NotificationListBinding {

    @BindingAdapter("bind:dataListNew")
    public static void setNotificationDataList(RecyclerView recyclerView, List<Notification_> datalist) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();

        if (adapter != null && adapter instanceof NotificationAdapter) {
            ((NotificationAdapter) adapter).setNotificationDataList(datalist);
        } else {
            throw new IllegalStateException("RecyclerView either has no adapter set or the "
                    + "adapter isn't of type MovieAdapter");
        }
    }
}

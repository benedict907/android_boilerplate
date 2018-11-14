package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.model.Notification_;
import com.vip.exam.android_concepts.R;
import com.vip.exam.android_concepts.databinding.ItemViewBinder;

import java.util.ArrayList;
import java.util.List;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {


    Context mcontext;


    public List<Notification_> notificationDataList = new ArrayList<>();

    public NotificationAdapter(Context context) {

        this.mcontext = context;
    }

    public void setNotificationDataList(@NonNull List<Notification_> notificationDataList) {
        this.notificationDataList = notificationDataList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ItemViewBinder itemViewBind;

        public MyViewHolder(ItemViewBinder itemBinding) {
            super(itemBinding.getRoot());

            this.itemViewBind = itemBinding;
        }

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemViewBinder binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_push, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

       // final Notification_ mData = notificationDataList.get(position);

           holder.itemViewBind.setItemViewModel(notificationDataList.get(position));

         if (notificationDataList.get(position).getIsRead())
             holder.itemViewBind.viewcolor.setBackgroundColor(mcontext.getResources().getColor(R.color.colorAccent));
         else
             holder.itemViewBind.viewcolor.setBackgroundColor(mcontext.getResources().getColor(R.color.colorPrimary));


        holder.itemViewBind.txtNotificationDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"Click : "+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        if (notificationDataList != null)
            return notificationDataList.size();
        else
            return 0;
    }



}
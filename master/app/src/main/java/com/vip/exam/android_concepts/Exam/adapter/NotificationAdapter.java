package com.vip.exam.android_concepts.Exam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vipin.kotlindemo.R;
import com.example.vipin.kotlindemo.contract.NotificationContract;
import com.example.vipin.kotlindemo.model.pojo_model.Notification_;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {


    Context mcontext;

    protected NotificationContract.View mView;

    public List<Notification_> notificationDataList = new ArrayList<>();


    public NotificationAdapter(Context context, List<Notification_> notificationDataList) {

        mView = (NotificationContract.View) context;
        this.mcontext = context;
        this.notificationDataList = notificationDataList;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView txtNotification;

        View viewBlueStirpVertical;

        TextView txtNotificationDate;


        public MyViewHolder(View view) {
            super(view);

            txtNotification = (TextView) view.findViewById(R.id.txt_notification);
            txtNotificationDate = (TextView) view.findViewById(R.id.txt_notification_date);
            viewBlueStirpVertical = (View) view.findViewById(R.id.viewcolor);
        }

        @Override
        public void onClick(View v) {

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_pusJh, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if (notificationDataList.get(position).getIsRead())
            holder.viewBlueStirpVertical.setBackgroundColor(mcontext.getResources().getColor(R.color.colorAccent));
        else
            holder.viewBlueStirpVertical.setBackgroundColor(mcontext.getResources().getColor(R.color.colorPrimary));

        holder.txtNotification.setText(notificationDataList.get(position).getNotificationText());

        try {
            holder.txtNotificationDate.setText(getdate(notificationDataList.get(position).getSendAt()));
        }catch (Exception e){e.printStackTrace();}

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // this is for goto the details page
                mView.GotoDetailsPage(position, notificationDataList.get(position).getActionKeyWord());

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

    public String getdate(String mydate) {

        Date myDate = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            myDate = format.parse(mydate);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy  hh:mm a", Locale.getDefault());
        String finalDate = timeFormat.format(myDate);
        return String.valueOf(finalDate);

    }


}
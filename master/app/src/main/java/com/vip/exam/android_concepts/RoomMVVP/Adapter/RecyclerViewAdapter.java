package com.vip.exam.android_concepts.RoomMVVP.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.vip.exam.android_concepts.R;
import com.vip.exam.android_concepts.RoomMVVP.Activity.MainRoom;
import com.vip.exam.android_concepts.RoomMVVP.RoomDB.model.MessageModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<MessageModel> bModelList;
    private View.OnLongClickListener longClickListener;
    Context context;
    Clickdata clickdata;

    public RecyclerViewAdapter(List<MessageModel> bModelList, View.OnLongClickListener longClickListener, MainRoom mainRoom) {
        this.bModelList = bModelList;
        this.longClickListener = longClickListener;
        this.context = mainRoom;
        clickdata = (Clickdata) context;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        MessageModel borrowModel = bModelList.get(position);
        holder.nameTextView.setText(borrowModel.getPersonName());
        holder.dateTextView.setText(borrowModel.getBorrowDate().toLocaleString().substring(0, 11));
        holder.itemView.setTag(borrowModel);
        holder.itemView.setOnLongClickListener(longClickListener);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickdata.gotodetailsPage(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bModelList.size();
    }

    public void addItems(List<MessageModel> borrowModelList) {
        this.bModelList = borrowModelList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView dateTextView;

        RecyclerViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.item_txt);
            dateTextView = view.findViewById(R.id.date_txt);
        }
    }
}
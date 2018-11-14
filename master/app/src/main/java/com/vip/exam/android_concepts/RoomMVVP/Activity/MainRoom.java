package com.vip.exam.android_concepts.RoomMVVP.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.vip.exam.android_concepts.R;
import com.vip.exam.android_concepts.RoomMVVP.Adapter.Clickdata;
import com.vip.exam.android_concepts.RoomMVVP.Adapter.RecyclerViewAdapter;
import com.vip.exam.android_concepts.RoomMVVP.RoomDB.model.DetailsModel;
import com.vip.exam.android_concepts.RoomMVVP.RoomDB.model.MessageModel;
import com.vip.exam.android_concepts.RoomMVVP.ViewModels.MainRoomViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainRoom extends AppCompatActivity implements View.OnLongClickListener,Clickdata {


    private Date date;
    String dateS;
    private EditText nameEditText;
    private Button addbtn;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    private MainRoomViewModel addViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_room);

        addViewModel = ViewModelProviders.of(this).get(MainRoomViewModel.class);

        nameEditText = findViewById(R.id.add_txt);
        addbtn = findViewById(R.id.add_btn);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<MessageModel>(), this,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerViewAdapter);

        addViewModel.getItemList().observe(MainRoom.this, new Observer<List<MessageModel>>() {
            @Override
            public void onChanged(@Nullable List<MessageModel> itemdata) {
                recyclerViewAdapter.addItems(itemdata);
            }
        });



        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getCurrentDateTime();

                if (nameEditText.getText() == null || date == null)
                    Toast.makeText(MainRoom.this, "Field is Empty", Toast.LENGTH_SHORT).show();
                else {
                    addViewModel.addMessage(new MessageModel(
                            nameEditText.getText().toString(),
                            date
                    ));

                    /** Add another table to the same data **/
                    addViewModel.addDetails(new DetailsModel(
                            nameEditText.getText().toString(),
                            dateS
                    ));
                }

                nameEditText.setText("");
            }
        });

    }


    private Date getCurrentDateTime() {

        dateS = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        date = Calendar.getInstance().getTime();

        Log.e("date","-"+date.toString()+",,"+dateS);
        return date;
    }

    @Override
    public boolean onLongClick(View view) {
        MessageModel bModel = (MessageModel) view.getTag();
        addViewModel.deleteItem(bModel);
        Toast.makeText(this, "Deleted : "+((MessageModel) view.getTag()).getPersonName(), Toast.LENGTH_SHORT).show();
        return true;
    }


    @Override
    public void gotodetailsPage(int data) {

        Intent intent = new Intent(MainRoom.this,DetailsActivity.class);
        startActivity(intent);
    }
}


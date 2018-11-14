package com.vip.exam.android_concepts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.view.MainActivityDragger;
import com.vip.exam.android_concepts.RoomMVVP.Activity.MainRoom;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =findViewById(R.id.room_mvvm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b1 = new Intent(MainActivity.this, MainRoom.class);
                startActivity(b1);
            }
        });

        b2 =findViewById(R.id.mvp_retrofit);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b2 = new Intent(MainActivity.this, MainActivityDragger.class);
                startActivity(b2);
            }
        });
    }
}

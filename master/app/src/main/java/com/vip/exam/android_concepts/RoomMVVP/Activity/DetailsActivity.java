package com.vip.exam.android_concepts.RoomMVVP.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vip.exam.android_concepts.R;
import com.vip.exam.android_concepts.RoomMVVP.ViewModels.DetailsViewModel;


public class DetailsActivity extends AppCompatActivity{

    private EditText nameEditText;
    private Button delete,update,count,view;

    private DetailsViewModel addViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        addViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);

        nameEditText = findViewById(R.id.editText);

        delete = findViewById(R.id.delete_button);
        update = findViewById(R.id.update_button);
        count = findViewById(R.id.count_button);
        view = findViewById(R.id.view_button);


        //add observer to LiveData
        //observer gets called every time data changes in LiveData
        addViewModel.getCurrentData().observe(this, newdata -> {
            ((EditText)findViewById(R.id.editText)).setText(newdata);
        });


        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addViewModel.countItem();
             //   addViewModel.getCurrentData().setValue("Count:*");
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addViewModel.deleteItem(nameEditText.getText().toString());
               // addViewModel.getCurrentData().setValue("Deleted: "+nameEditText.getText().toString());
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addViewModel.updateDetails("VIPIN",nameEditText.getText().toString());


            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addViewModel.viewDetails(nameEditText.getText().toString());

            }
        });

    }

/*
    // Create the observer which updates the UI.
    final Observer<String> nameObserver = new Observer<String>() {
        @Override
        public void onChanged(@Nullable final String newName) {
            // Update the UI, in this case, a TextView.
            mNameTextView.setText(newName);
        }
    };

    // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.getCurrentName().observe(this, nameObserver);
*/


}

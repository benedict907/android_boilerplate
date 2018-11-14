/*
package com.vip.exam.android_concepts;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alignminds.ivyplex.contracts.PreviousOrderContract;
import com.alignminds.ivyplex.utilities.ValidationUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmailDialogue extends Dialog {


   EmailDialogue emailDialoge = new EmailDialogue(PreviousOrderActivity.this);
                emailDialoge.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                emailDialoge.setCancelable(false);
                emailDialoge.show();

    RelativeLayout startShiftCloseBtn;
    private Activity home;
    EditText sensEmlTxt;

    RelativeLayout emailBtn;

    public EmailDialogue(Activity home) {
        super(home);
        this.home = home;
     //   mView = (PreviousOrderContract.View) home;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.layout_send_email);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        OnInit();


    }

    private void OnInit() {


    }

    @OnClick({R.id.email_btn, R.id.start_shift_close_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.email_btn:

                if (ValidationUtil.validateUserEmail(sensEmlTxt.getText().toString(), home)) {
                    mView.sendEmail(sensEmlTxt.getText().toString());
                    dismiss();
                } else
                    Toast.makeText(home, "Please enter valid Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.start_shift_close_btn:
               dismiss();
                break;

        }

    }
}*/

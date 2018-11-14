package com.vip.exam.android_concepts.Exam.contract;


import com.example.vipin.kotlindemo.model.pojo_model.Notification_;

import java.util.List;


public interface NotificationContract {

    interface View{

        //view dialog box
        void showDialogbox();

        //hide dialog box
        void hideDialogbox();

        //method for errore showing
        void showerrorSnak(String message);


        void SetNotification(List<Notification_> data);

        void GotoDetailsPage(int position, String type);

    }

    interface Presenter{


        void CallNotification(int size);

        void setNotification(List<Notification_> data);

        //method for errore showing
        void showerrorSnak(String message);
    }

}

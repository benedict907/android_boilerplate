package com.vip.exam.android_concepts.RoomMVVP.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.vip.exam.android_concepts.RoomMVVP.RoomDB.AppDatabase;
import com.vip.exam.android_concepts.RoomMVVP.RoomDB.model.DetailsModel;
import com.vip.exam.android_concepts.RoomMVVP.RoomDB.model.MessageModel;

import java.util.List;


public class MainRoomViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;
    private final LiveData<List<MessageModel>> itemList;

    public MainRoomViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        itemList = appDatabase.itemAndPersonModel().getAllMessageItems();
    }


    public LiveData<List<MessageModel>> getItemList() {
        return itemList;
    }


    public void addMessage(final MessageModel bModel) {
        new addAsyncTask(appDatabase).execute(bModel);
    }

    private static class addAsyncTask extends AsyncTask<MessageModel, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final MessageModel... params) {
            db.itemAndPersonModel().addMessage(params[0]);

            Log.e("inserted","now1");
            return null;
        }
    }

    public void deleteItem(MessageModel borrowModel) {
        new deleteAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class deleteAsyncTask extends AsyncTask<MessageModel, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final MessageModel... params) {
            db.itemAndPersonModel().deleteMessageAll(params[0]);
            return null;
        }

    }

    ////////////////////////////////////////
    /**
     * Add another table to same data
     */

    public void addDetails(final DetailsModel bModel) {
        new addDetailsAsyncTask(appDatabase).execute(bModel);
    }

    private static class addDetailsAsyncTask extends AsyncTask<DetailsModel, Void, Void> {

        private AppDatabase db;

        addDetailsAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final DetailsModel... params) {
            db.itemDetailsModel().addDetails(params[0]);

            Log.e("inserted","now2");
            return null;
        }
    }

}

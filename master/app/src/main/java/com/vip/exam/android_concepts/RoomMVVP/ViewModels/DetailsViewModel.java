package com.vip.exam.android_concepts.RoomMVVP.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;
import android.util.Log;


import com.vip.exam.android_concepts.RoomMVVP.RoomDB.AppDatabase;
import com.vip.exam.android_concepts.RoomMVVP.RoomDB.model.DetailsModel;

import java.util.List;


public class DetailsViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;
    private final LiveData<List<DetailsModel>> itemList;

    private static MutableLiveData<String> data_Str = new MutableLiveData<String>();

    public DetailsViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        itemList = appDatabase.itemDetailsModel().getAllDetailsItems();
    }

    public MutableLiveData<String> getCurrentData() {
        if (data_Str == null) {
            data_Str = new MutableLiveData<String>();
        }
        return data_Str;
    }


    public LiveData<List<DetailsModel>> getItemList() {
        return itemList;
    }


    public void deleteItem(String borrowModel) {
        new deleteAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class deleteAsyncTask extends AsyncTask<String, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final String... params) {
            db.itemDetailsModel().deleteOneItem(params[0]);
            data_Str.postValue("Deleted: "+params[0]);
            Log.e("deleted","now");
            return null;
        }

    }

    public void countItem() {
        new CountAsyncTask(appDatabase).execute();
    }

    private class CountAsyncTask extends AsyncTask<String, Void, Void> {

        private AppDatabase db;

        CountAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final String... params) {
          int count =  db.itemDetailsModel().countAllItem();
            Log.e("Count","now");
            data_Str.postValue("COUNT : "+count);
            Log.e("count","="+count);
            return null;
        }

    }


    ////////////////////////////////////////
    /**
     * update value to single row
     */

    public void updateDetails(String newvalue,String oldval) {
        new addDetailsAsyncTask(appDatabase).execute(newvalue,oldval);
    }

    private static class addDetailsAsyncTask extends AsyncTask<String, Void, Void> {

        private AppDatabase db;

        addDetailsAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final String... params) {
            db.itemDetailsModel().updateitem(params[0],params[1]);
            data_Str.postValue("UPDATED TO : "+params[0]);
            Log.e("UPDATE","now");
            return null;
        }
    }

    /**
     * VIEW value to single row
     */

    public void viewDetails(String newvaluel) {
        new viewDetailsAsyncTask(appDatabase).execute(newvaluel);
    }

    private static class viewDetailsAsyncTask extends AsyncTask<String, Void, Void> {

        private AppDatabase db;

        viewDetailsAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final String... params) {

            DetailsModel data =  db.itemDetailsModel().getDetailsbyId(params[0]);

            Log.e("view one","now");
            try {
                Log.e("view one","now"+data.getPersonName()+","+data.getBorrowDate());
                data_Str.postValue("Selected  - "+data.getPersonName());
            }catch (Exception e){
                data_Str.postValue("Selected  - Not ");
            }

            return null;
        }
    }

}

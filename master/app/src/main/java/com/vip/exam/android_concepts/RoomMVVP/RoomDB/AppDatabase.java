package com.vip.exam.android_concepts.RoomMVVP.RoomDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.vip.exam.android_concepts.RoomMVVP.RoomDB.dao.DetailsModelDao;
import com.vip.exam.android_concepts.RoomMVVP.RoomDB.dao.MessageModelDao;
import com.vip.exam.android_concepts.RoomMVVP.RoomDB.model.DetailsModel;
import com.vip.exam.android_concepts.RoomMVVP.RoomDB.model.MessageModel;


@Database(entities = {MessageModel.class, DetailsModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "borrow_db")
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract MessageModelDao itemAndPersonModel();

    public abstract DetailsModelDao itemDetailsModel();



}

package com.vip.exam.android_concepts.RoomMVVP.RoomDB.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.vip.exam.android_concepts.RoomMVVP.RoomDB.model.DetailsModel;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface DetailsModelDao {

    @Query("select * from DetailsModel  ORDER BY personName ASC")
    LiveData<List<DetailsModel>> getAllDetailsItems();

    @Query("select * from DetailsModel where personName = :name")
    DetailsModel getDetailsbyId(String name);

    @Insert(onConflict = REPLACE) // Same value insert time conflict problem avoid use
    void addDetails(DetailsModel DetailsModel);

    @Query("DELETE FROM DetailsModel WHERE personName = :name")
    void deleteOneItem(String name);// one item deleted

    @Query("SELECT COUNT(*) FROM DetailsModel")
    int countAllItem();


    @Query("DELETE FROM DetailsModel")//Table full clear
    void deleteAll();

     // Updating only
    @Query("UPDATE DetailsModel SET personName=:newname WHERE personName = :name")
    void updateitem(String newname, String name);




/*     // Conditions base select and delete items etc.
    @Query("SELECT id, weatherIconId, date, min, max FROM weather WHERE date >= :date")
    LiveData<List<ListWeatherEntry>> getCurrentWeatherForecasts(Date date); */


}

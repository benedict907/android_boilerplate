package com.vip.exam.android_concepts.RoomMVVP.RoomDB.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

/*@Entity(tableName = "weather", indices = {@Index(value = {"date"}, unique = true)})
public class WeatherEntry {}*/

@Entity
public class DetailsModel {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "personName")
    private String personName;


    private String borrowDate;

    public DetailsModel(String personName, String borrowDate) {

        this.personName = personName;
        this.borrowDate = borrowDate;
    }


  /*  @TypeConverters(TicketVarianceConverter.class)
    @ColumnInfo(name = "ticketItemVarients")
    private List<TicketItemVarients> ticketItemVarients = null;*/

    public String getPersonName() {
        return personName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }
}

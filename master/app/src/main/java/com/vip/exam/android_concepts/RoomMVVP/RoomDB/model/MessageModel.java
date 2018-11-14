package com.vip.exam.android_concepts.RoomMVVP.RoomDB.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;


import com.vip.exam.android_concepts.RoomMVVP.RoomDB.DateConverterUtil;

import java.util.Date;


@Entity(tableName = "MessageModel")
public class MessageModel {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "personName")
    private String personName;

    @TypeConverters(DateConverterUtil.class)
    private Date borrowDate;

    public MessageModel(String personName, Date borrowDate) {

        this.personName = personName;
        this.borrowDate = borrowDate;
    }


    public String getPersonName() {
        return personName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }
}

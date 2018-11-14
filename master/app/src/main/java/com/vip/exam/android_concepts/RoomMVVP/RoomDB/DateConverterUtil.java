package com.vip.exam.android_concepts.RoomMVVP.RoomDB;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverterUtil {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}

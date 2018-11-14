/*
package com.vip.exam.android_concepts.RoomMVVP.RoomDB;

import android.arch.persistence.room.TypeConverter;


import com.google.gson.Gson;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class TicketModifierConverter implements Serializable {

    @TypeConverter // note this annotation
    public String fromOptionValuesList(List<TicketModifier> optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<TicketModifier>>() {
        }.getType();
        String json = gson.toJson(optionValues, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<TicketModifier> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<TicketModifier>>() {
        }.getType();
        List<TicketModifier> ticketModifierItems = gson.fromJson(optionValuesString, type);
        return ticketModifierItems;
    }
}
*/

package com.vip.exam.android_concepts.Exam.api_call_manager;


import com.example.vipin.kotlindemo.model.pojo_model.Notification;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by vipin on 12/3/18.
 */

public interface ApiInterFace {

    @FormUrlEncoded
    @POST("driver/notifications")
    Call<Notification> postNotificationDetails(
            @Header("Authorization") String token,
            @Field("offset") String offset,
            @Field("limit") String limit);


    @FormUrlEncoded
    @POST("driver/notifications")
    Observable<Notification> postNotificationDetailsRX(
            @Header("Authorization") String token,
            @Field("offset") String offset,
            @Field("limit") String limit);


    @GET("https://maps.googleapis.com/maps/api/distancematrix/json")
    Call<Notification> getLocationAddress(
            @Header("Authorization") String token,
            @Query("origins") String LatLono);

}

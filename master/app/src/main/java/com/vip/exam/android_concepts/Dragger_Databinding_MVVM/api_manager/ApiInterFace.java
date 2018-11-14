package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.api_manager;




import com.vip.exam.android_concepts.Dragger_Databinding_MVVM.model.Notification;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by vipin on 12/3/18.
 */

public interface ApiInterFace {

    @FormUrlEncoded
    @POST("driver/notifications")
    Call<Notification> postNotificationDetails(
            @Header("Authorization") String token,
            @Field("offset") int offset,
            @Field("limit") String limit);


    @FormUrlEncoded
    @POST("driver/notifications")
    Observable<Notification> postNotificationDetailsRX(
            @Header("Authorization") String token,
            @Field("offset") String offset,
            @Field("limit") String limit);



}

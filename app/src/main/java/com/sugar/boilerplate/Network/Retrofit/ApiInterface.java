package com.sugar.boilerplate.Network.Retrofit;

import com.sugar.boilerplate.Network.Request.MainResponse;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {


    @GET("posts")
    Call<List<MainResponse>> getApiResponse();



//    @Headers("Content-Type: application/json")
//    @POST("hotels/booking")
//    Call<BookingResponse> getBooking(
//            @Body String ota_id,
//            @Body String vendor,
//            @Body String account,
//            @Body String payment_details,
//            @Body String hotel_data,
//            @Body String room_data,
//            @Body String ip_address );

//    // Hotel Details
//    @FormUrlEncoded
//    @POST("ota/hotels/detail")
//    Call<RoomsResponseModel> getRoomsResponseModel( @Field("ota_id") String ota_id
//            ,@Field("hotel_slug") String hotel_slug
//            ,@Field("api_name") int api_name
//            ,@Field("currency_name") String currency_name );
//    @GET("supplier/hotel_amenities")
//    Call<HotelAmenitiesResponseModel> getHotelAmenitiesResponseModel( @Query("supplier_id") String supplier_id
//            ,@Query("hotel_id") String hotel_id );
//
//    @FormUrlEncoded
//    @POST("global/store_fcm")
//    Call<FcmTokenResponse> tokenResponse( @Field("fcm_token") String fcm_token,
//                                          @Field("account_id") String account_id,
//                                          @Field("devices_name") String devices_name,
//                                          @Field("uuid") String uuid,
//                                          @Field("token") String token );
//    @FormUrlEncoded
//    @POST("ota/hotels/bookings")
//    Call<ManuallBookingResponse> getManualBookingResponse( @Field("rooms") JSONArray rooms,
//                                                           @Field("checkin") String checkin,
//                                                           @Field("checkout") String checkout,
//                                                           @Field("ota_id") String ota_id,
//                                                           @Field("user_status") String user_status,
//                                                           @Field("user_id") String user_id,
//                                                           @Field("user_type") String user_type,
//                                                           @Field("account") String account,
//                                                           @Field("booking_status") String booking_status,
//                                                           @Field("payment_status") String payment_status,
//                                                           @Field("payment_method") String payment_method,
//                                                           @Field("device_type") String device_type,
//                                                           @Field("api_name") String api_name,
//                                                           @Field("model_type_id") String model_type_id,
//                                                           @Field("paid_prices") String paid_prices,
//                                                           @Field("user_img") String user_img,
//                                                           @Field("nic_image") String nic_image,
//                                                           @Field("feature_note") String feature_note );
//
//
//    @FormUrlEncoded
//    @POST("ota/hotels/update_booking")
//    Call<ManuallBookingResponse> getUpdateBookingResponse( @Field("rooms") JSONArray rooms,
//                                                           @Field("checkin") String checkin,
//                                                           @Field("checkout") String checkout,
//                                                           @Field("ota_id") String ota_id,
//                                                           @Field("user_status") String user_status,
//                                                           @Field("user_id") String user_id,
//                                                           @Field("user_type") String user_type,
//                                                           @Field("account") String account,
//                                                           @Field("booking_status") String booking_status,
//                                                           @Field("payment_status") String payment_status,
//                                                           @Field("payment_method") String payment_method,
//                                                           @Field("device_type") String device_type,
//                                                           @Field("api_name") String api_name,
//                                                           @Field("model_type_id") String model_type_id,
//                                                           @Field("paid_prices") String paid_prices,
//                                                           @Field("user_img") String user_img,
//                                                           @Field("nic_image") String nic_image,
//                                                           @Field("feature_note") String feature_note,
//                                                           @Field("super_booking_id") String super_booking_id );
//
//
//    @FormUrlEncoded
//    @POST("supplier/hotels/bookings/getAllMobileCalendarBookings")
//    Call<AllBookingResponse> getAllBookingResponse( @Field("supplier_id") String supplier_id,
//                                                    @Field("hotel_slug") String hotel_slug );


}

package com.boongg.store.Networking;

import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Requests.CreateBookingRequest;
import com.boongg.store.Models.Requests.DropVehicleRequest;
import com.boongg.store.Models.Responses.CreateBooking.CreateBookingResponse;
import com.boongg.store.Models.Responses.CreateBooking.CreateBookingSuccessResponse;
import com.boongg.store.Models.Responses.DropVehicleResponse;
import com.boongg.store.Models.Responses.PreDropBookings.PreDropBooking;
import com.boongg.store.Models.Token;
import com.boongg.store.Utilities.LoginToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BookingRequest {
    @GET("BOOKED")
    Call<List<Booking>> getAllBookings();

    @GET("COMPLETED")
    Call<List<Booking>> getCompletedBooking();
    @GET("ONGOING")
    Call<List<Booking>> getDropBookings();

    @GET("ONGOING")
    Call<List<PreDropBooking>> getPreDropBookings();

    @POST("rentbooking/offline")
    Call<List<CreateBookingResponse>> createBooking(@Body CreateBookingRequest c);

    @POST("rentbooking/request/complete")
    Call<Void> dropVehicle(@Body DropVehicleRequest d);


}

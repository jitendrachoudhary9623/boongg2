package com.boongg.store.Networking;

import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Token;
import com.boongg.store.Utilities.LoginToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface BookingRequest {
    @GET("BOOKED")
    Call<List<Booking>> getAllBookings();

}

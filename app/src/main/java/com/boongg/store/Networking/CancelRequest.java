package com.boongg.store.Networking;

import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Cancel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CancelRequest {
//    http://localhost:3100/api/rentbooking/request/cancel/5d071b35f705e83cf3eb71f0

    @FormUrlEncoded
    @POST("{bookingId}/")
    Call<Cancel> cancelBooking(@Path("bookingId") String bookingId, @Field("response") String response);

}

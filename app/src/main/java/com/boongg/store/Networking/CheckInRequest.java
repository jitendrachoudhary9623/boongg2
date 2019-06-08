package com.boongg.store.Networking;

import com.boongg.store.Models.Requests.CheckIn;
import com.boongg.store.Models.UpdateResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CheckInRequest {

    @POST("rentbooking/update")
    Call<UpdateResponse> checkIn(@Body CheckIn check);
}

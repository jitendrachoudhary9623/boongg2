package com.boongg.store.Networking;


import com.boongg.store.Models.Responses.CancelledData.Cancel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CancelledData {

    @GET("rentbooking/list/{token}/CANCELLED")
    Call<List<Cancel>> getCancelledDate(@Path("token") String token);
}

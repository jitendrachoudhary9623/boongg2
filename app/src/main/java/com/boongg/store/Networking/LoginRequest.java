package com.boongg.store.Networking;


import com.boongg.store.Models.Token;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginRequest {

    @FormUrlEncoded
    @POST("login")
    Call<Token> userLogin(@Field("username") String username, @Field("password") String password);
}

package com.boongg.store.Networking;

import com.boongg.store.Models.Responses.SearchUSer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SearchUser {

    @GET("getwebuser/{phoneNumber}")
    Call<List<SearchUSer>> searchUser(@Path("phoneNumber") String phoneNumber);
}

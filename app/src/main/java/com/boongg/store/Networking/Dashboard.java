package com.boongg.store.Networking;

import com.boongg.store.Models.DashboardInfo;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Dashboard {
    @GET("mobile/dashboard-info/{token}")
    Single<DashboardInfo> getDashboardInfo(@Path("token") String token);
}

package com.boongg.store.Networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VehicleRequest {
    @GET("rent-pool-delete/{vehicleId}")
    Call<Void> deleteVehicle(@Path("vehicleId") String vehicleId);

}

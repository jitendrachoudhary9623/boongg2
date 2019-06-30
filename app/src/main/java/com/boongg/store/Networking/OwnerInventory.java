package com.boongg.store.Networking;

import com.boongg.store.Models.BrandList;
import com.boongg.store.Models.Requests.BikeMaintaince;
import com.boongg.store.Models.Requests.CreateBike;
import com.boongg.store.Models.Requests.ModifyRequest;
import com.boongg.store.Models.Requests.UpdateBikePrice;
import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Models.Responses.NearbyVehicles.Vehicle;
import com.boongg.store.Models.Responses.Owners.BikePriceChart;
import com.boongg.store.Models.Responses.Owners.Owner;
import com.boongg.store.Models.Responses.RentBikeResponse;
import com.boongg.store.Models.Responses.VehicleList.VehicleList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OwnerInventory {

    @GET("storeforid/{token}")
    Call<Owner> getOwnerInfo(@Path("token") String token);

    @GET("rent/search/{owner_city_name}/any/any/{owner_city_locality}/")
    Call<Vehicle> getVehicleNearby(@Path("owner_city_name") String city, @Path("owner_city_locality") String locality,
                                         @Query(value="start_date",encoded =true) String start_date, @Query(value="end_date",encoded =true) String end_date, @Query(value = "timezone",encoded =true) String timezone);

    @GET("rent-pool/all-list-store/{token}")
    Call<List<VehicleInventoryResponse>> getAvailableVehicles(@Path("token") String token);

    @GET("rent-pool/list/{token}/")
    Call<List<VehicleList>> getVehicleList(@Path("token") String token);

    @GET("rentbikes/list/{token}")
    Call<List<RentBikeResponse>> getRentVehicles(@Path("token") String token);

    @POST("rentbooking/modifybookingrequest")
    Call<Void> modifyVehicle(@Body ModifyRequest modifyRequest);

    @GET("brand/list")
    Call<List<BrandList>> getBikeList();

    @POST("rent-pool/add")
    Call<Void> creakeBike(@Body CreateBike bike);

    @GET("rentbikes/{bikeId}")
    Call<List<BikePriceChart>> getBikePriceChart(@Path("bikeId") String bikeId);

    @POST("rentbikes/update/price")
    Call<Void> updateBikePrice(@Body UpdateBikePrice ubp);

    @POST("rentbooking/block")
    Call<Void> maintainance(@Body BikeMaintaince bike);
}


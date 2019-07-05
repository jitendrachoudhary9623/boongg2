package com.boongg.store.Networking;


import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Requests.BikeDetails.Bike;
import com.boongg.store.Models.Requests.CreateBookingRequest;
import com.boongg.store.Models.Requests.DropVehicleRequest;
import com.boongg.store.Models.Requests.ModifyBikes.Modify;
import com.boongg.store.Models.Requests.UpdateBike.UpdateB;
import com.boongg.store.Models.Responses.CreateBooking.CreateBookingResponse;
import com.boongg.store.Models.Responses.CreateBooking.CreateBookingSuccessResponse;
import com.boongg.store.Models.Responses.Drop.DropBooking;
import com.boongg.store.Models.Responses.DropVehicleResponse;
import com.boongg.store.Models.Responses.PreDropBookings.PreDropBooking;
import com.boongg.store.Models.Token;
import com.boongg.store.Utilities.LoginToken;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BookingRequest {
    @GET("BOOKED")
    Call<List<Booking>> getAllBookings();



    //
    @GET("COMPLETED")
    Observable<List<Booking>> getCompletedBooking();
    @GET("ONGOING")
    Observable<List<DropBooking>> getRDropBookings();
    //

    @GET("ONGOING")
    Call<List<DropBooking>> getDropBookings();

    @GET("ONGOING")
    Call<List<PreDropBooking>> getPreDropBookings();

    @GET("ONGOING")
    Observable<List<PreDropBooking>> getOnGoingBikes();

    @GET("AVAILABLE")
    Observable<List<PreDropBooking>> getAvailableBikes();

    @GET("BLOCKED/MAINTENANCE")
    Observable<List<PreDropBooking>> getMaintainanceBikes();

    @POST("rentbooking/offline")
    Call<List<CreateBookingResponse>> createBooking(@Body CreateBookingRequest c);

    @POST("rentbooking/request/complete")
    Call<Void> dropVehicle(@Body DropVehicleRequest d);

    @GET("rent-pool/{bikeId}")
    Call<Bike> getBike(@Path("bikeId") String bikeId);

    @POST("rent-pool/update-id")
    Call<UpdateB> updateBike(@Body UpdateB bike);

    @POST("rentbooking/modifybookingrequest")
    Call<Void> modifyBikeInDrop(@Body Modify m);
}

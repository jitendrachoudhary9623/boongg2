package com.boongg.store.Networking;

import com.boongg.store.Models.Requests.ExtendBookingDateRequest;
import com.boongg.store.Models.Requests.ExtendDateAfterRentRequest;
import com.boongg.store.Models.Responses.ExtendDateAfterRentResponse;
import com.boongg.store.Models.Responses.ExtendDateResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RentCalculationAPI {

@POST("rentbikes/calculaterent")
Call<ExtendDateResponse> getExtendedDateRent(@Body ExtendBookingDateRequest e);

@POST("rentbooking/update/extendate")
Call<ExtendDateAfterRentResponse> getExtendedDateAfterResponse(@Body ExtendDateAfterRentRequest e);

@POST("rentbooking/sendinvoice")
Call<Void> sendInvoice(@Body String id);
}

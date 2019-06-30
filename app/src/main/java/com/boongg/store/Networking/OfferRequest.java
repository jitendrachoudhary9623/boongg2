package com.boongg.store.Networking;

import com.boongg.store.Models.Requests.ViewOffer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OfferRequest {

    @GET("coupen-code/list")
    Call<List<ViewOffer>> getOffers();
}

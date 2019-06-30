package com.boongg.store.Networking;

import com.boongg.store.Models.Responses.PaymentMethod;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Payment {

    @GET("paymentype/list")
    Call<List<PaymentMethod>> getPaymentMethods();
}

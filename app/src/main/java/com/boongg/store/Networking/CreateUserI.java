package com.boongg.store.Networking;

import com.boongg.store.Models.Requests.CreateUser;
import com.boongg.store.Models.Requests.SendOtpRequest;
import com.boongg.store.Models.Requests.VerifyOtpRequest;
import com.boongg.store.Models.Responses.CreateUserResponse;
import com.boongg.store.Models.Responses.CreateUserSuccessResponse;
import com.boongg.store.Models.Responses.SendOtpResponse;
import com.boongg.store.Models.Responses.VerifyOtpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CreateUserI {

    @POST("createuser")
    Call<CreateUserSuccessResponse> createNewUser(@Body CreateUser createUser);

    @POST("sendOTP")
    Call<SendOtpResponse> sendOtp(@Body SendOtpRequest req);

    @POST("verifyOTP")
    Call<VerifyOtpResponse> verifyOtp(@Body VerifyOtpRequest req);
}

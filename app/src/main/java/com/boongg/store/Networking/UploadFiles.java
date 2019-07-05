package com.boongg.store.Networking;

import com.boongg.store.Models.Requests.BikeDetails.Bike;
import com.boongg.store.Models.Requests.UploadFiles.FormData;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadFiles {
    @Multipart
    @POST("rent-pool/upload-doc")
    Call<Void> uploadImage(@Part MultipartBody.Part file, @Part("formData") RequestBody formdata);
}

package com.boongg.store.Networking;

import android.util.Log;

import com.boongg.store.Utilities.LoginToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CancelClient {
    //public static final String BASE_URL = "http://18.222.139.67:3100/api/rentbooking/request/cancel/";
    public static final String BASE_URL = RestApiURL.API_BASE_URL+"api/rentbooking/request/cancel/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        Log.e("JWT",BASE_URL);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}

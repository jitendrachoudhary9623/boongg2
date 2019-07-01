package com.boongg.store.Networking;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.boongg.store.Utilities.LoginToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class OAPIClient {
   // public static final String BASE_URL = "http://13.127.135.220:3100/api/rentbooking/list/"+ LoginToken.id+"/";
    public static final String BASE_URL = RestApiURL.API_BASE_URL+"api/rentbooking/list/"+ LoginToken.id+"/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        Log.e("JWT",BASE_URL);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

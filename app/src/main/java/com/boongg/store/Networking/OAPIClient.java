package com.boongg.store.Networking;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.boongg.store.Utilities.LoginToken;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OAPIClient {

    public static final String BASE_URL = "http://18.222.139.67:3100/api/rentbooking/list/"+ LoginToken.id+"/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        Log.e("JWT",BASE_URL);
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

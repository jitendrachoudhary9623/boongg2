package com.boongg.store.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.boongg.store.Models.Requests.StoreInfo.StoreDetail;
import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefUtils {
    static SharedPreferences mPrefs=null;


    public static <T> void saveObjectToSharedPred(Context context,T object,String key){
        if(mPrefs==null) {
            initSharedPreference(context);
        }
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(object); // myObject - instance of MyObject
        prefsEditor.putString(key, json);
        prefsEditor.commit();
    }

    public static <T> T returnObject(String key,T t,Context context){
            initSharedPreference(context);
            Gson gson = new Gson();
            String json = mPrefs.getString(key, "");
            // StoreDetail obj = gson.fromJson(json, StoreDetail.class);
            T obj = (T)gson.fromJson(json,t.getClass());
            return obj;

    }
    public static StoreDetail returnObject(String key, Context context){
        initSharedPreference(context);
        Gson gson = new Gson();
        String json = mPrefs.getString(key, "");
        // StoreDetail obj = gson.fromJson(json, StoreDetail.class);
        StoreDetail obj = gson.fromJson(json,StoreDetail.class);
        return obj;

    }
    private static void initSharedPreference(Context context) {
            mPrefs=context.getSharedPreferences(LoginToken.PREFS, Context.MODE_PRIVATE);
    }
}

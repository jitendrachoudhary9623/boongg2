package com.boongg.store.Networking.DataFetchers;

import android.view.View;

import com.boongg.store.Models.Booking;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.RecyclerViews.BookingAdapter;
import com.boongg.store.Utilities.DateSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PickUpDataFetcher {
    static List<Booking> bookingList=null;

    public static List<Booking> fetchData(final String day) {
        try {
            if (bookingList == null) {
                bookingList = new ArrayList<>();
            } else {
                bookingList.clear();
            }
            BookingRequest bookingRequest = OAPIClient.getClient().create(BookingRequest.class);
            Call<List<Booking>> call1 = bookingRequest.getAllBookings();
            call1.enqueue(new Callback<List<Booking>>() {
                @Override
                public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {

                    if(response.isSuccessful()) {
                        if(response.body()!=null) {
                            bookingList = DateSorter.getBookings(day, response.body(), true);
                        }
                    }

                }

                @Override
                public void onFailure(Call<List<Booking>> call, Throwable t) {

                }
            });
        }catch (Exception e){}
        return bookingList;
    }

}

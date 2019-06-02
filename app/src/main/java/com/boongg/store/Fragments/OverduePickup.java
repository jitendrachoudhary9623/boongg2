package com.boongg.store.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Booking;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.BookingAdapter;
import com.boongg.store.Utilities.DateSorter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OverduePickup  extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_overdue_pickup, container, false);
        final RecyclerView recyclerView;
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_overdue_pickup);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final TextView msg=(TextView)rootView.findViewById(R.id.overdue_no_msg);
        BookingRequest bookingRequest= OAPIClient.getClient().create(BookingRequest.class);
        Call<List<Booking>> call1 = bookingRequest.getAllBookings();
        call1.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {

                List<Booking> bookingList = new ArrayList<>();
                bookingList = response.body();
               // bookingList= DateSorter.getBookings("Overdue",bookingList);
                bookingList=DateSorter.getBookings("Overdue",bookingList);
                if(bookingList.size()>0) {
                    BookingAdapter adapter = new BookingAdapter(DateSorter.getBookings("Overdue", bookingList), getContext());
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(getContext(), "Size " + bookingList.size(), Toast.LENGTH_LONG).show();
                    msg.setVisibility(View.GONE);

                }else{
                    msg.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onFailure(Call<List<Booking>> call, Throwable t) {
                Toast.makeText(getContext(),""+t.toString(),Toast.LENGTH_LONG).show();
                Log.e("JWT ERR",t.toString());
            }
        });
        return rootView;
    }
}

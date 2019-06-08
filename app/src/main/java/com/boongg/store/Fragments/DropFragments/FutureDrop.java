package com.boongg.store.Fragments.DropFragments;

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
import com.boongg.store.RecyclerViews.DropAdapter;
import com.boongg.store.Utilities.DateSorter;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FutureDrop extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drop_future, container, false);
        final RecyclerView recyclerView;
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_future_drop);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        BookingRequest bookingRequest= OAPIClient.getClient().create(BookingRequest.class);
        Call<List<Booking>> call1 = bookingRequest.getDropBookings();
        final TextView msg=(TextView)rootView.findViewById(R.id.drop_future_no_msg);

        call1.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {
                List<Booking> bookingList = new ArrayList<>();
                bookingList = response.body();
                //bookingList=;
                if(bookingList.size()>0) {
                    DropAdapter adapter = new DropAdapter(bookingList, getContext());
                    recyclerView.setAdapter(adapter);
                    msg.setVisibility(View.GONE);
                }
                else{
                    msg.setVisibility(View.VISIBLE);
                }
                //    Toast.makeText(getContext(),"Size "+bookingList.size(),Toast.LENGTH_LONG).show();
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

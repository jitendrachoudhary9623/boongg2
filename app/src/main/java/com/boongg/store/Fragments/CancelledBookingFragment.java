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
import com.boongg.store.Models.Responses.CancelledData.Cancel;
import com.boongg.store.Models.Token;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.CancelledData;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.BookingAdapter;
import com.boongg.store.RecyclerViews.CancelAdapter;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.LoginToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CancelledBookingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cancelled_booking, container, false);
        final RecyclerView recyclerView;
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_cancelled_booking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        CancelledData cancelRequest= APIClient.getClient().create(CancelledData.class);
        Call<List<Cancel>> call1 = cancelRequest.getCancelledDate(LoginToken.id);
        Log.e("JWT token",LoginToken.tokenId);
        Log.e("JWT id",LoginToken.id);

        final TextView msg=(TextView)rootView.findViewById(R.id.cancel_no_msg);

        call1.enqueue(new Callback<List<Cancel>>() {
            @Override
            public void onResponse(Call<List<Cancel>> call, Response<List<Cancel>> response) {
                List<Cancel> bookingList = new ArrayList<>();
                bookingList = response.body();
                if(bookingList.size()>0) {
                    CancelAdapter adapter = new CancelAdapter(bookingList, getContext());
                    recyclerView.setAdapter(adapter);
                    msg.setVisibility(View.GONE);
                }
                else{
                    msg.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Cancel>> call, Throwable t) {
                Toast.makeText(getContext(),""+t.toString(),Toast.LENGTH_LONG).show();
                Log.e("JWT ERR",t.toString());
            }
        });
        return rootView;
    }
}

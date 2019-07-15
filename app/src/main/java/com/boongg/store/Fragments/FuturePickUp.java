package com.boongg.store.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import com.boongg.store.Models.Booking;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.BookingAdapter;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.ProgressbarUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuturePickUp extends Fragment {

    RecyclerView recyclerView;
    List<Booking> bookingList = new ArrayList<>();
    TextView msg;
    boolean datafetched;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_future_pickup, container, false);
        setHasOptionsMenu(true);
        datafetched=false;
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_future_pickup);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        msg=(TextView)rootView.findViewById(R.id.future_no_msg);

        fetchData(false);

        return rootView;
    }

    private void fetchData(final boolean isrefresh) {
        if(isrefresh){
            datafetched=false;
            msg.setVisibility(View.VISIBLE);
            ProgressbarUtil.showProgressbar(getContext());
        }
        BookingRequest bookingRequest= OAPIClient.getClient().create(BookingRequest.class);
        Call<List<Booking>> call1 = bookingRequest.getAllBookings();
        call1.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {

                if(isrefresh){
                    msg.setVisibility(View.VISIBLE);
                    ProgressbarUtil.hideProgressBar();
                }
                datafetched=true;
                bookingList = response.body();
                //bookingList=;
                try {
                    bookingList = DateSorter.getBookings("Future", bookingList,true);
                    if (bookingList.size() > 0) {
                        Collections.sort(bookingList);
                        BookingAdapter adapter = new BookingAdapter(bookingList, getContext());
                        recyclerView.setAdapter(adapter);
                        msg.setVisibility(View.GONE);
                    }
                }catch (Exception d){
                    msg.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onFailure(Call<List<Booking>> call, Throwable t) {
               // Toast.makeText(getContext(),""+t.toString(),Toast.LENGTH_LONG).show();
                Log.e("JWT ERR",t.toString());
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.current_booking,menu);
        final MenuItem searchItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        EditText searchEditText = (EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        searchEditText.setTextColor(getResources().getColor(R.color.value_color));
        searchEditText.setHintTextColor(getResources().getColor(R.color.value_color));
        searchEditText.setBackgroundColor(getResources().getColor(R.color.white));
        MenuItem refresh=menu.findItem(R.id.refresh);
        refresh.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                fetchData(true);
                return false;
            }
        });
        MenuItem sortItems=menu.findItem(R.id.sort);
        sortItems.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Collections.reverse(bookingList);

                if(datafetched){
                    Log.e("DROP","After Sort MENU"+bookingList.size());

                    BookingAdapter adapter = new BookingAdapter(bookingList, getContext());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                if(datafetched){
                    BookingAdapter adapter = new BookingAdapter(bookingList, getContext());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                updateSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                updateSearch(query);

                return false;
            }
        });    }

    private void updateSearch(String query) {
        try {
            if (datafetched) {
                List<Booking> search = new ArrayList<>();
                for (Booking b : bookingList) {
                    if (b.getBoonggBookingId().contains(query.toUpperCase())||b.getWebuserId().getProfile().getMobileNumber().contains(query)||b.getWebuserId().getProfile().getName().toUpperCase().contains(query.toUpperCase())) {
                        search.add(b);
                    }
                }
                if(search.isEmpty()){
                    msg.setText("No Search Results found");
                    msg.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }else {
                    recyclerView.setVisibility(View.VISIBLE);

                    msg.setVisibility(View.GONE);
                    BookingAdapter adapter = new BookingAdapter(search, getContext());
                    recyclerView.setAdapter(adapter);
                }

            }
        }catch (Exception e){}
    }
}

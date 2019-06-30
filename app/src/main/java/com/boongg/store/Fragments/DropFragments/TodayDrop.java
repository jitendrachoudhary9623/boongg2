package com.boongg.store.Fragments.DropFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Booking;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.DropAdapter;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.ProgressbarUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodayDrop extends Fragment {
    RecyclerView recyclerView;
    List<Booking> bookingList = new ArrayList<>();
    TextView msg;
    boolean datafetched;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drop_today, container, false);
setHasOptionsMenu(true);
        datafetched=false;
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_today_drop);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

         msg=(TextView)rootView.findViewById(R.id.drop_today_no_msg);

         fetchData(false);
        return rootView;
    }

    private void fetchData(final boolean isrefresh) {
        BookingRequest bookingRequest= OAPIClient.getClient().create(BookingRequest.class);
        Call<List<Booking>> call1 = bookingRequest.getDropBookings();
        if(isrefresh){
            ProgressbarUtil.showProgressbar(getContext());
        }
        call1.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {
                bookingList=new ArrayList<>();
                bookingList = response.body();
                datafetched=true;
                //bookingList=;
                if(bookingList.size()>0) {
                    bookingList = DateSorter.getBookings("Today", response.body(),false);

                    DropAdapter adapter = new DropAdapter(bookingList, getContext());
                    recyclerView.setAdapter(adapter);
                    msg.setVisibility(View.GONE);
                    if(isrefresh){
                        ProgressbarUtil.hideProgressBar();
                    }
                }
                else{
                    msg.setVisibility(View.VISIBLE);
                }
                //    Toast.makeText(getContext(),"Size "+bookingList.size(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Booking>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.current_booking,menu);
        final MenuItem searchItem = menu.findItem(R.id.search);
        MenuItem refresh=menu.findItem(R.id.refresh);
        refresh.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                fetchData(true);
                return false;
            }
        });
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                if(datafetched){
                    DropAdapter adapter = new DropAdapter(bookingList, getContext());
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
                    DropAdapter adapter = new DropAdapter(search, getContext());
                    recyclerView.setAdapter(adapter);
                }

            }
        }catch (Exception e){}
    }
}

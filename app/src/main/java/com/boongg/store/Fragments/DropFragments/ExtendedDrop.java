package com.boongg.store.Fragments.DropFragments;

import android.graphics.Color;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Responses.Drop.DropBooking;
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

public class ExtendedDrop extends Fragment {
    RecyclerView recyclerView;
    List<DropBooking> bookingList = new ArrayList<>();
    TextView msg;
    boolean datafetched;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drop_extended, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_extended_drop);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        msg=(TextView)rootView.findViewById(R.id.drop_extended_no_msg);
        setHasOptionsMenu(true);
        datafetched=false;
        fetchData(false);
        return rootView;
    }

    private void fetchData(final boolean isrefresh) {
        BookingRequest bookingRequest= OAPIClient.getClient().create(BookingRequest.class);
        Call<List<DropBooking>> call1 = bookingRequest.getDropBookings();
        if(isrefresh){
            ProgressbarUtil.showProgressbar(getContext());
        }
        call1.enqueue(new Callback<List<DropBooking>>() {
            @Override
            public void onResponse(Call<List<DropBooking>> call, Response<List<DropBooking>> response) {
                bookingList = response.body();
                datafetched=true;
                //bookingList=;
                if(bookingList.size()>0) {
                    bookingList = DateSorter.getDropBookings("Overdue", response.body(),false);

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
            public void onFailure(Call<List<DropBooking>> call, Throwable t) {
                Toast.makeText(getContext(),""+t.toString(),Toast.LENGTH_LONG).show();
                Log.e("JWT ERR",t.toString());
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
        EditText searchEditText = (EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.value_color));
        searchEditText.setHintTextColor(getResources().getColor(R.color.value_color));
        searchEditText.setBackgroundColor(getResources().getColor(R.color.white));
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
                List<DropBooking> search = new ArrayList<>();
                for (DropBooking b : bookingList) {
                    if (b.get_rentPoolKey().getRegistrationNumber().contains(query.toUpperCase())||b.getBoonggBookingId().contains(query.toUpperCase())||b.get_webuserId().getProfile().getMobileNumber().contains(query)||b.get_webuserId().getProfile().getName().toUpperCase().contains(query.toUpperCase())) {
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

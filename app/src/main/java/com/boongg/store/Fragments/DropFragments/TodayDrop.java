package com.boongg.store.Fragments.DropFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import com.boongg.store.Models.Responses.Drop.DropBooking;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.DropAdapter;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.ProgressbarUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class TodayDrop extends Fragment {
    RecyclerView recyclerView;
    List<DropBooking> bookingList = new ArrayList<>();
    TextView msg;
    boolean datafetched;
    BookingRequest bookingRequest;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drop_today, container, false);
        setHasOptionsMenu(true);
        datafetched=false;
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_today_drop);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        msg=(TextView)rootView.findViewById(R.id.drop_today_no_msg);
         fetchData(false);
        return rootView;
    }

    private void fetchData(final boolean isrefresh) {
        BookingRequest bookingRequest= OAPIClient.getClient().create(BookingRequest.class);

            ProgressbarUtil.showProgressbar(getContext());

        compositeDisposable.add(bookingRequest.getRDropBookings().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<DropBooking>>() {
            @Override
            public void accept(List<DropBooking> bookings) throws Exception {
                datafetched=true;
                if(bookings.size()>0) {
                    bookings = DateSorter.getDropBookings("Today", bookings,false);
                    bookingList.clear();
                    bookingList.addAll(bookings);

                    Log.e("DROP","Before Sort "+bookingList.size()+" "+bookings.size());
                    Collections.sort(bookings);
                    Log.e("DROP","After Sort "+bookingList.size()+" "+bookings.size());

                    DropAdapter adapter = new DropAdapter(bookingList, getContext());
                    recyclerView.setAdapter(adapter);
                    msg.setVisibility(View.GONE);
                        ProgressbarUtil.hideProgressBar();

                }
                else{
                    msg.setVisibility(View.VISIBLE);
                }
                displayData(bookings);

            }
        }));


    }

    private void displayData(List<DropBooking> bookings) {
        if(bookings.size()<1){
            msg.setVisibility(View.VISIBLE);
        }
        else {
            recyclerView.setItemViewCacheSize(bookings.size());

            msg.setVisibility(View.GONE);
            DropAdapter adapter = new DropAdapter(bookings, getContext());
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
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
        MenuItem sortItems=menu.findItem(R.id.sort);
        sortItems.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Collections.reverse(bookingList);

                if(datafetched){
                    Log.e("DROP","After Sort MENU"+bookingList.size());

                    DropAdapter adapter = new DropAdapter(bookingList, getContext());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
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
                    if (b.get_rentPoolKey().getRegistrationNumber().toUpperCase().equals(query.toUpperCase())||b.get_rentPoolKey().getRegistrationNumber().contains(query.toUpperCase())||b.getBoonggBookingId().contains(query.toUpperCase())||b.get_webuserId().getProfile().getMobileNumber().contains(query)||b.get_webuserId().getProfile().getName().toUpperCase().contains(query.toUpperCase())) {
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

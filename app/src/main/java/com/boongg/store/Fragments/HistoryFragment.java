package com.boongg.store.Fragments;

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
import com.boongg.store.Models.Responses.CancelledData.Cancel;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.CancelledData;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.CancelAdapter;
import com.boongg.store.RecyclerViews.DropAdapter;
import com.boongg.store.RecyclerViews.HistoryAdapter;
import com.boongg.store.Utilities.AlertBoxUtils;
import com.boongg.store.Utilities.LoginToken;
import com.boongg.store.Utilities.ProgressbarUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;
    List<Booking> bookingList;
    TextView msg;
    boolean datafetched;
    BookingRequest bookingRequest;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cancelled_booking, container, false);
        setHasOptionsMenu(true);
        datafetched=false;
        bookingList=new ArrayList<>();
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_cancelled_booking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ProgressbarUtil.showProgressbar(getContext());
        bookingRequest= OAPIClient.getClient().create(BookingRequest.class);
        msg=(TextView)rootView.findViewById(R.id.cancel_no_msg);
        msg.setText("No Completed Bookings");
        fetchData();
        return rootView;
    }

    private void fetchData() {
        compositeDisposable.add(bookingRequest.getCompletedBooking().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Booking>>() {
            @Override
            public void accept(List<Booking> bookings) throws Exception {
                datafetched=true;
                bookingList=bookings;
                displayData(bookings);

            }
        }));
    }

    private void displayData(List<Booking> bookings) {
        if(bookings.size()<1){
            msg.setVisibility(View.VISIBLE);
        }
        else {
            msg.setVisibility(View.GONE);
            HistoryAdapter adapter = new HistoryAdapter(bookings, getContext());
            recyclerView.setAdapter(adapter);
        }
        ProgressbarUtil.hideProgressBar();

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
                ProgressbarUtil.showProgressbar(getContext());
                fetchData();
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
                    HistoryAdapter adapter = new HistoryAdapter(bookingList, getContext());
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
                    HistoryAdapter adapter = new HistoryAdapter(search, getContext());
                    recyclerView.setAdapter(adapter);
                }

            }
        }catch (Exception e){}
    }
}

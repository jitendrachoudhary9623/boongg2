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


import com.boongg.store.Models.Responses.CancelledData.Cancel;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.CancelledData;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.CancelAdapter;
import com.boongg.store.Utilities.LoginToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CancelledBookingFragment extends Fragment {
    List<Cancel> bookingList = new ArrayList<>();
    View rootView;
    RecyclerView recyclerView;
    TextView msg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_cancelled_booking, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_cancelled_booking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        setHasOptionsMenu(true);
        msg = (TextView) rootView.findViewById(R.id.cancel_no_msg);
        fetchData();
        return rootView;
    }

    private void fetchData() {
        CancelledData cancelRequest = APIClient.getClient().create(CancelledData.class);
        Call<List<Cancel>> call1 = cancelRequest.getCancelledDate(LoginToken.id);
        call1.enqueue(new Callback<List<Cancel>>() {
            @Override
            public void onResponse(Call<List<Cancel>> call, Response<List<Cancel>> response) {
                bookingList = response.body();
                setupRecycler(bookingList);
            }

            @Override
            public void onFailure(Call<List<Cancel>> call, Throwable t) {
                //     Toast.makeText(getContext(),""+t.toString(),Toast.LENGTH_LONG).show();
                Log.e("JWT ERR", t.toString());
            }
        });
    }

    private void setupRecycler(List<Cancel> bookingList) {
        if (this.bookingList.size() > 0) {
            CancelAdapter adapter = new CancelAdapter(this.bookingList, getContext());
            recyclerView.setAdapter(adapter);
            msg.setVisibility(View.GONE);
        } else {
            msg.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.inventory_menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.i_search);
        MenuItem refresh = menu.findItem(R.id.i_refresh);
        refresh.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                fetchData();
                return false;
            }
        });

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        searchEditText.setTextColor(getResources().getColor(R.color.value_color));
        searchEditText.setHintTextColor(getResources().getColor(R.color.value_color));
        searchEditText.setBackgroundColor(getResources().getColor(R.color.white));
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                fetchData();
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
        });
    }

    private void updateSearch(String query) {
        try {
            List<Cancel> search = new ArrayList<>();
            for (Cancel b : bookingList) {
                if (b.getWebuserId().getProfile().getMobileNumber().toUpperCase().contains(query.toUpperCase()) || b.getModel().toUpperCase().contains(query.toUpperCase()) || b.getBrand().toUpperCase().contains(query.toUpperCase()) || b.getBoonggBookingId().contains(query.toUpperCase())) {
                    search.add(b);
                }
            }
            if (search.isEmpty()) {
                msg.setText("No Search Results found");
                msg.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            } else {
                recyclerView.setVisibility(View.VISIBLE);

                msg.setVisibility(View.GONE);
                setupRecycler(search);
            }


        } catch (Exception e) {
        }
    }
}

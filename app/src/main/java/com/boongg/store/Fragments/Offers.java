package com.boongg.store.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boongg.store.Models.Requests.ViewOffer;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.OfferRequest;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.OfferAdapter;
import com.boongg.store.Utilities.AlertBoxUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Offers extends Fragment {

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_offers, container, false);
        setHasOptionsMenu(true);
        final RecyclerView recyclerView;
        final TextView offer_msg=(TextView)rootView.findViewById(R.id.offer_no_msg);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_offer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        OfferRequest offerRequest= APIClient.getClient().create(OfferRequest.class);
        Call<List<ViewOffer>> viewOffer=offerRequest.getOffers();
        AlertBoxUtils.showLoadingAlert(getContext());
        viewOffer.enqueue(new Callback<List<ViewOffer>>() {
            @Override
            public void onResponse(Call<List<ViewOffer>> call, Response<List<ViewOffer>> response) {
                offer_msg.setVisibility(View.GONE);
                OfferAdapter adapter=new OfferAdapter(response.body(),getContext());
                recyclerView.setAdapter(adapter);
                AlertBoxUtils.hideLoadingAlert();
            }

            @Override
            public void onFailure(Call<List<ViewOffer>> call, Throwable t) {

            }
        });
        return rootView;
    }
}

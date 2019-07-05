package com.boongg.store.Fragments.VehicleInventoryFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Responses.RentBikeResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.BookingAdapter;
import com.boongg.store.RecyclerViews.VehicleRentCollectionAdapter;
import com.boongg.store.Utilities.LoginToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RentCollectionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_rent_collection, container, false);
        final RecyclerView recyclerView;
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_rent_all_bikes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        OwnerInventory oi= APIClient.getClient().create(OwnerInventory.class);
        Call<List<RentBikeResponse>> call=oi.getRentVehicles(LoginToken.id);
        final TextView msg=(TextView)rootView.findViewById(R.id.rent_all_bikes_inventory_no_msg);

        call.enqueue(new Callback<List<RentBikeResponse>>() {
            @Override
            public void onResponse(Call<List<RentBikeResponse>> call, Response<List<RentBikeResponse>> response) {
              try {
                //  Toast.makeText(getContext(), "" + response.body().size(), Toast.LENGTH_LONG).show();
                  VehicleRentCollectionAdapter adapter = new VehicleRentCollectionAdapter(response.body(), getContext());
                  recyclerView.setAdapter(adapter);
                  msg.setVisibility(View.GONE);
              }catch (Exception e){}
            }

            @Override
            public void onFailure(Call<List<RentBikeResponse>> call, Throwable t) {
              //  Toast.makeText(getContext(),""+t.toString(),Toast.LENGTH_LONG).show();
                msg.setVisibility(View.VISIBLE);


            }
        });

        return rootView;
    }
}

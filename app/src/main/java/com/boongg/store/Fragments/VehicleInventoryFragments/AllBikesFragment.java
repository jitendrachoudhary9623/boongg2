package com.boongg.store.Fragments.VehicleInventoryFragments;

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
import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.BookingAdapter;
import com.boongg.store.RecyclerViews.VehicleInventoryAdapter;
import com.boongg.store.Utilities.LoginToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllBikesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_inventory_all_bikes, container, false);
        final RecyclerView recyclerView;
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_inventory_all_bikes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        OwnerInventory inventory= APIClient.getClient().create(OwnerInventory.class);
        Call<List<VehicleInventoryResponse>> call1 = inventory.getAvailableVehicles(LoginToken.id);
        final TextView msg=(TextView)rootView.findViewById(R.id.all_bikes_inventory_no_msg);
        call1.enqueue(new Callback<List<VehicleInventoryResponse>>() {
            @Override
            public void onResponse(Call<List<VehicleInventoryResponse>> call, Response<List<VehicleInventoryResponse>> response) {
                List<VehicleInventoryResponse> vehicleInventoryResponses=response.body();
                if(vehicleInventoryResponses.size()>0) {
                    VehicleInventoryAdapter adapter = new VehicleInventoryAdapter(vehicleInventoryResponses, getContext());
                    recyclerView.setAdapter(adapter);
                    msg.setVisibility(View.GONE);
                }
                else{
                    msg.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<VehicleInventoryResponse>> call, Throwable t) {
                Toast.makeText(getContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}

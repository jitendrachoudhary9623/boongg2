package com.boongg.store.RecyclerViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Interfaces.OnImageClickListener;
import com.boongg.store.Models.Responses.NearbyVehicles.Result;
import com.boongg.store.Models.Responses.RentBikeResponse;
import com.boongg.store.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VehicleRentCollectionAdapter extends RecyclerView.Adapter<VehicleRentCollectionAdapter.VehicleRentCollectionViewHolder> {



    List<RentBikeResponse> vehicleList;
    Context mContext;
    public VehicleRentCollectionAdapter() {
    }

    @NonNull
    @Override
    public VehicleRentCollectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_vehicle_rent_list, viewGroup, false);
        VehicleRentCollectionViewHolder mv = new VehicleRentCollectionViewHolder(itemView);
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleRentCollectionViewHolder holder, int position) {
        holder.bindData(position);

    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

    public VehicleRentCollectionAdapter(List<RentBikeResponse> vehicleList, Context context) {
        this.vehicleList = vehicleList;
        mContext = context;

    }


    public class VehicleRentCollectionViewHolder extends RecyclerView.ViewHolder{

        TextView bikename,status,engine,quantity,prichart;
        public VehicleRentCollectionViewHolder(@NonNull View itemView) {
            super(itemView);
            bikename=(TextView)itemView.findViewById(R.id.rent_inventory_all_bike_name);
            status=(TextView)itemView.findViewById(R.id.rent_inventory_all_status);
            engine=(TextView)itemView.findViewById(R.id.rent_inventory_all_engine);
            quantity=(TextView)itemView.findViewById(R.id.rent_inventory_all_qty);

        }
        public void bindData(final int position) {
        RentBikeResponse rent=vehicleList.get(position);
        bikename.setText(rent.getBrand()+"  "+rent.getModel());
        status.setText(rent.getStatus());
        engine.setText("Engine "+rent.getEngineCapacity()+" CC");
        quantity.setText("Quantity : "+rent.getQuantity());


        }
    }
}

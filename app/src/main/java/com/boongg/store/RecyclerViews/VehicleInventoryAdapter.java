package com.boongg.store.RecyclerViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Interfaces.OnImageClickListener;
import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Models.Responses.NearbyVehicles.Result;
import com.boongg.store.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VehicleInventoryAdapter  extends RecyclerView.Adapter<VehicleInventoryAdapter.VehicleViewHolder> {


    List<VehicleInventoryResponse> vehicleList;
    Context mContext;
    public VehicleInventoryAdapter() {
    }

    public VehicleInventoryAdapter(List<VehicleInventoryResponse> vehicleList, Context context ) {
        this.vehicleList = vehicleList;
        mContext = context;
    }
    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_available_bikes, viewGroup, false);
        VehicleViewHolder mv = new VehicleViewHolder(itemView);
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        holder.bindData(position);

    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

    public class VehicleViewHolder extends RecyclerView.ViewHolder{

        TextView vehicleName,status,regno;
        LinearLayout vll;
        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicleName=(TextView)itemView.findViewById(R.id.all_inventory_vehicle_name);
            status=(TextView)itemView.findViewById(R.id.all_inventory_status);
            regno=(TextView)itemView.findViewById(R.id.all_inventory_registration_no);
          }
        public void bindData(final int position) {
        VehicleInventoryResponse vehicle=vehicleList.get(position);
        vehicleName.setText(vehicle.getBrand()+" "+vehicle.getVehicleModel());
        status.setText(vehicle.getStatusType().getType());
        regno.setText("Registration No : "+vehicle.getRegistrationNumber());
        }
    }

}

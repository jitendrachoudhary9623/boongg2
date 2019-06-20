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
import com.boongg.store.Models.Responses.CancelledData.Cancel;
import com.boongg.store.Models.Responses.NearbyVehicles.Result;
import com.boongg.store.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VehicleSelectAdapter  extends RecyclerView.Adapter<VehicleSelectAdapter.VehicleViewHolder> {

    private OnImageClickListener onImageClickListener;

    List<Result> vehicleList;
    Context mContext;
    public VehicleSelectAdapter() {
    }

    public VehicleSelectAdapter(List<Result> vehicleList, Context context,OnImageClickListener onImageClickListener) {
        this.vehicleList = vehicleList;
        mContext = context;
        this.onImageClickListener = onImageClickListener;

    }
    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_create_booking_vehicle, viewGroup, false);
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

        ImageView vehicleImage;
        TextView vehicleName,availability,weekday,weekend,bikeRent,bookingPay;
        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicleImage=(ImageView)itemView.findViewById(R.id.create_booking_select_vehicle);
            vehicleName=(TextView)itemView.findViewById(R.id.create_booking_select_vehicle_name);
            bikeRent=(TextView)itemView.findViewById(R.id.bike_rent);
            bookingPay=(TextView)itemView.findViewById(R.id.booking_pay);

        }
        public void bindData(final int position) {
            final Result v=vehicleList.get(position);
            Toast.makeText(mContext,v.getThumbUrl(),Toast.LENGTH_LONG).show();
            Picasso.with(mContext).load(v.getThumbUrl()).into(vehicleImage);
            vehicleName.setText(v.getBrand()+" "+v.getModelName());
            bikeRent.setText(mContext.getResources().getString(R.string.rs)+" "+v.getRentCalculated());
            bookingPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v1) {

                    onImageClickListener.onImageClick(v);

                }
            });

        }
    }

}

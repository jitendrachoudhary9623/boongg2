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
import com.boongg.store.Models.Responses.NearbyVehicles.Result;
import com.boongg.store.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VehicleRentAdapter  extends RecyclerView.Adapter<VehicleRentAdapter.VehicleViewHolder> {

    private OnImageClickListener onImageClickListener;

    List<Result> vehicleList;
    Context mContext;
    public VehicleRentAdapter() {
    }

    public VehicleRentAdapter(List<Result> vehicleList, Context context,OnImageClickListener onImageClickListener) {
        this.vehicleList = vehicleList;
        mContext = context;
        this.onImageClickListener = onImageClickListener;

    }
    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_rent_bike, viewGroup, false);
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
        TextView vehicleName;
        LinearLayout vll;
        TextView hr,m_f,s_s,m,total_rent;
        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicleImage=(ImageView)itemView.findViewById(R.id.create_booking_select_vehicle);
            vehicleName=(TextView)itemView.findViewById(R.id.create_booking_select_vehicle_name);
            vll=(LinearLayout)itemView.findViewById(R.id.rent_booking_vehicle_select_ll);
            total_rent=(TextView)itemView.findViewById(R.id.rent_total);
            hr=(TextView)itemView.findViewById(R.id.rent_hour);
            m_f=(TextView)itemView.findViewById(R.id.rent_mon_fri_day);
            s_s=(TextView)itemView.findViewById(R.id.rent_sat_sun_day);
            m=(TextView)itemView.findViewById(R.id.rent_month);
        }
        public void bindData(final int position) {
            final Result v=vehicleList.get(position);
            Toast.makeText(mContext,v.getThumbUrl(),Toast.LENGTH_LONG).show();
            Picasso.with(mContext).load(v.getThumbUrl()).into(vehicleImage);
            vehicleName.setText(v.getBrand()+" "+v.getModelName());
            vll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v1) {



                    onImageClickListener.onImageClick(v);

                }
            });
            total_rent.setText("Total Rent\n"+mContext.getResources().getString(R.string.rs)+" "+v.getRentCalculated());

            hr.setText(mContext.getResources().getString(R.string.rs)+" "+v.getWeekDayPrice()+" / hr");

            m_f.setText(mContext.getResources().getString(R.string.rs)+" "+v.getWeekDayPrice()+" / day");
            s_s.setText(mContext.getResources().getString(R.string.rs)+" "+v.getWeekEndPrice()+" / day");
            m.setText(mContext.getResources().getString(R.string.rs)+" "+(v.getRentCalculated()*30)+" / month");

        }
    }

}

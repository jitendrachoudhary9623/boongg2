package com.boongg.store.RecyclerViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.boongg.store.Models.Booking;
import com.boongg.store.R;
import com.boongg.store.Utilities.DateSorter;

import java.util.List;

public class DropAdapter extends RecyclerView.Adapter<DropAdapter.DropViewHolder>{

    List<Booking> bookings;
    Context mContext;
    public DropAdapter(){

    }
    boolean show=false;
    public DropAdapter(List<Booking> bookings, Context context) {
        this.bookings = bookings;
        mContext = context;
    }

    @NonNull
    @Override
    public DropViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_drop, parent, false);
        DropViewHolder mv = new DropViewHolder(itemView);
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull DropViewHolder holder, int position) {
        holder.bindData(position);

    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public class DropViewHolder extends RecyclerView.ViewHolder {
        TextView options;
        LinearLayout showOptions;
        TextView startDate,endDate,bookingId,name,phone,amount,mode,vehicle;
        public DropViewHolder(@NonNull View itemView) {
            super(itemView);
            options=(TextView) itemView.findViewById(R.id.drop_options);
            showOptions=(LinearLayout)itemView.findViewById(R.id.drop_show);
            startDate=(TextView)itemView.findViewById(R.id.rv_drop_start_date);
            endDate=(TextView)itemView.findViewById(R.id.rv_drop_end_date);
            bookingId=(TextView)itemView.findViewById(R.id.rv_drop_booking_id);
            name=(TextView)itemView.findViewById(R.id.rv_drop_customer_name);
            phone=(TextView)itemView.findViewById(R.id.rv_drop_phone);
            amount=(TextView)itemView.findViewById(R.id.rv_drop_amount);
            vehicle=(TextView)itemView.findViewById(R.id.rv_drop_vehicle);
        }

        public void bindData(final int position) {
            Booking booking=bookings.get(position);
            try {
                startDate.setText(DateSorter.getFormattedDate(booking.getStartDate()));
                endDate.setText(DateSorter.getFormattedDate(booking.getEndDate()));

            }catch (Exception e){

            }
            bookingId.setText(""+booking.getBoonggBookingId());
            name.setText(""+booking.getWebuserId().getProfile().getName());
            phone.setText(""+booking.getWebuserId().getProfile().getMobileNumber());
           amount.setText(mContext.getResources().getString(R.string.rs)+" "+String.format("%.2f",booking.getRentTotal()));
           vehicle.setText(booking.getBrand()+" - "+booking.getModel());
           options.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(show){
                        showOptions.setVisibility(View.GONE);
                        show=(!show);

                    }else{
                        showOptions.setVisibility(View.VISIBLE);
                        show=(!show);


                    }
                }
            });
        }

    }

}

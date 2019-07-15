package com.boongg.store.RecyclerViews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
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


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    List<Booking> bookings;
    Context mContext;

    public HistoryAdapter() {
    }

    public HistoryAdapter(List<Booking> bookings, Context context) {
        this.bookings = bookings;
        mContext = context;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_cancel, parent, false);
        HistoryViewHolder mv = new HistoryViewHolder(itemView);
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.bindData(position);

    }



    @Override
    public int getItemCount() {
        return this.bookings.size();
    }
    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView bookingId,startDate,endDate,customberName,phoneNo,amount,status,vehicleName,mode,cancelledOn;
        LinearLayout call;
        public HistoryViewHolder(View itemView) {
            super(itemView);
            bookingId = (TextView) itemView.findViewById(R.id.cancel_booking_id);
            startDate=(TextView) itemView.findViewById(R.id.cancel_start_date);
            endDate=(TextView) itemView.findViewById(R.id.cancel_end_date);
            customberName=(TextView) itemView.findViewById(R.id.cancel_customer_name);
            phoneNo=(TextView) itemView.findViewById(R.id.cancel_phone);
            amount=(TextView) itemView.findViewById(R.id.cancel_amount);
            status=(TextView) itemView.findViewById(R.id.cancel_online);
            vehicleName=(TextView) itemView.findViewById(R.id.cancel_vehicle);
            mode=(TextView) itemView.findViewById(R.id.cancel_mode);
            call=(LinearLayout)itemView.findViewById(R.id.cancel_call_user);
            cancelledOn=(TextView)itemView.findViewById(R.id.cancel_booking_time);

        }


        public void bindData(final int position) {
            final Booking booking=bookings.get(position);
            bookingId.setText(""+booking.getBoonggBookingId());
            try {
                startDate.setText(DateSorter.getFormattedDate(booking.getStartDate()));
                endDate.setText(""+DateSorter.getFormattedDate(booking.getEndDate()));
                cancelledOn.setText("Completed on "+DateSorter.getFormattedDate(booking.getUpdatedAt()));

            }catch (Exception e){

            }
            try {
              customberName.setText("" + booking.getWebuserId().getProfile().getName());
                phoneNo.setText("" + booking.getWebuserId().getProfile().getMobileNumber());
                amount.setText(mContext.getResources().getString(R.string.rs) + " " + String.format("%.2f", booking.getTotalAmountRecived()));

                mode.setText(booking.getBookingType());

                vehicleName.setText(booking.getBrand() + " - " + booking.getModel());

            }
            catch(Exception e)
            {
             //   Toast.makeText(mContext,e.toString(),Toast.LENGTH_LONG).show();
            }
            finally {

            }
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + booking.getWebuserId().getProfile().getMobileNumber()));
                    mContext.startActivity(intent);
                }
            });
        }
    }

}

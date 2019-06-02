package com.boongg.store.RecyclerViews;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Fragments.CurrentBooking;
import com.boongg.store.MainActivity;
import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Buttons;
import com.boongg.store.R;
import com.boongg.store.Utilities.DateSorter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {

    List<Booking> bookings;
    Context mContext;

    public BookingAdapter() {
    }

    public BookingAdapter(List<Booking> bookings, Context context) {
        this.bookings = bookings;
        mContext = context;
    }

    @Override
    public BookingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_pickup, parent, false);
        BookingViewHolder mv = new BookingViewHolder(itemView);
        return mv;
    }

    @Override
    public void onBindViewHolder(BookingViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return this.bookings.size();
    }

    public class BookingViewHolder extends RecyclerView.ViewHolder {

        TextView bookingId,startDate,endDate,customberName,phoneNo,amount,status,vehicleName,mode;
        ImageView buttonImage;
        LinearLayout call;
        public BookingViewHolder(View itemView) {
            super(itemView);
            bookingId = (TextView) itemView.findViewById(R.id.rv_booking_id);
            startDate=(TextView) itemView.findViewById(R.id.rv_start_date);
            endDate=(TextView) itemView.findViewById(R.id.rv_end_date);
            customberName=(TextView) itemView.findViewById(R.id.rv_customer_name);
            phoneNo=(TextView) itemView.findViewById(R.id.rv_phone);
            amount=(TextView) itemView.findViewById(R.id.rv_amount);
            status=(TextView) itemView.findViewById(R.id.rv_online);
            vehicleName=(TextView) itemView.findViewById(R.id.rv_vehicle);
            call=(LinearLayout) itemView.findViewById(R.id.call_user);
            mode=(TextView)itemView.findViewById(R.id.rv_mode);
        }


        public void bindData(final int position) {
            final Booking booking=bookings.get(position);
            bookingId.setText(""+booking.getBoonggBookingId());

            try {
                startDate.setText(DateSorter.getFormattedDate(booking.getStartDate()));
                endDate.setText(" - "+DateSorter.getFormattedDate(booking.getEndDate()));
            }catch (Exception e){

            }
            customberName.setText(""+booking.getWebuserId().getProfile().getName());
            phoneNo.setText(""+booking.getWebuserId().getProfile().getMobileNumber());
            amount.setText(mContext.getResources().getString(R.string.rs)+" "+String.format("%.2f",booking.getRentTotal()));

            mode.setText(booking.getBookingType());
           /* if(booking.getStatus().equals("BOOKED")){
                status.setBackgroundColor(mContext.getResources().getColor(R.color.sgreen));
            }*/
            vehicleName.setText(booking.getBrand()+" - "+booking.getModel());
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
         //           Toast.makeText(mContext,"Called "+booking.getWebuserId().getProfile().getMobileNumber(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + booking.getWebuserId().getProfile().getMobileNumber()));
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
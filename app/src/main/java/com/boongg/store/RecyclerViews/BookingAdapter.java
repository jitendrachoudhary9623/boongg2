package com.boongg.store.RecyclerViews;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Fragments.CurrentBooking;
import com.boongg.store.MainActivity;
import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Buttons;
import com.boongg.store.Models.Cancel;
import com.boongg.store.Models.Requests.CheckIn;
import com.boongg.store.Models.Token;
import com.boongg.store.Models.UpdateResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.CancelClient;
import com.boongg.store.Networking.CancelRequest;
import com.boongg.store.Networking.CheckInRequest;
import com.boongg.store.Networking.LoginRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.R;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.JWTUtils;
import com.boongg.store.Utilities.LoginToken;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        TextView cancel,checkIn;
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
            cancel=(TextView) itemView.findViewById(R.id.rv_cancel_in_button);
            checkIn=(TextView) itemView.findViewById(R.id.rv_check_in_button);
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
            amount.setText(mContext.getResources().getString(R.string.rs)+" "+String.format("%.2f",booking.getTotalAmountRecived()));

            mode.setText(booking.getBookingType());
           /* if(booking.getStatus().equals("BOOKED")){
                status.setBackgroundColor(mContext.getResources().getColor(R.color.sgreen));
            }*/
            vehicleName.setText(booking.getBrand()+" - "+booking.getModel());
            checkIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater li = LayoutInflater.from(mContext);
                    View promptsView = li.inflate(R.layout.alert_checkin, null);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            mContext);
                    final EditText start=(EditText)promptsView.findViewById(R.id.startKm);
                    alertDialogBuilder.setView(promptsView);
                    alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("Check In",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {

                                            boolean isHelmetProvide=true;
                                            String startKm=start.getText().toString();
                                            CheckIn check=new CheckIn(booking.getRentBikeKey().getId(),isHelmetProvide,booking.getId(),startKm);

                                            CheckInRequest checkInRequest= APIClient.getClient().create(CheckInRequest.class);
                                            Call<UpdateResponse> call1 = checkInRequest.checkIn(check);
                                            call1.enqueue(new Callback<UpdateResponse>() {
                                                @Override
                                                public void onResponse(Call<UpdateResponse> call, Response<UpdateResponse> response) {
                                                    bookings.remove(position);
                                                    notifyItemRemoved(position);
                                                    notifyItemRangeChanged(position, bookings.size());
                                                }

                                                @Override
                                                public void onFailure(Call<UpdateResponse> call, Throwable t) {
                                                    Toast.makeText(mContext,"Something went wrong"+t.toString(),Toast.LENGTH_LONG).show();
                                                Log.e("JWT",t.toString());
                                                }
                                            });
                                        }
                                    })
                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            dialog.cancel();

                                        }
                                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater li = LayoutInflater.from(mContext);
                    View promptsView = li.inflate(R.layout.alert_cancel_booking, null);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            mContext);
                    alertDialogBuilder.setView(promptsView);
                    final EditText userInput = (EditText) promptsView
                            .findViewById(R.id.editTextDialogUserInput);
                    alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("Don't Cancel it",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            dialog.cancel();
                                         }
                                    })
                            .setNegativeButton("Cancel the booking",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            Log.d("Cancel Id",booking.getId());
                                            Toast.makeText(mContext,""+userInput.getText()+" "+booking.getId(),Toast.LENGTH_LONG).show();
                                            CancelRequest cancelRequest= CancelClient.getClient().create(CancelRequest.class);
                                            Call<Cancel> call1 = cancelRequest.cancelBooking(booking.getId(),userInput.getText().toString());
                                            call1.enqueue(new Callback<Cancel>() {
                                                @Override
                                                public void onResponse(Call<Cancel> call, Response<Cancel> response) {
                                                    Toast.makeText(mContext,"Booking Cancelled ",Toast.LENGTH_LONG).show();
                                                    bookings.remove(position);
                                                    notifyItemRemoved(position);
                                                    notifyItemRangeChanged(position, bookings.size());
                                                }
                                                @Override
                                                public void onFailure(Call<Cancel> call, Throwable t) {
                                                    Toast.makeText(mContext,""+t.toString(),Toast.LENGTH_LONG).show();
                                                }
                                            });
                                        }
                                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            });
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
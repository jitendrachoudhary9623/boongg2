package com.boongg.store.RecyclerViews;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Requests.CheckIn;
import com.boongg.store.Models.Requests.ExtendBookingDateRequest;
import com.boongg.store.Models.Requests.ExtendDateAfterRentRequest;
import com.boongg.store.Models.Responses.ExtendDateAfterRentResponse;
import com.boongg.store.Models.Responses.ExtendDateResponse;
import com.boongg.store.Models.UpdateResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.CheckInRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.Networking.RentCalculationAPI;
import com.boongg.store.R;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.ModifyAlertBox;
import com.boongg.store.Utilities.ProgressbarUtil;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        LinearLayout showOptions,dropLayout,extendLayout,sendLayout,modifyLayout;
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
            dropLayout=(LinearLayout)itemView.findViewById(R.id.drop_drop_button);
            extendLayout=(LinearLayout)itemView.findViewById(R.id.drop_option_extend);
            sendLayout=(LinearLayout)itemView.findViewById(R.id.send_invoice);
            modifyLayout=(LinearLayout)itemView.findViewById(R.id.drop_modify_vehicle);
        }

        public void bindData(final int position) {
            final Booking booking=bookings.get(position);
            try {
                startDate.setText(DateSorter.getFormattedDate(booking.getStartDate()));
                endDate.setText(DateSorter.getFormattedDate(booking.getEndDate()));

            }catch (Exception e){

            }
            bookingId.setText(""+booking.getBoonggBookingId());
            name.setText(""+booking.getWebuserId().getProfile().getName());
            phone.setText(""+booking.getWebuserId().getProfile().getMobileNumber());
           amount.setText(mContext.getResources().getString(R.string.rs)+" "+String.format("%.2f",booking.getTotalAmountRecived()));
           vehicle.setText(booking.getBrand()+" - "+booking.getModel());
          dropLayout.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                dropLayoutClick(booking);
              }
          });
          extendLayout.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  extendBooking(booking);
              }
          });

            sendLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProgressbarUtil.showProgressbar(mContext);
                    final RentCalculationAPI apiEndPoint= APIClient.getClient().create(RentCalculationAPI.class);
                    Call<Void> call1 = apiEndPoint.sendInvoice(booking.getId());
                    call1.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            ProgressbarUtil.hideProgressBar();
                            Toast.makeText(mContext,"Invoice Sent",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            ProgressbarUtil.hideProgressBar();

                            Toast.makeText(mContext,"Invoice Failed to sent",Toast.LENGTH_LONG).show();

                        }
                    });
                }
            });
            modifyLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ModifyAlertBox.modifyVehicle(mContext,booking);
                }
            });
        }

    }

    //extend booking click
    private void extendBooking(final Booking booking) {
        LayoutInflater li = LayoutInflater.from(mContext);
        View promptsView = li.inflate(R.layout.alert_drop_extend_date, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mContext);
        final TextView dateSelector=(TextView)promptsView.findViewById(R.id.alert_drop_extend_date_picker);
        final TextView calculateRent=(TextView)promptsView.findViewById(R.id.alert_drop_extend_calculate_rent);
        final TextView calculatedRent=(TextView)promptsView.findViewById(R.id.alert_drop_extend_date_rent_calculate);
        final TextView extendDate = (TextView)promptsView.findViewById(R.id.alert_drop_extend_date_api_call);



        setDateUsingDatePicker(dateSelector,mContext);
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder
                .setCancelable(false)
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();

                            }
                        });
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        calculateRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calRent(alertDialog,booking,dateSelector,calculatedRent,calculateRent,extendDate);
            }
        });
    }

    //calculates rent and extends booking
    private void calRent(final AlertDialog alertDialog, final Booking booking, final TextView dateSelector, final TextView calculatedRent, TextView calculateRent, final TextView extendDate) {
        final ExtendBookingDateRequest ex=new ExtendBookingDateRequest();
        ex.setModel(booking.getModel());
        ex.setEndDate(booking.getEndDate());
        ex.setSuggestedExtendedRent(booking.getRentWithDiscount());
        ex.setBrand(booking.getBrand());
        ex.setBookingId(booking.getId());
        //ex.setStartDate(booking.getStartDate());
        try {
            ex.setStartDate(booking.getStartDate());

            ex.setScheduleTime(dateSelector.getText().toString());
        }catch(Exception e){
            Toast.makeText(mContext,e.toString(),Toast.LENGTH_LONG).show();
        }
        final RentCalculationAPI rentCal= APIClient.getClient().create(RentCalculationAPI.class);
        Call<ExtendDateResponse> call1 = rentCal.getExtendedDateRent(ex);
        call1.enqueue(new Callback<ExtendDateResponse>() {
            @Override
            public void onResponse(Call<ExtendDateResponse> call, Response<ExtendDateResponse> response) {
                final int apiCalc=response.body().getCalculatedRent();
                try {
                }catch(Exception e){
                    calculatedRent.setText("Calculated Rent : 0 ");

                }
                calculatedRent.setText("Calculated Rent : " +apiCalc );

                extendDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ExtendDateAfterRentRequest request=new ExtendDateAfterRentRequest();
                        request.setBookingId(booking.getId());
                        request.setIsGstApplicable(true);
                        request.setRentPoolKey(booking.getRentBikeKey().getId());
                        request.setSuggestedExtendedRent(apiCalc);
                        request.setTotalExtendedBikeRent(apiCalc);
                        request.setScheduleTime(dateSelector.getText().toString());
                        request.setStartDate(booking.getStartDate());
                        Call<ExtendDateAfterRentResponse> call2 = rentCal.getExtendedDateAfterResponse(request);
                        call2.enqueue(new Callback<ExtendDateAfterRentResponse>() {
                            @Override
                            public void onResponse(Call<ExtendDateAfterRentResponse> call, Response<ExtendDateAfterRentResponse> response) {
                                Toast.makeText(mContext,"Success",Toast.LENGTH_LONG).show();
                                alertDialog.dismiss();

                            }

                            @Override
                            public void onFailure(Call<ExtendDateAfterRentResponse> call, Throwable t) {
                                Toast.makeText(mContext,"Fail "+t.toString(),Toast.LENGTH_LONG).show();

                            }
                        });

                    }
                });
            }

            @Override
            public void onFailure(Call<ExtendDateResponse> call, Throwable t) {

            }
        });
    }

    //drop button click
    private void dropLayoutClick(Booking booking) {
        LayoutInflater li = LayoutInflater.from(mContext);
        View promptsView = li.inflate(R.layout.alert_drop_drop_layout, null);
        final EditText startKm,totalKm,rtochallan,bike,fine_accident;
        startKm=(EditText)promptsView.findViewById(R.id.alert_drop_start_km);
        totalKm=(EditText)promptsView.findViewById(R.id.alert_total_km_run);
        rtochallan=(EditText)promptsView.findViewById(R.id.alert_drop_rto);
        bike=(EditText)promptsView.findViewById(R.id.alert_drop_bike_handover);
        fine_accident=(EditText)promptsView.findViewById(R.id.alert_drop_fine);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mContext);

        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Drop Vehicle",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                String startKm_=startKm.getText().toString();
                                String totalKm_=totalKm.getText().toString();
                                String rto=rtochallan.getText().toString();
                                String bike_=bike.getText().toString();
                                String fine=fine_accident.getText().toString();
                                dropVehicle(startKm_,totalKm_,rto,bike_,fine);
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

    private void dropVehicle(String startKm_, String totalKm_, String rto, String bike_, String fine) {
    }

    public void setDateUsingDatePicker(final TextView vt, final Context context){

        vt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final SimpleDateFormat mSimpleDateFormat;
                final Calendar mCalendar;
                mCalendar = Calendar.getInstance();
                //2019-06-18T07:34:34.787Z
                mSimpleDateFormat = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss.'000Z'", Locale.getDefault());
                final TimePickerDialog.OnTimeSetListener mTimeDataSet = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        mCalendar.set(Calendar.MINUTE, minute);

                        vt.setText(mSimpleDateFormat.format(mCalendar.getTime()));
                    }
                };
                final DatePickerDialog.OnDateSetListener mDateDataSet = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mCalendar.set(Calendar.YEAR, year);
                        mCalendar.set(Calendar.MONTH, monthOfYear);

                        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        new TimePickerDialog(context, mTimeDataSet, mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar.get(Calendar.MINUTE), true).show();
                    }
                };

                new DatePickerDialog(context, mDateDataSet, mCalendar.get(Calendar.YEAR),
                        mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });
    }

}

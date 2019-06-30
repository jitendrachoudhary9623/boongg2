package com.boongg.store.RecyclerViews;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.boongg.store.Models.Requests.DropVehicleRequest;
import com.boongg.store.Models.Requests.ExtendBookingDateRequest;
import com.boongg.store.Models.Requests.ExtendDateAfterRentRequest;
import com.boongg.store.Models.Responses.DropVehicleResponse;
import com.boongg.store.Models.Responses.ExtendDateAfterRentResponse;
import com.boongg.store.Models.Responses.ExtendDateResponse;
import com.boongg.store.Models.Responses.PreDropBookings.PreDropBooking;
import com.boongg.store.Models.UpdateResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.CheckInRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.Networking.RentCalculationAPI;
import com.boongg.store.R;
import com.boongg.store.Utilities.AlertBoxUtils;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.ModifyAlertBox;
import com.boongg.store.Utilities.ProgressbarUtil;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
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
        TextView startDate,endDate,bookingId,name,phone,amount,mode,vehicle,reg;
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
            reg=(TextView)itemView.findViewById(R.id.rv_drop_vehicle_reg);
        }

        public void bindData(final int position) {
            final Booking booking=bookings.get(position);
            try {
                startDate.setText(DateSorter.getFormattedDate(booking.getStartDate()));
                endDate.setText(DateSorter.getFormattedDate(booking.getEndDate()));

            }catch (Exception e){

            }
            reg.setText("Reg No :&#10;"+booking.getBoonggBookingId());

            bookingId.setText(""+booking.getBoonggBookingId());
            name.setText(""+booking.getWebuserId().getProfile().getName());
            phone.setText(""+booking.getWebuserId().getProfile().getMobileNumber());
           amount.setText(mContext.getResources().getString(R.string.rs)+" "+String.format("%.2f",booking.getTotalAmountRecived()));
           vehicle.setText(booking.getBrand()+" - "+booking.getModel());
           phone.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   //Toast.makeText(mContext,"Clicked",Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + booking.getWebuserId().getProfile().getMobileNumber()));
                   mContext.startActivity(intent);
               }
           });
          dropLayout.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  BookingRequest request=OAPIClient.getClient().create(BookingRequest.class);
                  Call<List<PreDropBooking>> call3=request.getPreDropBookings();
                  call3.enqueue(new Callback<List<PreDropBooking>>() {
                      @Override
                      public void onResponse(Call<List<PreDropBooking>> call, Response<List<PreDropBooking>> response) {

                          dropLayoutClick(booking,response.body(),position);

                      }

                      @Override
                      public void onFailure(Call<List<PreDropBooking>> call, Throwable t) {
AlertBoxUtils.showAlert(mContext,"error","",t.toString());
                      }
                  });
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
                            AlertBoxUtils.showAlert(mContext,"success","Invoice","Invoice sent successfully");
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            ProgressbarUtil.hideProgressBar();
                            AlertBoxUtils.showAlert(mContext,"error","Invoice","Invoice Failed to sent");
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
        extendDate.setVisibility(View.GONE);

        setDateUsingDatePicker(dateSelector,mContext);
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Extend Date", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        extend(booking,calculatedRent.getText().toString().split(":")[1],dateSelector);
                        dialog.cancel();

                    }
                })
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
                final Double apiCalc=response.body().getCalculatedRent();
                try {
                }catch(Exception e){
                    calculatedRent.setText("Calculated Rent : 0 ");

                }
                calculatedRent.setText("Calculated Rent :" +apiCalc );


            }

            @Override
            public void onFailure(Call<ExtendDateResponse> call, Throwable t) {

            }
        });
    }

    private void extend(Booking booking, String s, TextView dateSelector) {
        final RentCalculationAPI rentCal= APIClient.getClient().create(RentCalculationAPI.class);
        Double apiCalc=Double.parseDouble(s);
        ExtendDateAfterRentRequest request=new ExtendDateAfterRentRequest();
        request.setBookingId(booking.getId());
        request.setIsGstApplicable(true);
        request.setRentPoolKey(booking.getRentBikeKey().getId());
        request.setSuggestedExtendedRent((int)Math.round(apiCalc));
        request.setTotalExtendedBikeRent((int)Math.round(apiCalc));
        request.setScheduleTime(dateSelector.getText().toString());
        request.setStartDate(booking.getStartDate());
        Call<ExtendDateAfterRentResponse> call2 = rentCal.getExtendedDateAfterResponse(request);
        call2.enqueue(new Callback<ExtendDateAfterRentResponse>() {
            @Override
            public void onResponse(Call<ExtendDateAfterRentResponse> call, Response<ExtendDateAfterRentResponse> response) {
               // Toast.makeText(mContext,"Success",Toast.LENGTH_LONG).show();
                AlertBoxUtils.showAlert(mContext,"success","Date Extenstion","As you requested to extend date, yur request is fulfilled");
            }

            @Override
            public void onFailure(Call<ExtendDateAfterRentResponse> call, Throwable t) {
                AlertBoxUtils.showAlert(mContext,"error","Date Extenstion","Something went wrong "+t.toString());

            }
        });
    }

    //extend

    //drop button click
    private void dropLayoutClick(final Booking booking, List<PreDropBooking> preDrop, final int positionBooking) {
         final List<PreDropBooking> rentObject = new LinkedList<>();
        for(PreDropBooking preDropBooking:preDrop){
            if(booking.getRentBikeKey().getId().equals(preDropBooking.get_rentBikeKey().get_id())){
                rentObject.add(preDropBooking);
                break;
            }
        }

        LayoutInflater li = LayoutInflater.from(mContext);
        View promptsView = li.inflate(R.layout.alert_drop_drop_layout, null);
        final EditText startKm,totalKm,rtochallan,bike,fine_accident;
        startKm=(EditText)promptsView.findViewById(R.id.alert_drop_start_km);
        totalKm=(EditText)promptsView.findViewById(R.id.alert_total_km_run);
        rtochallan=(EditText)promptsView.findViewById(R.id.alert_drop_rto);
        bike=(EditText)promptsView.findViewById(R.id.alert_drop_bike_handover);
        fine_accident=(EditText)promptsView.findViewById(R.id.alert_drop_fine);
        TextView helmetMsg=(TextView)promptsView.findViewById(R.id.helment_msg);
        startKm.setText(""+rentObject.get(0).getStartKm());

        startKm.setEnabled(false);
        totalKm.setEnabled(false);
        bike.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if(s.toString().equals("")){
                        totalKm.setText("");

                    }
                    double diff = Double.parseDouble(s.toString()) - Double.parseDouble(startKm.getText().toString());
                    totalKm.setText(""+diff);
                }catch (Exception e){
                    Toast.makeText(mContext,""+e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
        if(rentObject.get(0).getIsHelmateProvided()) {
            helmetMsg.setText("Note : Please collect helmet from user");
        }
        else{
            helmetMsg.setText("Note : No Helmet Provided");
        }
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mContext);

        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Drop Vehicle",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                String bikeBookingId=rentObject.get(0).get_id();
                                String startKm_=startKm.getText().toString();
                                String totalKm_=totalKm.getText().toString();
                                String rto=rtochallan.getText().toString();
                                String bike_=bike.getText().toString();
                                String fine=fine_accident.getText().toString();
                                String rentPoolKey=rentObject.get(0).get_rentPoolKey().get_id();
                                dropVehicle(booking,positionBooking,bikeBookingId,startKm_,totalKm_,rto,bike_,fine,rentPoolKey);
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

    private void dropVehicle(final Booking booking, final int positionBooking, String bikeBookingId, String startKm_, String totalKm_, String rto, String bike_, String fine, String rentPoolKey) {
        DropVehicleRequest drop=new DropVehicleRequest();
        drop.set_rentPoolKey(rentPoolKey);
        drop.setBikeBookedId(bikeBookingId);
        drop.setEndKm(Integer.parseInt(totalKm_));
        drop.setFineAccidentalCost(fine);
        drop.setRtoChallen(rto);
        drop.setTotalKmRun(Integer.parseInt(totalKm_));
        BookingRequest request=APIClient.getClient().create(BookingRequest.class);
        Call<Void> call4=request.dropVehicle(drop);
        call4.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                AlertBoxUtils.showAlert(mContext,"success","Drop","Booking drop successfull");
                bookings.remove(booking);
                notifyItemRemoved(positionBooking);
                notifyItemRangeChanged(positionBooking, bookings.size());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                AlertBoxUtils.showAlert(mContext,"error","Drop","Error "+t.toString());
            }
        });
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

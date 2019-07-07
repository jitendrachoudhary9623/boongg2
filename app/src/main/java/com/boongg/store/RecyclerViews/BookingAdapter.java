package com.boongg.store.RecyclerViews;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.AlertPrompts.CheckInModify;
import com.boongg.store.CustomViews.NothingSelectedSpinnerAdapter;
import com.boongg.store.Fragments.CurrentBooking;
import com.boongg.store.MainActivity;
import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Buttons;
import com.boongg.store.Models.Cancel;
import com.boongg.store.Models.Requests.AddressUpdate.UpdateAddress;
import com.boongg.store.Models.Requests.CheckIn;
import com.boongg.store.Models.Requests.ModifyBikes.BikeModify;
import com.boongg.store.Models.Requests.StoreInfo.StoreDetail;
import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Models.Responses.SearchUSer;
import com.boongg.store.Models.Token;
import com.boongg.store.Models.UpdateResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.APIClientWithNULL;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.CancelClient;
import com.boongg.store.Networking.CancelRequest;
import com.boongg.store.Networking.CheckInRequest;
import com.boongg.store.Networking.LoginRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.Networking.SearchUser;
import com.boongg.store.R;
import com.boongg.store.Utilities.AlertBoxUtils;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.DateUtils;
import com.boongg.store.Utilities.JWTUtils;
import com.boongg.store.Utilities.LoginToken;
import com.boongg.store.Utilities.ProgressbarUtil;
import com.boongg.store.Utilities.SharedPrefUtils;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {

    List<Booking> bookings;
    Context mContext;
    boolean isBikeModified=false;
    VehicleInventoryResponse v2=null;

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
     String uAddress="";

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

        List<String> ds = new ArrayList<>();
        final List<VehicleInventoryResponse> vehicleList = new ArrayList<>();
        AlertDialog dialog2;

        private List<String> updateVehicleList(final boolean modify, final Booking booking) {
         //   Toast.makeText(mContext,"Called on "+modify,Toast.LENGTH_LONG).show();

            return ds;
        }
        boolean addressPresent=false;
        public void bindData(final int position) {
            final Booking booking=bookings.get(position);
            bookingId.setText(""+booking.getBoonggBookingId());
            try {
                startDate.setText(DateUtils.getIST(booking.getStartDate()));
                endDate.setText(DateUtils.getIST(booking.getEndDate()));
            }catch (Exception e){

            }
            customberName.setText(""+booking.getWebuserId().getProfile().getName());
            phoneNo.setText(""+booking.getWebuserId().getProfile().getMobileNumber());
            amount.setText(mContext.getResources().getString(R.string.rs)+" "+String.format("%.2f",booking.getTotalAmountRecived()));

            mode.setText(booking.getBookingType());
            vehicleName.setText(booking.getBrand()+" - "+booking.getModel());


            checkIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    LayoutInflater li = LayoutInflater.from(mContext);

                    View promptsView = li.inflate(R.layout.alert_checkin, null);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            mContext,R.style.CustomAlertDialog);
                    final EditText totalRent=(EditText)promptsView.findViewById(R.id.totalRent);
                    final EditText start=(EditText)promptsView.findViewById(R.id.startKm);
                    final EditText address=(EditText)promptsView.findViewById(R.id.emergency_address);
                    final CheckBox modifyBikeCheckBox,helmentProvidedCheckBox;
                    TextView selectedBikeText=(TextView)promptsView.findViewById(R.id.selected_bike_show);
                    selectedBikeText.setText("Booking for : "+booking.getBrand()+" "+booking.getModel());
                    modifyBikeCheckBox=(CheckBox)promptsView.findViewById(R.id.modify_bike_checkbox);
                    totalRent.setText(""+booking.getRentWithDiscount());
                    SearchUser searchUser = APIClient.getClient().create(SearchUser.class);
                    Call<List<SearchUSer>> call1 = searchUser.searchUser(booking.getWebuserId().getProfile().getMobileNumber());
                    call1.enqueue(new Callback<List<SearchUSer>>() {
                        @Override
                        public void onResponse(Call<List<SearchUSer>> call, Response<List<SearchUSer>> response) {
                            try {
                                uAddress=response.body().get(0).getProfile().getAddress();
                                if(!uAddress.equals("")){
                                    addressPresent=true;
                                }
                                address.setText(response.body().get(0).getProfile().getAddress());
                            }catch (Exception e){


                            }

                        }

                        @Override
                        public void onFailure(Call<List<SearchUSer>> call, Throwable t) {

                        }
                    });
                    final Spinner niceSpinner = (Spinner) promptsView.findViewById(R.id.select_bike_spinner);

                    OwnerInventory inventory=APIClient.getClient().create(OwnerInventory.class);

                    Call<List<VehicleInventoryResponse>> call2= inventory.getAvailableVehicles(LoginToken.id);
                    call2.enqueue(new Callback<List<VehicleInventoryResponse>>() {
                        @Override
                        public void onResponse(Call<List<VehicleInventoryResponse>> call, Response<List<VehicleInventoryResponse>> response) {
                            ds=null;
                            ds=new ArrayList<>();
                            vehicleList.clear();
                            for(VehicleInventoryResponse vir:response.body()){

                                    if(booking.getModel().equals(vir.getVehicleModel())) {
                                        Log.e("JWT", booking.getBrand() + " " + booking.getModel() + " ---- " + vir.getBrand() + " ----- " + vir.getVehicleModel());
                                        vehicleList.add(vir);
                                        ds.add("(" + vir.getRegistrationNumber() + ") " + vir.getBrand() + " " + vir.getVehicleModel());
                                    }
                            }
                            if(ds.size()==0){
                                ds.add("No Bikes Available / Please contact admin");
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<String >(
                                    mContext,
                                    R.layout.spinner_vehicle_select,
                                    ds
                            );


                            niceSpinner.setAdapter(new NothingSelectedSpinnerAdapter(
                                    adapter,
                                    R.layout.spinner_row_nothing_selected,
                                    mContext));

                        }
                        @Override
                        public void onFailure(Call<List<VehicleInventoryResponse>> call, Throwable t) {
                            AlertBoxUtils.showAlert(mContext,"error","",""+t.toString());

                        }
                    });
                    modifyBikeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                            if(dialog2.isShowing()){
                                dialog2.dismiss();
                            }
                            isBikeModified=isChecked;
                            AlertBoxUtils.showLoadingAlert(mContext);
                            OwnerInventory inventory=APIClient.getClient().create(OwnerInventory.class);
                            Call<List<VehicleInventoryResponse>> call2= inventory.getAvailableVehicles(LoginToken.id);
                            call2.enqueue(new Callback<List<VehicleInventoryResponse>>() {
                                @Override
                                public void onResponse(Call<List<VehicleInventoryResponse>> call, Response<List<VehicleInventoryResponse>> response) {
                                    ds=null;
                                    ds=new ArrayList<>();
                                    vehicleList.clear();
                                    for(VehicleInventoryResponse vir:response.body()){
                                        if(isChecked) {
                                            vehicleList.add(vir);
                                            ds.add("(" + vir.getRegistrationNumber() + ") " + vir.getBrand() + " " + vir.getVehicleModel());
                                        }else{
                                            if(booking.getModel().equals(vir.getVehicleModel())){
                                                Log.e("JWT",booking.getBrand()+" "+booking.getModel()+" ---- "+vir.getBrand()+" ----- "+vir.getVehicleModel());
                                                vehicleList.add(vir);
                                                ds.add("(" + vir.getRegistrationNumber() + ") " + vir.getBrand() + " " + vir.getVehicleModel());
                                            }
                                        }
                                    }
                                    ArrayAdapter<String> adapter = new ArrayAdapter<String >(
                                            mContext,
                                            R.layout.spinner_vehicle_select,
                                            ds
                                    );

                                    niceSpinner.setAdapter(new NothingSelectedSpinnerAdapter(
                                            adapter,
                                            R.layout.spinner_row_nothing_selected,
                                            mContext));
                                }

                                @Override
                                public void onFailure(Call<List<VehicleInventoryResponse>> call, Throwable t) {
                                    AlertBoxUtils.showAlert(mContext,"error","",""+t.toString());

                                }
                            });
                            AlertBoxUtils.hideLoadingAlert();
                            if(!dialog2.isShowing()){
                                dialog2.show();
                            }
                        }
                    });



                    final String[] bId = {""};
                    final String selectedBike[]={""};
                    niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            try {
                                switch (position){
                                    case 0:
                                        break;
                                    default:
                                         v2 = vehicleList.get(position-1);
                                         Log.e("DATA SELECTED",position+" "+v2.getBrand()+" "+v2.getVehicleModel());
                                        bId[0] = v2.get_id();
                                        break;
                                }

                            }catch (Exception e){
                                AlertBoxUtils.showAlert(mContext,"error","Bike Not Available","Selected Bike is Not Available / Contact Admin");
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    helmentProvidedCheckBox=(CheckBox)promptsView.findViewById(R.id.helmet_provided);


                    alertDialogBuilder.setView(promptsView);
                    alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("Check In",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(final DialogInterface dialog, int id) {
                                            if (bId[0].equals("")) {
                                                address.setError("Bike is not selected");
                                                dialog.dismiss();
                                                AlertBoxUtils.showAlert(mContext,"error","Check in failed","Bike was not selected properly, please select bike again");
                                            }
                                            else if (start.getText().toString().equals("")) {
                                                start.setError("Enter Start Km for the bike");
                                                dialog.dismiss();
                                                AlertBoxUtils.showAlert(mContext,"error","Check in failed","Start KM should be added");

                                            } else {

                                                if (isBikeModified) {
                                                    CheckInModify.modifyVehicle(mContext,booking,v2,start,addressPresent,address,uAddress,helmentProvidedCheckBox);
                                                    bookings.remove(position);
                                                    notifyItemRemoved(position);
                                                    notifyItemRangeChanged(position, bookings.size());
                                                    if (addressPresent == false || uAddress.equals(address.getText().toString()) == false) {
                                                        //update Address
                                                        try {
                                                            String phoneNo = booking.getWebuserId().getProfile().getMobileNumber();
                                                            final SearchUser user = APIClient.getClient().create(SearchUser.class);
                                                            Call<List<SearchUSer>> scall = user.searchUser(phoneNo);
                                                            scall.enqueue(new Callback<List<SearchUSer>>() {
                                                                @Override
                                                                public void onResponse(Call<List<SearchUSer>> call, Response<List<SearchUSer>> response) {
                                                                    switch (response.body().size()) {
                                                                        case 1:
                                                                            UpdateAddress update = new UpdateAddress();
                                                                            update.setId(response.body().get(0));
                                                                            update.setAddress(address.getText().toString());
                                                                            Call<Void> updateA = user.updateAddress(update);
                                                                            updateA.enqueue(new Callback<Void>() {
                                                                                @Override
                                                                                public void onResponse(Call<Void> call, Response<Void> response) {
                                                                                }
                                                                                @Override
                                                                                public void onFailure(Call<Void> call, Throwable t) {

                                                                                }
                                                                            });
                                                                            break;
                                                                        default:
                                                                            break;
                                                                    }
                                                                }

                                                                @Override
                                                                public void onFailure(Call<List<SearchUSer>> call, Throwable t) {

                                                                }
                                                            });

                                                        } catch (Exception e) {
                                                        }
                                                        dialog2.dismiss();
                                                        AlertBoxUtils.showAlert(mContext, "success", "Check In", "Check in successfull");

                                                    } else {
                                                       // AlertBoxUtils.showAlert(mContext, "success", "Check In", "Check in successfull");
                                                    }
                                                } else {
                                                    boolean isHelmetProvide = false;
                                                    if (helmentProvidedCheckBox.isChecked()) {
                                                        isHelmetProvide = true;
                                                    }
                                                    String startKm = start.getText().toString();
                                                    Log.e("JWT", booking.toString());
                                                    CheckIn check = new CheckIn(bId[0], isHelmetProvide, booking.getId(), startKm);
                                                    Log.e("JWT", booking.getRentBikeKey().getId());
                                                    CheckInRequest checkInRequest = APIClient.getClient().create(CheckInRequest.class);
                                                    Call<Void> call1 = checkInRequest.checkIn(check);
                                                    ProgressbarUtil.showProgressbar(mContext);
                                                    call1.enqueue(new Callback<Void>() {
                                                        @Override
                                                        public void onResponse(Call<Void> call, Response<Void> response) {
                                                            bookings.remove(position);
                                                            notifyItemRemoved(position);
                                                            notifyItemRangeChanged(position, bookings.size());
                                                            ProgressbarUtil.hideProgressBar();
                                                            if (addressPresent == false || uAddress.equals(address.getText().toString()) == false) {
                                                                //update Address
                                                                try {
                                                                    String phoneNo = booking.getWebuserId().getProfile().getMobileNumber();
                                                                    final SearchUser user = APIClient.getClient().create(SearchUser.class);
                                                                    Call<List<SearchUSer>> scall = user.searchUser(phoneNo);
                                                                    scall.enqueue(new Callback<List<SearchUSer>>() {
                                                                        @Override
                                                                        public void onResponse(Call<List<SearchUSer>> call, Response<List<SearchUSer>> response) {
                                                                            switch (response.body().size()) {
                                                                                case 1:
                                                                                    UpdateAddress update = new UpdateAddress();
                                                                                    update.setId(response.body().get(0));
                                                                                    update.setAddress(address.getText().toString());
                                                                                    Call<Void> updateA = user.updateAddress(update);
                                                                                    updateA.enqueue(new Callback<Void>() {
                                                                                        @Override
                                                                                        public void onResponse(Call<Void> call, Response<Void> response) {

                                                                                        }

                                                                                        @Override
                                                                                        public void onFailure(Call<Void> call, Throwable t) {

                                                                                        }
                                                                                    });
                                                                                    break;
                                                                                default:
                                                                                    break;
                                                                            }
                                                                        }

                                                                        @Override
                                                                        public void onFailure(Call<List<SearchUSer>> call, Throwable t) {

                                                                        }
                                                                    });

                                                                } catch (Exception e) {
                                                                }
                                                                dialog2.dismiss();
                                                                AlertBoxUtils.showAlert(mContext, "success", "Check In", "Check in successfull");

                                                            } else {
                                                                AlertBoxUtils.showAlert(mContext, "success", "Check In", "Check in successfull");
                                                            }
                                                        }

                                                        @Override
                                                        public void onFailure(Call<Void> call, Throwable t) {
                                                            //Toast.makeText(mContext,"Something went wrong"+t.toString(),Toast.LENGTH_LONG).show();
                                                            ProgressbarUtil.hideProgressBar();

                                                            AlertBoxUtils.showAlert(mContext, "error", "Something wet wrong ", "" + t.toString());
                                                            Log.e("JWT", t.toString());
                                                        }
                                                    });
                                                }
                                            }
                                        }
                                    })
                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            dialog.cancel();

                                        }
                                    });
                    dialog2 = alertDialogBuilder.create();
                    //dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    dialog2.show();
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater li = LayoutInflater.from(mContext);
                    View promptsView = li.inflate(R.layout.alert_cancel_booking, null);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            mContext,R.style.CustomAlertDialog);
                    alertDialogBuilder.setView(promptsView);
                    final Spinner userInput = (Spinner) promptsView
                            .findViewById(R.id.nice_spinner_cancel_reason);

                    List<String> dataset = new ArrayList<>(Arrays.asList("Customer Didn't Showup"
                            , "Vehicle Issue", "Other"));
                    ArrayAdapter<String> adapter = new ArrayAdapter<String >(
                            mContext,
                            R.layout.spinner_vehicle_select,
                            dataset
                    );
                    userInput.setAdapter(adapter);
                    final String[] cancelReason = new String[1];
                    userInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            cancelReason[0] = parent.getItemAtPosition(position).toString();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    alertDialogBuilder
                            .setCancelable(false)
                            .setNegativeButton("Don't Cancel it",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            dialog.cancel();
                                        }
                                    })
                            .setPositiveButton("Cancel the booking",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            //Log.d("Cancel Id",booking.getId());
                                            //  Toast.makeText(mContext,""+userInput.getText()+" "+booking.getId(),Toast.LENGTH_LONG).show();
                                            CancelRequest cancelRequest= CancelClient.getClient().create(CancelRequest.class);
                                            Call<Cancel> call1 = cancelRequest.cancelBooking(booking.getId(),cancelReason[0]);
                                            call1.enqueue(new Callback<Cancel>() {
                                                @Override
                                                public void onResponse(Call<Cancel> call, Response<Cancel> response) {
                                                    //Toast.makeText(mContext,"Booking Cancelled ",Toast.LENGTH_LONG).show();
                                                    bookings.remove(position);
                                                    notifyItemRemoved(position);
                                                    notifyItemRangeChanged(position, bookings.size());
                                                    AlertBoxUtils.showAlert(mContext,"success","Booking Cancelled","Success");

                                                }
                                                @Override
                                                public void onFailure(Call<Cancel> call, Throwable t) {
                                                 //   Toast.makeText(mContext,""+t.toString(),Toast.LENGTH_LONG).show();
                                                }
                                            });
                                        }
                                    });
                    dialog2 = alertDialogBuilder.create();
                    //dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    dialog2.show();
                }
            });
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Toast.makeText(mContext,"Clicked",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + booking.getWebuserId().getProfile().getMobileNumber()));
                    mContext.startActivity(intent);
                }
            });
        }
    }

}
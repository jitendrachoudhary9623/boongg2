package com.boongg.store.AlertPrompts;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Requests.AddressUpdate.UpdateAddress;
import com.boongg.store.Models.Requests.ExtendBookingDateRequest;
import com.boongg.store.Models.Requests.ModifyBikes.BikeModify;
import com.boongg.store.Models.Requests.StoreInfo.StoreDetail;
import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Models.Responses.CreateBooking.CreateBookingResponse;
import com.boongg.store.Models.Responses.ExtendDateResponse;
import com.boongg.store.Models.Responses.SearchUSer;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.APIClientWithNULL;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.RentCalculationAPI;
import com.boongg.store.Networking.SearchUser;
import com.boongg.store.R;
import com.boongg.store.Utilities.AlertBoxUtils;
import com.boongg.store.Utilities.LoginToken;
import com.boongg.store.Utilities.ProgressbarUtil;
import com.boongg.store.Utilities.SharedPrefUtils;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckInModify {
    AlertDialog dialog2;
    static double gst=0;
    static Double apiCalc=0.0;

    public static void modifyVehicle(final Context mContext, final Booking booking, VehicleInventoryResponse v2, EditText start, final boolean addressPresent, final EditText address, final String uAddress, CheckBox helmentProvidedCheckBox){
        LayoutInflater li = LayoutInflater.from(mContext);

        View promptsView = li.inflate(R.layout.alert_modify_screen, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mContext,R.style.CustomAlertDialog);
        final BikeModify bm=new BikeModify();

        final EditText base_rent_bike,total_rent_bike,cgst_rent_bike,sgst_rent_bike;
        base_rent_bike=(EditText)promptsView.findViewById(R.id.base_rent_bike);
        total_rent_bike=(EditText)promptsView.findViewById(R.id.total_rent_bike);
        cgst_rent_bike=(EditText)promptsView.findViewById(R.id.cgst_rent_bike);
        sgst_rent_bike=(EditText)promptsView.findViewById(R.id.sgst_rent_bike);
        final EditText base_new_rent_bike,total_new__rent_bike,cgst_new_rent_bike,sgst_new_rent_bike;
        base_new_rent_bike=(EditText)promptsView.findViewById(R.id.base_new_rent_bike);
        total_new__rent_bike=(EditText)promptsView.findViewById(R.id.total_new__rent_bike);
        cgst_new_rent_bike=(EditText)promptsView.findViewById(R.id.cgst_new_rent_bike);
        sgst_new_rent_bike=(EditText)promptsView.findViewById(R.id.sgst_new_rent_bike);
        final TextView previous_name,modified_name,modify_msg;
        modify_msg=(TextView)promptsView.findViewById(R.id.modify_msg);
        previous_name=(TextView)promptsView.findViewById(R.id.previous_bike_name);
        previous_name.setText(String.format("Previous Bike Details (%s - %s)",booking.getBrand(),booking.getModel()));
        modified_name=(TextView)promptsView.findViewById(R.id.modified_bike_name);
        modified_name.setText(String.format("Modified Bike Details (%s - %s)",v2.getBrand(),v2.getVehicleModel()));
        StoreDetail sd2 = new StoreDetail();
        final StoreDetail sd = SharedPrefUtils.returnObject(LoginToken.OWNER_INFO, sd2, mContext);
        try {
            if (!sd.getGstNumber().equals("") && sd.getGstNumber() != null) {
                gst = 0.06;
            } else {
                gst = 0.00;
            }
        } catch (Exception e) {
            gst = 0.00;
        }

        base_rent_bike.setText(""+booking.getTotalAmountRecived());
        cgst_rent_bike.setText(""+(booking.getTotalAmountRecived()*gst));
        sgst_rent_bike.setText(""+(booking.getTotalAmountRecived()*gst));
        total_rent_bike.setText(""+(booking.getTotalAmountRecived()+(2*gst)));
        final EditText difference_amount=(EditText)promptsView.findViewById(R.id.difference_amount);

        final ExtendBookingDateRequest ex=new ExtendBookingDateRequest();
        ex.setModel(v2.getVehicleModel());
        ex.setEndDate(booking.getEndDate());
        ex.setSuggestedExtendedRent(null);
        ex.setBrand(v2.getBrand());
        ex.setBookingId(null);
        //ex.setStartDate(booking.getStartDate());
        try {
            ex.setStartDate(booking.getStartDate());
            ex.setScheduleTime(booking.getEndDate());
        }catch(Exception e){
            //   Toast.makeText(mContext,e.toString(),Toast.LENGTH_LONG).show();
        }
        final RentCalculationAPI rentCal= APIClientWithNULL.getClient().create(RentCalculationAPI.class);
        Call<ExtendDateResponse> call1 = rentCal.getExtendedDateRent(ex);
        call1.enqueue(new Callback<ExtendDateResponse>() {
            @Override
            public void onResponse(Call<ExtendDateResponse> call, Response<ExtendDateResponse> response) {
                try {
                    apiCalc=response.body().getCalculatedRent();
                    base_new_rent_bike.setText(""+apiCalc);
                    cgst_new_rent_bike.setText(""+(apiCalc*gst));
                    sgst_new_rent_bike.setText(""+(apiCalc*gst));
                    total_new__rent_bike.setText(""+(apiCalc+(2*gst)));
                    bm.setModifiedBikeBaseRent(getStringToDouble(total_new__rent_bike.getText().toString()));
                    double diff=(getStringToDouble(total_new__rent_bike.getText().toString())-getStringToDouble(total_rent_bike.getText().toString()));
                    difference_amount.setText(""+diff);
                    bm.setModifiedBikeReceviableAmount(getStringToDouble(total_new__rent_bike.getText().toString())+diff);
                    bm.setDifferenceAmount(diff);


                    if(diff>0){
                        modify_msg.setText(String.format("Difference - The User need to pay %.0f Rs Extra",diff));
                    }
                    else if(diff<0){
                        modify_msg.setText(String.format("Difference - You (Franchise) need to pay %.0f Rs",diff));
                    }else{
                        modify_msg.setText("Difference - The Difference is 0, no need to pay");
                    }

                }catch(Exception e){
                    apiCalc=0.0;
                }
            }

            @Override
            public void onFailure(Call<ExtendDateResponse> call, Throwable t) {
            }
        });

        CheckBox wavier=(CheckBox)promptsView.findViewById(R.id.wavier);
        wavier.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                bm.setIsWaveAmount(isChecked);
                if(isChecked){
                    modify_msg.setText("Amount difference waived");
                    difference_amount.setText(""+0);
                }else{

                    double diff=(getStringToDouble(total_new__rent_bike.getText().toString())-getStringToDouble(total_rent_bike.getText().toString()));
                    difference_amount.setText("Difference - "+diff);
                    if(diff>0){
                        modify_msg.setText(String.format("Difference - The User need to pay %.0f Rs Extra",diff));
                    }
                    else if(diff<0){
                            modify_msg.setText(String.format("Difference - You (Franchise) need to pay %.0f Rs",diff));
                    }else{
                        modify_msg.setText("The Difference is 0, no need to pay");
                    }
                }
            }
        });


        final BookingRequest br= APIClientWithNULL.getClient().create(BookingRequest.class);
        bm.setBookingId(booking.getId());
        if(v2!=null){

            bm.setBrand(v2.getBrand());
            bm.setModel(v2.getVehicleModel());
            bm.setSelectedBike(v2.get_id());
        }
        double diff=(getStringToDouble(total_new__rent_bike.getText().toString())-getStringToDouble(total_rent_bike.getText().toString()));

        boolean isHelmetProvide = false;
        if (helmentProvidedCheckBox.isChecked()) {
            isHelmetProvide = true;
        }
        bm.setIsHelmateProvided(isHelmetProvide);
        bm.setIsModifiedBikes(true);
        String startKm = start.getText().toString();
        bm.setStartKm(Double.parseDouble(startKm));
        StoreDetail sdd = new StoreDetail();
        final StoreDetail sddd = SharedPrefUtils.returnObject(LoginToken.OWNER_INFO, sdd, mContext);
        try {
            if (!sddd.getGstNumber().equals("") && sddd.getGstNumber() != null) {
                bm.setModifiedBikeCGST(0.06);
                bm.setModifiedBikeSGST(0.06);                                                        }
            else {
                bm.setModifiedBikeCGST(0.0);
                bm.setModifiedBikeSGST(0.0);
            }
        } catch (Exception e) {
            bm.setModifiedBikeCGST(0.0);
            bm.setModifiedBikeSGST(0.0);
        }
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder
                .setCancelable(false).setPositiveButton("Modify", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Call<Void> modifyCheckIn=br.modifyBike(bm);
                modifyCheckIn.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
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
                        } else {
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        //Toast.makeText(mContext,"Something went wrong"+t.toString(),Toast.LENGTH_LONG).show();
                        ProgressbarUtil.hideProgressBar();
                    }
                });
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              dialog.cancel();
            }
        });
        AlertDialog dialog2 = alertDialogBuilder.create();
        dialog2.show();

/*
        */
    }


    public static Double getStringToDouble(String s){
        try{
            return Double.parseDouble(s);
        }catch (Exception e){
            return 0.0;
        }
    }
}

package com.boongg.store.Utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Booking;
import com.boongg.store.Models.Requests.ModifyRequest;
import com.boongg.store.Models.Responses.Drop.DropBooking;
import com.boongg.store.Models.Responses.Owners.Owner;
import com.boongg.store.Models.Responses.VehicleList.VehicleList;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.Networking.RentCalculationAPI;
import com.boongg.store.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class ModifyAlertBox {
    static final int[] selectedPosition = {0};
    public static List<VehicleList> vehicleLists=new ArrayList<>();
    public static void modifyVehicle(final Context context, final DropBooking booking){
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.alert_modify_vehicle, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        final Spinner spinner = (Spinner) promptsView.findViewById(R.id.modify_vehicle);
        final TextView modfiyButton=(TextView)promptsView.findViewById(R.id.modify_vehicle_button);
        modfiyButton.setVisibility(View.GONE);
        final OwnerInventory inventory= APIClient.getClient().create(OwnerInventory.class);
        alertDialogBuilder.setView(promptsView);


        Call<List<VehicleList>>  call1 = inventory.getVehicleList(LoginToken.id);
        call1.enqueue(new Callback<List<VehicleList>>() {
            @Override
            public void onResponse(Call<List<VehicleList>> call, Response<List<VehicleList>> response) {
                Toast.makeText(context,"Success",Toast.LENGTH_LONG).show();

               vehicleLists=response.body();
                final List<String> vehicelDisplay=new ArrayList<>();
                for(VehicleList v : response.body()){
                    vehicelDisplay.add(v.getBrand()+" "+v.getVehicleModel()+" "+v.getRegistrationNumber());
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, vehicelDisplay);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        selectedPosition[0]=position;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                modfiyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

            @Override
            public void onFailure(Call<List<VehicleList>> call, Throwable t) {
                Toast.makeText(context,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Modify Vehicle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {
                        int p=selectedPosition[0];
                        ModifyRequest request=new ModifyRequest();
                        request.setBookingId(booking.get_id());
                        request.setBrand(vehicleLists.get(p).getBrand());
                        request.setModel(vehicleLists.get(p).getVehicleModel());
                        request.setPreviousBikePoolKey(booking.get_id());
                        request.setNewBikePoolKey(vehicleLists.get(p).get_id());
                        Call<Void> call3=inventory.modifyVehicle(request);
                        call3.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {

                                dialog.dismiss();
                                AlertBoxUtils.showAlert(context,"success","Modify Vehicle","Success");
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                dialog.dismiss();
                                AlertBoxUtils.showAlert(context,"error","Modify Vehicle","Failed");


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
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}



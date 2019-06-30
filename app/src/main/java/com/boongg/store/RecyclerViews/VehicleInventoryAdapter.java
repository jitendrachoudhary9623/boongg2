package com.boongg.store.RecyclerViews;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Interfaces.OnImageClickListener;
import com.boongg.store.MainActivity;
import com.boongg.store.Models.Requests.BikeMaintaince;
import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Models.Responses.NearbyVehicles.Result;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.R;
import com.boongg.store.Utilities.AlertBoxUtils;
import com.boongg.store.Utilities.DateUtils;
import com.boongg.store.Utilities.JWTUtils;
import com.boongg.store.Utilities.LoginToken;
import com.boongg.store.Utilities.ProgressbarUtil;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleInventoryAdapter  extends RecyclerView.Adapter<VehicleInventoryAdapter.VehicleViewHolder> {


    private static final int PICKFILE_RESULT_CODE = 96 ;
    List<VehicleInventoryResponse> vehicleList;
    Context mContext;
    public VehicleInventoryAdapter() {
    }

    public VehicleInventoryAdapter(List<VehicleInventoryResponse> vehicleList, Context context ) {
        this.vehicleList = vehicleList;
        mContext = context;
    }
    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_available_bikes, viewGroup, false);
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

        TextView vehicleName,status,regno;
        LinearLayout maintain,upload;
        LinearLayout vll;
        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicleName=(TextView)itemView.findViewById(R.id.all_inventory_vehicle_name);
            status=(TextView)itemView.findViewById(R.id.all_inventory_status);
            regno=(TextView)itemView.findViewById(R.id.all_inventory_registration_no);
            maintain=(LinearLayout)itemView.findViewById(R.id.all_bike_maintain);
            upload=(LinearLayout)itemView.findViewById(R.id.available_upload_file);
          }
        public void bindData(final int position) {
        final VehicleInventoryResponse vehicle=vehicleList.get(position);

        vehicleName.setText(vehicle.getBrand()+" "+vehicle.getVehicleModel());
        status.setText(vehicle.getStatusType().getType());

        int sbg=mContext.getResources().getColor(R.color.green_pay);
        switch (vehicle.getStatusType().getType()){
            case "AVAILABLE":
                sbg=mContext.getResources().getColor(R.color.green_pay);
                break;
            case "MAINTAINANCE":
                sbg=mContext.getResources().getColor(R.color.deep_pink);
                break;
            default:
                sbg=mContext.getResources().getColor(R.color.colorPrimary);
        }
        status.setBackgroundColor(sbg);
        regno.setText("Registration No : "+vehicle.getRegistrationNumber());
        maintain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  ProgressbarUtil.showProgressbar(mContext);
                BikeMaintaince bikeMaintaince=new BikeMaintaince();
                bikeMaintaince.setBrand(vehicle.getBrand());
                bikeMaintaince.setReason("MAINTENANCE");

                try {
                    JSONObject obj=JWTUtils.getUserLoginDetailsFromJWT(LoginToken.tokenId);
                    bikeMaintaince.setStore(obj.getString("_store"));
                    bikeMaintaince.setStartDate(DateUtils.getTodaysDate());
                    bikeMaintaince.setEndDate(DateUtils.getDateAfterBeforeTime(1));
                    bikeMaintaince.setRentPool(vehicle.get_id());
                    bikeMaintaince.setModel(vehicle.getVehicleModel());

                    OwnerInventory oi= APIClient.getClient().create(OwnerInventory.class);
                    Call<Void> call=oi.maintainance(bikeMaintaince);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if(response.isSuccessful()) {
                                AlertBoxUtils.showAlert(mContext, "success", "Maintainance", "Bike Added to Maintainance");
                            status.setBackgroundColor(mContext.getResources().getColor(R.color.deep_pink));
                            }
                            }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            AlertBoxUtils.showAlert(mContext,"error","Maintainance","Something went wrong");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater li = LayoutInflater.from(mContext);

                View promptsView = li.inflate(R.layout.alert_doc_upload, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        mContext,R.style.CustomAlertDialog);
                TextView rc=(TextView)promptsView.findViewById(R.id.rc_file_chooser);

                fileChooser(rc);
                alertDialogBuilder.setView(promptsView);
                alertDialogBuilder
                        .setCancelable(false).setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();

                            }
                        });
                AlertDialog dialog=alertDialogBuilder.create();
                dialog.show();
            }
        });


        }
        String displayName = "Invalid file";

        private void fileChooser(final TextView rc) {
            rc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                    chooseFile.setType("*/*");
                    chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                    ((Activity) mContext).startActivityForResult(chooseFile, PICKFILE_RESULT_CODE);
                    rc.setText(displayName);
                }
            });

        }

        public void onActivityResult(int requestCode, int resultCode,
                                     Intent returnIntent) {
            if (resultCode == PICKFILE_RESULT_CODE) {
                // Get the Uri of the selected file
                Uri uri = returnIntent.getData();
                String uriString = uri.toString();
                File myFile = new File(uriString);
                String path = myFile.getAbsolutePath();

                if (uriString.startsWith("content://")) {
                    Cursor cursor = null;
                    try {
                        cursor = ((Activity)mContext).getContentResolver().query(uri, null, null, null, null);
                        if (cursor != null && cursor.moveToFirst()) {
                            displayName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                        }
                    } finally {
                        cursor.close();
                    }
                } else if (uriString.startsWith("file://")) {
                    displayName = myFile.getName();
                }else{
                    displayName="Click Again";
                }


            }
        }
    }



}

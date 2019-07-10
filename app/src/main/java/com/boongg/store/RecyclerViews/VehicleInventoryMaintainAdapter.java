package com.boongg.store.RecyclerViews;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.boongg.store.Models.BrandList;
import com.boongg.store.Models.Requests.BikeDetails.Bike;
import com.boongg.store.Models.Requests.BikeMaintaince;
import com.boongg.store.Models.Requests.MaintainanceBikes.MaintenanceBike;
import com.boongg.store.Models.Requests.UpdateBike.StatusType;
import com.boongg.store.Models.Requests.UpdateBike.UpdateB;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.Networking.RestApiURL;
import com.boongg.store.Networking.VehicleRequest;
import com.boongg.store.R;
import com.boongg.store.UploadDocuments;
import com.boongg.store.Utilities.AlertBoxUtils;
import com.boongg.store.Utilities.DateUtils;
import com.boongg.store.Utilities.JWTUtils;
import com.boongg.store.Utilities.LoginToken;
import com.boongg.store.Utilities.ProgressbarUtil;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleInventoryMaintainAdapter extends RecyclerView.Adapter<VehicleInventoryMaintainAdapter.VehicleViewHolder> {


    private static final int PICKFILE_RESULT_CODE = 96 ;
    List<MaintenanceBike> vehicleList;
    Context mContext;
    FragmentActivity activity;
    boolean showOptions=false;
    public VehicleInventoryMaintainAdapter(List<MaintenanceBike> vehicleList, Context context, FragmentActivity activity) {
        this.vehicleList = vehicleList;
        mContext = context;
        this.activity=activity;
    }

    public VehicleInventoryMaintainAdapter(List<MaintenanceBike> vehicleList, Context context ) {
        this.vehicleList = vehicleList;
        mContext = context;
    }
    public VehicleInventoryMaintainAdapter(List<MaintenanceBike> vehicleList, Context context, boolean showOptions ) {
        this.vehicleList = vehicleList;
        mContext = context;
        this.showOptions=showOptions;
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
        Bike bike=null;

        TextView vehicleName,status,regno;
        LinearLayout maintain,upload,delete,edit;
        LinearLayout vll;
        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicleName=(TextView)itemView.findViewById(R.id.all_inventory_vehicle_name);
            status=(TextView)itemView.findViewById(R.id.all_inventory_status);
            regno=(TextView)itemView.findViewById(R.id.all_inventory_registration_no);
            maintain=(LinearLayout)itemView.findViewById(R.id.all_bike_maintain);
            upload=(LinearLayout)itemView.findViewById(R.id.available_upload_file);
            delete=(LinearLayout)itemView.findViewById(R.id.available_vehicle_delete);
            edit=(LinearLayout)itemView.findViewById(R.id.all_bike_edit);
            vll=(LinearLayout)itemView.findViewById(R.id.drop_show);
          }
        String year_s,model_s,brand_s;

        public void bindData(final int position) {
            final MaintenanceBike vehicle = vehicleList.get(position);
            if(showOptions){
                vll.setVisibility(View.GONE);
            }
            vehicleName.setText(vehicle.getBrand() + " " + vehicle.getModel());
            status.setText("IN-MAINTAINANCE");
            status.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("Remove from Maintainance");
                    builder.setMessage("Are you sure you want to remove "+vehicle.getBrand()+" "+vehicle.getModel()+"from maintainance ?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            OwnerInventory ownerInventory=APIClient.getClient().create(OwnerInventory.class);
                            Call<Void> call=ownerInventory.unblock(vehicle.get_id());
                            call.enqueue(new Callback<Void>()
                            {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response)
                                {
                                    vehicleList.remove(vehicle);
                                    notifyItemChanged(position);
                                    AlertBoxUtils.showAlert(mContext,"success","Bike Status","Available");
                                }
                                @Override
                                public void onFailure(Call<Void> call, Throwable t)
                                {
                                }
                            });
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    builder.show();

                }
            });
            int sbg = mContext.getResources().getColor(R.color.green_pay);
            switch (vehicle.getStatus()) {
                case "AVAILABLE":
                    sbg = mContext.getResources().getColor(R.color.green_pay);
                    break;
                case "MAINTAINANCE":
                    sbg = mContext.getResources().getColor(R.color.deep_pink);
                    break;
                default:
                    sbg = mContext.getResources().getColor(R.color.blue);
            }

            status.setBackgroundColor(sbg);
            try {
                regno.setText("Registration No : " + vehicle.get_rentPoolKey().getRegistrationNumber());
            }catch(Exception e){

            }


        }


    }



}

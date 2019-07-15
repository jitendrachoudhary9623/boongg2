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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.boongg.store.Models.BrandList;
import com.boongg.store.Models.Requests.AvailableBikes.AvailableBike;
import com.boongg.store.Models.Requests.BikeDetails.Bike;
import com.boongg.store.Models.Requests.BikeMaintaince;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleInventoryAdapter  extends RecyclerView.Adapter<VehicleInventoryAdapter.VehicleViewHolder> {


    private static final int PICKFILE_RESULT_CODE = 96 ;
    List<AvailableBike> vehicleList;
    Context mContext;
    FragmentActivity activity;
    boolean showOptions=false;
    public VehicleInventoryAdapter(List<AvailableBike> vehicleList, Context context, FragmentActivity activity) {
        this.vehicleList = vehicleList;
        mContext = context;
        this.activity=activity;
    }

    public VehicleInventoryAdapter(List<AvailableBike> vehicleList, Context context ) {
        this.vehicleList = vehicleList;
        mContext = context;
    }
    public VehicleInventoryAdapter(List<AvailableBike> vehicleList, Context context,boolean showOptions ) {
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
        ImageView rci,puci,insurancei;
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

            rci=(ImageView)itemView.findViewById(R.id.all_inventory_rc);
            puci=(ImageView)itemView.findViewById(R.id.all_inventory_puc);
            insurancei=(ImageView)itemView.findViewById(R.id.all_inventory_insuarance);



        }
        String year_s,model_s,brand_s;

        public void bindData(final int position) {
            try {
                final AvailableBike vehicle = vehicleList.get(position);

                vehicleName.setText(vehicle.getBrand() + " " + vehicle.getVehicleModel());
                status.setText(vehicle.getStatusType().getType());
                try {
                    if (!vehicle.getRcFiles().get(0).getFullUrl().equals("")) {
                        rci.setImageDrawable(mContext.getDrawable(R.drawable.check));
                    }
                }catch (Exception e){
                    rci.setImageDrawable(mContext.getDrawable(R.drawable.cancel_2));
                }
                try {
                    if (!vehicle.getPucFiles().get(0).getFullUrl().equals("")) {
                        String expiryDate=vehicle.getPucFiles().get(0).getExpiryDate().substring(0,10);
                        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                        Date pd=format.parse(expiryDate);
                        Date d=new Date();
                        if(pd.equals(d)||pd.after(d)){
                            puci.setImageDrawable(mContext.getDrawable(R.drawable.check));
                        }
                        else{
                            puci.setImageDrawable(mContext.getDrawable(R.drawable.warning));
                        }

                    }
                }catch (Exception e){
                    puci.setImageDrawable(mContext.getDrawable(R.drawable.cancel_2));
                }
                try {
                    if (!vehicle.getLicenceFiles().get(0).getFullUrl().equals("")) {
                        String expiryDate=vehicle.getLicenceFiles().get(0).getExpiryDate().substring(0,10);
                        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                        Date pd=format.parse(expiryDate);
                        Date d=new Date();
                        if(pd.equals(d)||pd.after(d)){
                            insurancei.setImageDrawable(mContext.getDrawable(R.drawable.check));
                        }
                        else {
                            insurancei.setImageDrawable(mContext.getDrawable(R.drawable.warning));
                        }
                    }
                }catch (Exception e){
                    insurancei.setImageDrawable(mContext.getDrawable(R.drawable.cancel_2));

                }
                int sbg = mContext.getResources().getColor(R.color.green_pay);
                switch (vehicle.getStatusType().getType()) {
                    case "AVAILABLE":
                        sbg = mContext.getResources().getColor(R.color.green_pay);
                        break;
                    case "MAINTAINANCE":
                        sbg = mContext.getResources().getColor(R.color.deep_pink);
                        break;
                    default:
                        sbg = mContext.getResources().getColor(R.color.blue);
                }
                if (showOptions) {
                    vll.setVisibility(View.GONE);
                    status.setText("ON-BOOKING");
                    sbg = mContext.getResources().getColor(R.color.red);
                }
                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LayoutInflater li = LayoutInflater.from(mContext);

                        final View rootView = li.inflate(R.layout.alert_edit_booking, null);
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                mContext, R.style.CustomAlertDialog);
                        final EditText owner_name_s, owner_contact, owner_email, kmTravelled, registration_id, engine_id, chassis_id, engine_capacity, color, purchaseCost, selllCost;
                        int current = 0;
                        final Spinner year = (Spinner) rootView.findViewById(R.id.add_bike_model_year);
                        final Spinner model = (Spinner) rootView.findViewById(R.id.add_bike_model);
                        final Spinner brand = (Spinner) rootView.findViewById(R.id.add_bike_brand);
                        owner_name_s = (EditText) rootView.findViewById(R.id.add_bike_owner_name);
                        owner_contact = (EditText) rootView.findViewById(R.id.add_bike_owner_contact);
                        owner_email = (EditText) rootView.findViewById(R.id.add_bike_owner_email);

                        color = (EditText) rootView.findViewById(R.id.add_bike_color);
                        kmTravelled = (EditText) rootView.findViewById(R.id.add_bike_km_travelled);
                        registration_id = (EditText) rootView.findViewById(R.id.add_bike_registration);
                        chassis_id = (EditText) rootView.findViewById(R.id.add_bike_chassis_number);
                        engine_id = (EditText) rootView.findViewById(R.id.add_bike_engine_number);
                        engine_capacity = (EditText) rootView.findViewById(R.id.add_bike_engine_capacity);
                        purchaseCost = (EditText) rootView.findViewById(R.id.add_bike_purchase_cost);
                        selllCost = (EditText) rootView.findViewById(R.id.add_bike_sell_cost);
                        TextView updateBike = (TextView) rootView.findViewById(R.id.add_bike_button_2);
                        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
                        current = calendar.get(Calendar.YEAR);
                        List<Integer> yearas = new ArrayList<>();
                        for (int i = current; i >= 2000; i--) {
                            yearas.add(i);
                        }
                        final BookingRequest bookingRequest = APIClient.getClient().create(BookingRequest.class);
                        updateBike.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                UpdateB b = new UpdateB();
                                b.setVehicleModel(model_s);
                                b.setBrand(brand_s);
                                b.setYear(year_s);
                                b.setColor(color.getText().toString());

                                b.setEngineCapacity(Integer.parseInt(engine_capacity.getText().toString()));
                                b.setEngineNumber(engine_id.getText().toString());
                                b.setChassisNumber(chassis_id.getText().toString());
                                b.setRegistrationNumber(registration_id.getText().toString());

                                b.setName(owner_name_s.getText().toString());
                                b.setContact(owner_contact.getText().toString());
                                b.setEmail(owner_email.getText().toString());

                                b.setPurchaseCost(Integer.parseInt(purchaseCost.getText().toString()));
                                b.setSellCost(Integer.parseInt(selllCost.getText().toString()));
                                b.setKmTravel(Integer.parseInt(kmTravelled.getText().toString()));

                                b.setId(bike.getId());
                                StatusType s = new StatusType();
                                s.setType(bike.getStatusType().getType());
                                b.setStatusType(s);
                                b.setUserId(vehicle.getId());
                                b.setStore(bike.get_storeKey());
                                Call<UpdateB> updateBCall = bookingRequest.updateBike(b);
                                updateBCall.enqueue(new Callback<UpdateB>() {
                                    @Override
                                    public void onResponse(Call<UpdateB> call, Response<UpdateB> response) {
                                        if (response.isSuccessful()) {
                                            AlertBoxUtils.showAlert(mContext, "success", "Update Bike", "Successfull");
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<UpdateB> call, Throwable t) {

                                    }
                                });
                            }
                        });
                        ArrayAdapter<Integer> yearAdapter = new ArrayAdapter<Integer>(mContext, android.R.layout.simple_spinner_item, yearas);
                        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        year.setAdapter(yearAdapter);
                        final List<String> bikeModel = new ArrayList<>();
                        final List<String> bikeBrand = new ArrayList<>();

                        OwnerInventory inventory = APIClient.getClient().create(OwnerInventory.class);
                        Call<List<BrandList>> c = inventory.getBikeList();
                        bikeBrand.add("Select Vehicle");
                        c.enqueue(new Callback<List<BrandList>>() {
                            @Override
                            public void onResponse(Call<List<BrandList>> call, final Response<List<BrandList>> response) {
                                for (BrandList b : response.body()) {
                                    bikeModel.add(b.getBrandName());
                                }
                                try {
                                    ArrayAdapter<String> modelAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, bikeModel);
                                    modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                    model.setAdapter(modelAdapter);
                                    ProgressbarUtil.hideProgressBar();
                                    model.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            BrandList b = response.body().get(position);
                                            model_s = b.getBrandName();
                                            ArrayAdapter<String> brandAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, b.getModels());
                                            brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                            brand.setAdapter(brandAdapter);
                                            brand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    brand_s = brand.getSelectedItem().toString();
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });
                                } catch (Exception e) {

                                }
                            }

                            @Override
                            public void onFailure(Call<List<BrandList>> call, Throwable t) {

                            }
                        });
                        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                year_s = year.getSelectedItem().toString();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                        Call<Bike> bikeCall = bookingRequest.getBike(vehicle.getId());
                        bikeCall.enqueue(new Callback<Bike>() {
                            @Override
                            public void onResponse(Call<Bike> call, Response<Bike> response) {
                                try {
                                    bike = response.body();
                                    owner_name_s.setText(bike.getOwner().get(0).getName());
                                    owner_contact.setText(bike.getOwner().get(0).getContact());
                                    owner_email.setText(bike.getOwner().get(0).getEmail());

                                    color.setText(bike.getColor());
                                    kmTravelled.setText("" + bike.getKmTravel());
                                    registration_id.setText("" + bike.getRegistrationNumber());
                                    chassis_id.setText("" + bike.getChassisNumber());
                                    ;
                                    engine_id.setText("" + bike.getEngineNumber());
                                    engine_capacity.setText("" + bike.getEngineCapacity());
                                    purchaseCost.setText("" + bike.getPurchaseCost());
                                    selllCost.setText("" + bike.getSellCost());
                                } catch (Exception e) {

                                }
                            }

                            @Override
                            public void onFailure(Call<Bike> call, Throwable t) {

                            }
                        });

                        alertDialogBuilder.setView(rootView);
                        alertDialogBuilder
                                .setCancelable(false)
                              .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                });
                        AlertDialog dialog = alertDialogBuilder.create();
                        dialog.show();
                    }
                });
                status.setBackgroundColor(sbg);
                try {
                    regno.setText("Registration No : " + vehicle.getRegistrationNumber());
                } catch (Exception e) {

                }
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        VehicleRequest deleteRequest = APIClient.getClient().create(VehicleRequest.class);
                        Call<Void> call = deleteRequest.deleteVehicle(vehicle.get_id());
                        call.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if (response.isSuccessful()) {
                                    AlertBoxUtils.showAlert(mContext, "success", "Bike Delete", "Deleted");

                                    vehicleList.remove(vehicle);
                                    notifyDataSetChanged();
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                AlertBoxUtils.showAlert(mContext, "error", "Bike Delete", "Failed, Try After Some time later");
                            }
                        });
                    }
                });
                maintain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setTitle("Add Bike To Maintainance");
                        builder.setMessage("You want to add bike to maintainance?");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //  ProgressbarUtil.showProgressbar(mContext);
                                BikeMaintaince bikeMaintaince = new BikeMaintaince();
                                bikeMaintaince.setBrand(vehicle.getBrand());
                                bikeMaintaince.setReason("MAINTENANCE");

                                try {
                                    JSONObject obj = JWTUtils.getUserLoginDetailsFromJWT(LoginToken.tokenId);
                                    bikeMaintaince.setStore(obj.getString("_store"));
                                    bikeMaintaince.setStartDate(DateUtils.getTodaysDate());
                                    bikeMaintaince.setEndDate(DateUtils.getDateAfterBeforeTime(1));
                                    bikeMaintaince.setRentPool(vehicle.get_id());
                                    bikeMaintaince.setModel(vehicle.getVehicleModel());

                                    OwnerInventory oi = APIClient.getClient().create(OwnerInventory.class);
                                    Call<Void> call = oi.maintainance(bikeMaintaince);
                                    call.enqueue(new Callback<Void>() {
                                        @Override
                                        public void onResponse(Call<Void> call, Response<Void> response) {
                                            if (response.isSuccessful()) {
                                                AlertBoxUtils.showAlert(mContext, "success", "Maintainance", "Bike Added to Maintainance");
                                                status.setBackgroundColor(mContext.getResources().getColor(R.color.deep_pink));
                                                vehicleList.remove(vehicle);
                                                notifyDataSetChanged();
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<Void> call, Throwable t) {
                                            AlertBoxUtils.showAlert(mContext, "error", "Maintainance", "Something went wrong");
                                        }
                                    });

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
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
                upload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, UploadDocuments.class);
                        intent.putExtra("ID", vehicle.get_id());
                        try {
                            intent.putExtra("RC", RestApiURL.API_BASE_URL + "api/rentpooldocument/" + vehicle.getRcFiles().get(0).getFullUrl());
                            intent.putExtra("PUC", RestApiURL.API_BASE_URL + "api/rentpooldocument/" + vehicle.getPucFiles().get(0).getFullUrl());
                            intent.putExtra("INSURANCE", RestApiURL.API_BASE_URL + "api/rentpooldocument/" + vehicle.getLicenceFiles().get(0).getFullUrl());

                        } catch (Exception e) {
                            intent.putExtra("RC", "");
                            intent.putExtra("PUC", "");
                            intent.putExtra("INSURANCE", "");

                        }
                        ((Activity) mContext).startActivity(intent);
                    }
                });

            }catch (Exception e){

            }
        }


    }



}

package com.boongg.store.Fragments.VehicleInventoryFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.boongg.store.Models.BrandList;
import com.boongg.store.Models.Requests.CreateBike;
import com.boongg.store.Models.Requests.StatusType;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.R;
import com.boongg.store.Utilities.JWTUtils;
import com.boongg.store.Utilities.LoginToken;
import com.boongg.store.Utilities.ProgressbarUtil;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddBike extends Fragment {


    TextView prev,next,addBike;
    EditText owner_name_s,owner_contact,owner_email,kmTravelled,registration_id,engine_id,chassis_id,engine_capacity,color,purchaseCost,selllCost;
    CardView s1,s2,s3,s4;
    List<CardView>cardViews;
    int current=0;
    ProgressBar pb;
    String year_s,model_s,brand_s;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_add_bike, container, false);
        pb = (ProgressBar) rootView.findViewById(R.id.pb);
        final int[] progressStatus = {0};

        final Spinner year=(Spinner)rootView.findViewById(R.id.add_bike_model_year);
        final Spinner model=(Spinner)rootView.findViewById(R.id.add_bike_model);
        final Spinner brand=(Spinner)rootView.findViewById(R.id.add_bike_brand);
        s1=(CardView)rootView.findViewById(R.id.screen1);
        s2=(CardView)rootView.findViewById(R.id.screen2);
        s3=(CardView)rootView.findViewById(R.id.screen3);
        s4=(CardView)rootView.findViewById(R.id.screen4);
        addBike=(TextView)rootView.findViewById(R.id.add_bike_button_2);

        owner_name_s=(EditText) rootView.findViewById(R.id.add_bike_owner_name);
        owner_contact=(EditText) rootView.findViewById(R.id.add_bike_owner_contact);
        owner_email=(EditText) rootView.findViewById(R.id.add_bike_owner_email);

        color=(EditText)rootView.findViewById(R.id.add_bike_color);
        kmTravelled=(EditText)rootView.findViewById(R.id.add_bike_km_travelled);
        registration_id=(EditText)rootView.findViewById(R.id.add_bike_registration);
        chassis_id=(EditText)rootView.findViewById(R.id.add_bike_chassis_number);
        engine_id=(EditText)rootView.findViewById(R.id.add_bike_engine_number);
        engine_capacity=(EditText)rootView.findViewById(R.id.add_bike_engine_capacity);
        purchaseCost=(EditText)rootView.findViewById(R.id.add_bike_purchase_cost);
        selllCost=(EditText)rootView.findViewById(R.id.add_bike_sell_cost);
        prev=(TextView)rootView.findViewById(R.id.add_bike_previous);
        next=(TextView)rootView.findViewById(R.id.add_bike_next);
        addBike.setVisibility(View.GONE);
        prev.setVisibility(View.GONE);
        cardViews=new ArrayList<>();
        cardViews.add(s1);
        cardViews.add(s2);
        cardViews.add(s3);
        cardViews.add(s4);
        addBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    createBiike(year_s, model_s, brand_s, getViewText(owner_name_s), getViewText(owner_contact), getViewText(owner_email),
                            getViewText(color), getViewText(kmTravelled), getViewText(registration_id),
                            getViewText(chassis_id), getViewText(engine_id), getViewText(engine_capacity),
                            getViewText(purchaseCost), getViewText(selllCost)
                    );
                }catch (Exception e){

                }
            }
        });


        makeVisibleForm(s1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeForm("next",pb, progressStatus[0]);
                progressStatus[0] = progressStatus[0] +25;
                pb.setProgress(progressStatus[0]);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeForm("prev",pb, progressStatus[0]);
                progressStatus[0]=progressStatus[0]-25;
                pb.setProgress(progressStatus[0]);
            }
        });


        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int current=calendar.get(Calendar.YEAR);
        List<Integer> yearas=new ArrayList<>();
        for(int i=current;i>=2000;i--){
            yearas.add(i);
        }
        ArrayAdapter<Integer> yearAdapter = new ArrayAdapter<Integer>(getContext(), android.R.layout.simple_spinner_item, yearas);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year.setAdapter(yearAdapter);
        final List<String> bikeModel=new ArrayList<>();
        final List<String> bikeBrand=new ArrayList<>();

        OwnerInventory inventory= APIClient.getClient().create(OwnerInventory.class);
        Call<List<BrandList>> c=inventory.getBikeList();
        bikeBrand.add("Select Vehicle");

        ProgressbarUtil.showProgressbar(getContext());
        c.enqueue(new Callback<List<BrandList>>() {
            @Override
            public void onResponse(Call<List<BrandList>> call, final Response<List<BrandList>> response) {
                for(BrandList b:response.body()){
                    bikeModel.add(b.getBrandName());
                }
                try {
                    ArrayAdapter<String> modelAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, bikeModel);
                    modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(modelAdapter);
                    ProgressbarUtil.hideProgressBar();
                    model.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            BrandList b = response.body().get(position);
                            brand_s = b.getBrandName();
                            ArrayAdapter<String> brandAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, b.getModels());
                            brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            brand.setAdapter(brandAdapter);
                            brand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    model_s = brand.getSelectedItem().toString();
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
                }catch(Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<BrandList>> call, Throwable t) {

            }
        });
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year_s=year.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootView;
    }



    private void createBiike(String year_s, String model_s, String brand_s, String owner_name_s,
                             String owner_contact, String owner_email,String color, String kmTravelled,
                             String registration_id, String chassis_id, String engine_id, String engine_capacity,
                             String purchaseCost, String selllCost) {
        try {
            CreateBike bike = new CreateBike();
            bike.setName(owner_name_s);
            bike.setContact(owner_contact);
            bike.setEmail(owner_email);
            bike.setColor(color);
            bike.setChassisNumber(chassis_id);
            bike.setEngineNumber(engine_id);
            bike.setEngineCapacity(Integer.parseInt(engine_capacity));
            bike.setSellCost(Integer.parseInt(selllCost));
            bike.setPurchaseCost(Integer.parseInt(purchaseCost));
            bike.setRegistrationNumber(registration_id);
            bike.setKmTravel(Integer.parseInt(kmTravelled));
            StatusType t = new StatusType();
            t.setType("AVAILABLE");
            bike.setStatusType(t);
            bike.setBrand(brand_s);
            bike.setVehicleModel(model_s);
            bike.setYear(year_s);
            bike.setStore(LoginToken.id);

            try{
                JSONObject json= JWTUtils.getUserLoginDetailsFromJWT(LoginToken.tokenId);
                bike.setUserId(json.getString("_id"));
            }catch(Exception e){
            }
              //getUserId from token
            OwnerInventory inv = APIClient.getClient().create(OwnerInventory.class);
            Call<Void> call2 = inv.creakeBike(bike);
            call2.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {


                    new SweetAlertDialog(getContext(), SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Success")
                            .setContentText("Bike Added! Please check in the tab")
                            .show();
                    pb.setProgress(100);

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    new SweetAlertDialog(getContext(), SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Bike Adding Failed")
                            .setContentText("Due to technical faults bike adding failed")
                            .show();
                    pb.setProgress(0);
                }
            });
        }catch(Exception e){
            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Something went wrong")
                    .setContentText("Ensure you have filled all the fields properly")
                    .show();
        }
        }

    private String getViewText(EditText view) {
        return view.getText().toString();
    }

    private void changeForm(String actions,ProgressBar pb, int progressStatus) {

        if(actions.equals("next")){
            current++;

        }else if (actions.equals("prev")){
            current--;
            progressStatus=progressStatus-25;
            pb.setProgress(progressStatus);
        }
        if(current<0){
            current=0;

        }else if(current>cardViews.size()-1){
            current=cardViews.size()-1;

        }
        if(current==0){
            prev.setVisibility(View.INVISIBLE);
            next.setVisibility(View.VISIBLE);
            addBike.setVisibility(View.GONE);

        }
        else if(current==cardViews.size()-1){
            next.setVisibility(View.INVISIBLE);
            prev.setVisibility(View.VISIBLE);
            addBike.setVisibility(View.VISIBLE);

        }
        else{
            next.setVisibility(View.VISIBLE);
            prev.setVisibility(View.VISIBLE);
            addBike.setVisibility(View.GONE);

        }
        makeVisibleForm(cardViews.get(current));
    }

    private void makeVisibleForm(CardView s) {
        for(CardView c:cardViews){
            if(s.equals(c)){
                c.setVisibility(View.VISIBLE);
            }
            else{
                c.setVisibility(View.GONE);
            }
        }
    }
}

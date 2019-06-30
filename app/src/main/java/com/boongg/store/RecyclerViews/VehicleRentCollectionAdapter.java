package com.boongg.store.RecyclerViews;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Models.Requests.CheckIn;
import com.boongg.store.Models.Requests.UpdateBikePrice;
import com.boongg.store.Models.Responses.Owners.BikePriceChart;

import com.boongg.store.Models.Responses.Owners.Location2;
import com.boongg.store.Models.Responses.Owners.Owner;
import com.boongg.store.Models.Responses.Owners.PriceChart;
import com.boongg.store.Models.Responses.RentBikeResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.CheckInRequest;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.R;
import com.boongg.store.Utilities.AlertBoxUtils;
import com.boongg.store.Utilities.JWTUtils;
import com.boongg.store.Utilities.LoginToken;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleRentCollectionAdapter extends RecyclerView.Adapter<VehicleRentCollectionAdapter.VehicleRentCollectionViewHolder> {



    List<RentBikeResponse> vehicleList;
    Context mContext;
    public VehicleRentCollectionAdapter() {
    }

    @NonNull
    @Override
    public VehicleRentCollectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_vehicle_rent_list, viewGroup, false);
        VehicleRentCollectionViewHolder mv = new VehicleRentCollectionViewHolder(itemView);
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleRentCollectionViewHolder holder, int position) {
        holder.bindData(position);

    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

    public VehicleRentCollectionAdapter(List<RentBikeResponse> vehicleList, Context context) {
        this.vehicleList = vehicleList;
        mContext = context;

    }


    public class VehicleRentCollectionViewHolder extends RecyclerView.ViewHolder{

        TextView bikename,status,engine,quantity,prichart;
        public VehicleRentCollectionViewHolder(@NonNull View itemView) {
            super(itemView);
            bikename=(TextView)itemView.findViewById(R.id.rent_inventory_all_bike_name);
            status=(TextView)itemView.findViewById(R.id.rent_inventory_all_status);
            engine=(TextView)itemView.findViewById(R.id.rent_inventory_all_engine);
            quantity=(TextView)itemView.findViewById(R.id.rent_inventory_all_qty);
            prichart=(TextView)itemView.findViewById(R.id.rent_inventory_all_button);
        }
        public void bindData(final int position) {

                final RentBikeResponse rent = vehicleList.get(position);
            try {
                Toast.makeText(mContext,rent.getPictures().get(0).toString(),Toast.LENGTH_LONG).show();
                bikename.setText(rent.getBrand() + "  " + rent.getModel());
                status.setText(rent.getStatus());

                engine.setText("Engine " + rent.getEngineCapacity() + " CC");
                quantity.setText("Total Qty : " + Math.round(rent.getQuantity()));
            }catch (Exception e){

            }

        prichart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OwnerInventory inventory= APIClient.getClient().create(OwnerInventory.class);
                Call<List<BikePriceChart>> call= inventory.getBikePriceChart(rent.get_id());
                call.enqueue(new Callback<List<BikePriceChart>>() {
                    @Override
                    public void onResponse(Call<List<BikePriceChart>> call, Response<List<BikePriceChart>> response) {
                       List<BikePriceChart> bikeChart=response.body();

                       /*
                        new SweetAlertDialog(mContext)
                                .setTitleText("Price Chart - "+rent.getBrand()+" "+rent.getModel())
                                .setContentText(""+bikeChart.get(0).getLocation2().get(0).getPriceChart())
                                .show();
                        */
                       showPriceChart(bikeChart.get(0),rent);
                    }

                    @Override
                    public void onFailure(Call<List<BikePriceChart>> call, Throwable t) {

                    }
                });

            }
        });

        }
        ArrayList<Integer> myEditTextList = new ArrayList<Integer>();

        private void showPriceChart(final BikePriceChart bikeChart, final RentBikeResponse rent) {
            LayoutInflater li = LayoutInflater.from(mContext);
            final View promptsView = li.inflate(R.layout.alert_price_chart, null);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    mContext);
            final LinearLayout left_bar=(LinearLayout) promptsView.findViewById(R.id.left_bar);
            final LinearLayout right_bar=(LinearLayout) promptsView.findViewById(R.id.right_bar);
            final LinearLayout bottom_bar=(LinearLayout) promptsView.findViewById(R.id.bottom_bar);
//Edit Texts
           final EditText hourly=(EditText)promptsView.findViewById(R.id.price_chart_hourly);
            final EditText day_1=(EditText)promptsView.findViewById(R.id.price_chart_1_day);
            final EditText day_2=(EditText)promptsView.findViewById(R.id.price_chart_2_day);
            final EditText day_3=(EditText)promptsView.findViewById(R.id.price_chart_3_day);
            final EditText day_4=(EditText)promptsView.findViewById(R.id.price_chart_4_day);
            final EditText day_5=(EditText)promptsView.findViewById(R.id.price_chart_5_day);
            final EditText day_6=(EditText)promptsView.findViewById(R.id.price_chart_6_day);
            final EditText day_7=(EditText)promptsView.findViewById(R.id.price_chart_7_day);
            final EditText weekday=(EditText)promptsView.findViewById(R.id.price_chart_weekday);

            final EditText weekwnd=(EditText)promptsView.findViewById(R.id.price_chart_weekend);
            final EditText day_10=(EditText)promptsView.findViewById(R.id.price_chart_10_day);
            final EditText day_15=(EditText)promptsView.findViewById(R.id.price_chart_15_day);
            final EditText day_20=(EditText)promptsView.findViewById(R.id.price_chart_20_day);
            final EditText monthly=(EditText)promptsView.findViewById(R.id.price_chart_monthly);
            final EditText extra_kms=(EditText)promptsView.findViewById(R.id.price_chart_extra_kms);
            final EditText extra_hrs=(EditText)promptsView.findViewById(R.id.price_chart_extra_hrs);
            final EditText km_limit=(EditText)promptsView.findViewById(R.id.price_chart_kms_limit);
             final ArrayList<EditText> editTexts=new ArrayList<>();
            final CheckBox getAdminRents=(CheckBox)promptsView.findViewById(R.id.price_chart_admin_price);

             if(bikeChart.getLocation2().size()>0) {
                     PriceChart priceChart = bikeChart.getLocation2().get(0).getPriceChart();
                     try {
                         getAdminRents.setChecked(priceChart.getIsAdminRentApplied());
                     }catch (Exception e){

                     }
                     hourly.setText("" + priceChart.getHourlyRate());
                     day_1.setText("" + priceChart.getWeekdays());
                     day_2.setText("" + priceChart.getTwoDayRate());
                     day_3.setText("" + priceChart.getThreeDayRate());
                     day_4.setText("" + priceChart.getFourDayRate());
                     day_5.setText("" + priceChart.getFiveDayRate());
                     day_6.setText("" + priceChart.getSixDayRate());
                     day_7.setText("" + priceChart.getSevenDayRate());
                 weekday.setText("" + priceChart.getWeekdays());

                 weekwnd.setText("" + priceChart.getWeekend());
                     day_10.setText("" + priceChart.getTenDayRate());
                     day_15.setText("" + priceChart.getFifteenDays());
                     day_20.setText("" + priceChart.getTwentyDayRate());
                     monthly.setText("" + priceChart.getMonthly());
                     extra_kms.setText("" + priceChart.getExtraKMS());
                     extra_hrs.setText("" + priceChart.getExtraHRS());
                     km_limit.setText("" + priceChart.getKmsLimit());

                 }

            getAdminRents.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){

                        try {
                            PriceChart priceChart = bikeChart.getLocation2().get(0).getPriceChart();
                            hourly.setText("" + priceChart.getHourlyRate());
                            day_1.setText("" + priceChart.getWeekdays());
                            day_2.setText("" + priceChart.getTwoDayRate());
                            day_3.setText("" + priceChart.getThreeDayRate());
                            day_4.setText("" + priceChart.getFourDayRate());
                            day_5.setText("" + priceChart.getFiveDayRate());
                            day_6.setText("" + priceChart.getSixDayRate());
                            day_7.setText("" + priceChart.getSevenDayRate());
                            weekday.setText("" + priceChart.getWeekdays());
                            weekwnd.setText("" + priceChart.getWeekend());
                            day_10.setText("" + priceChart.getTenDayRate());
                            day_15.setText("" + priceChart.getFifteenDays());
                            day_20.setText("" + priceChart.getTwentyDayRate());
                            monthly.setText("" + priceChart.getMonthly());
                            extra_kms.setText("" + priceChart.getExtraKMS());
                            extra_hrs.setText("" + priceChart.getExtraHRS());
                            km_limit.setText("" + priceChart.getKmsLimit());
                        }catch (Exception e){

                        }
                    }

                }
            });
            alertDialogBuilder.setView(promptsView);
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("Update Price",
                            new DialogInterface.OnClickListener() {
                                public void onClick(final DialogInterface dialog, int id) {
                                    OwnerInventory owner=APIClient.getClient().create(OwnerInventory.class);
                                    UpdateBikePrice ubp=new UpdateBikePrice();
                                    try {
                                        JSONObject o= JWTUtils.getUserLoginDetailsFromJWT(LoginToken.tokenId);
                                        String e[]=o.getString("email").split("@");
                                        try {
                                            ubp.setLocation(e[0]);
                                        }catch (Exception e2){
                                            ubp.setLocation("");
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    ubp.setWeekdays(Integer.parseInt(weekday.getText().toString()));
                                    ubp.setWeekend(Integer.parseInt(weekwnd.getText().toString()));
                                    ubp.setHourlyRate(Integer.parseInt(day_1.getText().toString()));
                                    ubp.setTwoDayRate(Integer.parseInt(day_2.getText().toString()));
                                    ubp.setThreeDayRate(Integer.parseInt(day_3.getText().toString()));
                                    ubp.setFourDayRate(Integer.parseInt(day_4.getText().toString()));
                                    ubp.setFiveDayRate(Integer.parseInt(day_5.getText().toString()));
                                    ubp.setSixDayRate(Integer.parseInt(day_6.getText().toString()));
                                    ubp.setSevenDayRate(Integer.parseInt(day_7.getText().toString()));
                                    ubp.setTenDayRate(Integer.parseInt(day_10.getText().toString()));
                                    ubp.setFifteenDays(Integer.parseInt(day_15.getText().toString()));
                                    ubp.setTwentyDayRate(Integer.parseInt(day_20.getText().toString()));
                                    ubp.setMonthly(Integer.parseInt(monthly.getText().toString()));
                                    ubp.setExtraHRS(Integer.parseInt(extra_hrs.getText().toString()));
                                    ubp.setExtraKMS(Integer.parseInt(extra_kms.getText().toString()));

                                    ubp.setKmsLimit(Integer.parseInt(km_limit.getText().toString()));
                                    ubp.setTick(false);

                                    if(getAdminRents.isChecked())
                                        ubp.setTick(true);
                                    ubp.setRentBikeId(bikeChart.get_id());

                                    Call<Void> call2=owner.updateBikePrice(ubp);
                                    call2.enqueue(new Callback<Void>() {
                                        @Override
                                        public void onResponse(Call<Void> call, Response<Void> response) {
                                            dialog.cancel();
                                            AlertBoxUtils.showAlert(mContext,"success","Price","Updated Succesfully");
                                        }

                                        @Override
                                        public void onFailure(Call<Void> call, Throwable t) {
                                            dialog.cancel();
                                            AlertBoxUtils.showAlert(mContext,"failure","Price","Something went wrong");
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
            AlertDialog dialog2 = alertDialogBuilder.create();
            dialog2.show();
        }
    }

}

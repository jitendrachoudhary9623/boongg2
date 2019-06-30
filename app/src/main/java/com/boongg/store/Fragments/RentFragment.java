package com.boongg.store.Fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.boongg.store.Interfaces.OnImageClickListener;
import com.boongg.store.Models.Responses.NearbyVehicles.Result;
import com.boongg.store.Models.Responses.NearbyVehicles.Vehicle;
import com.boongg.store.Models.Responses.Owners.Owner;
import com.boongg.store.Models.Responses.SearchUSer;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.Networking.SearchUser;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.VehicleRentAdapter;
import com.boongg.store.RecyclerViews.VehicleSelectAdapter;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.LoginToken;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RentFragment extends Fragment {
    View rootView;
    private RecyclerView recyclerView;
    TextView startDate,endDate,show;
    Button search;
    ProgressDialog progressDialog;
    DatePickerDialog picker;
    private Owner o;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();

    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
setHasOptionsMenu(true);
         rootView = inflater.inflate(R.layout.fragment_rent_calculation, container, false);
         recyclerView=(RecyclerView)rootView.findViewById(R.id.rent_bike_select);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayout.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       search=(Button)rootView.findViewById(R.id.rent_search_user_button);
        startDate=(TextView) rootView.findViewById(R.id.rent_start_date);
        endDate=(TextView) rootView.findViewById(R.id.rent_end_date);
         progressDialog = new ProgressDialog(getContext());
        show=(TextView) rootView.findViewById(R.id.show_msg);
        searchVehicle();
        setDateUsingDatePicker(startDate);
        setDateUsingDatePicker(endDate);
        return  rootView;
    }

    private void searchVehicle() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressBar();
                final OwnerInventory owner = APIClient.getClient().create(OwnerInventory.class);
                Call<Owner> call1 = owner.getOwnerInfo(LoginToken.id);
                call1.enqueue(new Callback<Owner>() {
                    @Override
                    public void onResponse(Call<Owner> call, Response<Owner> response) {
                        o = response.body();

                        String sd = DateSorter.convertStringToTimestamp((startDate.getText().toString()));
                        String ed = DateSorter.convertStringToTimestamp((endDate.getText().toString()));
                        Call<Vehicle> call2 = owner.getVehicleNearby(o.getCity().getName(), o.getLocality().get(0).toString(), sd, ed, "Asia/Calcutta");
                        call2.enqueue(new Callback<Vehicle>() {
                            @Override
                            public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {
                                progressDialog.hide();
                                List<Result> vehicle = response.body().getResults();
                                if(vehicle.size()>0){
                                    show.setVisibility(View.VISIBLE);
                                }
                                VehicleRentAdapter adapter = new VehicleRentAdapter(vehicle, getContext(), new OnImageClickListener() {
                                    @Override
                                    public void onImageClick(Result vehichle) {
                                        LinearLayout card=(LinearLayout) rootView.findViewById(R.id.rent_card);
                                        card.setVisibility(View.VISIBLE);

                                        TextView hr,m_f,s_s,m,total_rent;
                                        total_rent=(TextView)rootView.findViewById(R.id.rent_total);
                                        hr=(TextView)rootView.findViewById(R.id.rent_hour);
                                        m_f=(TextView)rootView.findViewById(R.id.rent_mon_fri_day);
                                        s_s=(TextView)rootView.findViewById(R.id.rent_sat_sun_day);
                                        m=(TextView)rootView.findViewById(R.id.rent_month);

                                        total_rent.setText("Total Rent\n"+getContext().getResources().getString(R.string.rs)+" "+vehichle.getRentCalculated());

                                        hr.setText(getContext().getResources().getString(R.string.rs)+" "+vehichle.getWeekDayPrice()+" / hr");

                                        m_f.setText(getContext().getResources().getString(R.string.rs)+" "+vehichle.getWeekDayPrice()+" / day");
                                        s_s.setText(getContext().getResources().getString(R.string.rs)+" "+vehichle.getWeekEndPrice()+" / day");
                                        m.setText(getContext().getResources().getString(R.string.rs)+" "+(vehichle.getRentCalculated()*30)+" / month");

                                    }
                                });
                                recyclerView.setAdapter(adapter);
                                Toast.makeText(getContext(), "" + response.body().getCitys(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<Vehicle> call, Throwable t) {
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<Owner> call, Throwable t) {

                    }

                });
            }
        });
    }

    public void setDateUsingDatePicker(final TextView vt){

        vt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final SimpleDateFormat mSimpleDateFormat;
                final Calendar mCalendar;
                mCalendar = Calendar.getInstance();

                mSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.getDefault());
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
                      TimePickerDialog tpd=  new TimePickerDialog(getContext(),android.R.style.Theme_Holo_Light_Dialog, mTimeDataSet, mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar.get(Calendar.MINUTE), false);
                        tpd.show();
                    }
                };

                new DatePickerDialog(getContext(), mDateDataSet, mCalendar.get(Calendar.YEAR),
                        mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });
    }



    private void showProgressBar() {
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
    }
    private void showDialog() {

        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.alert_bottom_vehicle_select, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setView(promptsView);
        recyclerView=(RecyclerView)promptsView.findViewById(R.id.rv_create_booking_select_bike);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}


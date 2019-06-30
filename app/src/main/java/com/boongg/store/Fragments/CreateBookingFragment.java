package com.boongg.store.Fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.boongg.store.Interfaces.OnImageClickListener;
import com.boongg.store.LoginActivity;
import com.boongg.store.MainActivity;
import com.boongg.store.Models.Requests.CheckIn;
import com.boongg.store.Models.Requests.CreateBookingRequest;
import com.boongg.store.Models.Requests.CreateUser;
import com.boongg.store.Models.Requests.SendOtpRequest;
import com.boongg.store.Models.Requests.VerifyOtpRequest;
import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Models.Responses.CancelledData.Cancel;
import com.boongg.store.Models.Responses.CreateBooking.BikeList;
import com.boongg.store.Models.Responses.CreateBooking.CreateBookingResponse;
import com.boongg.store.Models.Responses.CreateBooking.CreateBookingSuccessResponse;
import com.boongg.store.Models.Responses.CreateUserResponse;
import com.boongg.store.Models.Responses.CreateUserSuccessResponse;
import com.boongg.store.Models.Responses.NearbyVehicles.Result;
import com.boongg.store.Models.Responses.NearbyVehicles.Vehicle;
import com.boongg.store.Models.Responses.Owners.Owner;
import com.boongg.store.Models.Responses.PaymentMethod;
import com.boongg.store.Models.Responses.SearchUSer;
import com.boongg.store.Models.Responses.SendOtpResponse;
import com.boongg.store.Models.Responses.VerifyOtpResponse;
import com.boongg.store.Models.UpdateResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.CancelledData;
import com.boongg.store.Networking.CheckInRequest;
import com.boongg.store.Networking.CreateUserI;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.Networking.Payment;
import com.boongg.store.Networking.SearchUser;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.CancelAdapter;
import com.boongg.store.RecyclerViews.VehicleSelectAdapter;
import com.boongg.store.Utilities.AlertBoxUtils;
import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.FragmentUtils;
import com.boongg.store.Utilities.LoginToken;
import com.boongg.store.Utilities.ProgressbarUtil;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static android.support.v7.widget.LinearLayoutManager.*;

public class CreateBookingFragment extends Fragment {
    TextView search, searchBike;
    Button searchb, createB, sentOtp, submitOtp;
    LinearLayout nouser;
    LinearLayout userfound, createUser, otpLayout;
    TextView startDate, endDate;
    DatePickerDialog picker;
    EditText fname, lname, email, storeOtp, userOtp,username,email_search;
    RecyclerView recyclerView = null;
    ProgressDialog progressDialog;
    SearchUSer su;
    private OnImageClickListener listner;
    public Result selectedVehicle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_create_booking, container, false);
        setHasOptionsMenu(true);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_create_booking_select_bike);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        search = (TextView) rootView.findViewById(R.id.create_search_user);
        searchb = (Button) rootView.findViewById(R.id.create_search_user_button);
        nouser = (LinearLayout) rootView.findViewById(R.id.create_search_user_not_found);
        userfound = (LinearLayout) rootView.findViewById(R.id.create_search_user_found);
        startDate = (TextView) rootView.findViewById(R.id.create_search_user_start_date);
        endDate = (TextView) rootView.findViewById(R.id.create_search_user_end_date);
        createUser = (LinearLayout) rootView.findViewById(R.id.create_search_user_create_new);
        fname = (EditText) rootView.findViewById(R.id.create_search_user_fname);
        lname = (EditText) rootView.findViewById(R.id.create_search_user_lname);
        email = (EditText) rootView.findViewById(R.id.create_search_user_email);
        createB = (Button) rootView.findViewById(R.id.create_search_user_create_new_user_button);
        sentOtp = (Button) rootView.findViewById(R.id.create_search_user_create_otp);
        searchBike = (TextView) rootView.findViewById(R.id.create_search_user_search_bike);
        progressDialog = new ProgressDialog(getContext());
        otpLayout = (LinearLayout) rootView.findViewById(R.id.user_otp_box);
        userOtp = (EditText) rootView.findViewById(R.id.user_otp);
        storeOtp = (EditText) rootView.findViewById(R.id.store_otp);
        username=(EditText)rootView.findViewById(R.id.create_search_user_name);
        email_search=(EditText)rootView.findViewById(R.id.create_search_email) ;
        submitOtp = (Button) rootView.findViewById(R.id.submit_otp);

        setDateUsingDatePicker(startDate);
        setDateUsingDatePicker(endDate);
        searchb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String number = search.getText().toString();
                SearchUser searchUser = APIClient.getClient().create(SearchUser.class);
                Call<List<SearchUSer>> call1 = searchUser.searchUser(number);
                showProgressBar();
                call1.enqueue(new Callback<List<SearchUSer>>() {
                    @Override
                    public void onResponse(Call<List<SearchUSer>> call, Response<List<SearchUSer>> response) {
                        progressDialog.hide();

                        try {
                            List<SearchUSer> users = response.body();
                            switch (users.size()) {
                                case 0:
                                    Toast.makeText(getContext(), "No User Found", Toast.LENGTH_LONG).show();

                                    nouser.setVisibility(View.VISIBLE);
                                    userfound.setVisibility(View.GONE);
                                    createUser.setVisibility(View.VISIBLE);
                                    AlertBoxUtils.showAlert(getContext(), "error", "User Search Result", "User not found");

                                    createUserProfile(number);
                                    break;
                                case 1:

                                    nouser.setVisibility(View.GONE);
                                    userfound.setVisibility(View.VISIBLE);
                                    createUser.setVisibility(View.GONE);
                                    su = users.get(0);
                                    username.setText(su.getProfile().getName());
                                    email_search.setText(su.getEmail());
                                    AlertBoxUtils.showAlert(getContext(), "success", "User Search Result", "User found");

                                    creatingBooking();

                                    break;
                            }
                        }catch (Exception e){

                        }
                    }

                    @Override
                    public void onFailure(Call<List<SearchUSer>> call, Throwable t) {
                        progressDialog.hide();
                        Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();

    }
    private void showProgressBar() {
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
    }

    Owner o;

    private void creatingBooking() {


        searchBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressBar();
                final OwnerInventory owner = APIClient.getClient().create(OwnerInventory.class);
                Call<Owner> call1 = owner.getOwnerInfo(LoginToken.id);
                call1.enqueue(new Callback<Owner>() {
                    @Override
                    public void onResponse(Call<Owner> call, Response<Owner> response) {
                        o = response.body();
                        //  Call<List<OwnerInventory>> call2 = owner.getVehicleNearby(o.getCity(),o.getLocality().get(0),);
                        String sd = DateSorter.convertStringToTimestamp((startDate.getText().toString()));
                        String ed = DateSorter.convertStringToTimestamp((endDate.getText().toString()));
                        Call<Vehicle> call2 = owner.getVehicleNearby(o.getCity().getName(), o.getLocality().get(0).toString(), sd, ed, "Asia/Calcutta");
                        call2.enqueue(new Callback<Vehicle>() {
                            @Override
                            public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {
                                progressDialog.hide();

                                List<Result> vehicle = response.body().getResults();
                                VehicleSelectAdapter adapter = new VehicleSelectAdapter(vehicle, getContext(), new OnImageClickListener() {
                                    @Override
                                    public void onImageClick(Result vehichle) {
                                        payment(vehichle);
                                    }
                                });
                                recyclerView.setAdapter(adapter);
                                Toast.makeText(getContext(), "" + response.body().getCitys(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<Vehicle> call, Throwable t) {
                                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
                                Log.e("JWT", t.toString());
                                Log.d("JWT", "ok  " + call.request().url().toString());
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

    private void payment(final Result vehichle) {

        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.alert_payment, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext(),R.style.CustomAlertDialog);
        alertDialogBuilder.setView(promptsView);
        final EditText trent, srent,totalCalculatedRent;
        TextView payNow;
        trent = (EditText) promptsView.findViewById(R.id.pay_total_rent);
        srent = (EditText) promptsView.findViewById(R.id.pay_selected_rent);
        totalCalculatedRent=(EditText)promptsView.findViewById(R.id.total_calculated_rent);
        //spinner = (Spinner)promptsView.findViewById(R.id.payment_method_spinner);
        final NiceSpinner spinner = (NiceSpinner) promptsView.findViewById(R.id.payment_method_spinner);
        final CheckBox immediate_checkout = (CheckBox) promptsView.findViewById(R.id.immediate_checkout);
        final boolean immediate_checkout_boolean = false;
        final EditText cgst=(EditText) promptsView.findViewById(R.id.pay_cgst);
        final EditText sgst=(EditText) promptsView.findViewById(R.id.pay_sgst);

        payNow = (TextView) promptsView.findViewById(R.id.payment_pay_now);
        final List<String> paymentMethods = new ArrayList<>();
        final List<PaymentMethod> paymentObjects = new LinkedList<>();
        final PaymentMethod[] payObject = new PaymentMethod[1];
        Payment payment = APIClient.getClient().create(Payment.class);
        Call<List<PaymentMethod>> pcall = payment.getPaymentMethods();
        AlertBoxUtils.showLoadingAlert(getContext());
        pcall.enqueue(new Callback<List<PaymentMethod>>() {
            @Override
            public void onResponse(Call<List<PaymentMethod>> call, Response<List<PaymentMethod>> response) {
                Toast.makeText(getContext(), response.body().size() + "", Toast.LENGTH_LONG).show();
                for (PaymentMethod m : response.body()) {
                    paymentMethods.add(m.getPaymentType());
                    paymentObjects.add(m);
                }

                spinner.attachDataSource(paymentMethods);
                payObject[0] = paymentObjects.get(0);
                AlertBoxUtils.hideLoadingAlert();
            }

            @Override
            public void onFailure(Call<List<PaymentMethod>> call, Throwable t) {

            }
        });

        spinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                payObject[0] = paymentObjects.get(position);
            }
        });


        trent.setText(formatString("" + (vehichle.getRentCalculated()+(vehichle.getRentCalculated()*0.06)*2)));
        srent.setText(formatString("" + (vehichle.getRentCalculated()+(vehichle.getRentCalculated()*0.06)*2)));
        srent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    Double gst = Double.parseDouble(srent.getText().toString()) * 0.06;
                    sgst.setText(formatString(gst.toString()));
                    cgst.setText(formatString(gst.toString()));
                    totalCalculatedRent.setText(formatString(""+(Double.parseDouble(sgst.getText().toString())*2+Double.parseDouble(srent.getText().toString()))));

                }catch (Exception e){

                }
            }
        });
        sgst.setText(""+formatString(""+(vehichle.getRentCalculated()*0.06)));
        cgst.setText(formatString(""+(vehichle.getRentCalculated()*0.06)));
        totalCalculatedRent.setText(formatString(""+(Double.parseDouble(sgst.getText().toString())*2+Double.parseDouble(srent.getText().toString()))));
        final AlertDialog alertDialog = alertDialogBuilder.create();

        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateBookingRequest booking = new CreateBookingRequest();
                booking.setUsername(su.getProfile().getName());
                booking.setEmailid(su.getEmail());
                booking.setIsGstApplicable(true);
                booking.setMobileNo(su.getProfile().getMobileNumber());
                booking.setLocation(o.getLocality().get(0));
                booking.setMobileNo(su.getProfile().getMobileNumber());
                booking.setPaymentType("OFFLINE");
                booking.setPaymentTypeMode(payObject[0].get_id()); //paymenttype getlist
                booking.setRecivableAmountWithTax(Double.parseDouble(trent.getText().toString()));
                booking.setRentTotal(Double.parseDouble(trent.getText().toString()));
                booking.setSuggestedRent(Double.parseDouble(srent.getText().toString()));
                booking.setStoreKey(LoginToken.id);

                booking.setWebUserId(su.getId());
                List<BikeList> bikes = new ArrayList<>();
                BikeList bike = new BikeList();
                bike.setAddress(vehichle.getAddress());
                bike.setBrand(vehichle.getBrand());
                bike.setQuantity(1.0);
                bike.setThumbUrl(vehichle.getThumbUrl());
                bike.setIsAddtoCart(true);
                bike.setRentCalculated(Double.parseDouble(trent.getText().toString()));
                bike.setKey(vehichle.getKey());
                bike.setMapAddr(vehichle.getMapAddr());
                bike.setModelName(vehichle.getModelName());
                bike.setWeekDayPrice(vehichle.getWeekDayPrice());
                bike.setWeekEndPrice(vehichle.getWeekEndPrice());
                bike.setCartQuantity(vehichle.getQuantity());
                bike.setStartDate(Long.parseLong(DateSorter.convertStringToTimestamp(startDate.getText().toString())));
                bike.setEndDate(Long.parseLong(DateSorter.convertStringToTimestamp(endDate.getText().toString())));

                bikes.add(bike);

                booking.setBikeList(bikes);
                Log.e("JWT", booking.toString());
                BookingRequest bookingRequest = APIClient.getClient().create(BookingRequest.class);
                Call<List<CreateBookingResponse>> call3 = bookingRequest.createBooking(booking);
                alertDialog.dismiss();

                showProgressBar();
                call3.enqueue(new Callback<List<CreateBookingResponse>>() {
                    @Override
                    public void onResponse(Call<List<CreateBookingResponse>> call, Response<List<CreateBookingResponse>> response) {

                        progressDialog.hide();

                        if (!immediate_checkout.isChecked()) {
                            AlertBoxUtils.showAlert(getContext(), "success", "Booking", "Booking created Successfully");
                            getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        } else {
                            AlertBoxUtils.showAlert(getContext(), "success", "Booking Created", "Booking created Successfully!!\nImmediate CheckIn");
                            directCheckOut(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CreateBookingResponse>> call, Throwable t) {
                        progressDialog.hide();
                        Log.e("JWT", t.toString());
                        new SweetAlertDialog(getContext(), SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Booking")
                                .setContentText("Booking failed" + t.toString())
                                .show();

                    }
                });
            }
        });
        alertDialog.show();
    }

    AlertDialog dialog2;
    List<String> ds = new ArrayList<>();
    List<VehicleInventoryResponse> vehicleList = new ArrayList<>();

    private void directCheckOut(final List<CreateBookingResponse> body) {
        LayoutInflater li = LayoutInflater.from(getContext());
        View promptsView = li.inflate(R.layout.alert_checkin, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());
        final EditText start = (EditText) promptsView.findViewById(R.id.startKm);
        final EditText totalRent=(EditText)promptsView.findViewById(R.id.totalRent);
        totalRent.setText(""+body.get(0).getRentTotal());
        final CheckBox modifyBikeCheckBox, helmentProvidedCheckBox;
        modifyBikeCheckBox = (CheckBox) promptsView.findViewById(R.id.modify_bike_checkbox);
        final Spinner niceSpinner = (Spinner) promptsView.findViewById(R.id.select_bike_spinner);
        OwnerInventory inventory = APIClient.getClient().create(OwnerInventory.class);
        Call<List<VehicleInventoryResponse>> call2 = inventory.getAvailableVehicles(LoginToken.id);
        call2.enqueue(new Callback<List<VehicleInventoryResponse>>() {
            @Override
            public void onResponse(Call<List<VehicleInventoryResponse>> call, Response<List<VehicleInventoryResponse>> response) {
                ds = null;
                ds = new LinkedList<>();
                ds.add("Select Vehicle");
                for (VehicleInventoryResponse vir : response.body()) {
                    if (body.get(0).getModel().equals(vir.getVehicleModel())) {
                        vehicleList.add(vir);
                        ds.add("(" + vir.getRegistrationNumber() + ") " + vir.getBrand() + " " + vir.getVehicleModel());
                    }
                }
                for (String s : ds) {
                    Log.e("JWT", s);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String >(
                        getContext(),
                        android.R.layout.simple_spinner_item,
                        ds
                );
                niceSpinner.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<VehicleInventoryResponse>> call, Throwable t) {
                AlertBoxUtils.showAlert(getContext(), "error", "", "" + t.toString());
            }
        });
        modifyBikeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
                if (dialog2.isShowing()) {
                    dialog2.dismiss();
                }
                AlertBoxUtils.showLoadingAlert(getContext());
                OwnerInventory inventory = APIClient.getClient().create(OwnerInventory.class);
                Call<List<VehicleInventoryResponse>> call2 = inventory.getAvailableVehicles(LoginToken.id);
                call2.enqueue(new Callback<List<VehicleInventoryResponse>>() {
                    @Override
                    public void onResponse(Call<List<VehicleInventoryResponse>> call, Response<List<VehicleInventoryResponse>> response) {
                        ds = null;
                        ds = new ArrayList<>();
                        //ds.add("Select Vehicle")
                        if (isChecked) {
                            ds.add("Select Vehicle for modification");
                        } else {
                            ds.add("Select Vehicle");
                        }
                        for (VehicleInventoryResponse vir : response.body()) {

                            if (isChecked) {
                                vehicleList.add(vir);
                                ds.add("(" + vir.getRegistrationNumber() + ") " + vir.getBrand() + " " + vir.getVehicleModel());
                            } else {
                                if (body.get(0).getModel().equals(vir.getVehicleModel())) {
                                    Log.e("JWT", body.get(0).getBrand() + " " + body.get(0).getModel() + " ---- " + vir.getBrand() + " ----- " + vir.getVehicleModel());
                                    vehicleList.add(vir);
                                    ds.add("(" + vir.getRegistrationNumber() + ") " + vir.getBrand() + " " + vir.getVehicleModel());
                                }
                            }
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<String >(
                                getContext(),
                                android.R.layout.simple_spinner_item,
                                ds
                        );
                        niceSpinner.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<VehicleInventoryResponse>> call, Throwable t) {
                        AlertBoxUtils.showAlert(getContext(), "error", "", "" + t.toString());

                    }
                });
                AlertBoxUtils.hideLoadingAlert();
                if (!dialog2.isShowing()) {
                    dialog2.show();
                }
            }
        });

        final String[] bId = {""};
        final String selectedBike[] = {""};
        niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    VehicleInventoryResponse v2 = vehicleList.get(position);
                    bId[0] = v2.getId();
                } catch (Exception e) {
                    AlertBoxUtils.showAlert(getContext(), "error", "Something went wrong", "Please reselect the bike");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        helmentProvidedCheckBox = (CheckBox) promptsView.findViewById(R.id.helmet_provided);
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Check In",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                boolean isHelmetProvide = false;
                                if (helmentProvidedCheckBox.isChecked()) {
                                    isHelmetProvide = true;
                                }
                                String startKm = start.getText().toString();
                                CheckIn check = new CheckIn(bId[0], isHelmetProvide, body.get(0).getId(), startKm);
                                CheckInRequest checkInRequest = APIClient.getClient().create(CheckInRequest.class);
                                Call<Void> call1 = checkInRequest.checkIn(check);
                                call1.enqueue(new Callback<Void>() {
                                    @Override
                                    public void onResponse(Call<Void> call, Response<Void> response) {

                                        AlertBoxUtils.showAlert(getContext(), "success", "Check In", "Check in successfull ! please wait we will take you to the main screem");
                                        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                                    }

                                    @Override
                                    public void onFailure(Call<Void> call, Throwable t) {
                                        //Toast.makeText(getContext(),"Something went wrong"+t.toString(),Toast.LENGTH_LONG).show();
                                        AlertBoxUtils.showAlert(getContext(), "error", "Something wet wrong ", "" + t.toString());
                                    }
                                });
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                            }
                        });
        dialog2 = alertDialogBuilder.create();
        dialog2.show();
    }

    private void createUserProfile(final String number) {
    createUser.setVisibility(View.VISIBLE);
    createB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final String fullname = fname.getText().toString() + " " + lname.getText().toString();
            final String email_ = email.getText().toString();
            final CreateUser user = new CreateUser(fullname, number, email_);
            final CreateUserI createUser = APIClient.getClient().create(CreateUserI.class);
            showProgressBar();
            final Call<CreateUserSuccessResponse> call1 = createUser.createNewUser(user);
            call1.enqueue(new Callback<CreateUserSuccessResponse>() {
                @Override
                public void onResponse(Call<CreateUserSuccessResponse> call, Response<CreateUserSuccessResponse> response) {
                  progressDialog.hide();
                    if(response.code()!=500){
                        sentOtp.setVisibility(View.VISIBLE);
                        sentOtp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                otpLayout.setVisibility(View.VISIBLE);
                                //call send otp
                                otpLayout.setVisibility(View.VISIBLE);

                                SendOtpRequest otpRequest = new SendOtpRequest(email_,number);
                                ProgressbarUtil.showProgressbar(getContext());
                                Call<SendOtpResponse> otpCall = createUser.sendOtp(otpRequest);
                                otpCall.enqueue(new Callback<SendOtpResponse>() {
                                    @Override
                                    public void onResponse(Call<SendOtpResponse> call, Response<SendOtpResponse> response) {
                                        ProgressbarUtil.hideProgressBar();
                                        storeOtp.setText(response.body().getOtp());
                                        submitOtp.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                VerifyOtpRequest verifyOtpRequest=new VerifyOtpRequest(email_, number, storeOtp.getText().toString());
                                                ProgressbarUtil.showProgressbar(getContext());
                                                Call<VerifyOtpResponse> verifyOtp = createUser.verifyOtp(verifyOtpRequest);
                                                verifyOtp.enqueue(new Callback<VerifyOtpResponse>() {
                                                    @Override
                                                    public void onResponse(Call<VerifyOtpResponse> call, Response<VerifyOtpResponse> response) {
                                                        ProgressbarUtil.hideProgressBar();

                                                    }

                                                    @Override
                                                    public void onFailure(Call<VerifyOtpResponse> call, Throwable t) {
                                                        ProgressbarUtil.hideProgressBar();
                                                    }
                                                });

                                            }
                                        });
                                    }

                                    @Override
                                    public void onFailure(Call<SendOtpResponse> call, Throwable t) {
                                        ProgressbarUtil.hideProgressBar();
                                    }
                                });
                            }
                        });
                    }
                    else{
                        sentOtp.setVisibility(View.GONE);
                        Toast.makeText(getContext(),"Failure"+response.body().getSuccess(),Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<CreateUserSuccessResponse> call, Throwable t) {

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
                        new TimePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog,mTimeDataSet, mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar.get(Calendar.MINUTE), false).show();
                    }
                };

                new DatePickerDialog(getContext(), mDateDataSet, mCalendar.get(Calendar.YEAR),
                        mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });


    }
    public String formatString(String ss){
        try {
            return String.format("%.2f", Double.parseDouble(ss));
        }catch(Exception e){
            return ss;
        }
    }


}


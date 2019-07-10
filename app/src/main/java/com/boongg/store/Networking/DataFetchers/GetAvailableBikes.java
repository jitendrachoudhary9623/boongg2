package com.boongg.store.Networking.DataFetchers;

import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Models.Responses.PreDropBookings.PreDropBooking;
import com.boongg.store.Models.Responses.RentBikeResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.Utilities.LoginToken;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAvailableBikes {

    public static List<PreDropBooking> getAvailableBikes(){

         BookingRequest maint = OAPIClient.getClient().create(BookingRequest.class);
         final OwnerInventory avail = APIClient.getClient().create(OwnerInventory.class);
        final List<PreDropBooking> maintaince=new ArrayList<>();
        final List<PreDropBooking> available=new ArrayList<>();
        final List<PreDropBooking> data=new ArrayList<>();
        final Call<List<PreDropBooking>> mai=maint.getSMaintainanceBikes();
        Call<List<PreDropBooking>> ava=avail.getSAllVehicles(LoginToken.id);
        ava.enqueue(new Callback<List<PreDropBooking>>() {
            @Override
            public void onResponse(Call<List<PreDropBooking>> call, Response<List<PreDropBooking>> response) {
                available.addAll(response.body());
                mai.enqueue(new Callback<List<PreDropBooking>>() {
                    @Override
                    public void onResponse(Call<List<PreDropBooking>> call, Response<List<PreDropBooking>> response) {
                        maintaince.addAll(response.body());
                        for(PreDropBooking m:maintaince){
                            for(PreDropBooking a:available){
                                try {
                                    if (a.get_rentPoolKey().getRegistrationNumber().equals(m.get_rentPoolKey().getRegistrationNumber())) {
                                        continue;
                                    } else if (a.get_rentPoolKey().getStatusType().getType().equals("BOOKED")) {
                                        continue;
                                    } else {
                                        data.add(a);
                                    }
                                }catch (Exception e){
                                    continue;
                                }
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<List<PreDropBooking>> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<List<PreDropBooking>> call, Throwable t) {

            }
        });


        return data;
    }
}

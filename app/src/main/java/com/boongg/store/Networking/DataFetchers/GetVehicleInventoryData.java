package com.boongg.store.Networking.DataFetchers;

import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.Utilities.LoginToken;

import java.util.List;

import retrofit2.Call;

public class GetVehicleInventoryData {

    public List<VehicleInventoryResponse> getSelectedBooking(){
        OwnerInventory inventory = APIClient.getClient().create(OwnerInventory.class);
        Call<List<VehicleInventoryResponse>> call2 = inventory.getAvailableVehicles(LoginToken.id);
        return null;
    }
}

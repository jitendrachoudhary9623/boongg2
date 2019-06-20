package com.boongg.store.Interfaces;

import com.boongg.store.Models.Responses.NearbyVehicles.Result;

//Interface needed to pass data from recycler view to the main fragment
public interface OnImageClickListener {
    void onImageClick(Result vehichle);
}

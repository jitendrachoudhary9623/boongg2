 package com.boongg.store.Models.Requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BikeMaintaince implements Parcelable
{

    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("store")
    @Expose
    private String store;
    @SerializedName("rentPool")
    @Expose
    private String rentPool;
    public final static Parcelable.Creator<BikeMaintaince> CREATOR = new Creator<BikeMaintaince>() {


        @SuppressWarnings({
                "unchecked"
        })
        public BikeMaintaince createFromParcel(Parcel in) {
            return new BikeMaintaince(in);
        }

        public BikeMaintaince[] newArray(int size) {
            return (new BikeMaintaince[size]);
        }

    }
            ;

    protected BikeMaintaince(Parcel in) {
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.reason = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.store = ((String) in.readValue((String.class.getClassLoader())));
        this.rentPool = ((String) in.readValue((String.class.getClassLoader())));
    }

    public BikeMaintaince() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getRentPool() {
        return rentPool;
    }

    public void setRentPool(String rentPool) {
        this.rentPool = rentPool;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeValue(reason);
        dest.writeValue(brand);
        dest.writeValue(model);
        dest.writeValue(store);
        dest.writeValue(rentPool);
    }

    public int describeContents() {
        return 0;
    }

}
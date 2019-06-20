package com.boongg.store.Models.Requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModifyRequest implements Parcelable
{

    @SerializedName("bookingId")
    @Expose
    private String bookingId;
    @SerializedName("newBikePoolKey")
    @Expose
    private String newBikePoolKey;
    @SerializedName("previousBikePoolKey")
    @Expose
    private String previousBikePoolKey;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("model")
    @Expose
    private String model;
    public final static Parcelable.Creator<ModifyRequest> CREATOR = new Creator<ModifyRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ModifyRequest createFromParcel(Parcel in) {
            return new ModifyRequest(in);
        }

        public ModifyRequest[] newArray(int size) {
            return (new ModifyRequest[size]);
        }

    }
            ;

    protected ModifyRequest(Parcel in) {
        this.bookingId = ((String) in.readValue((String.class.getClassLoader())));
        this.newBikePoolKey = ((String) in.readValue((String.class.getClassLoader())));
        this.previousBikePoolKey = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ModifyRequest() {
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getNewBikePoolKey() {
        return newBikePoolKey;
    }

    public void setNewBikePoolKey(String newBikePoolKey) {
        this.newBikePoolKey = newBikePoolKey;
    }

    public String getPreviousBikePoolKey() {
        return previousBikePoolKey;
    }

    public void setPreviousBikePoolKey(String previousBikePoolKey) {
        this.previousBikePoolKey = previousBikePoolKey;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(bookingId);
        dest.writeValue(newBikePoolKey);
        dest.writeValue(previousBikePoolKey);
        dest.writeValue(brand);
        dest.writeValue(model);
    }

    public int describeContents() {
        return 0;
    }

}
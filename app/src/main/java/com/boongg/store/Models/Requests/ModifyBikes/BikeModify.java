package com.boongg.store.Models.Requests.ModifyBikes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BikeModify implements Parcelable
{

    @SerializedName("bookingId")
    @Expose
    private String bookingId;
    @SerializedName("selectedBike")
    @Expose
    private String selectedBike;
    @SerializedName("isModifiedBikes")
    @Expose
    private Boolean isModifiedBikes;
    @SerializedName("isWaveAmount")
    @Expose
    private Boolean isWaveAmount;
    @SerializedName("modifiedBikeBaseRent")
    @Expose
    private Double modifiedBikeBaseRent;
    @SerializedName("modifiedBikeReceviableAmount")
    @Expose
    private Double modifiedBikeReceviableAmount;
    @SerializedName("modifiedBikeCGST")
    @Expose
    private Double modifiedBikeCGST;
    @SerializedName("modifiedBikeSGST")
    @Expose
    private Double modifiedBikeSGST;
    @SerializedName("differenceAmount")
    @Expose
    private Double differenceAmount;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("startKm")
    @Expose
    private Double startKm;
    @SerializedName("isHelmateProvided")
    @Expose
    private Boolean isHelmateProvided;
    public final static Parcelable.Creator<BikeModify> CREATOR = new Creator<BikeModify>() {


        @SuppressWarnings({
                "unchecked"
        })
        public BikeModify createFromParcel(Parcel in) {
            return new BikeModify(in);
        }

        public BikeModify[] newArray(int size) {
            return (new BikeModify[size]);
        }

    }
            ;

    protected BikeModify(Parcel in) {
        this.bookingId = ((String) in.readValue((String.class.getClassLoader())));
        this.selectedBike = ((String) in.readValue((String.class.getClassLoader())));
        this.isModifiedBikes = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isWaveAmount = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.modifiedBikeBaseRent = ((Double) in.readValue((Double.class.getClassLoader())));
        this.modifiedBikeReceviableAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.modifiedBikeCGST = ((Double) in.readValue((Double.class.getClassLoader())));
        this.modifiedBikeSGST = ((Double) in.readValue((Double.class.getClassLoader())));
        this.differenceAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.startKm = ((Double) in.readValue((Double.class.getClassLoader())));
        this.isHelmateProvided = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public BikeModify() {
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getSelectedBike() {
        return selectedBike;
    }

    public void setSelectedBike(String selectedBike) {
        this.selectedBike = selectedBike;
    }

    public Boolean getIsModifiedBikes() {
        return isModifiedBikes;
    }

    public void setIsModifiedBikes(Boolean isModifiedBikes) {
        this.isModifiedBikes = isModifiedBikes;
    }

    public Boolean getIsWaveAmount() {
        return isWaveAmount;
    }

    public void setIsWaveAmount(Boolean isWaveAmount) {
        this.isWaveAmount = isWaveAmount;
    }

    public Double getModifiedBikeBaseRent() {
        return modifiedBikeBaseRent;
    }

    public void setModifiedBikeBaseRent(Double modifiedBikeBaseRent) {
        this.modifiedBikeBaseRent = modifiedBikeBaseRent;
    }

    public Double getModifiedBikeReceviableAmount() {
        return modifiedBikeReceviableAmount;
    }

    public void setModifiedBikeReceviableAmount(Double modifiedBikeReceviableAmount) {
        this.modifiedBikeReceviableAmount = modifiedBikeReceviableAmount;
    }

    public Double getModifiedBikeCGST() {
        return modifiedBikeCGST;
    }

    public void setModifiedBikeCGST(Double modifiedBikeCGST) {
        this.modifiedBikeCGST = modifiedBikeCGST;
    }

    public Double getModifiedBikeSGST() {
        return modifiedBikeSGST;
    }

    public void setModifiedBikeSGST(Double modifiedBikeSGST) {
        this.modifiedBikeSGST = modifiedBikeSGST;
    }

    public Double getDifferenceAmount() {
        return differenceAmount;
    }

    public void setDifferenceAmount(Double differenceAmount) {
        this.differenceAmount = differenceAmount;
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

    public Double getStartKm() {
        return startKm;
    }

    public void setStartKm(Double startKm) {
        this.startKm = startKm;
    }

    public Boolean getIsHelmateProvided() {
        return isHelmateProvided;
    }

    public void setIsHelmateProvided(Boolean isHelmateProvided) {
        this.isHelmateProvided = isHelmateProvided;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(bookingId);
        dest.writeValue(selectedBike);
        dest.writeValue(isModifiedBikes);
        dest.writeValue(isWaveAmount);
        dest.writeValue(modifiedBikeBaseRent);
        dest.writeValue(modifiedBikeReceviableAmount);
        dest.writeValue(modifiedBikeCGST);
        dest.writeValue(modifiedBikeSGST);
        dest.writeValue(differenceAmount);
        dest.writeValue(brand);
        dest.writeValue(model);
        dest.writeValue(startKm);
        dest.writeValue(isHelmateProvided);
    }

    public int describeContents() {
        return 0;
    }

}
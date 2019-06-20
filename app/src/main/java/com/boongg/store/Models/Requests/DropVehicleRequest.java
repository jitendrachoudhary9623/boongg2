package com.boongg.store.Models.Requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DropVehicleRequest implements Parcelable
{

    @SerializedName("endKm")
    @Expose
    private Integer endKm;
    @SerializedName("rtoChallen")
    @Expose
    private String rtoChallen;
    @SerializedName("fineAccidentalCost")
    @Expose
    private String fineAccidentalCost;
    @SerializedName("bikeBookedId")
    @Expose
    private String bikeBookedId;
    @SerializedName("totalKmRun")
    @Expose
    private Integer totalKmRun;
    @SerializedName("_rentPoolKey")
    @Expose
    private String _rentPoolKey;
    public final static Parcelable.Creator<DropVehicleRequest> CREATOR = new Creator<DropVehicleRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DropVehicleRequest createFromParcel(Parcel in) {
            return new DropVehicleRequest(in);
        }

        public DropVehicleRequest[] newArray(int size) {
            return (new DropVehicleRequest[size]);
        }

    }
            ;

    protected DropVehicleRequest(Parcel in) {
        this.endKm = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rtoChallen = ((String) in.readValue((String.class.getClassLoader())));
        this.fineAccidentalCost = ((String) in.readValue((String.class.getClassLoader())));
        this.bikeBookedId = ((String) in.readValue((String.class.getClassLoader())));
        this.totalKmRun = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this._rentPoolKey = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DropVehicleRequest() {
    }

    public Integer getEndKm() {
        return endKm;
    }

    public void setEndKm(Integer endKm) {
        this.endKm = endKm;
    }

    public String getRtoChallen() {
        return rtoChallen;
    }

    public void setRtoChallen(String rtoChallen) {
        this.rtoChallen = rtoChallen;
    }

    public String getFineAccidentalCost() {
        return fineAccidentalCost;
    }

    public void setFineAccidentalCost(String fineAccidentalCost) {
        this.fineAccidentalCost = fineAccidentalCost;
    }

    public String getBikeBookedId() {
        return bikeBookedId;
    }

    public void setBikeBookedId(String bikeBookedId) {
        this.bikeBookedId = bikeBookedId;
    }

    public Integer getTotalKmRun() {
        return totalKmRun;
    }

    public void setTotalKmRun(Integer totalKmRun) {
        this.totalKmRun = totalKmRun;
    }

    public String get_rentPoolKey() {
        return _rentPoolKey;
    }

    public void set_rentPoolKey(String _rentPoolKey) {
        this._rentPoolKey = _rentPoolKey;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(endKm);
        dest.writeValue(rtoChallen);
        dest.writeValue(fineAccidentalCost);
        dest.writeValue(bikeBookedId);
        dest.writeValue(totalKmRun);
        dest.writeValue(_rentPoolKey);
    }

    public int describeContents() {
        return 0;
    }

}
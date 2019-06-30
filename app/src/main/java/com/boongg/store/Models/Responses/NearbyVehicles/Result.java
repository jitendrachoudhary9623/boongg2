
package com.boongg.store.Models.Responses.NearbyVehicles;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable
{

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("modelName")
    @Expose
    private String modelName;
    @SerializedName("weekDayPrice")
    @Expose
    private Double weekDayPrice;
    @SerializedName("weekEndPrice")
    @Expose
    private Double weekEndPrice;
    @SerializedName("mapAddr")
    @Expose
    private MapAddr mapAddr;
    @SerializedName("address")
    @Expose
    private List<Address> address = null;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("rentCalculated")
    @Expose
    private Double rentCalculated;
    @SerializedName("thumbUrl")
    @Expose
    private String thumbUrl;
    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
    ;

    protected Result(Parcel in) {
        this.key = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.modelName = ((String) in.readValue((String.class.getClassLoader())));
        this.weekDayPrice = ((Double) in.readValue((Double.class.getClassLoader())));
        this.weekEndPrice = ((Double) in.readValue((Double.class.getClassLoader())));
        this.mapAddr = ((MapAddr) in.readValue((MapAddr.class.getClassLoader())));
        in.readList(this.address, (com.boongg.store.Models.Responses.NearbyVehicles.Address.class.getClassLoader()));
        this.quantity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.rentCalculated = ((Double) in.readValue((Double.class.getClassLoader())));
        this.thumbUrl = ((String) in.readValue((String.class.getClassLoader())));
    }


    public Result() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getWeekDayPrice() {
        return weekDayPrice;
    }

    public void setWeekDayPrice(Double weekDayPrice) {
        this.weekDayPrice = weekDayPrice;
    }

    public Double getWeekEndPrice() {
        return weekEndPrice;
    }

    public void setWeekEndPrice(Double weekEndPrice) {
        this.weekEndPrice = weekEndPrice;
    }

    public MapAddr getMapAddr() {
        return mapAddr;
    }

    public void setMapAddr(MapAddr mapAddr) {
        this.mapAddr = mapAddr;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRentCalculated() {
        return rentCalculated;
    }

    public void setRentCalculated(Double rentCalculated) {
        this.rentCalculated = rentCalculated;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(key);
        dest.writeValue(brand);
        dest.writeValue(modelName);
        dest.writeValue(weekDayPrice);
        dest.writeValue(weekEndPrice);
        dest.writeValue(mapAddr);
        dest.writeList(address);
        dest.writeValue(quantity);
        dest.writeValue(rentCalculated);
        dest.writeValue(thumbUrl);
    }

    public int describeContents() {
        return  0;
    }

}

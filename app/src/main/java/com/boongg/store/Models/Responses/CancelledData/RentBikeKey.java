
package com.boongg.store.Models.Responses.CancelledData;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RentBikeKey implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("engineCapacity")
    @Expose
    private Integer engineCapacity;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_storeKey")
    @Expose
    private String storeKey;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("location")
    @Expose
    private List<Location> location = null;
    @SerializedName("pictures")
    @Expose
    private List<Object> pictures = null;
    public final static Parcelable.Creator<RentBikeKey> CREATOR = new Creator<RentBikeKey>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RentBikeKey createFromParcel(Parcel in) {
            return new RentBikeKey(in);
        }

        public RentBikeKey[] newArray(int size) {
            return (new RentBikeKey[size]);
        }

    }
    ;

    protected RentBikeKey(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.engineCapacity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.storeKey = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.location, (com.boongg.store.Models.Responses.CancelledData.Location.class.getClassLoader()));
        in.readList(this.pictures, (java.lang.Object.class.getClassLoader()));
    }

    public RentBikeKey() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStoreKey() {
        return storeKey;
    }

    public void setStoreKey(String storeKey) {
        this.storeKey = storeKey;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public List<Object> getPictures() {
        return pictures;
    }

    public void setPictures(List<Object> pictures) {
        this.pictures = pictures;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(updatedAt);
        dest.writeValue(createdAt);
        dest.writeValue(model);
        dest.writeValue(brand);
        dest.writeValue(quantity);
        dest.writeValue(engineCapacity);
        dest.writeValue(status);
        dest.writeValue(storeKey);
        dest.writeValue(v);
        dest.writeList(location);
        dest.writeList(pictures);
    }

    public int describeContents() {
        return  0;
    }

}

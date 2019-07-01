
package com.boongg.store.Models.Responses.Drop;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _rentBikeKey implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String _id;
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
    private String _storeKey;
    @SerializedName("__v")
    @Expose
    private Integer __v;
    @SerializedName("location")
    @Expose
    private List<Location> location = null;
    @SerializedName("pictures")
    @Expose
    private List<Object> pictures = null;
    public final static Creator<_rentBikeKey> CREATOR = new Creator<_rentBikeKey>() {


        @SuppressWarnings({
            "unchecked"
        })
        public _rentBikeKey createFromParcel(Parcel in) {
            return new _rentBikeKey(in);
        }

        public _rentBikeKey[] newArray(int size) {
            return (new _rentBikeKey[size]);
        }

    }
    ;

    protected _rentBikeKey(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.engineCapacity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this._storeKey = ((String) in.readValue((String.class.getClassLoader())));
        this.__v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.location, (Location.class.getClassLoader()));
        in.readList(this.pictures, (Object.class.getClassLoader()));
    }

    public _rentBikeKey() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String get_storeKey() {
        return _storeKey;
    }

    public void set_storeKey(String _storeKey) {
        this._storeKey = _storeKey;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
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
        dest.writeValue(_id);
        dest.writeValue(updatedAt);
        dest.writeValue(createdAt);
        dest.writeValue(model);
        dest.writeValue(brand);
        dest.writeValue(quantity);
        dest.writeValue(engineCapacity);
        dest.writeValue(status);
        dest.writeValue(_storeKey);
        dest.writeValue(__v);
        dest.writeList(location);
        dest.writeList(pictures);
    }

    public int describeContents() {
        return  0;
    }

}


package com.boongg.store.Models.Requests.MaintainanceBikes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintenanceBike implements Parcelable
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
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("_storeKey")
    @Expose
    private String _storeKey;
    @SerializedName("_rentPoolKey")
    @Expose
    private com.boongg.store.Models.Requests.MaintainanceBikes._rentPoolKey _rentPoolKey;
    @SerializedName("__v")
    @Expose
    private Integer __v;
    @SerializedName("blocking")
    @Expose
    private Blocking blocking;
    @SerializedName("isBlockBike")
    @Expose
    private Boolean isBlockBike;
    public final static Creator<MaintenanceBike> CREATOR = new Creator<MaintenanceBike>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MaintenanceBike createFromParcel(Parcel in) {
            return new MaintenanceBike(in);
        }

        public MaintenanceBike[] newArray(int size) {
            return (new MaintenanceBike[size]);
        }

    }
    ;

    protected MaintenanceBike(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this._storeKey = ((String) in.readValue((String.class.getClassLoader())));
        this._rentPoolKey = ((com.boongg.store.Models.Requests.MaintainanceBikes._rentPoolKey) in.readValue((_rentPoolKey.class.getClassLoader())));
        this.__v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.blocking = ((Blocking) in.readValue((Blocking.class.getClassLoader())));
        this.isBlockBike = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public MaintenanceBike() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String get_storeKey() {
        return _storeKey;
    }

    public void set_storeKey(String _storeKey) {
        this._storeKey = _storeKey;
    }

    public com.boongg.store.Models.Requests.MaintainanceBikes._rentPoolKey get_rentPoolKey() {
        return _rentPoolKey;
    }

    public void set_rentPoolKey(com.boongg.store.Models.Requests.MaintainanceBikes._rentPoolKey _rentPoolKey) {
        this._rentPoolKey = _rentPoolKey;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public Blocking getBlocking() {
        return blocking;
    }

    public void setBlocking(Blocking blocking) {
        this.blocking = blocking;
    }

    public Boolean getIsBlockBike() {
        return isBlockBike;
    }

    public void setIsBlockBike(Boolean isBlockBike) {
        this.isBlockBike = isBlockBike;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(updatedAt);
        dest.writeValue(createdAt);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeValue(brand);
        dest.writeValue(model);
        dest.writeValue(location);
        dest.writeValue(status);
        dest.writeValue(quantity);
        dest.writeValue(_storeKey);
        dest.writeValue(_rentPoolKey);
        dest.writeValue(__v);
        dest.writeValue(blocking);
        dest.writeValue(isBlockBike);
    }

    public int describeContents() {
        return  0;
    }

}

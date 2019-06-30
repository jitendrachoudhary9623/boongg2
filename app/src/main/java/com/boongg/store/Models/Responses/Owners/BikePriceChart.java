package com.boongg.store.Models.Responses.Owners;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BikePriceChart implements Parcelable
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
    private _storeKey _storeKey;
    @SerializedName("__v")
    @Expose
    private Integer __v;
    @SerializedName("location")
    @Expose
    private List<Location2> Location2 = null;
    @SerializedName("pictures")
    @Expose
    private List<Object> pictures = null;
    public final static Parcelable.Creator<BikePriceChart> CREATOR = new Creator<BikePriceChart>() {


        @SuppressWarnings({
                "unchecked"
        })
        public BikePriceChart createFromParcel(Parcel in) {
            return new BikePriceChart(in);
        }

        public BikePriceChart[] newArray(int size) {
            return (new BikePriceChart[size]);
        }

    }
            ;

    protected BikePriceChart(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.engineCapacity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this._storeKey = ((_storeKey) in.readValue((_storeKey.class.getClassLoader())));
        this.__v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.Location2, (Location2.class.getClassLoader()));
        in.readList(this.pictures, (java.lang.Object.class.getClassLoader()));
    }

    public BikePriceChart() {
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

    public _storeKey get_storeKey() {
        return _storeKey;
    }

    public void set_storeKey(_storeKey _storeKey) {
        this._storeKey = _storeKey;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public List<Location2> getLocation2() {
        return Location2;
    }

    public void setLocation2(List<Location2> Location2) {
        this.Location2 = Location2;
    }

    @Override
    public String toString() {
        return "BikePriceChart{" +
                "_id='" + _id + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", engineCapacity=" + engineCapacity +
                ", status='" + status + '\'' +
                ", _storeKey=" + _storeKey +
                ", __v=" + __v +
                ", Location2=" + Location2 +
                ", pictures=" + pictures +
                '}';
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
        dest.writeList(Location2);
        dest.writeList(pictures);
    }

    public int describeContents() {
        return 0;
    }

}


 class _storeKey implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("loc")
    @Expose
    private List<Integer> loc = null;
    @SerializedName("_city")
    @Expose
    private String _city;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("__v")
    @Expose
    private Integer __v;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("locality")
    @Expose
    private List<String> locality = null;
    @SerializedName("contact")
    @Expose
    private List<Object> contact = null;
    public final static Parcelable.Creator<_storeKey> CREATOR = new Creator<_storeKey>() {


        @SuppressWarnings({
                "unchecked"
        })
        public _storeKey createFromParcel(Parcel in) {
            return new _storeKey(in);
        }

        public _storeKey[] newArray(int size) {
            return (new _storeKey[size]);
        }

    }
            ;

    protected _storeKey(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.loc, (java.lang.Integer.class.getClassLoader()));
        this._city = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.isActive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.__v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.locality, (java.lang.String.class.getClassLoader()));
        in.readList(this.contact, (java.lang.Object.class.getClassLoader()));
    }

    public _storeKey() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Integer> getLoc() {
        return loc;
    }

    public void setLoc(List<Integer> loc) {
        this.loc = loc;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<String> getLocality() {
        return locality;
    }

    public void setLocality(List<String> locality) {
        this.locality = locality;
    }

    public List<Object> getContact() {
        return contact;
    }

    public void setContact(List<Object> contact) {
        this.contact = contact;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(name);
        dest.writeValue(address);
        dest.writeList(loc);
        dest.writeValue(_city);
        dest.writeValue(startDate);
        dest.writeValue(isActive);
        dest.writeValue(__v);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeList(locality);
        dest.writeList(contact);
    }

    public int describeContents() {
        return 0;
    }

}


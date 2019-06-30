package com.boongg.store.Models.Responses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class RentBikeResponse implements Parcelable
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
    private Double quantity;
    @SerializedName("engineCapacity")
    @Expose
    private Double engineCapacity;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_storeKey")
    @Expose
    private com.boongg.store.Models.Responses._storeKey _storeKey;
    @SerializedName("__v")
    @Expose
    private Double __v;
    @SerializedName("location")
    @Expose
    private List<Location> location = null;
    @SerializedName("pictures")
    @Expose
    private List<Object> pictures = null;
    public final static Parcelable.Creator<RentBikeResponse> CREATOR = new Creator<RentBikeResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RentBikeResponse createFromParcel(Parcel in) {
            return new RentBikeResponse(in);
        }

        public RentBikeResponse[] newArray(int size) {
            return (new RentBikeResponse[size]);
        }

    }
            ;

    protected RentBikeResponse(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.engineCapacity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this._storeKey = ((com.boongg.store.Models.Responses._storeKey) in.readValue((_storeKey.class.getClassLoader())));
        this.__v = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.location, (Location.class.getClassLoader()));
        in.readList(this.pictures, (java.lang.Object.class.getClassLoader()));
    }

    public RentBikeResponse() {
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public com.boongg.store.Models.Responses._storeKey get_storeKey() {
        return _storeKey;
    }

    public void set_storeKey(com.boongg.store.Models.Responses._storeKey _storeKey) {
        this._storeKey = _storeKey;
    }

    public Double get__v() {
        return __v;
    }

    public void set__v(Double __v) {
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
        return 0;
    }

}


class PriceChart implements Parcelable
{

    @SerializedName("weekdays")
    @Expose
    private Double weekdays;
    @SerializedName("weekend")
    @Expose
    private Double weekend;
    @SerializedName("hourlyRate")
    @Expose
    private Double hourlyRate;
    @SerializedName("kmsLimit")
    @Expose
    private Double kmsLimit;
    @SerializedName("extraKMS")
    @Expose
    private Double extraKMS;
    @SerializedName("extraHRS")
    @Expose
    private Double extraHRS;
    @SerializedName("monthly")
    @Expose
    private Double monthly;
    @SerializedName("fifteenDays")
    @Expose
    private Double fifteenDays;
    @SerializedName("twoDayRate")
    @Expose
    private Double twoDayRate;
    @SerializedName("threeDayRate")
    @Expose
    private Double threeDayRate;
    @SerializedName("fourDayRate")
    @Expose
    private Double fourDayRate;
    @SerializedName("fiveDayRate")
    @Expose
    private Double fiveDayRate;
    @SerializedName("sixDayRate")
    @Expose
    private Double sixDayRate;
    @SerializedName("sevenDayRate")
    @Expose
    private Double sevenDayRate;
    @SerializedName("tenDayRate")
    @Expose
    private Double tenDayRate;
    @SerializedName("twentyDayRate")
    @Expose
    private Double twentyDayRate;
    @SerializedName("isAdminRentApplied")
    @Expose
    private Boolean isAdminRentApplied;
    public final static Parcelable.Creator<PriceChart> CREATOR = new Creator<PriceChart>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PriceChart createFromParcel(Parcel in) {
            return new PriceChart(in);
        }

        public PriceChart[] newArray(int size) {
            return (new PriceChart[size]);
        }

    }
            ;

    protected PriceChart(Parcel in) {
        this.weekdays = ((Double) in.readValue((Double.class.getClassLoader())));
        this.weekend = ((Double) in.readValue((Double.class.getClassLoader())));
        this.hourlyRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.kmsLimit = ((Double) in.readValue((Double.class.getClassLoader())));
        this.extraKMS = ((Double) in.readValue((Double.class.getClassLoader())));
        this.extraHRS = ((Double) in.readValue((Double.class.getClassLoader())));
        this.monthly = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fifteenDays = ((Double) in.readValue((Double.class.getClassLoader())));
        this.twoDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.threeDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fourDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fiveDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.sixDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.sevenDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.tenDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.twentyDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.isAdminRentApplied = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public PriceChart() {
    }

    public Double getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Double weekdays) {
        this.weekdays = weekdays;
    }

    public Double getWeekend() {
        return weekend;
    }

    public void setWeekend(Double weekend) {
        this.weekend = weekend;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Double getKmsLimit() {
        return kmsLimit;
    }

    public void setKmsLimit(Double kmsLimit) {
        this.kmsLimit = kmsLimit;
    }

    public Double getExtraKMS() {
        return extraKMS;
    }

    public void setExtraKMS(Double extraKMS) {
        this.extraKMS = extraKMS;
    }

    public Double getExtraHRS() {
        return extraHRS;
    }

    public void setExtraHRS(Double extraHRS) {
        this.extraHRS = extraHRS;
    }

    public Double getMonthly() {
        return monthly;
    }

    public void setMonthly(Double monthly) {
        this.monthly = monthly;
    }

    public Double getFifteenDays() {
        return fifteenDays;
    }

    public void setFifteenDays(Double fifteenDays) {
        this.fifteenDays = fifteenDays;
    }

    public Double getTwoDayRate() {
        return twoDayRate;
    }

    public void setTwoDayRate(Double twoDayRate) {
        this.twoDayRate = twoDayRate;
    }

    public Double getThreeDayRate() {
        return threeDayRate;
    }

    public void setThreeDayRate(Double threeDayRate) {
        this.threeDayRate = threeDayRate;
    }

    public Double getFourDayRate() {
        return fourDayRate;
    }

    public void setFourDayRate(Double fourDayRate) {
        this.fourDayRate = fourDayRate;
    }

    public Double getFiveDayRate() {
        return fiveDayRate;
    }

    public void setFiveDayRate(Double fiveDayRate) {
        this.fiveDayRate = fiveDayRate;
    }

    public Double getSixDayRate() {
        return sixDayRate;
    }

    public void setSixDayRate(Double sixDayRate) {
        this.sixDayRate = sixDayRate;
    }

    public Double getSevenDayRate() {
        return sevenDayRate;
    }

    public void setSevenDayRate(Double sevenDayRate) {
        this.sevenDayRate = sevenDayRate;
    }

    public Double getTenDayRate() {
        return tenDayRate;
    }

    public void setTenDayRate(Double tenDayRate) {
        this.tenDayRate = tenDayRate;
    }

    public Double getTwentyDayRate() {
        return twentyDayRate;
    }

    public void setTwentyDayRate(Double twentyDayRate) {
        this.twentyDayRate = twentyDayRate;
    }

    public Boolean getIsAdminRentApplied() {
        return isAdminRentApplied;
    }

    public void setIsAdminRentApplied(Boolean isAdminRentApplied) {
        this.isAdminRentApplied = isAdminRentApplied;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(weekdays);
        dest.writeValue(weekend);
        dest.writeValue(hourlyRate);
        dest.writeValue(kmsLimit);
        dest.writeValue(extraKMS);
        dest.writeValue(extraHRS);
        dest.writeValue(monthly);
        dest.writeValue(fifteenDays);
        dest.writeValue(twoDayRate);
        dest.writeValue(threeDayRate);
        dest.writeValue(fourDayRate);
        dest.writeValue(fiveDayRate);
        dest.writeValue(sixDayRate);
        dest.writeValue(sevenDayRate);
        dest.writeValue(tenDayRate);
        dest.writeValue(twentyDayRate);
        dest.writeValue(isAdminRentApplied);
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
    private List<Double> loc = null;
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
    private Double __v;
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
        in.readList(this.loc, (java.lang.Double.class.getClassLoader()));
        this._city = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.isActive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.__v = ((Double) in.readValue((Double.class.getClassLoader())));
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

    public List<Double> getLoc() {
        return loc;
    }

    public void setLoc(List<Double> loc) {
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

    public Double get__v() {
        return __v;
    }

    public void set__v(Double __v) {
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
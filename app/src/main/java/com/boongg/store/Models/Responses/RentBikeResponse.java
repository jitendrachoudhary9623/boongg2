package com.boongg.store.Models.Responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
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
    private Integer quantity;
    @SerializedName("engineCapacity")
    @Expose
    private Integer engineCapacity;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_storeKey")
    @Expose
    private com.boongg.store.Models.Responses._storeKey _storeKey;
    @SerializedName("__v")
    @Expose
    private Integer __v;
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
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.engineCapacity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this._storeKey = ((com.boongg.store.Models.Responses._storeKey) in.readValue((_storeKey.class.getClassLoader())));
        this.__v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.location, (com.boongg.store.Models.Responses.Location.class.getClassLoader()));
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

    public com.boongg.store.Models.Responses._storeKey get_storeKey() {
        return _storeKey;
    }

    public void set_storeKey(com.boongg.store.Models.Responses._storeKey _storeKey) {
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
        return 0;
    }

}

class Location implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("priceChart")
    @Expose
    private PriceChart priceChart;
    public final static Parcelable.Creator<Location> CREATOR = new Creator<Location>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        public Location[] newArray(int size) {
            return (new Location[size]);
        }

    }
            ;

    protected Location(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.priceChart = ((PriceChart) in.readValue((PriceChart.class.getClassLoader())));
    }

    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public PriceChart getPriceChart() {
        return priceChart;
    }

    public void setPriceChart(PriceChart priceChart) {
        this.priceChart = priceChart;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(_id);
        dest.writeValue(priceChart);
    }

    public int describeContents() {
        return 0;
    }

}
class PriceChart implements Parcelable
{

    @SerializedName("weekdays")
    @Expose
    private Integer weekdays;
    @SerializedName("weekend")
    @Expose
    private Integer weekend;
    @SerializedName("hourlyRate")
    @Expose
    private Integer hourlyRate;
    @SerializedName("kmsLimit")
    @Expose
    private Integer kmsLimit;
    @SerializedName("extraKMS")
    @Expose
    private Integer extraKMS;
    @SerializedName("extraHRS")
    @Expose
    private Integer extraHRS;
    @SerializedName("monthly")
    @Expose
    private Integer monthly;
    @SerializedName("fifteenDays")
    @Expose
    private Integer fifteenDays;
    @SerializedName("twoDayRate")
    @Expose
    private Integer twoDayRate;
    @SerializedName("threeDayRate")
    @Expose
    private Integer threeDayRate;
    @SerializedName("fourDayRate")
    @Expose
    private Integer fourDayRate;
    @SerializedName("fiveDayRate")
    @Expose
    private Integer fiveDayRate;
    @SerializedName("sixDayRate")
    @Expose
    private Integer sixDayRate;
    @SerializedName("sevenDayRate")
    @Expose
    private Integer sevenDayRate;
    @SerializedName("tenDayRate")
    @Expose
    private Integer tenDayRate;
    @SerializedName("twentyDayRate")
    @Expose
    private Integer twentyDayRate;
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
        this.weekdays = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.weekend = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hourlyRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.kmsLimit = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.extraKMS = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.extraHRS = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.monthly = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fifteenDays = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.twoDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.threeDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fourDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fiveDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sixDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sevenDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.tenDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.twentyDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isAdminRentApplied = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public PriceChart() {
    }

    public Integer getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Integer weekdays) {
        this.weekdays = weekdays;
    }

    public Integer getWeekend() {
        return weekend;
    }

    public void setWeekend(Integer weekend) {
        this.weekend = weekend;
    }

    public Integer getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Integer hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Integer getKmsLimit() {
        return kmsLimit;
    }

    public void setKmsLimit(Integer kmsLimit) {
        this.kmsLimit = kmsLimit;
    }

    public Integer getExtraKMS() {
        return extraKMS;
    }

    public void setExtraKMS(Integer extraKMS) {
        this.extraKMS = extraKMS;
    }

    public Integer getExtraHRS() {
        return extraHRS;
    }

    public void setExtraHRS(Integer extraHRS) {
        this.extraHRS = extraHRS;
    }

    public Integer getMonthly() {
        return monthly;
    }

    public void setMonthly(Integer monthly) {
        this.monthly = monthly;
    }

    public Integer getFifteenDays() {
        return fifteenDays;
    }

    public void setFifteenDays(Integer fifteenDays) {
        this.fifteenDays = fifteenDays;
    }

    public Integer getTwoDayRate() {
        return twoDayRate;
    }

    public void setTwoDayRate(Integer twoDayRate) {
        this.twoDayRate = twoDayRate;
    }

    public Integer getThreeDayRate() {
        return threeDayRate;
    }

    public void setThreeDayRate(Integer threeDayRate) {
        this.threeDayRate = threeDayRate;
    }

    public Integer getFourDayRate() {
        return fourDayRate;
    }

    public void setFourDayRate(Integer fourDayRate) {
        this.fourDayRate = fourDayRate;
    }

    public Integer getFiveDayRate() {
        return fiveDayRate;
    }

    public void setFiveDayRate(Integer fiveDayRate) {
        this.fiveDayRate = fiveDayRate;
    }

    public Integer getSixDayRate() {
        return sixDayRate;
    }

    public void setSixDayRate(Integer sixDayRate) {
        this.sixDayRate = sixDayRate;
    }

    public Integer getSevenDayRate() {
        return sevenDayRate;
    }

    public void setSevenDayRate(Integer sevenDayRate) {
        this.sevenDayRate = sevenDayRate;
    }

    public Integer getTenDayRate() {
        return tenDayRate;
    }

    public void setTenDayRate(Integer tenDayRate) {
        this.tenDayRate = tenDayRate;
    }

    public Integer getTwentyDayRate() {
        return twentyDayRate;
    }

    public void setTwentyDayRate(Integer twentyDayRate) {
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
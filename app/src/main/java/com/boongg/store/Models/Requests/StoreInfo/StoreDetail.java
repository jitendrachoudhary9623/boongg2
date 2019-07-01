
package com.boongg.store.Models.Requests.StoreInfo;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreDetail implements Parcelable
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
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("_city")
    @Expose
    private com.boongg.store.Models.Requests.StoreInfo._city _city;
    @SerializedName("gstNumber")
    @Expose
    private String gstNumber;
    @SerializedName("pancardNumer")
    @Expose
    private String pancardNumer;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("__v")
    @Expose
    private Integer __v;
    @SerializedName("locality")
    @Expose
    private List<String> locality = null;
    @SerializedName("contact")
    @Expose
    private List<Object> contact = null;
    @SerializedName("loc")
    @Expose
    private List<Integer> loc = null;
    public final static Creator<StoreDetail> CREATOR = new Creator<StoreDetail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public StoreDetail createFromParcel(Parcel in) {
            return new StoreDetail(in);
        }

        public StoreDetail[] newArray(int size) {
            return (new StoreDetail[size]);
        }

    }
    ;

    protected StoreDetail(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
        this._city = ((com.boongg.store.Models.Requests.StoreInfo._city) in.readValue((_city.class.getClassLoader())));
        this.gstNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.pancardNumer = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.isActive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.__v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.locality, (String.class.getClassLoader()));
        in.readList(this.contact, (Object.class.getClassLoader()));
        in.readList(this.loc, (Integer.class.getClassLoader()));
    }

    public StoreDetail() {
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public com.boongg.store.Models.Requests.StoreInfo._city get_city() {
        return _city;
    }

    public void set_city(com.boongg.store.Models.Requests.StoreInfo._city _city) {
        this._city = _city;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getPancardNumer() {
        return pancardNumer;
    }

    public void setPancardNumer(String pancardNumer) {
        this.pancardNumer = pancardNumer;
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

    public List<Integer> getLoc() {
        return loc;
    }

    public void setLoc(List<Integer> loc) {
        this.loc = loc;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(name);
        dest.writeValue(address);
        dest.writeValue(longitude);
        dest.writeValue(latitude);
        dest.writeValue(_city);
        dest.writeValue(gstNumber);
        dest.writeValue(pancardNumer);
        dest.writeValue(startDate);
        dest.writeValue(isActive);
        dest.writeValue(__v);
        dest.writeList(locality);
        dest.writeList(contact);
        dest.writeList(loc);
    }

    public int describeContents() {
        return  0;
    }

}

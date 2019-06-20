
package com.boongg.store.Models.Responses.Owners;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner implements Parcelable
{

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", loc=" + loc +
                ", city=" + city +
                ", gstNumber='" + gstNumber + '\'' +
                ", pancardNumer='" + pancardNumer + '\'' +
                ", startDate='" + startDate + '\'' +
                ", isActive=" + isActive +
                ", v=" + v +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", locality=" + locality +
                ", contact=" + contact +
                '}';
    }

    @SerializedName("_id")
    @Expose
    private String id;
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
    private City city;
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
    private Integer v;
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
    public final static Parcelable.Creator<Owner> CREATOR = new Creator<Owner>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        public Owner[] newArray(int size) {
            return (new Owner[size]);
        }

    }
    ;

    protected Owner(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.loc, (java.lang.Integer.class.getClassLoader()));
        this.city = ((City) in.readValue((City.class.getClassLoader())));
        this.gstNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.pancardNumer = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.isActive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.locality, (java.lang.String.class.getClassLoader()));
        in.readList(this.contact, (java.lang.Object.class.getClassLoader()));
    }

    public Owner() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
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
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(address);
        dest.writeList(loc);
        dest.writeValue(city);
        dest.writeValue(gstNumber);
        dest.writeValue(pancardNumer);
        dest.writeValue(startDate);
        dest.writeValue(isActive);
        dest.writeValue(v);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeList(locality);
        dest.writeList(contact);
    }

    public int describeContents() {
        return  0;
    }

}

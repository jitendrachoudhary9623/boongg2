
package com.boongg.store.Models.Responses.NearbyVehicles;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Locality implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("_city")
    @Expose
    private City city;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("__v")
    @Expose
    private Double v;
    public final static Parcelable.Creator<Locality> CREATOR = new Creator<Locality>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Locality createFromParcel(Parcel in) {
            return new Locality(in);
        }

        public Locality[] newArray(int size) {
            return (new Locality[size]);
        }

    }
    ;

    protected Locality(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.latitude = ((Double) in.readValue((Double.class.getClassLoader())));
        this.longitude = ((Double) in.readValue((Double.class.getClassLoader())));
        this.city = ((City) in.readValue((City.class.getClassLoader())));
        this.isActive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.v = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public Locality() {
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(city);
        dest.writeValue(isActive);
        dest.writeValue(v);
    }

    public int describeContents() {
        return  0;
    }

}

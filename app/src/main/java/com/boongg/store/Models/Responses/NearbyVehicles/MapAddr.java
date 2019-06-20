
package com.boongg.store.Models.Responses.NearbyVehicles;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MapAddr implements Parcelable
{

    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    public final static Parcelable.Creator<MapAddr> CREATOR = new Creator<MapAddr>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MapAddr createFromParcel(Parcel in) {
            return new MapAddr(in);
        }

        public MapAddr[] newArray(int size) {
            return (new MapAddr[size]);
        }

    }
    ;

    protected MapAddr(Parcel in) {
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
    }

    public MapAddr() {
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(latitude);
        dest.writeValue(longitude);
    }

    public int describeContents() {
        return  0;
    }

}

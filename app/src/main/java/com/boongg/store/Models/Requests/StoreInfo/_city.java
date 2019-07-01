
package com.boongg.store.Models.Requests.StoreInfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _city implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("latitude")
    @Expose
    private Integer latitude;
    @SerializedName("longitude")
    @Expose
    private Integer longitude;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("__v")
    @Expose
    private Integer __v;
    public final static Creator<_city> CREATOR = new Creator<_city>() {


        @SuppressWarnings({
            "unchecked"
        })
        public _city createFromParcel(Parcel in) {
            return new _city(in);
        }

        public _city[] newArray(int size) {
            return (new _city[size]);
        }

    }
    ;

    protected _city(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.latitude = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.longitude = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isActive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.__v = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public _city() {
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

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(name);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(isActive);
        dest.writeValue(__v);
    }

    public int describeContents() {
        return  0;
    }

}

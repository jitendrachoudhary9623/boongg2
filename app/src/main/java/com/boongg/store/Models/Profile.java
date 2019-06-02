
package com.boongg.store.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile implements Parcelable
{

    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<Profile> CREATOR = new Creator<Profile>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        public Profile[] newArray(int size) {
            return (new Profile[size]);
        }

    }
    ;

    protected Profile(Parcel in) {
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.picture = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.mobileNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Profile() {
    }

    /**
     * 
     * @param picture
     * @param location
     * @param name
     * @param gender
     * @param mobileNumber
     */
    public Profile(String location, String picture, String gender, String mobileNumber, String name) {
        super();
        this.location = location;
        this.picture = picture;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(location);
        dest.writeValue(picture);
        dest.writeValue(gender);
        dest.writeValue(mobileNumber);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}

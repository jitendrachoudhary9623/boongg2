package com.boongg.store.Models.Requests;


import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateUser implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("email")
    @Expose
    private String email;

    public CreateUser(String name, String mobileNumber, String email) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public final static Parcelable.Creator<CreateUser> CREATOR = new Creator<CreateUser>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CreateUser createFromParcel(Parcel in) {
            return new CreateUser(in);
        }

        public CreateUser[] newArray(int size) {
            return (new CreateUser[size]);
        }

    }
            ;

    protected CreateUser(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.mobileNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CreateUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(mobileNumber);
        dest.writeValue(email);
    }

    public int describeContents() {
        return 0;
    }

}
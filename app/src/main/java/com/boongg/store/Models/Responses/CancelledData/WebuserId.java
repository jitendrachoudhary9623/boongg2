
package com.boongg.store.Models.Responses.CancelledData;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WebuserId implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("otp")
    @Expose
    private String otp;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("isMobileVerified")
    @Expose
    private Boolean isMobileVerified;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    public final static Parcelable.Creator<WebuserId> CREATOR = new Creator<WebuserId>() {


        @SuppressWarnings({
            "unchecked"
        })
        public WebuserId createFromParcel(Parcel in) {
            return new WebuserId(in);
        }

        public WebuserId[] newArray(int size) {
            return (new WebuserId[size]);
        }

    }
    ;

    protected WebuserId(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.otp = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.isMobileVerified = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.profile = ((Profile) in.readValue((Profile.class.getClassLoader())));
    }

    public WebuserId() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(Boolean isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(otp);
        dest.writeValue(email);
        dest.writeValue(isMobileVerified);
        dest.writeValue(profile);
    }

    public int describeContents() {
        return  0;
    }

}

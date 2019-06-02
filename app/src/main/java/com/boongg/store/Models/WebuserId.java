
package com.boongg.store.Models;

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
    @SerializedName("passwordResetExpires")
    @Expose
    private String passwordResetExpires;
    @SerializedName("passwordResetToken")
    @Expose
    private String passwordResetToken;
    @SerializedName("isMobileVerified")
    @Expose
    private Boolean isMobileVerified;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("optCreatedOn")
    @Expose
    private String optCreatedOn;
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
        this.passwordResetExpires = ((String) in.readValue((String.class.getClassLoader())));
        this.passwordResetToken = ((String) in.readValue((String.class.getClassLoader())));
        this.isMobileVerified = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.profile = ((Profile) in.readValue((Profile.class.getClassLoader())));
        this.optCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public WebuserId() {
    }

    /**
     * 
     * @param id
     * @param optCreatedOn
     * @param email
     * @param passwordResetExpires
     * @param passwordResetToken
     * @param otp
     * @param profile
     * @param isMobileVerified
     */
    public WebuserId(String id, String otp, String email, String passwordResetExpires, String passwordResetToken, Boolean isMobileVerified, Profile profile, String optCreatedOn) {
        super();
        this.id = id;
        this.otp = otp;
        this.email = email;
        this.passwordResetExpires = passwordResetExpires;
        this.passwordResetToken = passwordResetToken;
        this.isMobileVerified = isMobileVerified;
        this.profile = profile;
        this.optCreatedOn = optCreatedOn;
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

    public String getPasswordResetExpires() {
        return passwordResetExpires;
    }

    public void setPasswordResetExpires(String passwordResetExpires) {
        this.passwordResetExpires = passwordResetExpires;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
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

    public String getOptCreatedOn() {
        return optCreatedOn;
    }

    public void setOptCreatedOn(String optCreatedOn) {
        this.optCreatedOn = optCreatedOn;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(otp);
        dest.writeValue(email);
        dest.writeValue(passwordResetExpires);
        dest.writeValue(passwordResetToken);
        dest.writeValue(isMobileVerified);
        dest.writeValue(profile);
        dest.writeValue(optCreatedOn);
    }

    public int describeContents() {
        return  0;
    }

}

package com.boongg.store.Models.Responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.boongg.store.Models.Responses.Profile;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyOtpResponse implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String _id;
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
    @SerializedName("profile")
    @Expose
    private Profile profile;
    public final static Parcelable.Creator<VerifyOtpResponse> CREATOR = new Creator<VerifyOtpResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public VerifyOtpResponse createFromParcel(Parcel in) {
            return new VerifyOtpResponse(in);
        }

        public VerifyOtpResponse[] newArray(int size) {
            return (new VerifyOtpResponse[size]);
        }

    }
            ;

    protected VerifyOtpResponse(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.otp = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.passwordResetExpires = ((String) in.readValue((String.class.getClassLoader())));
        this.passwordResetToken = ((String) in.readValue((String.class.getClassLoader())));
        this.profile = ((Profile) in.readValue((Profile.class.getClassLoader())));
    }

    public VerifyOtpResponse() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(otp);
        dest.writeValue(email);
        dest.writeValue(passwordResetExpires);
        dest.writeValue(passwordResetToken);
        dest.writeValue(profile);
    }

    public int describeContents() {
        return 0;
    }

}
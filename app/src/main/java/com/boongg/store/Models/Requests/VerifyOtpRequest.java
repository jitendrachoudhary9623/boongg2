package com.boongg.store.Models.Requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyOtpRequest implements Parcelable
{

    @SerializedName("emailid")
    @Expose
    private String emailid;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("otp")
    @Expose
    private String otp;
    public final static Parcelable.Creator<VerifyOtpRequest> CREATOR = new Creator<VerifyOtpRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public VerifyOtpRequest createFromParcel(Parcel in) {
            return new VerifyOtpRequest(in);
        }

        public VerifyOtpRequest[] newArray(int size) {
            return (new VerifyOtpRequest[size]);
        }

    }
            ;

    protected VerifyOtpRequest(Parcel in) {
        this.emailid = ((String) in.readValue((String.class.getClassLoader())));
        this.mobile = ((String) in.readValue((String.class.getClassLoader())));
        this.otp = ((String) in.readValue((String.class.getClassLoader())));
    }

    public VerifyOtpRequest() {
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public VerifyOtpRequest(String emailid, String mobile, String otp) {
        this.emailid = emailid;
        this.mobile = mobile;
        this.otp = otp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(emailid);
        dest.writeValue(mobile);
        dest.writeValue(otp);
    }

    public int describeContents() {
        return 0;
    }

}
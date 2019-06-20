package com.boongg.store.Models.Requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendOtpRequest implements Parcelable
{

    @SerializedName("emailid")
    @Expose
    private String emailid;

    public SendOtpRequest(String emailid, String mobile) {
        this.emailid = emailid;
        this.mobile = mobile;
    }

    @SerializedName("mobile")
    @Expose
    private String mobile;
    public final static Parcelable.Creator<SendOtpRequest> CREATOR = new Creator<SendOtpRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SendOtpRequest createFromParcel(Parcel in) {
            return new SendOtpRequest(in);
        }

        public SendOtpRequest[] newArray(int size) {
            return (new SendOtpRequest[size]);
        }

    }
            ;

    protected SendOtpRequest(Parcel in) {
        this.emailid = ((String) in.readValue((String.class.getClassLoader())));
        this.mobile = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SendOtpRequest() {
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(emailid);
        dest.writeValue(mobile);
    }

    public int describeContents() {
        return 0;
    }

}
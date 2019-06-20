package com.boongg.store.Models.Responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendOtpResponse implements Parcelable
{

    @SerializedName("otp")
    @Expose
    private String otp;
    public final static Parcelable.Creator<SendOtpResponse> CREATOR = new Creator<SendOtpResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SendOtpResponse createFromParcel(Parcel in) {
            return new SendOtpResponse(in);
        }

        public SendOtpResponse[] newArray(int size) {
            return (new SendOtpResponse[size]);
        }

    }
            ;

    protected SendOtpResponse(Parcel in) {
        this.otp = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SendOtpResponse() {
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(otp);
    }

    public int describeContents() {
        return 0;
    }

}
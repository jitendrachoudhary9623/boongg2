package com.boongg.store.Models.Responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtendDateResponse implements Parcelable
{

    @SerializedName("calculatedRent")
    @Expose
    private Integer calculatedRent;
    public final static Parcelable.Creator<ExtendDateResponse> CREATOR = new Creator<ExtendDateResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExtendDateResponse createFromParcel(Parcel in) {
            return new ExtendDateResponse(in);
        }

        public ExtendDateResponse[] newArray(int size) {
            return (new ExtendDateResponse[size]);
        }

    }
            ;

    protected ExtendDateResponse(Parcel in) {
        this.calculatedRent = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public ExtendDateResponse() {
    }

    public Integer getCalculatedRent() {
        return calculatedRent;
    }

    public void setCalculatedRent(Integer calculatedRent) {
        this.calculatedRent = calculatedRent;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(calculatedRent);
    }

    public int describeContents() {
        return 0;
    }

}
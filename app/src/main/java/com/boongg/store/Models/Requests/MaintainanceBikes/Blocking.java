
package com.boongg.store.Models.Requests.MaintainanceBikes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Blocking implements Parcelable
{

    @SerializedName("reason")
    @Expose
    private String reason;
    public final static Creator<Blocking> CREATOR = new Creator<Blocking>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Blocking createFromParcel(Parcel in) {
            return new Blocking(in);
        }

        public Blocking[] newArray(int size) {
            return (new Blocking[size]);
        }

    }
    ;

    protected Blocking(Parcel in) {
        this.reason = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Blocking() {
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(reason);
    }

    public int describeContents() {
        return  0;
    }

}

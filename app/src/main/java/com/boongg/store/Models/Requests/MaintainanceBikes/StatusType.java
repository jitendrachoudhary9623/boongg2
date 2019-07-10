
package com.boongg.store.Models.Requests.MaintainanceBikes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusType implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    public final static Creator<StatusType> CREATOR = new Creator<StatusType>() {


        @SuppressWarnings({
            "unchecked"
        })
        public StatusType createFromParcel(Parcel in) {
            return new StatusType(in);
        }

        public StatusType[] newArray(int size) {
            return (new StatusType[size]);
        }

    }
    ;

    protected StatusType(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
    }

    public StatusType() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
    }

    public int describeContents() {
        return  0;
    }

}

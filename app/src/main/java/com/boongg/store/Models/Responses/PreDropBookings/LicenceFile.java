
package com.boongg.store.Models.Responses.PreDropBookings;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LicenceFile implements Parcelable
{

    @SerializedName("fullUrl")
    @Expose
    private String fullUrl;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("_id")
    @Expose
    private String _id;
    public final static Parcelable.Creator<LicenceFile> CREATOR = new Creator<LicenceFile>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LicenceFile createFromParcel(Parcel in) {
            return new LicenceFile(in);
        }

        public LicenceFile[] newArray(int size) {
            return (new LicenceFile[size]);
        }

    }
    ;

    protected LicenceFile(Parcel in) {
        this.fullUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.expiryDate = ((String) in.readValue((String.class.getClassLoader())));
        this._id = ((String) in.readValue((String.class.getClassLoader())));
    }

    public LicenceFile() {
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(fullUrl);
        dest.writeValue(expiryDate);
        dest.writeValue(_id);
    }

    public int describeContents() {
        return  0;
    }

}

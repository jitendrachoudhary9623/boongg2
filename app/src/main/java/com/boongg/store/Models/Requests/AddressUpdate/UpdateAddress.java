
package com.boongg.store.Models.Requests.AddressUpdate;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.boongg.store.Models.Responses.SearchUSer;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateAddress implements Parcelable
{

    @SerializedName("id")
    @Expose
    private SearchUSer id;
    @SerializedName("address")
    @Expose
    private String address;
    public final static Creator<UpdateAddress> CREATOR = new Creator<UpdateAddress>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UpdateAddress createFromParcel(Parcel in) {
            return new UpdateAddress(in);
        }

        public UpdateAddress[] newArray(int size) {
            return (new UpdateAddress[size]);
        }

    }
    ;

    protected UpdateAddress(Parcel in) {
        this.id = ((SearchUSer) in.readValue((SearchUSer.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UpdateAddress() {
    }

    public SearchUSer getId() {
        return id;
    }

    public void setId(SearchUSer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(address);
    }

    public int describeContents() {
        return  0;
    }

}

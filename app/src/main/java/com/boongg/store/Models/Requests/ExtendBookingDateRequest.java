package com.boongg.store.Models.Requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtendBookingDateRequest implements Parcelable
{

    @SerializedName("scheduleTime")
    @Expose
    private Object scheduleTime;
    @SerializedName("bookingId")
    @Expose
    private Object bookingId;
    @SerializedName("suggestedExtendedRent")
    @Expose
    private Object suggestedExtendedRent;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("model")
    @Expose
    private String model;
    public final static Parcelable.Creator<ExtendBookingDateRequest> CREATOR = new Creator<ExtendBookingDateRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExtendBookingDateRequest createFromParcel(Parcel in) {
            return new ExtendBookingDateRequest(in);
        }

        public ExtendBookingDateRequest[] newArray(int size) {
            return (new ExtendBookingDateRequest[size]);
        }

    }
            ;

    protected ExtendBookingDateRequest(Parcel in) {
        this.scheduleTime = ((Object) in.readValue((Object.class.getClassLoader())));
        this.bookingId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.suggestedExtendedRent = ((Object) in.readValue((Object.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExtendBookingDateRequest() {
    }

    public Object getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Object scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Object getBookingId() {
        return bookingId;
    }

    public void setBookingId(Object bookingId) {
        this.bookingId = bookingId;
    }

    public Object getSuggestedExtendedRent() {
        return suggestedExtendedRent;
    }

    public void setSuggestedExtendedRent(Object suggestedExtendedRent) {
        this.suggestedExtendedRent = suggestedExtendedRent;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(scheduleTime);
        dest.writeValue(bookingId);
        dest.writeValue(suggestedExtendedRent);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeValue(brand);
        dest.writeValue(model);
    }

    public int describeContents() {
        return 0;
    }

}
package com.boongg.store.Models.Requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtendDateAfterRentRequest implements Parcelable
{

    @SerializedName("scheduleTime")
    @Expose
    private String scheduleTime;
    @SerializedName("bookingId")
    @Expose
    private String bookingId;
    @SerializedName("suggestedExtendedRent")
    @Expose
    private Integer suggestedExtendedRent;
    @SerializedName("isGstApplicable")
    @Expose
    private Boolean isGstApplicable;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("totalExtendedBikeRent")
    @Expose
    private Integer totalExtendedBikeRent;
    @SerializedName("rentPoolKey")
    @Expose
    private String rentPoolKey;
    public final static Parcelable.Creator<ExtendDateAfterRentRequest> CREATOR = new Creator<ExtendDateAfterRentRequest>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExtendDateAfterRentRequest createFromParcel(Parcel in) {
            return new ExtendDateAfterRentRequest(in);
        }

        public ExtendDateAfterRentRequest[] newArray(int size) {
            return (new ExtendDateAfterRentRequest[size]);
        }

    }
            ;

    protected ExtendDateAfterRentRequest(Parcel in) {
        this.scheduleTime = ((String) in.readValue((String.class.getClassLoader())));
        this.bookingId = ((String) in.readValue((String.class.getClassLoader())));
        this.suggestedExtendedRent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isGstApplicable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.totalExtendedBikeRent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rentPoolKey = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExtendDateAfterRentRequest() {
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getSuggestedExtendedRent() {
        return suggestedExtendedRent;
    }

    public void setSuggestedExtendedRent(Integer suggestedExtendedRent) {
        this.suggestedExtendedRent = suggestedExtendedRent;
    }

    public Boolean getIsGstApplicable() {
        return isGstApplicable;
    }

    public void setIsGstApplicable(Boolean isGstApplicable) {
        this.isGstApplicable = isGstApplicable;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getTotalExtendedBikeRent() {
        return totalExtendedBikeRent;
    }

    public void setTotalExtendedBikeRent(Integer totalExtendedBikeRent) {
        this.totalExtendedBikeRent = totalExtendedBikeRent;
    }

    public String getRentPoolKey() {
        return rentPoolKey;
    }

    public void setRentPoolKey(String rentPoolKey) {
        this.rentPoolKey = rentPoolKey;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(scheduleTime);
        dest.writeValue(bookingId);
        dest.writeValue(suggestedExtendedRent);
        dest.writeValue(isGstApplicable);
        dest.writeValue(startDate);
        dest.writeValue(totalExtendedBikeRent);
        dest.writeValue(rentPoolKey);
    }

    public int describeContents() {
        return 0;
    }

}
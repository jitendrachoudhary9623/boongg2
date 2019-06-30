
package com.boongg.store.Models.Responses.CancelledData;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceChart implements Parcelable
{

    @SerializedName("weekdays")
    @Expose
    private Double weekdays;
    @SerializedName("weekend")
    @Expose
    private Double weekend;
    @SerializedName("hourlyRate")
    @Expose
    private Double hourlyRate;
    @SerializedName("kmsLimit")
    @Expose
    private Double kmsLimit;
    @SerializedName("extraKMS")
    @Expose
    private Double extraKMS;
    @SerializedName("extraHRS")
    @Expose
    private Double extraHRS;
    @SerializedName("monthly")
    @Expose
    private Double monthly;
    @SerializedName("fifteenDays")
    @Expose
    private Double fifteenDays;
    @SerializedName("twoDayRate")
    @Expose
    private Double twoDayRate;
    @SerializedName("threeDayRate")
    @Expose
    private Double threeDayRate;
    @SerializedName("fourDayRate")
    @Expose
    private Double fourDayRate;
    @SerializedName("fiveDayRate")
    @Expose
    private Double fiveDayRate;
    @SerializedName("sixDayRate")
    @Expose
    private Double sixDayRate;
    @SerializedName("sevenDayRate")
    @Expose
    private Double sevenDayRate;
    @SerializedName("tenDayRate")
    @Expose
    private Double tenDayRate;
    @SerializedName("twentyDayRate")
    @Expose
    private Double twentyDayRate;
    @SerializedName("isAdminRentApplied")
    @Expose
    private Boolean isAdminRentApplied;
    public final static Parcelable.Creator<PriceChart> CREATOR = new Creator<PriceChart>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PriceChart createFromParcel(Parcel in) {
            return new PriceChart(in);
        }

        public PriceChart[] newArray(int size) {
            return (new PriceChart[size]);
        }

    }
    ;

    protected PriceChart(Parcel in) {
        this.weekdays = ((Double) in.readValue((Double.class.getClassLoader())));
        this.weekend = ((Double) in.readValue((Double.class.getClassLoader())));
        this.hourlyRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.kmsLimit = ((Double) in.readValue((Double.class.getClassLoader())));
        this.extraKMS = ((Double) in.readValue((Double.class.getClassLoader())));
        this.extraHRS = ((Double) in.readValue((Double.class.getClassLoader())));
        this.monthly = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fifteenDays = ((Double) in.readValue((Double.class.getClassLoader())));
        this.twoDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.threeDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fourDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fiveDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.sixDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.sevenDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.tenDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.twentyDayRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.isAdminRentApplied = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public PriceChart() {
    }

    public Double getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Double weekdays) {
        this.weekdays = weekdays;
    }

    public Double getWeekend() {
        return weekend;
    }

    public void setWeekend(Double weekend) {
        this.weekend = weekend;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Double getKmsLimit() {
        return kmsLimit;
    }

    public void setKmsLimit(Double kmsLimit) {
        this.kmsLimit = kmsLimit;
    }

    public Double getExtraKMS() {
        return extraKMS;
    }

    public void setExtraKMS(Double extraKMS) {
        this.extraKMS = extraKMS;
    }

    public Double getExtraHRS() {
        return extraHRS;
    }

    public void setExtraHRS(Double extraHRS) {
        this.extraHRS = extraHRS;
    }

    public Double getMonthly() {
        return monthly;
    }

    public void setMonthly(Double monthly) {
        this.monthly = monthly;
    }

    public Double getFifteenDays() {
        return fifteenDays;
    }

    public void setFifteenDays(Double fifteenDays) {
        this.fifteenDays = fifteenDays;
    }

    public Double getTwoDayRate() {
        return twoDayRate;
    }

    public void setTwoDayRate(Double twoDayRate) {
        this.twoDayRate = twoDayRate;
    }

    public Double getThreeDayRate() {
        return threeDayRate;
    }

    public void setThreeDayRate(Double threeDayRate) {
        this.threeDayRate = threeDayRate;
    }

    public Double getFourDayRate() {
        return fourDayRate;
    }

    public void setFourDayRate(Double fourDayRate) {
        this.fourDayRate = fourDayRate;
    }

    public Double getFiveDayRate() {
        return fiveDayRate;
    }

    public void setFiveDayRate(Double fiveDayRate) {
        this.fiveDayRate = fiveDayRate;
    }

    public Double getSixDayRate() {
        return sixDayRate;
    }

    public void setSixDayRate(Double sixDayRate) {
        this.sixDayRate = sixDayRate;
    }

    public Double getSevenDayRate() {
        return sevenDayRate;
    }

    public void setSevenDayRate(Double sevenDayRate) {
        this.sevenDayRate = sevenDayRate;
    }

    public Double getTenDayRate() {
        return tenDayRate;
    }

    public void setTenDayRate(Double tenDayRate) {
        this.tenDayRate = tenDayRate;
    }

    public Double getTwentyDayRate() {
        return twentyDayRate;
    }

    public void setTwentyDayRate(Double twentyDayRate) {
        this.twentyDayRate = twentyDayRate;
    }

    public Boolean getIsAdminRentApplied() {
        return isAdminRentApplied;
    }

    public void setIsAdminRentApplied(Boolean isAdminRentApplied) {
        this.isAdminRentApplied = isAdminRentApplied;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(weekdays);
        dest.writeValue(weekend);
        dest.writeValue(hourlyRate);
        dest.writeValue(kmsLimit);
        dest.writeValue(extraKMS);
        dest.writeValue(extraHRS);
        dest.writeValue(monthly);
        dest.writeValue(fifteenDays);
        dest.writeValue(twoDayRate);
        dest.writeValue(threeDayRate);
        dest.writeValue(fourDayRate);
        dest.writeValue(fiveDayRate);
        dest.writeValue(sixDayRate);
        dest.writeValue(sevenDayRate);
        dest.writeValue(tenDayRate);
        dest.writeValue(twentyDayRate);
        dest.writeValue(isAdminRentApplied);
    }

    public int describeContents() {
        return  0;
    }

}

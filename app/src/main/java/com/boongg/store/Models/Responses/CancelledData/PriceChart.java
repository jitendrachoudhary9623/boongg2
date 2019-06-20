
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
    private Integer weekdays;
    @SerializedName("weekend")
    @Expose
    private Integer weekend;
    @SerializedName("hourlyRate")
    @Expose
    private Integer hourlyRate;
    @SerializedName("kmsLimit")
    @Expose
    private Integer kmsLimit;
    @SerializedName("extraKMS")
    @Expose
    private Integer extraKMS;
    @SerializedName("extraHRS")
    @Expose
    private Integer extraHRS;
    @SerializedName("monthly")
    @Expose
    private Integer monthly;
    @SerializedName("fifteenDays")
    @Expose
    private Integer fifteenDays;
    @SerializedName("twoDayRate")
    @Expose
    private Integer twoDayRate;
    @SerializedName("threeDayRate")
    @Expose
    private Integer threeDayRate;
    @SerializedName("fourDayRate")
    @Expose
    private Integer fourDayRate;
    @SerializedName("fiveDayRate")
    @Expose
    private Integer fiveDayRate;
    @SerializedName("sixDayRate")
    @Expose
    private Integer sixDayRate;
    @SerializedName("sevenDayRate")
    @Expose
    private Integer sevenDayRate;
    @SerializedName("tenDayRate")
    @Expose
    private Integer tenDayRate;
    @SerializedName("twentyDayRate")
    @Expose
    private Integer twentyDayRate;
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
        this.weekdays = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.weekend = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hourlyRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.kmsLimit = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.extraKMS = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.extraHRS = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.monthly = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fifteenDays = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.twoDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.threeDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fourDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fiveDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sixDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sevenDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.tenDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.twentyDayRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isAdminRentApplied = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public PriceChart() {
    }

    public Integer getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Integer weekdays) {
        this.weekdays = weekdays;
    }

    public Integer getWeekend() {
        return weekend;
    }

    public void setWeekend(Integer weekend) {
        this.weekend = weekend;
    }

    public Integer getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Integer hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Integer getKmsLimit() {
        return kmsLimit;
    }

    public void setKmsLimit(Integer kmsLimit) {
        this.kmsLimit = kmsLimit;
    }

    public Integer getExtraKMS() {
        return extraKMS;
    }

    public void setExtraKMS(Integer extraKMS) {
        this.extraKMS = extraKMS;
    }

    public Integer getExtraHRS() {
        return extraHRS;
    }

    public void setExtraHRS(Integer extraHRS) {
        this.extraHRS = extraHRS;
    }

    public Integer getMonthly() {
        return monthly;
    }

    public void setMonthly(Integer monthly) {
        this.monthly = monthly;
    }

    public Integer getFifteenDays() {
        return fifteenDays;
    }

    public void setFifteenDays(Integer fifteenDays) {
        this.fifteenDays = fifteenDays;
    }

    public Integer getTwoDayRate() {
        return twoDayRate;
    }

    public void setTwoDayRate(Integer twoDayRate) {
        this.twoDayRate = twoDayRate;
    }

    public Integer getThreeDayRate() {
        return threeDayRate;
    }

    public void setThreeDayRate(Integer threeDayRate) {
        this.threeDayRate = threeDayRate;
    }

    public Integer getFourDayRate() {
        return fourDayRate;
    }

    public void setFourDayRate(Integer fourDayRate) {
        this.fourDayRate = fourDayRate;
    }

    public Integer getFiveDayRate() {
        return fiveDayRate;
    }

    public void setFiveDayRate(Integer fiveDayRate) {
        this.fiveDayRate = fiveDayRate;
    }

    public Integer getSixDayRate() {
        return sixDayRate;
    }

    public void setSixDayRate(Integer sixDayRate) {
        this.sixDayRate = sixDayRate;
    }

    public Integer getSevenDayRate() {
        return sevenDayRate;
    }

    public void setSevenDayRate(Integer sevenDayRate) {
        this.sevenDayRate = sevenDayRate;
    }

    public Integer getTenDayRate() {
        return tenDayRate;
    }

    public void setTenDayRate(Integer tenDayRate) {
        this.tenDayRate = tenDayRate;
    }

    public Integer getTwentyDayRate() {
        return twentyDayRate;
    }

    public void setTwentyDayRate(Integer twentyDayRate) {
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

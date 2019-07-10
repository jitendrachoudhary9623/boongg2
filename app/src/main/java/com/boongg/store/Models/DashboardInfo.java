package com.boongg.store.Models;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardInfo implements Parcelable
{

    @SerializedName("maintainance")
    @Expose
    private Double maintainance;
    @SerializedName("pickup")
    @Expose
    private Double pickup;
    @SerializedName("drop")
    @Expose
    private Double drop;
    @SerializedName("ongoing")
    @Expose
    private Double ongoing;
    @SerializedName("todayCollection")
    @Expose
    private Double todayCollection;
    @SerializedName("monthlyCollection")
    @Expose
    private Double monthlyCollection;
    @SerializedName("available")
    @Expose
    private Double available;
    public final static Parcelable.Creator<DashboardInfo> CREATOR = new Creator<DashboardInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DashboardInfo createFromParcel(Parcel in) {
            return new DashboardInfo(in);
        }

        public DashboardInfo[] newArray(int size) {
            return (new DashboardInfo[size]);
        }

    }
            ;

    protected DashboardInfo(Parcel in) {
        this.maintainance = ((Double) in.readValue((Double.class.getClassLoader())));
        this.pickup = ((Double) in.readValue((Double.class.getClassLoader())));
        this.drop = ((Double) in.readValue((Double.class.getClassLoader())));
        this.ongoing = ((Double) in.readValue((Double.class.getClassLoader())));
        this.todayCollection = ((Double) in.readValue((Double.class.getClassLoader())));
        this.monthlyCollection = ((Double) in.readValue((Double.class.getClassLoader())));
        this.available = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public DashboardInfo() {
    }

    public Double getMaintainance() {
        return maintainance;
    }

    public void setMaintainance(Double maintainance) {
        this.maintainance = maintainance;
    }

    public Double getPickup() {
        return pickup;
    }

    public void setPickup(Double pickup) {
        this.pickup = pickup;
    }

    public Double getDrop() {
        return drop;
    }

    public void setDrop(Double drop) {
        this.drop = drop;
    }

    public Double getOngoing() {
        return ongoing;
    }

    public void setOngoing(Double ongoing) {
        this.ongoing = ongoing;
    }

    public Double getTodayCollection() {
        return todayCollection;
    }

    public void setTodayCollection(Double todayCollection) {
        this.todayCollection = todayCollection;
    }

    public Double getMonthlyCollection() {
        return monthlyCollection;
    }

    public void setMonthlyCollection(Double monthlyCollection) {
        this.monthlyCollection = monthlyCollection;
    }

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(maintainance);
        dest.writeValue(pickup);
        dest.writeValue(drop);
        dest.writeValue(ongoing);
        dest.writeValue(todayCollection);
        dest.writeValue(monthlyCollection);
        dest.writeValue(available);
    }

    public int describeContents() {
        return 0;
    }

}
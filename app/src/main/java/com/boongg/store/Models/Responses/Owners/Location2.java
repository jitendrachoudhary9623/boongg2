package com.boongg.store.Models.Responses.Owners;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location2 implements Parcelable
{
    @Override
    public String toString() {
        return "Location2{" +
                "name='" + name + '\'' +
                ", _id='" + _id + '\'' +
                ", priceChart=" + priceChart +
                '}';
    }

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("priceChart")
    @Expose
    private PriceChart priceChart;
    public final static Parcelable.Creator<Location2> CREATOR = new Creator<Location2>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Location2 createFromParcel(Parcel in) {
            return new Location2(in);
        }

        public Location2[] newArray(int size) {
            return (new Location2[size]);
        }

    }
            ;

    protected Location2(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.priceChart = ((PriceChart) in.readValue((PriceChart.class.getClassLoader())));
    }

    public Location2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public PriceChart getPriceChart() {
        return priceChart;
    }

    public void setPriceChart(PriceChart priceChart) {
        this.priceChart = priceChart;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(_id);
        dest.writeValue(priceChart);
    }

    public int describeContents() {
        return 0;
    }

}
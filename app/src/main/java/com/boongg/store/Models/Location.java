
package com.boongg.store.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Location implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("priceChart")
    @Expose
    private PriceChart priceChart;
    public final static Parcelable.Creator<Location> CREATOR = new Creator<Location>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        public Location[] newArray(int size) {
            return (new Location[size]);
        }

    }
    ;

    protected Location(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.priceChart = ((PriceChart) in.readValue((PriceChart.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param priceChart
     */
    public Location(String name, String id, PriceChart priceChart) {
        super();
        this.name = name;
        this.id = id;
        this.priceChart = priceChart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PriceChart getPriceChart() {
        return priceChart;
    }

    public void setPriceChart(PriceChart priceChart) {
        this.priceChart = priceChart;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(id);
        dest.writeValue(priceChart);
    }

    public int describeContents() {
        return  0;
    }

}

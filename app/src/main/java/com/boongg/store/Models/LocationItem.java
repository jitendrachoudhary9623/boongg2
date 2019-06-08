package com.boongg.store.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LocationItem implements Parcelable {

	@SerializedName("name")
	private String name;

	@SerializedName("_id")
	private String id;

	@SerializedName("priceChart")
	private PriceChart priceChart;

	protected LocationItem(Parcel in) {
		name = in.readString();
		id = in.readString();
		priceChart = in.readParcelable(PriceChart.class.getClassLoader());
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(id);
		dest.writeParcelable(priceChart, flags);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<LocationItem> CREATOR = new Creator<LocationItem>() {
		@Override
		public LocationItem createFromParcel(Parcel in) {
			return new LocationItem(in);
		}

		@Override
		public LocationItem[] newArray(int size) {
			return new LocationItem[size];
		}
	};

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPriceChart(PriceChart priceChart){
		this.priceChart = priceChart;
	}

	public PriceChart getPriceChart(){
		return priceChart;
	}

	@Override
 	public String toString(){
		return 
			"LocationItem{" + 
			"name = '" + name + '\'' + 
			",_id = '" + id + '\'' + 
			",priceChart = '" + priceChart + '\'' + 
			"}";
		}
}
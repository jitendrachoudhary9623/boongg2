package com.boongg.store.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class StoreKey implements Parcelable {

	@SerializedName("loc")
	private List<Double> loc;

	@SerializedName("pancardNumer")
	private String pancardNumer;

	@SerializedName("address")
	private String address;

	@SerializedName("_city")
	private String city;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("locality")
	private List<String> locality;

	@SerializedName("isActive")
	private boolean isActive;

	@SerializedName("gstNumber")
	private String gstNumber;

	@SerializedName("__v")
	private int V;

	@SerializedName("contact")
	private List<Object> contact;

	@SerializedName("name")
	private String name;

	@SerializedName("_id")
	private String id;

	@SerializedName("startDate")
	private String startDate;

	@SerializedName("longitude")
	private String longitude;

	protected StoreKey(Parcel in) {
		pancardNumer = in.readString();
		address = in.readString();
		city = in.readString();
		latitude = in.readString();
		locality = in.createStringArrayList();
		isActive = in.readByte() != 0;
		gstNumber = in.readString();
		V = in.readInt();
		name = in.readString();
		id = in.readString();
		startDate = in.readString();
		longitude = in.readString();
	}

	public static final Creator<StoreKey> CREATOR = new Creator<StoreKey>() {
		@Override
		public StoreKey createFromParcel(Parcel in) {
			return new StoreKey(in);
		}

		@Override
		public StoreKey[] newArray(int size) {
			return new StoreKey[size];
		}
	};

	public void setLoc(List<Double> loc){
		this.loc = loc;
	}

	public List<Double> getLoc(){
		return loc;
	}

	public void setPancardNumer(String pancardNumer){
		this.pancardNumer = pancardNumer;
	}

	public String getPancardNumer(){
		return pancardNumer;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setLocality(List<String> locality){
		this.locality = locality;
	}

	public List<String> getLocality(){
		return locality;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setGstNumber(String gstNumber){
		this.gstNumber = gstNumber;
	}

	public String getGstNumber(){
		return gstNumber;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setContact(List<Object> contact){
		this.contact = contact;
	}

	public List<Object> getContact(){
		return contact;
	}

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

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"StoreKey{" + 
			"loc = '" + loc + '\'' + 
			",pancardNumer = '" + pancardNumer + '\'' + 
			",address = '" + address + '\'' + 
			",_city = '" + city + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",locality = '" + locality + '\'' + 
			",isActive = '" + isActive + '\'' + 
			",gstNumber = '" + gstNumber + '\'' + 
			",__v = '" + V + '\'' + 
			",contact = '" + contact + '\'' + 
			",name = '" + name + '\'' + 
			",_id = '" + id + '\'' + 
			",startDate = '" + startDate + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(pancardNumer);
		dest.writeString(address);
		dest.writeString(city);
		dest.writeString(latitude);
		dest.writeStringList(locality);
		dest.writeByte((byte) (isActive ? 1 : 0));
		dest.writeString(gstNumber);
		dest.writeInt(V);
		dest.writeString(name);
		dest.writeString(id);
		dest.writeString(startDate);
		dest.writeString(longitude);
	}
}
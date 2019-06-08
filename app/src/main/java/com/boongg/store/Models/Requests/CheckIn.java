package com.boongg.store.Models.Requests;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CheckIn implements Parcelable {

	public CheckIn(String selectedBike, boolean isHelmateProvided, String bookingId, String startKm) {
		this.selectedBike = selectedBike;
		this.isHelmateProvided = isHelmateProvided;
		this.bookingId = bookingId;
		this.startKm = startKm;
	}

	@SerializedName("selectedBike")
	private String selectedBike;

	@SerializedName("isHelmateProvided")
	private boolean isHelmateProvided;

	@SerializedName("bookingId")
	private String bookingId;

	@SerializedName("startKm")
	private String startKm;

	protected CheckIn(Parcel in) {
		selectedBike = in.readString();
		isHelmateProvided = in.readByte() != 0;
		bookingId = in.readString();
		startKm = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(selectedBike);
		dest.writeByte((byte) (isHelmateProvided ? 1 : 0));
		dest.writeString(bookingId);
		dest.writeString(startKm);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<CheckIn> CREATOR = new Creator<CheckIn>() {
		@Override
		public CheckIn createFromParcel(Parcel in) {
			return new CheckIn(in);
		}

		@Override
		public CheckIn[] newArray(int size) {
			return new CheckIn[size];
		}
	};

	public void setSelectedBike(String selectedBike){
		this.selectedBike = selectedBike;
	}

	public String getSelectedBike(){
		return selectedBike;
	}

	public void setIsHelmateProvided(boolean isHelmateProvided){
		this.isHelmateProvided = isHelmateProvided;
	}

	public boolean isIsHelmateProvided(){
		return isHelmateProvided;
	}

	public void setBookingId(String bookingId){
		this.bookingId = bookingId;
	}

	public String getBookingId(){
		return bookingId;
	}

	public void setStartKm(String startKm){
		this.startKm = startKm;
	}

	public String getStartKm(){
		return startKm;
	}

	@Override
 	public String toString(){
		return 
			"CheckIn{" + 
			"selectedBike = '" + selectedBike + '\'' + 
			",isHelmateProvided = '" + isHelmateProvided + '\'' + 
			",bookingId = '" + bookingId + '\'' + 
			",startKm = '" + startKm + '\'' + 
			"}";
		}
}
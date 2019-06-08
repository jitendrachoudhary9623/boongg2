package com.boongg.store.Models;

import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class StatusType implements Parcelable {

	@SerializedName("type")
	private String type;

	protected StatusType(Parcel in) {
		type = in.readString();
	}

	public static final Creator<StatusType> CREATOR = new Creator<StatusType>() {
		@Override
		public StatusType createFromParcel(Parcel in) {
			return new StatusType(in);
		}

		@Override
		public StatusType[] newArray(int size) {
			return new StatusType[size];
		}
	};

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"StatusType{" + 
			"type = '" + type + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(type);
	}
}
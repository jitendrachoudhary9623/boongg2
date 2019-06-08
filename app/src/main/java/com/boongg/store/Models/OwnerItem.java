package com.boongg.store.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class OwnerItem implements Parcelable {

	@SerializedName("contact")
	private String contact;

	@SerializedName("name")
	private String name;

	@SerializedName("_id")
	private String id;

	@SerializedName("email")
	private String email;

	protected OwnerItem(Parcel in) {
		contact = in.readString();
		name = in.readString();
		id = in.readString();
		email = in.readString();
	}

	public static final Creator<OwnerItem> CREATOR = new Creator<OwnerItem>() {
		@Override
		public OwnerItem createFromParcel(Parcel in) {
			return new OwnerItem(in);
		}

		@Override
		public OwnerItem[] newArray(int size) {
			return new OwnerItem[size];
		}
	};

	public void setContact(String contact){
		this.contact = contact;
	}

	public String getContact(){
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

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"OwnerItem{" + 
			"contact = '" + contact + '\'' + 
			",name = '" + name + '\'' + 
			",_id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(contact);
		dest.writeString(name);
		dest.writeString(id);
		dest.writeString(email);
	}
}
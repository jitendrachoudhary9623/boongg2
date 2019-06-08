package com.boongg.store.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UpdateResponse implements Parcelable {

	@SerializedName("endDate")
	private String endDate;

	@SerializedName("rentTotal")
	private int rentTotal;

	@SerializedName("cGst")
	private int cGst;

	@SerializedName("isHelmateProvided")
	private boolean isHelmateProvided;

	@SerializedName("_rentBikeKey")
	private RentBikeKey rentBikeKey;

	@SerializedName("startKm")
	private int startKm;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("rentWithDiscount")
	private int rentWithDiscount;

	@SerializedName("bookingType")
	private String bookingType;

	@SerializedName("__v")
	private int V;

	@SerializedName("model")
	private String model;

	@SerializedName("checkOutSmsFlag")
	private boolean checkOutSmsFlag;

	@SerializedName("totalAmountRecived")
	private int totalAmountRecived;

	@SerializedName("brand")
	private String brand;

	@SerializedName("updatedAt")
	private String updatedAt;

	@SerializedName("sGst")
	private int sGst;

	@SerializedName("boonggBookingId")
	private String boonggBookingId;

	@SerializedName("_storeKey")
	private StoreKey storeKey;

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("coupenApplied")
	private String coupenApplied;

	@SerializedName("_webuserId")
	private WebuserId webuserId;

	@SerializedName("isBlockBike")
	private boolean isBlockBike;

	@SerializedName("_rentPoolKey")
	private RentPoolKey rentPoolKey;

	@SerializedName("location")
	private String location;

	@SerializedName("_id")
	private String id;

	@SerializedName("_paymentType")
	private String paymentType;

	@SerializedName("startDate")
	private String startDate;

	@SerializedName("status")
	private String status;

	protected UpdateResponse(Parcel in) {
		endDate = in.readString();
		rentTotal = in.readInt();
		cGst = in.readInt();
		isHelmateProvided = in.readByte() != 0;
		rentBikeKey = in.readParcelable(RentBikeKey.class.getClassLoader());
		startKm = in.readInt();
		createdAt = in.readString();
		rentWithDiscount = in.readInt();
		bookingType = in.readString();
		V = in.readInt();
		model = in.readString();
		checkOutSmsFlag = in.readByte() != 0;
		totalAmountRecived = in.readInt();
		brand = in.readString();
		updatedAt = in.readString();
		sGst = in.readInt();
		boonggBookingId = in.readString();
		storeKey = in.readParcelable(StoreKey.class.getClassLoader());
		quantity = in.readInt();
		coupenApplied = in.readString();
		webuserId = in.readParcelable(WebuserId.class.getClassLoader());
		isBlockBike = in.readByte() != 0;
		rentPoolKey = in.readParcelable(RentPoolKey.class.getClassLoader());
		location = in.readString();
		id = in.readString();
		paymentType = in.readString();
		startDate = in.readString();
		status = in.readString();
	}

	public static final Creator<UpdateResponse> CREATOR = new Creator<UpdateResponse>() {
		@Override
		public UpdateResponse createFromParcel(Parcel in) {
			return new UpdateResponse(in);
		}

		@Override
		public UpdateResponse[] newArray(int size) {
			return new UpdateResponse[size];
		}
	};

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setRentTotal(int rentTotal){
		this.rentTotal = rentTotal;
	}

	public int getRentTotal(){
		return rentTotal;
	}

	public void setCGst(int cGst){
		this.cGst = cGst;
	}

	public int getCGst(){
		return cGst;
	}

	public void setIsHelmateProvided(boolean isHelmateProvided){
		this.isHelmateProvided = isHelmateProvided;
	}

	public boolean isIsHelmateProvided(){
		return isHelmateProvided;
	}

	public void setRentBikeKey(RentBikeKey rentBikeKey){
		this.rentBikeKey = rentBikeKey;
	}

	public RentBikeKey getRentBikeKey(){
		return rentBikeKey;
	}

	public void setStartKm(int startKm){
		this.startKm = startKm;
	}

	public int getStartKm(){
		return startKm;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setRentWithDiscount(int rentWithDiscount){
		this.rentWithDiscount = rentWithDiscount;
	}

	public int getRentWithDiscount(){
		return rentWithDiscount;
	}

	public void setBookingType(String bookingType){
		this.bookingType = bookingType;
	}

	public String getBookingType(){
		return bookingType;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setModel(String model){
		this.model = model;
	}

	public String getModel(){
		return model;
	}

	public void setCheckOutSmsFlag(boolean checkOutSmsFlag){
		this.checkOutSmsFlag = checkOutSmsFlag;
	}

	public boolean isCheckOutSmsFlag(){
		return checkOutSmsFlag;
	}

	public void setTotalAmountRecived(int totalAmountRecived){
		this.totalAmountRecived = totalAmountRecived;
	}

	public int getTotalAmountRecived(){
		return totalAmountRecived;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setSGst(int sGst){
		this.sGst = sGst;
	}

	public int getSGst(){
		return sGst;
	}

	public void setBoonggBookingId(String boonggBookingId){
		this.boonggBookingId = boonggBookingId;
	}

	public String getBoonggBookingId(){
		return boonggBookingId;
	}

	public void setStoreKey(StoreKey storeKey){
		this.storeKey = storeKey;
	}

	public StoreKey getStoreKey(){
		return storeKey;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setCoupenApplied(String coupenApplied){
		this.coupenApplied = coupenApplied;
	}

	public String getCoupenApplied(){
		return coupenApplied;
	}

	public void setWebuserId(WebuserId webuserId){
		this.webuserId = webuserId;
	}

	public WebuserId getWebuserId(){
		return webuserId;
	}

	public void setIsBlockBike(boolean isBlockBike){
		this.isBlockBike = isBlockBike;
	}

	public boolean isIsBlockBike(){
		return isBlockBike;
	}

	public void setRentPoolKey(RentPoolKey rentPoolKey){
		this.rentPoolKey = rentPoolKey;
	}

	public RentPoolKey getRentPoolKey(){
		return rentPoolKey;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPaymentType(String paymentType){
		this.paymentType = paymentType;
	}

	public String getPaymentType(){
		return paymentType;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"UpdateResponse{" + 
			"endDate = '" + endDate + '\'' + 
			",rentTotal = '" + rentTotal + '\'' + 
			",cGst = '" + cGst + '\'' + 
			",isHelmateProvided = '" + isHelmateProvided + '\'' + 
			",_rentBikeKey = '" + rentBikeKey + '\'' + 
			",startKm = '" + startKm + '\'' + 
			",createdAt = '" + createdAt + '\'' + 
			",rentWithDiscount = '" + rentWithDiscount + '\'' + 
			",bookingType = '" + bookingType + '\'' + 
			",__v = '" + V + '\'' + 
			",model = '" + model + '\'' + 
			",checkOutSmsFlag = '" + checkOutSmsFlag + '\'' + 
			",totalAmountRecived = '" + totalAmountRecived + '\'' + 
			",brand = '" + brand + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			",sGst = '" + sGst + '\'' + 
			",boonggBookingId = '" + boonggBookingId + '\'' + 
			",_storeKey = '" + storeKey + '\'' + 
			",quantity = '" + quantity + '\'' + 
			",coupenApplied = '" + coupenApplied + '\'' + 
			",_webuserId = '" + webuserId + '\'' + 
			",isBlockBike = '" + isBlockBike + '\'' + 
			",_rentPoolKey = '" + rentPoolKey + '\'' + 
			",location = '" + location + '\'' + 
			",_id = '" + id + '\'' + 
			",_paymentType = '" + paymentType + '\'' + 
			",startDate = '" + startDate + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(endDate);
		dest.writeInt(rentTotal);
		dest.writeInt(cGst);
		dest.writeByte((byte) (isHelmateProvided ? 1 : 0));
		dest.writeParcelable(rentBikeKey, flags);
		dest.writeInt(startKm);
		dest.writeString(createdAt);
		dest.writeInt(rentWithDiscount);
		dest.writeString(bookingType);
		dest.writeInt(V);
		dest.writeString(model);
		dest.writeByte((byte) (checkOutSmsFlag ? 1 : 0));
		dest.writeInt(totalAmountRecived);
		dest.writeString(brand);
		dest.writeString(updatedAt);
		dest.writeInt(sGst);
		dest.writeString(boonggBookingId);
		dest.writeParcelable(storeKey, flags);
		dest.writeInt(quantity);
		dest.writeString(coupenApplied);
		dest.writeParcelable(webuserId, flags);
		dest.writeByte((byte) (isBlockBike ? 1 : 0));
		dest.writeParcelable(rentPoolKey, flags);
		dest.writeString(location);
		dest.writeString(id);
		dest.writeString(paymentType);
		dest.writeString(startDate);
		dest.writeString(status);
	}
}
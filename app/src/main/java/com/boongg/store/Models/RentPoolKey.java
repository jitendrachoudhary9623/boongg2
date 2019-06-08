package com.boongg.store.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RentPoolKey implements Parcelable {

	@SerializedName("owner")
	private List<OwnerItem> owner;

	@SerializedName("pucFiles")
	private List<Object> pucFiles;

	@SerializedName("purchaseCost")
	private int purchaseCost;

	@SerializedName("_storeKey")
	private String storeKey;

	@SerializedName("color")
	private String color;

	@SerializedName("statusType")
	private StatusType statusType;

	@SerializedName("year")
	private int year;

	@SerializedName("engineNumber")
	private String engineNumber;

	@SerializedName("sellCost")
	private int sellCost;

	@SerializedName("rcFiles")
	private List<Object> rcFiles;

	@SerializedName("kmTravel")
	private int kmTravel;

	@SerializedName("engineCapacity")
	private int engineCapacity;

	@SerializedName("chassisNumber")
	private String chassisNumber;

	@SerializedName("licenceFiles")
	private List<Object> licenceFiles;

	@SerializedName("registrationNumber")
	private String registrationNumber;

	@SerializedName("__v")
	private int V;

	@SerializedName("vehicleModel")
	private String vehicleModel;

	@SerializedName("_id")
	private String _id;

	protected RentPoolKey(Parcel in) {
		purchaseCost = in.readInt();
		storeKey = in.readString();
		color = in.readString();
		year = in.readInt();
		engineNumber = in.readString();
		sellCost = in.readInt();
		kmTravel = in.readInt();
		engineCapacity = in.readInt();
		chassisNumber = in.readString();
		registrationNumber = in.readString();
		V = in.readInt();
		vehicleModel = in.readString();
		_id = in.readString();
		id = in.readString();
		brand = in.readString();
	}

	public static final Creator<RentPoolKey> CREATOR = new Creator<RentPoolKey>() {
		@Override
		public RentPoolKey createFromParcel(Parcel in) {
			return new RentPoolKey(in);
		}

		@Override
		public RentPoolKey[] newArray(int size) {
			return new RentPoolKey[size];
		}
	};

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@SerializedName("id")
	private String id;

	@SerializedName("brand")
	private String brand;

	public void setOwner(List<OwnerItem> owner){
		this.owner = owner;
	}

	public List<OwnerItem> getOwner(){
		return owner;
	}

	public void setPucFiles(List<Object> pucFiles){
		this.pucFiles = pucFiles;
	}

	public List<Object> getPucFiles(){
		return pucFiles;
	}

	public void setPurchaseCost(int purchaseCost){
		this.purchaseCost = purchaseCost;
	}

	public int getPurchaseCost(){
		return purchaseCost;
	}

	public void setStoreKey(String storeKey){
		this.storeKey = storeKey;
	}

	public String getStoreKey(){
		return storeKey;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setStatusType(StatusType statusType){
		this.statusType = statusType;
	}

	public StatusType getStatusType(){
		return statusType;
	}

	public void setYear(int year){
		this.year = year;
	}

	public int getYear(){
		return year;
	}

	public void setEngineNumber(String engineNumber){
		this.engineNumber = engineNumber;
	}

	public String getEngineNumber(){
		return engineNumber;
	}

	public void setSellCost(int sellCost){
		this.sellCost = sellCost;
	}

	public int getSellCost(){
		return sellCost;
	}

	public void setRcFiles(List<Object> rcFiles){
		this.rcFiles = rcFiles;
	}

	public List<Object> getRcFiles(){
		return rcFiles;
	}

	public void setKmTravel(int kmTravel){
		this.kmTravel = kmTravel;
	}

	public int getKmTravel(){
		return kmTravel;
	}

	public void setEngineCapacity(int engineCapacity){
		this.engineCapacity = engineCapacity;
	}

	public int getEngineCapacity(){
		return engineCapacity;
	}

	public void setChassisNumber(String chassisNumber){
		this.chassisNumber = chassisNumber;
	}

	public String getChassisNumber(){
		return chassisNumber;
	}

	public void setLicenceFiles(List<Object> licenceFiles){
		this.licenceFiles = licenceFiles;
	}

	public List<Object> getLicenceFiles(){
		return licenceFiles;
	}

	public void setRegistrationNumber(String registrationNumber){
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationNumber(){
		return registrationNumber;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setVehicleModel(String vehicleModel){
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleModel(){
		return vehicleModel;
	}



	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}

	@Override
 	public String toString(){
		return 
			"RentPoolKey{" + 
			"owner = '" + owner + '\'' + 
			",pucFiles = '" + pucFiles + '\'' + 
			",purchaseCost = '" + purchaseCost + '\'' + 
			",_storeKey = '" + storeKey + '\'' + 
			",color = '" + color + '\'' + 
			",statusType = '" + statusType + '\'' + 
			",year = '" + year + '\'' + 
			",engineNumber = '" + engineNumber + '\'' + 
			",sellCost = '" + sellCost + '\'' + 
			",rcFiles = '" + rcFiles + '\'' + 
			",kmTravel = '" + kmTravel + '\'' + 
			",engineCapacity = '" + engineCapacity + '\'' + 
			",chassisNumber = '" + chassisNumber + '\'' + 
			",licenceFiles = '" + licenceFiles + '\'' + 
			",registrationNumber = '" + registrationNumber + '\'' + 
			",__v = '" + V + '\'' + 
			",vehicleModel = '" + vehicleModel + '\'' + 
			",_id = '" + id + '\'' + 
			",id = '" + id + '\'' + 
			",brand = '" + brand + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(purchaseCost);
		dest.writeString(storeKey);
		dest.writeString(color);
		dest.writeInt(year);
		dest.writeString(engineNumber);
		dest.writeInt(sellCost);
		dest.writeInt(kmTravel);
		dest.writeInt(engineCapacity);
		dest.writeString(chassisNumber);
		dest.writeString(registrationNumber);
		dest.writeInt(V);
		dest.writeString(vehicleModel);
		dest.writeString(_id);
		dest.writeString(id);
		dest.writeString(brand);
	}
}
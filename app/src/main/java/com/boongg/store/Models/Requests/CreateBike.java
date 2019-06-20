package com.boongg.store.Models.Requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateBike implements Parcelable
{

    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("vehicleModel")
    @Expose
    private String vehicleModel;
    @SerializedName("engineCapacity")
    @Expose
    private Integer engineCapacity;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("kmTravel")
    @Expose
    private Integer kmTravel;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("chassisNumber")
    @Expose
    private String chassisNumber;
    @SerializedName("engineNumber")
    @Expose
    private String engineNumber;
    @SerializedName("registrationNumber")
    @Expose
    private String registrationNumber;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("purchaseCost")
    @Expose
    private Integer purchaseCost;
    @SerializedName("sellCost")
    @Expose
    private Integer sellCost;
    @SerializedName("statusType")
    @Expose
    private StatusType statusType;
    @SerializedName("store")
    @Expose
    private String store;
    public final static Parcelable.Creator<CreateBike> CREATOR = new Creator<CreateBike>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CreateBike createFromParcel(Parcel in) {
            return new CreateBike(in);
        }

        public CreateBike[] newArray(int size) {
            return (new CreateBike[size]);
        }

    }
            ;

    protected CreateBike(Parcel in) {
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleModel = ((String) in.readValue((String.class.getClassLoader())));
        this.engineCapacity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.year = ((String) in.readValue((String.class.getClassLoader())));
        this.kmTravel = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.color = ((String) in.readValue((String.class.getClassLoader())));
        this.chassisNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.engineNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.registrationNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.contact = ((String) in.readValue((String.class.getClassLoader())));
        this.purchaseCost = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sellCost = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusType = ((StatusType) in.readValue((StatusType.class.getClassLoader())));
        this.store = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CreateBike() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getKmTravel() {
        return kmTravel;
    }

    public void setKmTravel(Integer kmTravel) {
        this.kmTravel = kmTravel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(Integer purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Integer getSellCost() {
        return sellCost;
    }

    public void setSellCost(Integer sellCost) {
        this.sellCost = sellCost;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userId);
        dest.writeValue(brand);
        dest.writeValue(vehicleModel);
        dest.writeValue(engineCapacity);
        dest.writeValue(year);
        dest.writeValue(kmTravel);
        dest.writeValue(color);
        dest.writeValue(chassisNumber);
        dest.writeValue(engineNumber);
        dest.writeValue(registrationNumber);
        dest.writeValue(name);
        dest.writeValue(email);
        dest.writeValue(contact);
        dest.writeValue(purchaseCost);
        dest.writeValue(sellCost);
        dest.writeValue(statusType);
        dest.writeValue(store);
    }

    public int describeContents() {
        return 0;
    }

}



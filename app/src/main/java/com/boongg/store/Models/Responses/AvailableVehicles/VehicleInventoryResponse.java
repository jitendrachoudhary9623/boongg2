
package com.boongg.store.Models.Responses.AvailableVehicles;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleInventoryResponse implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("vehicleModel")
    @Expose
    private String vehicleModel;
    @SerializedName("engineCapacity")
    @Expose
    private Double engineCapacity;
    @SerializedName("year")
    @Expose
    private Double year;
    @SerializedName("kmTravel")
    @Expose
    private Double kmTravel;
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
    @SerializedName("purchaseCost")
    @Expose
    private Double purchaseCost;
    @SerializedName("sellCost")
    @Expose
    private Double sellCost;
    @SerializedName("statusType")
    @Expose
    private StatusType statusType;
    @SerializedName("_storeKey")
    @Expose
    private String _storeKey;
    @SerializedName("__v")
    @Expose
    private Double __v;
    @SerializedName("owner")
    @Expose
    private List<Owner> owner = null;
    @SerializedName("licenceFiles")
    @Expose
    private List<Object> licenceFiles = null;
    @SerializedName("pucFiles")
    @Expose
    private List<Object> pucFiles = null;
    @SerializedName("rcFiles")
    @Expose
    private List<Object> rcFiles = null;
    @SerializedName("id")
    @Expose
    private String id;
    public final static Creator<VehicleInventoryResponse> CREATOR = new Creator<VehicleInventoryResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public VehicleInventoryResponse createFromParcel(Parcel in) {
            return new VehicleInventoryResponse(in);
        }

        public VehicleInventoryResponse[] newArray(int size) {
            return (new VehicleInventoryResponse[size]);
        }

    }
    ;

    protected VehicleInventoryResponse(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleModel = ((String) in.readValue((String.class.getClassLoader())));
        this.engineCapacity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.year = ((Double) in.readValue((Double.class.getClassLoader())));
        this.kmTravel = ((Double) in.readValue((Double.class.getClassLoader())));
        this.color = ((String) in.readValue((String.class.getClassLoader())));
        this.chassisNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.engineNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.registrationNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.purchaseCost = ((Double) in.readValue((Double.class.getClassLoader())));
        this.sellCost = ((Double) in.readValue((Double.class.getClassLoader())));
        this.statusType = ((StatusType) in.readValue((StatusType.class.getClassLoader())));
        this._storeKey = ((String) in.readValue((String.class.getClassLoader())));
        this.__v = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.owner, (com.boongg.store.Models.Responses.AvailableVehicles.Owner.class.getClassLoader()));
        in.readList(this.licenceFiles, (Object.class.getClassLoader()));
        in.readList(this.pucFiles, (Object.class.getClassLoader()));
        in.readList(this.rcFiles, (Object.class.getClassLoader()));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
    }

    public VehicleInventoryResponse() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Double getYear() {
        return year;
    }

    public void setYear(Double year) {
        this.year = year;
    }

    public Double getKmTravel() {
        return kmTravel;
    }

    public void setKmTravel(Double kmTravel) {
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

    public Double getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(Double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Double getSellCost() {
        return sellCost;
    }

    public void setSellCost(Double sellCost) {
        this.sellCost = sellCost;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public String get_storeKey() {
        return _storeKey;
    }

    public void set_storeKey(String _storeKey) {
        this._storeKey = _storeKey;
    }

    public Double get__v() {
        return __v;
    }

    public void set__v(Double __v) {
        this.__v = __v;
    }

    public List<Owner> getOwner() {
        return owner;
    }

    public void setOwner(List<Owner> owner) {
        this.owner = owner;
    }

    public List<Object> getLicenceFiles() {
        return licenceFiles;
    }

    public void setLicenceFiles(List<Object> licenceFiles) {
        this.licenceFiles = licenceFiles;
    }

    public List<Object> getPucFiles() {
        return pucFiles;
    }

    public void setPucFiles(List<Object> pucFiles) {
        this.pucFiles = pucFiles;
    }

    public List<Object> getRcFiles() {
        return rcFiles;
    }

    public void setRcFiles(List<Object> rcFiles) {
        this.rcFiles = rcFiles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(brand);
        dest.writeValue(vehicleModel);
        dest.writeValue(engineCapacity);
        dest.writeValue(year);
        dest.writeValue(kmTravel);
        dest.writeValue(color);
        dest.writeValue(chassisNumber);
        dest.writeValue(engineNumber);
        dest.writeValue(registrationNumber);
        dest.writeValue(purchaseCost);
        dest.writeValue(sellCost);
        dest.writeValue(statusType);
        dest.writeValue(_storeKey);
        dest.writeValue(__v);
        dest.writeList(owner);
        dest.writeList(licenceFiles);
        dest.writeList(pucFiles);
        dest.writeList(rcFiles);
        dest.writeValue(id);
    }

    public int describeContents() {
        return  0;
    }

}

package com.boongg.store.Models.Responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DropVehicleResponse implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("__v")
    @Expose
    private Double __v;
    @SerializedName("_webuserId")
    @Expose
    private String _webuserId;
    @SerializedName("_rentBikeKey")
    @Expose
    private String _rentBikeKey;
    @SerializedName("totalAmountRecived")
    @Expose
    private Double totalAmountRecived;
    @SerializedName("sGst")
    @Expose
    private Double sGst;
    @SerializedName("cGst")
    @Expose
    private Double cGst;
    @SerializedName("rentWithDiscount")
    @Expose
    private Double rentWithDiscount;
    @SerializedName("rentTotal")
    @Expose
    private Double rentTotal;
    @SerializedName("discountGiven")
    @Expose
    private Double discountGiven;
    @SerializedName("coupenApplied")
    @Expose
    private String coupenApplied;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_paymentType")
    @Expose
    private String _paymentType;
    @SerializedName("bookingType")
    @Expose
    private String bookingType;
    @SerializedName("boonggBookingId")
    @Expose
    private String boonggBookingId;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("isHelmateProvided")
    @Expose
    private Boolean isHelmateProvided;
    @SerializedName("startKm")
    @Expose
    private Double startKm;
    @SerializedName("isBlockBike")
    @Expose
    private Boolean isBlockBike;
    public final static Parcelable.Creator<DropVehicleResponse> CREATOR = new Creator<DropVehicleResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DropVehicleResponse createFromParcel(Parcel in) {
            return new DropVehicleResponse(in);
        }

        public DropVehicleResponse[] newArray(int size) {
            return (new DropVehicleResponse[size]);
        }

    }
            ;

    protected DropVehicleResponse(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.__v = ((Double) in.readValue((Double.class.getClassLoader())));
        this._webuserId = ((String) in.readValue((String.class.getClassLoader())));
        this._rentBikeKey = ((String) in.readValue((String.class.getClassLoader())));
        this.totalAmountRecived = ((Double) in.readValue((Double.class.getClassLoader())));
        this.sGst = ((Double) in.readValue((Double.class.getClassLoader())));
        this.cGst = ((Double) in.readValue((Double.class.getClassLoader())));
        this.rentWithDiscount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.rentTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        this.discountGiven = ((Double) in.readValue((Double.class.getClassLoader())));
        this.coupenApplied = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this._paymentType = ((String) in.readValue((String.class.getClassLoader())));
        this.bookingType = ((String) in.readValue((String.class.getClassLoader())));
        this.boonggBookingId = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.isHelmateProvided = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.startKm = ((Double) in.readValue((Double.class.getClassLoader())));
        this.isBlockBike = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public DropVehicleResponse() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Double get__v() {
        return __v;
    }

    public void set__v(Double __v) {
        this.__v = __v;
    }

    public String get_webuserId() {
        return _webuserId;
    }

    public void set_webuserId(String _webuserId) {
        this._webuserId = _webuserId;
    }

    public String get_rentBikeKey() {
        return _rentBikeKey;
    }

    public void set_rentBikeKey(String _rentBikeKey) {
        this._rentBikeKey = _rentBikeKey;
    }

    public Double getTotalAmountRecived() {
        return totalAmountRecived;
    }

    public void setTotalAmountRecived(Double totalAmountRecived) {
        this.totalAmountRecived = totalAmountRecived;
    }

    public Double getSGst() {
        return sGst;
    }

    public void setSGst(Double sGst) {
        this.sGst = sGst;
    }

    public Double getCGst() {
        return cGst;
    }

    public void setCGst(Double cGst) {
        this.cGst = cGst;
    }

    public Double getRentWithDiscount() {
        return rentWithDiscount;
    }

    public void setRentWithDiscount(Double rentWithDiscount) {
        this.rentWithDiscount = rentWithDiscount;
    }

    public Double getRentTotal() {
        return rentTotal;
    }

    public void setRentTotal(Double rentTotal) {
        this.rentTotal = rentTotal;
    }

    public Double getDiscountGiven() {
        return discountGiven;
    }

    public void setDiscountGiven(Double discountGiven) {
        this.discountGiven = discountGiven;
    }

    public String getCoupenApplied() {
        return coupenApplied;
    }

    public void setCoupenApplied(String coupenApplied) {
        this.coupenApplied = coupenApplied;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String get_paymentType() {
        return _paymentType;
    }

    public void set_paymentType(String _paymentType) {
        this._paymentType = _paymentType;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getBoonggBookingId() {
        return boonggBookingId;
    }

    public void setBoonggBookingId(String boonggBookingId) {
        this.boonggBookingId = boonggBookingId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Boolean getIsHelmateProvided() {
        return isHelmateProvided;
    }

    public void setIsHelmateProvided(Boolean isHelmateProvided) {
        this.isHelmateProvided = isHelmateProvided;
    }

    public Double getStartKm() {
        return startKm;
    }

    public void setStartKm(Double startKm) {
        this.startKm = startKm;
    }

    public Boolean getIsBlockBike() {
        return isBlockBike;
    }

    public void setIsBlockBike(Boolean isBlockBike) {
        this.isBlockBike = isBlockBike;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(updatedAt);
        dest.writeValue(createdAt);
        dest.writeValue(__v);
        dest.writeValue(_webuserId);
        dest.writeValue(_rentBikeKey);
        dest.writeValue(totalAmountRecived);
        dest.writeValue(sGst);
        dest.writeValue(cGst);
        dest.writeValue(rentWithDiscount);
        dest.writeValue(rentTotal);
        dest.writeValue(discountGiven);
        dest.writeValue(coupenApplied);
        dest.writeValue(status);
        dest.writeValue(_paymentType);
        dest.writeValue(bookingType);
        dest.writeValue(boonggBookingId);
        dest.writeValue(quantity);
        dest.writeValue(location);
        dest.writeValue(model);
        dest.writeValue(brand);
        dest.writeValue(endDate);
        dest.writeValue(startDate);
        dest.writeValue(isHelmateProvided);
        dest.writeValue(startKm);
        dest.writeValue(isBlockBike);
    }

    public int describeContents() {
        return 0;
    }

}
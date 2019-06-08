package com.boongg.store.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cancel implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("_webuserId")
    @Expose
    private String webuserId;
    @SerializedName("_rentBikeKey")
    @Expose
    private String rentBikeKey;
    @SerializedName("_storeKey")
    @Expose
    private String storeKey;
    @SerializedName("totalAmountRecived")
    @Expose
    private Integer totalAmountRecived;
    @SerializedName("sGst")
    @Expose
    private Integer sGst;
    @SerializedName("cGst")
    @Expose
    private Integer cGst;
    @SerializedName("rentWithDiscount")
    @Expose
    private Integer rentWithDiscount;
    @SerializedName("rentTotal")
    @Expose
    private Integer rentTotal;
    @SerializedName("discountGiven")
    @Expose
    private Integer discountGiven;
    @SerializedName("coupenApplied")
    @Expose
    private String coupenApplied;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_paymentType")
    @Expose
    private String paymentType;
    @SerializedName("bookingType")
    @Expose
    private String bookingType;
    @SerializedName("boonggBookingId")
    @Expose
    private String boonggBookingId;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
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
    @SerializedName("isBlockBike")
    @Expose
    private Boolean isBlockBike;
    public final static Parcelable.Creator<Cancel> CREATOR = new Creator<Cancel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Cancel createFromParcel(Parcel in) {
            return new Cancel(in);
        }

        public Cancel[] newArray(int size) {
            return (new Cancel[size]);
        }

    }
            ;

    protected Cancel(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.webuserId = ((String) in.readValue((String.class.getClassLoader())));
        this.rentBikeKey = ((String) in.readValue((String.class.getClassLoader())));
        this.storeKey = ((String) in.readValue((String.class.getClassLoader())));
        this.totalAmountRecived = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sGst = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cGst = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rentWithDiscount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rentTotal = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.discountGiven = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.coupenApplied = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentType = ((String) in.readValue((String.class.getClassLoader())));
        this.bookingType = ((String) in.readValue((String.class.getClassLoader())));
        this.boonggBookingId = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.isBlockBike = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public Cancel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getWebuserId() {
        return webuserId;
    }

    public void setWebuserId(String webuserId) {
        this.webuserId = webuserId;
    }

    public String getRentBikeKey() {
        return rentBikeKey;
    }

    public void setRentBikeKey(String rentBikeKey) {
        this.rentBikeKey = rentBikeKey;
    }

    public String getStoreKey() {
        return storeKey;
    }

    public void setStoreKey(String storeKey) {
        this.storeKey = storeKey;
    }

    public Integer getTotalAmountRecived() {
        return totalAmountRecived;
    }

    public void setTotalAmountRecived(Integer totalAmountRecived) {
        this.totalAmountRecived = totalAmountRecived;
    }

    public Integer getSGst() {
        return sGst;
    }

    public void setSGst(Integer sGst) {
        this.sGst = sGst;
    }

    public Integer getCGst() {
        return cGst;
    }

    public void setCGst(Integer cGst) {
        this.cGst = cGst;
    }

    public Integer getRentWithDiscount() {
        return rentWithDiscount;
    }

    public void setRentWithDiscount(Integer rentWithDiscount) {
        this.rentWithDiscount = rentWithDiscount;
    }

    public Integer getRentTotal() {
        return rentTotal;
    }

    public void setRentTotal(Integer rentTotal) {
        this.rentTotal = rentTotal;
    }

    public Integer getDiscountGiven() {
        return discountGiven;
    }

    public void setDiscountGiven(Integer discountGiven) {
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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

    public Boolean getIsBlockBike() {
        return isBlockBike;
    }

    public void setIsBlockBike(Boolean isBlockBike) {
        this.isBlockBike = isBlockBike;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(updatedAt);
        dest.writeValue(createdAt);
        dest.writeValue(v);
        dest.writeValue(webuserId);
        dest.writeValue(rentBikeKey);
        dest.writeValue(storeKey);
        dest.writeValue(totalAmountRecived);
        dest.writeValue(sGst);
        dest.writeValue(cGst);
        dest.writeValue(rentWithDiscount);
        dest.writeValue(rentTotal);
        dest.writeValue(discountGiven);
        dest.writeValue(coupenApplied);
        dest.writeValue(status);
        dest.writeValue(paymentType);
        dest.writeValue(bookingType);
        dest.writeValue(boonggBookingId);
        dest.writeValue(quantity);
        dest.writeValue(location);
        dest.writeValue(model);
        dest.writeValue(brand);
        dest.writeValue(endDate);
        dest.writeValue(startDate);
        dest.writeValue(isBlockBike);
    }

    public int describeContents() {
        return 0;
    }

}
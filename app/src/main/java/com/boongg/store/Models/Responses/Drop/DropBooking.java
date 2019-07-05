
package com.boongg.store.Models.Responses.Drop;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

import com.boongg.store.Utilities.DateSorter;
import com.boongg.store.Utilities.DateUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DropBooking implements Parcelable,Comparable<DropBooking>
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
    private com.boongg.store.Models.Responses.Drop._webuserId _webuserId;
    @SerializedName("_rentBikeKey")
    @Expose
    private com.boongg.store.Models.Responses.Drop._rentBikeKey _rentBikeKey;
    @SerializedName("_storeKey")
    @Expose
    private String _storeKey;
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
    @SerializedName("_rentPoolKey")
    @Expose
    private com.boongg.store.Models.Responses.Drop._rentPoolKey _rentPoolKey;
    @SerializedName("isHelmateProvided")
    @Expose
    private Boolean isHelmateProvided;
    @SerializedName("startKm")
    @Expose
    private Double startKm;
    @SerializedName("isBlockBike")
    @Expose
    private Boolean isBlockBike;
    public final static Creator<DropBooking> CREATOR = new Creator<DropBooking>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DropBooking createFromParcel(Parcel in) {
            return new DropBooking(in);
        }

        public DropBooking[] newArray(int size) {
            return (new DropBooking[size]);
        }

    }
    ;

    protected DropBooking(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.__v = ((Double) in.readValue((Double.class.getClassLoader())));
        this._webuserId = ((com.boongg.store.Models.Responses.Drop._webuserId) in.readValue((_webuserId.class.getClassLoader())));
        this._rentBikeKey = ((com.boongg.store.Models.Responses.Drop._rentBikeKey) in.readValue((_rentBikeKey.class.getClassLoader())));
        this._storeKey = ((String) in.readValue((String.class.getClassLoader())));
        this.totalAmountRecived = ((Double) in.readValue((Double.class.getClassLoader())));
        this.sGst = ((Double) in.readValue((Double.class.getClassLoader())));
        this.cGst = ((Double) in.readValue((Double.class.getClassLoader())));
        this.rentWithDiscount = ((Double) in.readValue((Double.class.getClassLoader())));
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
        this._rentPoolKey = ((com.boongg.store.Models.Responses.Drop._rentPoolKey) in.readValue((_rentPoolKey.class.getClassLoader())));
        this.isHelmateProvided = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.startKm = ((Double) in.readValue((Double.class.getClassLoader())));
        this.isBlockBike = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public DropBooking() {
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

    public com.boongg.store.Models.Responses.Drop._webuserId get_webuserId() {
        return _webuserId;
    }

    public void set_webuserId(com.boongg.store.Models.Responses.Drop._webuserId _webuserId) {
        this._webuserId = _webuserId;
    }

    public com.boongg.store.Models.Responses.Drop._rentBikeKey get_rentBikeKey() {
        return _rentBikeKey;
    }

    public void set_rentBikeKey(com.boongg.store.Models.Responses.Drop._rentBikeKey _rentBikeKey) {
        this._rentBikeKey = _rentBikeKey;
    }

    public String get_storeKey() {
        return _storeKey;
    }

    public void set_storeKey(String _storeKey) {
        this._storeKey = _storeKey;
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
        this.endDate=endDate;

    }

    public String getIST(String date){

        Log.e("DATE 2 Input",date);
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd hh:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC+4"));

        //remove unwanted data
        date=date.replace("T"," ");
        date=date.replace(".000Z","");

        try {
            //date
            Date d1 = formatter.parse(date);
            d1.toLocaleString();
            DateFormat originalFormat = new SimpleDateFormat("EEE MMM dd kk:mm:ss yyyy", Locale.ENGLISH);
            DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
            Date date2 = originalFormat.parse(d1.toString().replace(" GMT+05:30 ", " "));
            String formattedDate = targetFormat.format(date2);
            Log.e("DATE 2 Output",formattedDate);

            return formattedDate;
        }catch (Exception e){
            Log.e("DATE",e.toString());
        }
        return date;
    }
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public com.boongg.store.Models.Responses.Drop._rentPoolKey get_rentPoolKey() {
        return _rentPoolKey;
    }

    public void set_rentPoolKey(com.boongg.store.Models.Responses.Drop._rentPoolKey _rentPoolKey) {
        this._rentPoolKey = _rentPoolKey;
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
        dest.writeValue(_storeKey);
        dest.writeValue(totalAmountRecived);
        dest.writeValue(sGst);
        dest.writeValue(cGst);
        dest.writeValue(rentWithDiscount);
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
        dest.writeValue(_rentPoolKey);
        dest.writeValue(isHelmateProvided);
        dest.writeValue(startKm);
        dest.writeValue(isBlockBike);
    }

    public int describeContents() {
        return  0;
    }


    @Override
    public int compareTo(DropBooking o) {

        try {
            String t=DateUtils.getIST(this.getEndDate());
            String ob=DateUtils.getIST(o.getEndDate());
            SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd hh:mm");
            Date d1=format.parse(t);
            Date d2=format.parse(ob);

            if (d1.after(d2)) {
                return -1;
            }
            else if(d1.before(d2)){
                return 1;
            }
            else{
                return 0;
            }
        }catch (Exception e){
        Log.e("DATE ERR ",e.toString());
        }
      return 0;
    }
}

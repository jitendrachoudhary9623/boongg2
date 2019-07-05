
package com.boongg.store.Models.Requests;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateBookingRequest implements Parcelable
{

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("emailid")
    @Expose
    private String emailid;
    @SerializedName("paymentType")
    @Expose
    private String paymentType;
    @SerializedName("paymentTypeMode")
    @Expose
    private String paymentTypeMode;
    @SerializedName("bikeList")
    @Expose
    private List<BikeList> bikeList = null;
    @SerializedName("rentTotal")
    @Expose
    private Double rentTotal;
    @SerializedName("suggestedRent")
    @Expose
    private Double suggestedRent;
    @SerializedName("recivableAmountWithTax")
    @Expose
    private Double recivableAmountWithTax;
    @SerializedName("discountAmount")
    @Expose
    private Double discountAmount;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("storeKey")
    @Expose
    private String storeKey;
    @SerializedName("webUserId")
    @Expose
    private String webUserId;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("isGstApplicable")
    @Expose
    private Boolean isGstApplicable;
    public final static Creator<CreateBookingRequest> CREATOR = new Creator<CreateBookingRequest>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CreateBookingRequest createFromParcel(Parcel in) {
            return new CreateBookingRequest(in);
        }

        public CreateBookingRequest[] newArray(int size) {
            return (new CreateBookingRequest[size]);
        }

    }
    ;

    protected CreateBookingRequest(Parcel in) {
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.emailid = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentType = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentTypeMode = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.bikeList, (BikeList.class.getClassLoader()));
        this.rentTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        this.suggestedRent = ((Double) in.readValue((Double.class.getClassLoader())));
        this.recivableAmountWithTax = ((Double) in.readValue((Double.class.getClassLoader())));
        this.discountAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.storeKey = ((String) in.readValue((String.class.getClassLoader())));
        this.webUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.mobileNo = ((String) in.readValue((String.class.getClassLoader())));
        this.isGstApplicable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public CreateBookingRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeMode() {
        return paymentTypeMode;
    }

    public void setPaymentTypeMode(String paymentTypeMode) {
        this.paymentTypeMode = paymentTypeMode;
    }

    public List<BikeList> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<BikeList> bikeList) {
        this.bikeList = bikeList;
    }

    public Double getRentTotal() {
        return rentTotal;
    }

    public void setRentTotal(Double rentTotal) {
        this.rentTotal = rentTotal;
    }

    public Double getSuggestedRent() {
        return suggestedRent;
    }

    public void setSuggestedRent(Double suggestedRent) {
        this.suggestedRent = suggestedRent;
    }

    public Double getRecivableAmountWithTax() {
        return recivableAmountWithTax;
    }

    public void setRecivableAmountWithTax(Double recivableAmountWithTax) {
        this.recivableAmountWithTax = recivableAmountWithTax;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStoreKey() {
        return storeKey;
    }

    public void setStoreKey(String storeKey) {
        this.storeKey = storeKey;
    }

    public String getWebUserId() {
        return webUserId;
    }

    public void setWebUserId(String webUserId) {
        this.webUserId = webUserId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Boolean getIsGstApplicable() {
        return isGstApplicable;
    }

    public void setIsGstApplicable(Boolean isGstApplicable) {
        this.isGstApplicable = isGstApplicable;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(emailid);
        dest.writeValue(paymentType);
        dest.writeValue(paymentTypeMode);
        dest.writeList(bikeList);
        dest.writeValue(rentTotal);
        dest.writeValue(suggestedRent);
        dest.writeValue(recivableAmountWithTax);
        dest.writeValue(discountAmount);
        dest.writeValue(location);
        dest.writeValue(storeKey);
        dest.writeValue(webUserId);
        dest.writeValue(mobileNo);
        dest.writeValue(isGstApplicable);
    }

    public int describeContents() {
        return  0;
    }

}

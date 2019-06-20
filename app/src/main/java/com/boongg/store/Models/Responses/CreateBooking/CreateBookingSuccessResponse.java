
package com.boongg.store.Models.Responses.CreateBooking;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateBookingSuccessResponse implements Parcelable
{
    @Override
    public String toString() {
        return "CreateBookingSuccessResponse{" +
                "username='" + username + '\'' +
                ", emailid='" + emailid + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", paymentTypeMode='" + paymentTypeMode + '\'' +
                ", bikeList=" + bikeList +
                ", rentTotal=" + rentTotal +
                ", suggestedRent=" + suggestedRent +
                ", recivableAmountWithTax=" + recivableAmountWithTax +
                ", discountAmount=" + discountAmount +
                ", location='" + location + '\'' +
                ", storeKey='" + storeKey + '\'' +
                ", webUserId='" + webUserId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", isGstApplicable=" + isGstApplicable +
                '}';
    }

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
    private Integer rentTotal;
    @SerializedName("suggestedRent")
    @Expose
    private Integer suggestedRent;
    @SerializedName("recivableAmountWithTax")
    @Expose
    private Double recivableAmountWithTax;
    @SerializedName("discountAmount")
    @Expose
    private Integer discountAmount;
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
    public final static Parcelable.Creator<CreateBookingSuccessResponse> CREATOR = new Creator<CreateBookingSuccessResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CreateBookingSuccessResponse createFromParcel(Parcel in) {
            return new CreateBookingSuccessResponse(in);
        }

        public CreateBookingSuccessResponse[] newArray(int size) {
            return (new CreateBookingSuccessResponse[size]);
        }

    }
    ;

    protected CreateBookingSuccessResponse(Parcel in) {
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.emailid = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentType = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentTypeMode = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.bikeList, (com.boongg.store.Models.Responses.CreateBooking.BikeList.class.getClassLoader()));
        this.rentTotal = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.suggestedRent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.recivableAmountWithTax = ((Double) in.readValue((Double.class.getClassLoader())));
        this.discountAmount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.storeKey = ((String) in.readValue((String.class.getClassLoader())));
        this.webUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.mobileNo = ((String) in.readValue((String.class.getClassLoader())));
        this.isGstApplicable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public CreateBookingSuccessResponse() {
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

    public Integer getRentTotal() {
        return rentTotal;
    }

    public void setRentTotal(Integer rentTotal) {
        this.rentTotal = rentTotal;
    }

    public Integer getSuggestedRent() {
        return suggestedRent;
    }

    public void setSuggestedRent(Integer suggestedRent) {
        this.suggestedRent = suggestedRent;
    }

    public Double getRecivableAmountWithTax() {
        return recivableAmountWithTax;
    }

    public void setRecivableAmountWithTax(Double recivableAmountWithTax) {
        this.recivableAmountWithTax = recivableAmountWithTax;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
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


package com.boongg.store.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RentPayment implements Parcelable
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
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("txnid")
    @Expose
    private String txnid;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("paymentGatewayType")
    @Expose
    private String paymentGatewayType;
    @SerializedName("bank_ref_num")
    @Expose
    private String bankRefNum;
    @SerializedName("payuMoneyId")
    @Expose
    private String payuMoneyId;
    @SerializedName("_webuserId")
    @Expose
    private String webuserId;
    @SerializedName("__v")
    @Expose
    private Double v;
    public final static Parcelable.Creator<RentPayment> CREATOR = new Creator<RentPayment>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RentPayment createFromParcel(Parcel in) {
            return new RentPayment(in);
        }

        public RentPayment[] newArray(int size) {
            return (new RentPayment[size]);
        }

    }
    ;

    protected RentPayment(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.mode = ((String) in.readValue((String.class.getClassLoader())));
        this.txnid = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentGatewayType = ((String) in.readValue((String.class.getClassLoader())));
        this.bankRefNum = ((String) in.readValue((String.class.getClassLoader())));
        this.payuMoneyId = ((String) in.readValue((String.class.getClassLoader())));
        this.webuserId = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public RentPayment() {
    }

    /**
     * 
     * @param amount
     * @param updatedAt
     * @param id
     * @param v
     * @param payuMoneyId
     * @param txnid
     * @param status
     * @param createdAt
     * @param paymentGatewayType
     * @param webuserId
     * @param bankRefNum
     * @param mode
     */
    public RentPayment(String id, String updatedAt, String createdAt, String mode, String txnid, Double amount, String status, String paymentGatewayType, String bankRefNum, String payuMoneyId, String webuserId, Double v) {
        super();
        this.id = id;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.mode = mode;
        this.txnid = txnid;
        this.amount = amount;
        this.status = status;
        this.paymentGatewayType = paymentGatewayType;
        this.bankRefNum = bankRefNum;
        this.payuMoneyId = payuMoneyId;
        this.webuserId = webuserId;
        this.v = v;
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTxnid() {
        return txnid;
    }

    public void setTxnid(String txnid) {
        this.txnid = txnid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentGatewayType() {
        return paymentGatewayType;
    }

    public void setPaymentGatewayType(String paymentGatewayType) {
        this.paymentGatewayType = paymentGatewayType;
    }

    public String getBankRefNum() {
        return bankRefNum;
    }

    public void setBankRefNum(String bankRefNum) {
        this.bankRefNum = bankRefNum;
    }

    public String getPayuMoneyId() {
        return payuMoneyId;
    }

    public void setPayuMoneyId(String payuMoneyId) {
        this.payuMoneyId = payuMoneyId;
    }

    public String getWebuserId() {
        return webuserId;
    }

    public void setWebuserId(String webuserId) {
        this.webuserId = webuserId;
    }

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(updatedAt);
        dest.writeValue(createdAt);
        dest.writeValue(mode);
        dest.writeValue(txnid);
        dest.writeValue(amount);
        dest.writeValue(status);
        dest.writeValue(paymentGatewayType);
        dest.writeValue(bankRefNum);
        dest.writeValue(payuMoneyId);
        dest.writeValue(webuserId);
        dest.writeValue(v);
    }

    public int describeContents() {
        return  0;
    }

}

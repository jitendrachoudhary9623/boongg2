package com.boongg.store.Models.Responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentMethod implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("paymentType")
    @Expose
    private String paymentType;
    @SerializedName("__v")
    @Expose
    private Integer __v;
    public final static Parcelable.Creator<PaymentMethod> CREATOR = new Creator<PaymentMethod>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PaymentMethod createFromParcel(Parcel in) {
            return new PaymentMethod(in);
        }

        public PaymentMethod[] newArray(int size) {
            return (new PaymentMethod[size]);
        }

    }
            ;

    protected PaymentMethod(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentType = ((String) in.readValue((String.class.getClassLoader())));
        this.__v = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public PaymentMethod() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(paymentType);
        dest.writeValue(__v);
    }

    public int describeContents() {
        return 0;
    }

}
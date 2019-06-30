package com.boongg.store.Models.Requests;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ViewOffer implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("coupenCode")
    @Expose
    private String coupenCode;
    @SerializedName("maxDiscount")
    @Expose
    private Integer maxDiscount;
    @SerializedName("minTransaction")
    @Expose
    private Integer minTransaction;
    @SerializedName("discountType")
    @Expose
    private String discountType;
    @SerializedName("discountInPrecentOrFlat")
    @Expose
    private Integer discountInPrecentOrFlat;
    @SerializedName("__v")
    @Expose
    private Integer __v;
    @SerializedName("usedByUser")
    @Expose
    private List<String> usedByUser = null;
    public final static Parcelable.Creator<ViewOffer> CREATOR = new Creator<ViewOffer>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ViewOffer createFromParcel(Parcel in) {
            return new ViewOffer(in);
        }

        public ViewOffer[] newArray(int size) {
            return (new ViewOffer[size]);
        }

    }
            ;

    protected ViewOffer(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.coupenCode = ((String) in.readValue((String.class.getClassLoader())));
        this.maxDiscount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.minTransaction = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.discountType = ((String) in.readValue((String.class.getClassLoader())));
        this.discountInPrecentOrFlat = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.__v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.usedByUser, (java.lang.String.class.getClassLoader()));
    }

    public ViewOffer() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCoupenCode() {
        return coupenCode;
    }

    public void setCoupenCode(String coupenCode) {
        this.coupenCode = coupenCode;
    }

    public Integer getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Integer maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public Integer getMinTransaction() {
        return minTransaction;
    }

    public void setMinTransaction(Integer minTransaction) {
        this.minTransaction = minTransaction;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Integer getDiscountInPrecentOrFlat() {
        return discountInPrecentOrFlat;
    }

    public void setDiscountInPrecentOrFlat(Integer discountInPrecentOrFlat) {
        this.discountInPrecentOrFlat = discountInPrecentOrFlat;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public List<String> getUsedByUser() {
        return usedByUser;
    }

    public void setUsedByUser(List<String> usedByUser) {
        this.usedByUser = usedByUser;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(coupenCode);
        dest.writeValue(maxDiscount);
        dest.writeValue(minTransaction);
        dest.writeValue(discountType);
        dest.writeValue(discountInPrecentOrFlat);
        dest.writeValue(__v);
        dest.writeList(usedByUser);
    }

    public int describeContents() {
        return 0;
    }

}
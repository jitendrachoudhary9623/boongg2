package com.boongg.store.Models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BrandList implements Parcelable
{
    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("brandName")
    @Expose
    private String brandName;
    @SerializedName("__v")
    @Expose
    private Double __v;
    @SerializedName("models")
    @Expose
    private List<String> models = null;
    public final static Parcelable.Creator<BrandList> CREATOR = new Creator<BrandList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public BrandList createFromParcel(Parcel in) {
            return new BrandList(in);
        }

        public BrandList[] newArray(int size) {
            return (new BrandList[size]);
        }

    };

    protected BrandList(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.brandName = ((String) in.readValue((String.class.getClassLoader())));
        this.__v = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.models, (java.lang.String.class.getClassLoader()));
    }
    public BrandList() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Double get__v() {
        return __v;
    }

    public void set__v(Double __v) {
        this.__v = __v;
    }

    public List<String> getModels() {
        return models;
    }

    public void setModels(List<String> models) {
        this.models = models;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(brandName);
        dest.writeValue(__v);
        dest.writeList(models);
    }

    public int describeContents() {
        return 0;
    }

}


package com.boongg.store.Models.Responses.NearbyVehicles;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brand implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("brandName")
    @Expose
    private String brandName;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("models")
    @Expose
    private List<String> models = null;
    public final static Parcelable.Creator<Brand> CREATOR = new Creator<Brand>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Brand createFromParcel(Parcel in) {
            return new Brand(in);
        }

        public Brand[] newArray(int size) {
            return (new Brand[size]);
        }

    }
    ;

    protected Brand(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.brandName = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.models, (java.lang.String.class.getClassLoader()));
    }

    public Brand() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public List<String> getModels() {
        return models;
    }

    public void setModels(List<String> models) {
        this.models = models;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(brandName);
        dest.writeValue(v);
        dest.writeList(models);
    }

    public int describeContents() {
        return  0;
    }

}

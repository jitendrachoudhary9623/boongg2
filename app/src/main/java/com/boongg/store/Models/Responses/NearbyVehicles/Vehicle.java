
package com.boongg.store.Models.Responses.NearbyVehicles;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle implements Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("totalQuantity")
    @Expose
    private Double totalQuantity;
    @SerializedName("isRentPage")
    @Expose
    private Boolean isRentPage;
    @SerializedName("brands")
    @Expose
    private List<Brand> brands = null;
    @SerializedName("locality")
    @Expose
    private List<Locality> locality = null;
    @SerializedName("citys")
    @Expose
    private List<String> citys = null;
    public final static Parcelable.Creator<Vehicle> CREATOR = new Creator<Vehicle>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        public Vehicle[] newArray(int size) {
            return (new Vehicle[size]);
        }

    }
    ;

    protected Vehicle(Parcel in) {
        in.readList(this.results, (com.boongg.store.Models.Responses.NearbyVehicles.Result.class.getClassLoader()));
        this.totalQuantity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.isRentPage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.brands, (com.boongg.store.Models.Responses.NearbyVehicles.Brand.class.getClassLoader()));
        in.readList(this.locality, (com.boongg.store.Models.Responses.NearbyVehicles.Locality.class.getClassLoader()));
        in.readList(this.citys, (java.lang.String.class.getClassLoader()));
    }

    public Vehicle() {
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Boolean getIsRentPage() {
        return isRentPage;
    }

    public void setIsRentPage(Boolean isRentPage) {
        this.isRentPage = isRentPage;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<Locality> getLocality() {
        return locality;
    }

    public void setLocality(List<Locality> locality) {
        this.locality = locality;
    }

    public List<String> getCitys() {
        return citys;
    }

    public void setCitys(List<String> citys) {
        this.citys = citys;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(totalQuantity);
        dest.writeValue(isRentPage);
        dest.writeList(brands);
        dest.writeList(locality);
        dest.writeList(citys);
    }

    public int describeContents() {
        return  0;
    }

}

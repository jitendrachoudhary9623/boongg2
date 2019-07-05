
package com.boongg.store.Models.Requests;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.boongg.store.Models.Responses.NearbyVehicles.Address;
import com.boongg.store.Models.Responses.NearbyVehicles.MapAddr;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BikeList implements Parcelable
{

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("modelName")
    @Expose
    private String modelName;
    @SerializedName("weekDayPrice")
    @Expose
    private Double weekDayPrice;
    @SerializedName("weekEndPrice")
    @Expose
    private Double weekEndPrice;
    @SerializedName("mapAddr")
    @Expose
    private MapAddr mapAddr;
    @SerializedName("address")
    @Expose
    private List<Address> address = null;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("rentCalculated")
    @Expose
    private Double rentCalculated;
    @SerializedName("thumbUrl")
    @Expose
    private String thumbUrl;
    @SerializedName("isAddtoCart")
    @Expose
    private Boolean isAddtoCart;
    @SerializedName("startDate")
    @Expose
    private Long startDate;
    @SerializedName("endDate")
    @Expose
    private Long endDate;
    @SerializedName("cartRent")
    @Expose
    private Double cartRent;
    @SerializedName("cartQuantity")
    @Expose
    private Double cartQuantity;
    @SerializedName("quantityList")
    @Expose
    private List<Double> quantityList = null;
    public final static Creator<BikeList> CREATOR = new Creator<BikeList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BikeList createFromParcel(Parcel in) {
            return new BikeList(in);
        }

        public BikeList[] newArray(int size) {
            return (new BikeList[size]);
        }

    }
    ;

    protected BikeList(Parcel in) {
        this.key = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.modelName = ((String) in.readValue((String.class.getClassLoader())));
        this.weekDayPrice = ((Double) in.readValue((Double.class.getClassLoader())));
        this.weekEndPrice = ((Double) in.readValue((Double.class.getClassLoader())));
        this.mapAddr = ((MapAddr) in.readValue((MapAddr.class.getClassLoader())));
        in.readList(this.address, (Address.class.getClassLoader()));
        this.quantity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.rentCalculated = ((Double) in.readValue((Double.class.getClassLoader())));
        this.thumbUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.isAddtoCart = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.startDate = ((Long) in.readValue((Long.class.getClassLoader())));
        this.endDate = ((Long) in.readValue((Long.class.getClassLoader())));
        this.cartRent = ((Double) in.readValue((Double.class.getClassLoader())));
        this.cartQuantity = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.quantityList, (Double.class.getClassLoader()));
    }

    public BikeList() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getWeekDayPrice() {
        return weekDayPrice;
    }

    public void setWeekDayPrice(Double weekDayPrice) {
        this.weekDayPrice = weekDayPrice;
    }

    public Double getWeekEndPrice() {
        return weekEndPrice;
    }

    public void setWeekEndPrice(Double weekEndPrice) {
        this.weekEndPrice = weekEndPrice;
    }

    public MapAddr getMapAddr() {
        return mapAddr;
    }

    public void setMapAddr(MapAddr mapAddr) {
        this.mapAddr = mapAddr;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRentCalculated() {
        return rentCalculated;
    }

    public void setRentCalculated(Double rentCalculated) {
        this.rentCalculated = rentCalculated;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public Boolean getIsAddtoCart() {
        return isAddtoCart;
    }

    public void setIsAddtoCart(Boolean isAddtoCart) {
        this.isAddtoCart = isAddtoCart;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public Double getCartRent() {
        return cartRent;
    }

    public void setCartRent(Double cartRent) {
        this.cartRent = cartRent;
    }

    public Double getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Double cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public List<Double> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(List<Double> quantityList) {
        this.quantityList = quantityList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(key);
        dest.writeValue(brand);
        dest.writeValue(modelName);
        dest.writeValue(weekDayPrice);
        dest.writeValue(weekEndPrice);
        dest.writeValue(mapAddr);
        dest.writeList(address);
        dest.writeValue(quantity);
        dest.writeValue(rentCalculated);
        dest.writeValue(thumbUrl);
        dest.writeValue(isAddtoCart);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeValue(cartRent);
        dest.writeValue(cartQuantity);
        dest.writeList(quantityList);
    }

    public int describeContents() {
        return  0;
    }

}

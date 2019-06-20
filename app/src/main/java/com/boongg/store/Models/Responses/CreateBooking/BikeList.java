
package com.boongg.store.Models.Responses.CreateBooking;

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
    private Integer weekDayPrice;
    @SerializedName("weekEndPrice")
    @Expose
    private Integer weekEndPrice;
    @SerializedName("mapAddr")
    @Expose
    private MapAddr mapAddr;
    @SerializedName("address")
    @Expose
    private List<Address> address = null;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("rentCalculated")
    @Expose
    private Integer rentCalculated;
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
    private Integer cartRent;
    @SerializedName("cartQuantity")
    @Expose
    private Integer cartQuantity;
    @SerializedName("quantityList")
    @Expose
    private List<Integer> quantityList = null;
    public final static Parcelable.Creator<BikeList> CREATOR = new Creator<BikeList>() {


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
        this.weekDayPrice = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.weekEndPrice = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mapAddr = ((MapAddr) in.readValue((MapAddr.class.getClassLoader())));
        in.readList(this.address, (com.boongg.store.Models.Responses.NearbyVehicles.Address.class.getClassLoader()));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rentCalculated = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.thumbUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.isAddtoCart = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.startDate = ((Long) in.readValue((Long.class.getClassLoader())));
        this.endDate = ((Long) in.readValue((Long.class.getClassLoader())));
        this.cartRent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cartQuantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.quantityList, (java.lang.Integer.class.getClassLoader()));
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

    public Integer getWeekDayPrice() {
        return weekDayPrice;
    }

    public void setWeekDayPrice(Integer weekDayPrice) {
        this.weekDayPrice = weekDayPrice;
    }

    public Integer getWeekEndPrice() {
        return weekEndPrice;
    }

    public void setWeekEndPrice(Integer weekEndPrice) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRentCalculated() {
        return rentCalculated;
    }

    public void setRentCalculated(Integer rentCalculated) {
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

    @Override
    public String toString() {
        return "{" +
                "key='" + key + '\'' +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", weekDayPrice=" + weekDayPrice +
                ", weekEndPrice=" + weekEndPrice +
                ", mapAddr=" + mapAddr +
                ", address=" + address +
                ", quantity=" + quantity +
                ", rentCalculated=" + rentCalculated +
                ", thumbUrl='" + thumbUrl + '\'' +
                ", isAddtoCart=" + isAddtoCart +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", cartRent=" + cartRent +
                ", cartQuantity=" + cartQuantity +
                ", quantityList=" + quantityList +
                '}';
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public Integer getCartRent() {
        return cartRent;
    }

    public void setCartRent(Integer cartRent) {
        this.cartRent = cartRent;
    }

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Integer cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public List<Integer> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(List<Integer> quantityList) {
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

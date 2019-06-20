package com.boongg.store.Models.Responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateUserSuccessResponse implements Parcelable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private Data data;
    public final static Parcelable.Creator<CreateUserSuccessResponse> CREATOR = new Creator<CreateUserSuccessResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CreateUserSuccessResponse createFromParcel(Parcel in) {
            return new CreateUserSuccessResponse(in);
        }

        public CreateUserSuccessResponse[] newArray(int size) {
            return (new CreateUserSuccessResponse[size]);
        }

    }
            ;

    protected CreateUserSuccessResponse(Parcel in) {
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public CreateUserSuccessResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeValue(data);
    }

    public int describeContents() {
        return 0;
    }

}


class Data implements Parcelable
{

    @SerializedName("otp")
    @Expose
    private String otp;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    public final static Parcelable.Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
            ;

    protected Data(Parcel in) {
        this.otp = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.profile = ((Profile) in.readValue((Profile.class.getClassLoader())));
    }

    public Data() {
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(otp);
        dest.writeValue(email);
        dest.writeValue(id);
        dest.writeValue(profile);
    }

    public int describeContents() {
        return 0;
    }

}
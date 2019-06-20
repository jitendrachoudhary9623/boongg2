
package com.boongg.store.Models.Responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchUSer implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("otp")
    @Expose
    private String otp;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("isMobileVerified")
    @Expose
    private Boolean isMobileVerified;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    public final static Parcelable.Creator<SearchUSer> CREATOR = new Creator<SearchUSer>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SearchUSer createFromParcel(Parcel in) {
            return new SearchUSer(in);
        }

        public SearchUSer[] newArray(int size) {
            return (new SearchUSer[size]);
        }

    }
    ;

    protected SearchUSer(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.otp = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.isMobileVerified = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.profile = ((Profile) in.readValue((Profile.class.getClassLoader())));
    }

    public SearchUSer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Boolean getIsMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(Boolean isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(otp);
        dest.writeValue(email);
        dest.writeValue(isMobileVerified);
        dest.writeValue(profile);
    }

    public int describeContents() {
        return  0;
    }

}

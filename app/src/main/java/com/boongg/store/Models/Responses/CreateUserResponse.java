package com.boongg.store.Models.Responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateUserResponse implements Parcelable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Parcelable.Creator<CreateUserResponse> CREATOR = new Creator<CreateUserResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CreateUserResponse createFromParcel(Parcel in) {
            return new CreateUserResponse(in);
        }

        public CreateUserResponse[] newArray(int size) {
            return (new CreateUserResponse[size]);
        }

    }
            ;

    protected CreateUserResponse(Parcel in) {
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CreateUserResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeValue(message);
    }

    public int describeContents() {
        return 0;
    }

}
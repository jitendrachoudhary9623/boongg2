package com.boongg.store.Models.Requests.UploadFiles;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormData implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("docType")
    @Expose
    private String docType;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    public final static Parcelable.Creator<FormData> CREATOR = new Creator<FormData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FormData createFromParcel(Parcel in) {
            return new FormData(in);
        }

        public FormData[] newArray(int size) {
            return (new FormData[size]);
        }

    }
            ;

    protected FormData(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.docType = ((String) in.readValue((String.class.getClassLoader())));
        this.expiryDate = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FormData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(docType);
        dest.writeValue(expiryDate);
    }

    public int describeContents() {
        return 0;
    }

}
package com.boongg.store.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token implements Parcelable
{

    public final static Parcelable.Creator<Token> CREATOR = new Creator<Token>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Token createFromParcel(Parcel in) {
            return new Token(in);
        }

        public Token[] newArray(int size) {
            return (new Token[size]);
        }

    };
    @SerializedName("token")
    @Expose
    private String token;

    protected Token(Parcel in) {
        this.token = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Token() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(token);
    }

    public int describeContents() {
        return 0;
    }

}

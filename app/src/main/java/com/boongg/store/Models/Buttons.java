package com.boongg.store.Models;

public class Buttons {
    String Buttton;
    int imageId;

    public Buttons(String buttton, int imageId) {
        Buttton = buttton;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Buttons(String buttton) {
        Buttton = buttton;
    }

    public String getButtton() {
        return Buttton;
    }

    public void setButtton(String buttton) {
        Buttton = buttton;
    }
}

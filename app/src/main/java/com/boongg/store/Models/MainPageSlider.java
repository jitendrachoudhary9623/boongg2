package com.boongg.store.Models;

public class MainPageSlider {

    String item1,item2,value1,value2,title;
    String item3,value3;
    int level;

    public int getLevel() {
        return level;
    }

    public MainPageSlider(String item1, String item2, String value1, String value2, String title, int level) {
        this.item1 = item1;
        this.item2 = item2;
        this.value1 = value1;
        this.value2 = value2;
        this.title = title;
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public MainPageSlider(String item1, String item2, String value1, String value2, String title, String item3, String value3, int level) {
        this.item1 = item1;
        this.item2 = item2;
        this.value1 = value1;
        this.value2 = value2;
        this.title = title;
        this.item3 = item3;
        this.value3 = value3;
        this.level = level;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public MainPageSlider(String item1, String item2, String item3, String value1, String value2,  String value3,String title) {
        this.item1 = item1;
        this.item2 = item2;
        this.value1 = value1;
        this.value2 = value2;
        this.title = title;
        this.item3 = item3;
        this.value3 = value3;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MainPageSlider(String item1, String item2, String value1, String value2, String title) {
        this.item1 = item1;
        this.item2 = item2;
        this.value1 = value1;
        this.value2 = value2;
        this.title = title;
    }
}

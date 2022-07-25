package com.example.photosharingapp;

public class category {

    String icon_title;
    Integer icon_img;

    public category(String icon_title, Integer icon_img) {
        this.icon_title = icon_title;
        this.icon_img = icon_img;
    }

    public String getIcon_title() {
        return icon_title;
    }

    public void setIcon_title(String icon_title) {
        this.icon_title = icon_title;
    }

    public Integer getIcon_img() {
        return icon_img;
    }

    public void setIcon_img(Integer icon_img) {
        this.icon_img = icon_img;
    }
}

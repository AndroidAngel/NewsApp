package com.androidangel.newsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("sectionId")
    @Expose
    private String sectionId;

    @SerializedName("sectionName")
    @Expose
    private String sectionName;


    @SerializedName("webTitle")
    @Expose
    private String webTitle;

    public String getSectionId() {
        return sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    @Override
    public String toString() {
        return "sectionId='" + sectionId + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", webTitle='" + webTitle + '\'' +
                '}';
    }
}


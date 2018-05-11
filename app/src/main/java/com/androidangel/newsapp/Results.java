package com.androidangel.newsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("sectionId")
    @Expose
    private String sectionId;

    @SerializedName("apiUrl")
    @Expose
    private String apiUrl;

    @SerializedName("webUrl")
    @Expose
    private String webUrl;


    @SerializedName("sectionName")
    @Expose
    private String sectionName;


    @SerializedName("webTitle")
    @Expose
    private String webTitle;

    public String getSectionId() {
        return sectionId;
    }

    public String getWebUrl() {
        return webUrl;
    }


    public String getApiUrl() {
        return apiUrl;
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

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
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


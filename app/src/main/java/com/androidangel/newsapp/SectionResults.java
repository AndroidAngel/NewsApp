package com.androidangel.newsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SectionResults {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("webUrl")
    @Expose
    private String webUrl;

    @SerializedName("webTitle")
    @Expose
    private String webTitle;

    @SerializedName("apiUrl")
    @Expose
    private String apiUrl;

    public String getId() {
        return id;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Override
    public String toString() {
        return "sectionId='" + id + '\'' +
                "apiUrl='" + apiUrl + '\'' +
                "apiUrl='" + apiUrl + '\'' +
                ", webTitle='" + webTitle + '\'' +
                '}';
    }
}

package com.androidangel.newsapp;

import java.io.Serializable;

public class News extends Object implements Serializable {




    public String news_url;
    public String sectionName;
    public String webTitle;

    public String getNews_url() {
        return this.news_url;
    }

    public String getSectionName() {
        return this.sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebTitle() {
        return this.webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }
}

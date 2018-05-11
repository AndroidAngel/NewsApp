package com.androidangel.newsapp;

import java.util.ArrayList;

public interface CallBackHandler {

    void onComplete(ArrayList<NewsData> newsArrayList);

    void onFail(Throwable t);

    void onComplete(NewsData news);
}

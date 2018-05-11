package com.androidangel.newsapp;

import java.util.ArrayList;

public interface CallBackHandler {

    void onComplete(ArrayList<News> newsArrayList);
    void onFail(Throwable t);

    void onComplete(News news);
}

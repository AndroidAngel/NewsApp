package com.androidangel.newsapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private final String API_KEY = "9271ca86-4372-430a-9c6f-b9bb1b837446";

    private final String END_POINT_URL = "https://content.guardianapis.com";


    private NewsAdapter mNewsAdapter;

    private final int MAIN_ACTIVITY_REQUEST_CODE = 1;

    int code;

    // SECOND SCREEN
    //move the itemclickListener to the maincategory activity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
    }
    private void initViews(){
        final ListView lV = findViewById(R.id.mainList);
        mNewsAdapter = new NewsAdapter(this,new ArrayList<News>());
        lV.setAdapter(mNewsAdapter);
        lV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // Intent intent =new Intent(MainCategory.this,MainActivity.class);
                //Intent Intent = new Intent(MainActivity.this, MainCategory.class);




                startActivityForResult(Intent, MAIN_ACTIVITY_REQUEST_CODE);

            }
        });
        NetworkUtils.getNewsDetail(this.END_POINT_URL,this.API_KEY, new CallBackHandler() {
            @Override
            public void onComplete(ArrayList<News>newsArrayList) {

                ArrayList<News>newsArray = newsArrayList;
                mNewsAdapter.clear();
                if (newsArray != null && !newsArray.isEmpty()){
                    mNewsAdapter.addAll(newsArray);
                    Log.i(MainActivity.LOG_TAG, "News retrieved");
                }

            }
            @Override
            public void onComplete(News news){
            News newsArray = news;


            }
            @Override
            public void onFail(Throwable t){
            }
        });


    }


}

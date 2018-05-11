package com.androidangel.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<Results> {


    public NewsAdapter(Context context, List<Results> newsArray) {
        super(context, 0, newsArray);
    }
    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.category_list_item,parent,false);

        }
        Results currentNews = getItem(position);
        TextView sectionTV = listItemView.findViewById(R.id.section_id);
        sectionTV.setText(currentNews.getSectionId());

//        TextView newsName = listItemView.findViewById(R.id.second_view);
//        newsName.setText(currentNews.getWebTitle());
        // for the next activity

        return listItemView;
    }

}

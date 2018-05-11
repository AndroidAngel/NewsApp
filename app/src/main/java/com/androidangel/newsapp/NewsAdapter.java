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
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }
        Results currentNews = getItem(position);
        TextView sectionTV = listItemView.findViewById(R.id.first_view);
        sectionTV.setText(currentNews.getSectionId());

        Results currentNewsTitle = getItem(position);
        TextView sectionTVTitle = listItemView.findViewById(R.id.second_view);
        sectionTVTitle.setText(currentNewsTitle.getWebTitle());

        return listItemView;
    }

}

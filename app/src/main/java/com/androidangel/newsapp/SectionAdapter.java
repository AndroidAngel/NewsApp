package com.androidangel.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SectionAdapter extends ArrayAdapter<SectionResults> {

    public SectionAdapter(Context context, List<SectionResults> sectionsArray) {
        super(context, 0, sectionsArray);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.category_list_item, parent, false);

        }


        SectionResults currentSectionWT = getItem(position);
        TextView sectionTVWebTitle = listItemView.findViewById(R.id.sectiontitle);
        sectionTVWebTitle.setText(currentSectionWT.getWebTitle());


        return listItemView;
    }
}
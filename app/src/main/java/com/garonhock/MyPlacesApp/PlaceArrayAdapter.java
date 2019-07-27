package com.garonhock.MyPlacesApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PlaceArrayAdapter extends ArrayAdapter <Place> {


    //PlaceArrayAdapter speaks to ListView directly
    public PlaceArrayAdapter(Context context, List<Place> objects) {
        super(context, android.R.layout.simple_expandable_list_item_1,  objects);
        //needs to be equivalent to ....
        //mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myPlaces);



    }

    //Can Control every row, by overriding a method
    //Each row is a view

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Place currentItem = getItem(position); //getItem method is part of arrayAdapter
        //if you give it a position, will give you that object from the list you gave it

        //need to inflate
        //what layout belongs in each row
        //have to put layout in the view

        // need to figure out if our view has been inflated or not

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_layout, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.row_title);
        TextView subTitle = (TextView) convertView.findViewById(R.id.row_sub_title);

        title.setText(currentItem.getName());
        subTitle.setText(currentItem.getDescription());

        return convertView;
    }
}

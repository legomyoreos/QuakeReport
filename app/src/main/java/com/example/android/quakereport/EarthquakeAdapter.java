package com.example.android.quakereport;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

        @Override
        public View getView ( int position, View convertView, ViewGroup parent){

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text);
        String magnitudeStrength = Double.valueOf(currentEarthquake.getmMagnitude()).toString();
        magnitudeTextView.setText(magnitudeStrength);

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text);
        locationTextView.setText(currentEarthquake.getmLocation());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text);
        dateTextView.setText(currentEarthquake.getmDate());


        return listItemView;
    }
}

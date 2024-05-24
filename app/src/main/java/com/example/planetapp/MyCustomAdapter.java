package com.example.planetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    // Using custom layouts --> myCustomAdapter
    // Using Custom Objects --> extends ArrayAdapter<Planet>

    private ArrayList<Planet> planetsArrayList = new ArrayList<Planet>();

    Context context;

    public MyCustomAdapter(ArrayList<Planet> planetsArrayList, Context context) {
        // the custom adapter  will take care of inflating this layout for every single item in the planetsArrayList
        super(context, R.layout.item_list_layout, planetsArrayList);
        this.context = context;
    }



    // View Holder Class: used to cache references to
    // the views within an item layout,
    // so that they don't need to be repeatedly looked up during scrolling
    private static class ViewHolder{
    ImageView imageImg;
    TextView planetName;
    TextView moonCount;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

      //1. Get the planet object for the current position
       // get item method is a method inherited from the array adapter class and it's used to retrieve the data item
        Planet planet = getItem(position);

         final View result;
        //2. Inflate layout
        ViewHolder myViewHolder = new ViewHolder();

        if (convertView == null) {
//            myViewHolder = LayoutInflater.from(this.context).inflate(R.layout.item_list_layout, )
        LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.item_list_layout, parent, false);
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moon_count);
            myViewHolder.imageImg = (ImageView) convertView.findViewById(R.id.imageView);

            // set tag is used to attach an arbitrary object to the view object.
            // this tag can be any object that you find useful for associating additional data or information with.
            convertView.setTag(myViewHolder);

        } else {
            //the view is recycled
            // getTag is used to retrieve an object that was previously set as a tag using the set tag method on the view object
            myViewHolder = (ViewHolder) convertView.getTag();

        }

        // Getting the data from model class (Planet)
        assert planet != null;
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.imageImg.setImageResource(planet.getPlanetImage());

        result = convertView;


        return result;



    }
}

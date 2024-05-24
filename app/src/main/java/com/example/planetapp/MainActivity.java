package com.example.planetapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        ListView listView;
        ArrayList<Planet> planetArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. adapterView: a listView
        listView = findViewById(R.id.listView);

        // 2. Data Source: Arraylist<Planet>
        planetArrayList = new ArrayList<>();

        Planet planet3 = new Planet("Earth", "1 Moons", R.drawable.earth);
        Planet planet1 = new Planet("Mercury", "0 Moons", R.drawable.mercury);
        Planet planet2 = new Planet("Venus", "0 Moons", R.drawable.venus);
        Planet planet4 =  new Planet("Mars", "2 Moons", R.drawable.mars);
        Planet planet5 = new Planet("Jupiter", "79 Moons", R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn", "83 Moons", R.drawable.saturn);

        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);
        planetArrayList.add(planet6);

        // the getApplicationCOntext is used to obtain global application context. It's a method provided by the context class commonly used throughout the Android development to access application level resources and services.
        MyCustomAdapter adapter = new MyCustomAdapter(planetArrayList, getApplicationContext());
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // adapter view: referes to the adapter view in which the click event occured. It can represent a list, view, grid, view or other adapter view widgets.
            // view: represents the speicific view that was clicked within the adapter view. It's the view representing the item that the user interacted with the position, which is an INT.
            // position: indicated the position of the clicked item within the adapter veiws list of items. the position is zero based
            // id: it holds the row id of the clicked item
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Planet Name: " + adapter.getItem(position).getPlanetName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
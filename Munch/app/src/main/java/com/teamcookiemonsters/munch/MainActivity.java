package com.teamcookiemonsters.munch;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Location> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvLocations = (RecyclerView) findViewById(R.id.rvLocations);

        locations = Location.createLocationsList(20);
        LocationsAdapter adapter = new LocationsAdapter(this, locations);
        rvLocations.setAdapter(adapter);
        rvLocations.setLayoutManager(new LinearLayoutManager(this));

        /*
        //Button naviButton = (Button) findViewById(R.id.navi_button);
        naviButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent naviIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/" +
                        "Jack+Baskin+School+Of+Engineering/@37.000353,-122.065333,17z/" +
                        "data=!3m2!4b1!5s0x808e417502b520a5:0x8580897e3de81364!4m5!3m4!1s0x808e4174e0eafc51:" +
                        "0x13397e072d0f2a67!8m2!3d37.000353!4d-122.0631443?hl=en"));
                startActivity(naviIntent);
            }
        });
        */
    }
}

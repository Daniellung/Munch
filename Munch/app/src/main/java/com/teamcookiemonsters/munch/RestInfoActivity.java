package com.teamcookiemonsters.munch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RestInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_info);

        // receive passed in restaurant info
        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String address1 = getIntent().getStringExtra("address1");
        String address2 = getIntent().getStringExtra("address2");
        String address3 = getIntent().getStringExtra("address3");
        String city = getIntent().getStringExtra("city");
        String state = getIntent().getStringExtra("state");
        String country = getIntent().getStringExtra("country");
        String zipcode = getIntent().getStringExtra("zipcode");
        //final Double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        //final Double longitude = getIntent().getDoubleExtra("longitude", 0.0);
        //String url = getIntent().getStringExtra("url");

        // display texts
        TextView phoneText = (TextView) findViewById(R.id.phone_text);
        TextView address1Text = (TextView) findViewById(R.id.address1_text);
        TextView address2Text = (TextView) findViewById(R.id.address2_text);
        TextView address3Text = (TextView) findViewById(R.id.address3_text);
        TextView cityText = (TextView) findViewById(R.id.city_text);
        TextView stateText = (TextView) findViewById(R.id.state_text);
        TextView countryText = (TextView) findViewById(R.id.country_text);
        TextView zipcodeText = (TextView) findViewById(R.id.zipcode_text);
        //TextView urlText = (TextView) findViewById(R.id.url_text);

        phoneText.setText(phone);
        address1Text.setText(address1);
        address2Text.setText(address2);
        address3Text.setText(address3);
        cityText.setText(city);
        stateText.setText(state);
        countryText.setText(country);
        zipcodeText.setText(zipcode);
        //urlText.setText(url);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /*
        Button goMap = (Button) findViewById(R.id.button);
        goMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String googlemaps = "http://www.google.com/maps/place/"+ latitude + "," + longitude;
                Intent naviIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(googlemaps));
                startActivity(naviIntent);
            }
        });
        */
    }
}
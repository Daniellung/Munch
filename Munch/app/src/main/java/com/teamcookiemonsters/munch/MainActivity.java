package com.teamcookiemonsters.munch;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import android.widget.TextView;
import java.io.OutputStreamWriter;

import android.app.Dialog;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.SupportMapFragment;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR_DOALOG_REQUEST = 9001;

    private static final String FINE_LOCATION = android.Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = android.Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private Boolean mLocationPermissionsGranted = false;

    TextView textView;

    EditText mEdit;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLocationPermission();

        if(isServicesOK()){
            init();
        }


        // initialize button
        Button goSearch = (Button) findViewById(R.id.button1);
        Button goNavi = (Button) findViewById(R.id.button3);
        Button goPref = (Button) findViewById(R.id.button4);
        // set up listener

        goNavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent naviIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/" +
                        "Jack+Baskin+School+Of+Engineering/@37.000353,-122.065333,17z/" +
                        "data=!3m2!4b1!5s0x808e417502b520a5:0x8580897e3de81364!4m5!3m4!1s0x808e4174e0eafc51:" +
                        "0x13397e072d0f2a67!8m2!3d37.000353!4d-122.0631443?hl=en"));
                startActivity(naviIntent);
            }
        });

        goSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mEdit   = (EditText)findViewById(R.id.searchText);
                text = mEdit.getText().toString();
                SearchItem newSearch = new SearchItem();
                newSearch.setSearch(text);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("Search", newSearch);
                startActivity(intent);
            }
        });

        goPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View k) {
                Intent pref = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(pref);
            }
        });



        //Button button2 = (Button) findViewById(R.id.button2);
        //Intent map = new Intent(this,Main3Activity.class);
        //startActivity(map);
    }

    private void init(){
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance()
                .isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance()
                    .getErrorDialog(MainActivity.this, available, ERROR_DOALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    private void getLocationPermission() {
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permisssions = {android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionsGranted = true;
                //initMap();
            } else {
                ActivityCompat.requestPermissions(this,
                        permisssions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(this,
                    permisssions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

}

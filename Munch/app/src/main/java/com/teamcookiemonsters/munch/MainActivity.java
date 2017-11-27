package com.teamcookiemonsters.munch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR_DOALOG_REQUEST = 9001;

    TextView textView;

    EditText mEdit;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isServicesOK()){
            init();
        }


        // initialize button
        Button goSearch = (Button) findViewById(R.id.button1);
        // set up listener


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
}


package com.teamcookiemonsters.munch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    EditText mEdit;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    }


}


package com.teamcookiemonsters.munch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class RestInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_info);

        // receive passed in restaurant info
        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        //String url = getIntent().getStringExtra("url");

        // display texts
        TextView phoneText = (TextView) findViewById(R.id.phone_text);
        //TextView urlText = (TextView) findViewById(R.id.url_text);

        phoneText.setText(phone);
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
    }
}

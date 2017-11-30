package com.teamcookiemonsters.munch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;



public class Main4Activity extends AppCompatActivity {
    boolean[] checked = new boolean[5];
    CheckBox OpenNow, Dollar1, Dollar2, Dollar3, Dollar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        OpenNow = (CheckBox) findViewById(R.id.checkBox1);
        //OpenNow.setChecked(false);
        OpenNow.setText("Open Now");
        Dollar1 = (CheckBox) findViewById(R.id.checkBox2);
        //Dollar1.setOnClickListener(this);
        //Dollar1.setChecked(true);
        Dollar2 = (CheckBox) findViewById(R.id.checkBox3);
        //Dollar2.setOnClickListener(this);
        //Dollar2.setChecked(true);
        Dollar3 = (CheckBox) findViewById(R.id.checkBox4);
        //Dollar3.setOnClickListener(this);
        //Dollar3.setChecked(true);
        Dollar4 = (CheckBox) findViewById(R.id.checkBox5);
        //Dollar4.setOnClickListener(this);
        //Dollar4.setChecked(true);


    }
    public boolean isOpenNow(){
        if(OpenNow.isChecked()) return true;
        else return false;
    }
}
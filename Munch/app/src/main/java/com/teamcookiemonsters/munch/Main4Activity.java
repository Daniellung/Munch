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
    CheckBox OpenNow, Dollar1, Dollar2, Dollar3, Dollar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        OpenNow = (CheckBox) findViewById(R.id.checkBox1);
        //OpenNow.setChecked(false);
        OpenNow.setOnClickListener(PrefListen);
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
        if(OpenNow.isChecked()) {
            System.out.println("isChecked");
            return true;
        }
        else return false;
    }
    private View.OnClickListener PrefListen = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            // Yes we will handle click here but which button clicked??? We don't know

            // So we will make
            switch (v.getId() /*to get clicked view id**/) {
                case R.id.checkBox1:
                    //if(Dollar1.setChecked(true));
                    // do something when the corky is clicked

                    break;
                case R.id.checkBox2:

                    // do something when the corky2 is clicked

                    break;
                case R.id.checkBox3:

                    // do something when the corky3 is clicked

                    break;
                default:
                    break;
            }
        }
    };

}
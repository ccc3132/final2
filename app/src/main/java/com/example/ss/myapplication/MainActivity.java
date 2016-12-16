package com.example.ss.myapplication;

import android.graphics.Color;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Switch Sw1;
    Chronometer C1;
    LinearLayout Li1;
    EditText Ed1;
    EditText Ed2;
    EditText Ed3;

    TextView Te1;
    TextView Te2;
    TextView Te3;

    Button b1;
    Button b2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){
        Sw1 = (Switch) findViewById(R.id.switch1);
        C1 = (Chronometer) findViewById(R.id.chronometer2);
        Li1 = (LinearLayout) findViewById(R.id.linearlayout);

        Ed1 = (EditText) findViewById(R.id.editText);
        Ed2 = (EditText) findViewById(R.id.editText2);
        Ed3 = (EditText) findViewById(R.id.editText3);

        Te1 = (TextView) findViewById(R.id.textView4);
        Te2 = (TextView) findViewById(R.id.textView5);
        Te3 = (TextView) findViewById(R.id.textView6);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);


        Sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    C1.setBase(SystemClock.elapsedRealtime());
                    C1.start();
                    C1.setBackgroundColor(Color.BLUE);
                }
                else
                {
                    return;
                }
            }
        });
    }
}

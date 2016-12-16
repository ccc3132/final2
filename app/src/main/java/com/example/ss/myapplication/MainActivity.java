package com.example.ss.myapplication;

import android.graphics.Color;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Switch Sw1;
    Chronometer C1;
    LinearLayout Li1;
    LinearLayout Li2;
    EditText Ed1;
    EditText Ed2;
    EditText Ed3;

    TextView Te1;
    TextView Te2;
    TextView Te3;
    TextView Te10;
    TextView Te11;
    TextView Te12;


    ImageView I1;

    Button b1;
    Button b2;
    Button b3;
    Button b4;

    RadioGroup Ra1;
    RadioGroup Ra2;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    RadioButton r5;

    TimePicker ti1;
    CalendarView Ca1;


    int result = 0;
    int sum = 0;
    int sale = 0;
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

        I1 = (ImageView) findViewById(R.id.imageView);

        Te1 = (TextView) findViewById(R.id.textView4);
        Te2 = (TextView) findViewById(R.id.textView5);
        Te3 = (TextView) findViewById(R.id.textView6);
        Te10 = (TextView) findViewById(R.id.textView10);
        Te11 = (TextView) findViewById(R.id.textView11);
        Te12 = (TextView) findViewById(R.id.textView12);


        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);

        Ra1= (RadioGroup) findViewById(R.id.radiogroup);
        Ra2 = (RadioGroup) findViewById(R.id.radiogroup2);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);
        r5 = (RadioButton) findViewById(R.id.radioButton5);

        Li2 = (LinearLayout) findViewById(R.id.layout2);


        ti1 = (TimePicker) findViewById(R.id.timePicker);
        Ca1 = (CalendarView) findViewById(R.id.calendarView);




        Sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    C1.setBase(SystemClock.elapsedRealtime());
                    C1.start();
                    C1.setTextColor(Color.BLUE);
                    Li1.setVisibility(View.VISIBLE);
                    ti1.setVisibility(View.GONE);
                    Ca1.setVisibility(View.GONE);
                }
                else
                {
                    return;
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                noli(1);
            }
        });


        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Li1.setVisibility(View.GONE);
            Li2.setVisibility(View.VISIBLE);
            }
        });
        Ra1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if(r1.isChecked()){
                    I1.setImageResource(R.drawable.noli1);
                }
                else if(r2.isChecked()){
                    I1.setImageResource(R.drawable.noli2);
                }
                else if(r3.isChecked()){
                    I1.setImageResource(R.drawable.noli3);
                }
                  else
                    return;
            }
        });


        Ra2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if(r4.isChecked()){
                    Ca1.setVisibility(View.VISIBLE);
                    ti1.setVisibility(View.GONE);
                }
                else if(r5.isChecked()){
                    Ca1.setVisibility(View.GONE);
                    ti1.setVisibility(View.VISIBLE);
                }
                else
                    return;
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ed1.getText().length() == 0 ||Ed2.getText().length() == 0 ||Ed3.getText().length() == 0){
                    Toast.makeText(getApplicationContext(),"인원예약을 먼저하세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                C1.stop();
                Toast.makeText(getApplicationContext(),"예약이 완료되었습니다.",Toast.LENGTH_SHORT).show();
                return;
            }
        });

        b4.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Li1.setVisibility(View.VISIBLE);
                Li2.setVisibility(View.GONE);
            }
        });




    }

    public void noli(int a){
        if(Ed1.getText().length() == 0 ||Ed2.getText().length() == 0 ||Ed3.getText().length() == 0){
            Toast.makeText(getApplicationContext(),"인원예약을 먼저하세요.",Toast.LENGTH_SHORT).show();
            return;
        }

        int num1 = Integer.parseInt(Ed1.getText().toString());
        int num2 = Integer.parseInt(Ed2.getText().toString());
        int num3 = Integer.parseInt(Ed3.getText().toString());

        switch (a){
            case 1:
               result = (num1 * 15000) + (num2 * 12000) + (num3 * 8000);
                sum = num1 + num2 + num3;
                        if(r1.isChecked()){
                            sale = result/20;
                            result = result - sale;
                        }
                        else if(r2.isChecked()){
                            I1.setImageResource(R.drawable.noli2);
                            sale = result/10;
                            result = result - sale;
                        }
                        else if(r3.isChecked()){
                            I1.setImageResource(R.drawable.noli3);
                            sale = result/5;
                            result = result - sale;
                        }
                break;
        }


        Te10.setText("총명수:" + sum);
        Te12.setText("총 결제금액:" + result);
        Te11.setText("할인금액:" + sale);

    }



}

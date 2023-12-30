package com.example.ltuddd_tlu.tuan3.tuan31_Java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ltuddd_tlu.R;

public class tuan31SecondActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan31_second);

        tv1 = findViewById(R.id.tuan31Tv1);
        Intent integer = getIntent();
        int a =Integer.parseInt(integer.getExtras().getString("a"));
        int b =Integer.parseInt(integer.getExtras().getString("b"));
        int c =Integer.parseInt(integer.getExtras().getString("c"));
        float delta = b*b-4*a*c;
        if(delta < 0){
            tv1.setText("PT vo nghiem");
        } else if (delta == 0) {
            tv1.setText("PT co nghiem kep" + (-b)/(2*a));
        } else {
            float x1 = (float) ((-b+Math.sqrt(delta))/(2*a));
            float x2 = (float) ((-b-Math.sqrt(delta))/(2*a));
            tv1.setText("Pt co 2 nghiem la:" + "\nx1 = " + x1 + "\nx2 = " + x2);

        }

    }
}
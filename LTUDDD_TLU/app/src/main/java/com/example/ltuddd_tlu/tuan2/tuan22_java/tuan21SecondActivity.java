package com.example.ltuddd_tlu.tuan2.tuan22_java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ltuddd_tlu.databinding.ActivityTuan21SecondBinding;

import com.example.ltuddd_tlu.R;

public class tuan21SecondActivity extends AppCompatActivity {

    TextView tv1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan21_second);

        tv1 = findViewById(R.id.tuan21Tv1);

        //don du lieu
        Intent i1=getIntent();

        //do hang
        String chuoi1 = i1.getExtras().getString("so1");
        String chuoi2 = i1.getExtras().getString("so2");

        //----
        float so1 = Float.parseFloat(chuoi1);
        float so2 = Float.parseFloat(chuoi2);
        float tong = so1 + so2;

        //hien thi ket qua
        tv1.setText(String.valueOf(tong));
    }
}
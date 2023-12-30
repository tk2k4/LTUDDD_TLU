package com.example.ltuddd_tlu.tuan3.tuan31_Java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ltuddd_tlu.R;

public class tuan31MainActivity extends AppCompatActivity {

    EditText txtA, txtB, txtC;

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan31_main);

        txtA = findViewById(R.id.tuan31TxtA);
        txtB = findViewById(R.id.tuan31TxtB);
        txtC = findViewById(R.id.tuan31TxtC);
        btn1 = findViewById(R.id.tuan31Btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tuan31MainActivity.this, tuan31SecondActivity.class);
                intent.putExtra("a", txtA.getText().toString());
                intent.putExtra("b", txtB.getText().toString());
                intent.putExtra("c", txtC.getText().toString());
                startActivity(intent);

            }
        });

    }
}
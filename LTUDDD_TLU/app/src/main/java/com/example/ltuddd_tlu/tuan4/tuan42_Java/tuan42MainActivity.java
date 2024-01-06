package com.example.ltuddd_tlu.tuan4.tuan42_Java;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ltuddd_tlu.R;

public class tuan42MainActivity extends AppCompatActivity {

    Button btnGetData;
    TextView tvKQ;
    Context context = this;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan42_main);

        tuan42VolleyFN volleyFN = new tuan42VolleyFN();
        tvKQ = findViewById(R.id.tuan42TvKQ);
        btnGetData = findViewById(R.id.tuan42Btn);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyFN.getJsonArrayOfObject(context,tvKQ);
            }
        });



    }
}
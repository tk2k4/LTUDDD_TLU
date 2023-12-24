package com.example.tinh_tong.tuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tinh_tong.R;

public class Tuan11MainActivity extends AppCompatActivity {

    EditText txt1, txt2;
    Button btn1;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan11_main);

        txt1=findViewById(R.id.sohang1txt1);
        txt2=findViewById(R.id.sohang2txt2);
        tv1=findViewById(R.id.ketqua1tv1);
        btn1=findViewById(R.id.button1Btn1);


        btn1.setOnClickListener(v-> tinhtong());

    }

    private void tinhtong() {

        //lay du lieu nhap vao tu EditText
        String str1=txt1.getText().toString();
        float so1=Float.parseFloat(str1);

        String str2=txt2.getText().toString();
        float so2=Float.parseFloat(str2);

        //tinh tong
        float tong = so1 + so2;

        //in ket qua ra man hinh
        tv1.setText(String.valueOf(tong));

    }
}
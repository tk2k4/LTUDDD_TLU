package com.example.ltuddd_tlu.tuan3.Lab31;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ltuddd_tlu.R;

public class Lab31MainActivity extends AppCompatActivity {

    EditText txtUser, txtPass;
    Button btn1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab31_main);

        btn1 = findViewById(R.id.tuan31btn1);
        txtUser = findViewById(R.id.tuan31txt1);
        txtPass = findViewById(R.id.tuan31txt2);
    }

    public void dangnhap(View view){
        if(txtUser.getText().toString().equals("admin")&&txtPass.getText().toString().equals("admin")){
            Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Đăng nhập không thành công", Toast.LENGTH_LONG).show();
        }
    }
}
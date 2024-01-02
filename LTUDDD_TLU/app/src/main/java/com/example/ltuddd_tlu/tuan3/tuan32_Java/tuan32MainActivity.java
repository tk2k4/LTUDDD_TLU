package com.example.ltuddd_tlu.tuan3.tuan32_Java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.ltuddd_tlu.R;

import java.util.ArrayList;

public class tuan32MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ListView lv;
        T32Adapter adapter;
        ArrayList<T32Contact> ls = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan32_main);

        lv = findViewById(R.id.tuan32Lv);
        ls.add(new T32Contact("Tran Duc Khanh", "2004", R.drawable.ic_launcher_background));
        ls.add(new T32Contact("Tran Khanh", "2004", R.drawable.ic_launcher_background));

        //tao adapter
        adapter = new T32Adapter(ls, this);
        lv.setAdapter(adapter);

    }
}
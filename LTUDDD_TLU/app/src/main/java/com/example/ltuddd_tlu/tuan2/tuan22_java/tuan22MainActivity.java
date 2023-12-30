package com.example.ltuddd_tlu.tuan2.tuan22_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ltuddd_tlu.R;

public class tuan22MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan22_main2);

        lv = findViewById(R.id.tuan22Listview);

        //nguon du lieu
        String[] arr = new String[]{"Mon 1", "Tuan 2", "Mon 3", "Mon 4", "Mon 5"};

        //adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);

        //hien thi len listView
        lv.setAdapter(adapter);

    }
}
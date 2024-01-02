package com.example.ltuddd_tlu.tuan3.tuan32_Java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ltuddd_tlu.R;

import java.util.ArrayList;

public class tuan32Main1Activity extends AppCompatActivity {

    ListView lvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan32_main1);

        lvContact = findViewById(R.id.tuan32LV);
        ArrayList<Contact> arrContact = new ArrayList<>();
        Contact contact1 = new Contact("Tran Duc Khanh", "099999999", "RED");
        Contact contact2 = new Contact("Tran Khanh", "0888888", "RED");
        arrContact.add(contact1);
        arrContact.add(contact2);

        CustomAdapter adapter = new CustomAdapter(this,R.layout.item_listview, arrContact);
        lvContact.setAdapter(adapter);
    }
}
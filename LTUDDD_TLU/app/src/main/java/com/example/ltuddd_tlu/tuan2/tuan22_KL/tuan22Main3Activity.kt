package com.example.ltuddd_tlu.tuan2.tuan22_KL

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.ltuddd_tlu.R

class tuan22Main3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var lv:ListView? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan22_main3)

        lv = findViewById(R.id.tuan22Lv)

        val arr = arrayOf("item1","item2", "Tran", "Duc", "Khanh", "A45039")

        val ad = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr)

        lv!!.adapter = ad;


    }
}
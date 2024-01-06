package com.example.ltuddd_tlu.tuan4.tuan42_Kotlin

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ltuddd_tlu.R

class tuan42MainActivity : AppCompatActivity() {

    var btn:Button? = null
    var tv:TextView? = null
    var context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan42_main2)

        btn = findViewById(R.id.tuan42Btn2)
        tv = findViewById(R.id.tuan42Tv2)

        val fn = tuan42VolleyKotlinFL()
        btn!!.setOnClickListener {
            fn.getJSON_ArrayObjects(context, tv!!)
        }

    }
}
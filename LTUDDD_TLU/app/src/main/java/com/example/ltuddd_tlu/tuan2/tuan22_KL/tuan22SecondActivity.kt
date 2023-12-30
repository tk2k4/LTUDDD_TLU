package com.example.ltuddd_tlu.tuan2.tuan22_KL

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.ltuddd_tlu.R
import com.example.ltuddd_tlu.databinding.ActivityTuan22SecondBinding

class tuan22SecondActivity : AppCompatActivity() {

    var tv1: TextView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan22_second)


        tv1 = findViewById(R.id.tuan22tv1)

        var i1=intent
        val chuoi1 = i1.extras!!.getString("so1")
        val chuoi2 = i1.extras!!.getString("so2")
        var so1 = chuoi1!!.toFloat()
        var so2 = chuoi2!!.toFloat()
        val tong = so1 + so2
        tv1!!.text = tong.toString()

    }
}
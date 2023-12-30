package com.example.ltuddd_tlu.tuan3.tuan31_KL

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.ltuddd_tlu.R

class tuan31Main2Activity : AppCompatActivity() {

    var tv2:TextView?? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan31_main2)

        tv2 = findViewById(R.id.tuan31Tv2)

        val i1 = intent
        val a = i1.extras!!.getString("a")!!.toInt()
        val b = i1.extras!!.getString("b")!!.toInt()
        val c = i1.extras!!.getString("c")!!.toInt()
        val delta = (b*b-4*a*c).toDouble()

        if(delta < 0){
            tv2!!.text="PT vo nghiem"
        } else if (delta == 0.0){
            tv2!!.text="PT co nghiem kep x= " + (-b)/2*a
        } else {
            val x1 = (-b+Math.sqrt(delta))/(2*a)
            val x2 = (-b-Math.sqrt(delta))/(2*a)
            tv2!!.text = "Pt co 2 nghiem phan biet:" + "\nx1 = $x1" + "\nx2 = $x2"
        }

    }
}
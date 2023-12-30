package com.example.ltuddd_tlu.tuan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.ltuddd_tlu.R

class tuan11MainActivityKL : AppCompatActivity() {

    //khai báo các control
    var txt1: EditText? = null
    var txt2: EditText? = null
    var btn1: Button? = null
    var tv1: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan11_main)

        //anh xa
        txt1 = findViewById(R.id.sohang1txt1)
        txt2 = findViewById(R.id.sohang2txt2)
        btn1 = findViewById(R.id.button1Btn1)
        tv1 = findViewById(R.id.ketqua1tv1)

        //xu ly su kien
        btn1!!.setOnClickListener(View.OnClickListener {
            tinhTong()
        })


    }

    private fun tinhTong() {
        //lay du lieu duoc nhap vao tu EditText1
        val str1 = txt1!!.text.toString()
        //chuyen sang kieu so
        val so1 = str1.toFloat()

        //lay du lieu nhap vao tu EditText2
        val str2 = txt2!!.text.toString()
        val so2 = str2.toFloat()

        //tinhtong
        val tong = so1 + so2

        //in ket qua
        tv1!!.text = tong.toString()
    }
}
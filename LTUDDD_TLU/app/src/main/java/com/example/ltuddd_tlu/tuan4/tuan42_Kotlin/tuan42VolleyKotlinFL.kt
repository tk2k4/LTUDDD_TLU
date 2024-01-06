package com.example.ltuddd_tlu.tuan4.tuan42_Kotlin

import android.content.Context
import android.widget.TextView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class tuan42VolleyKotlinFL {
    var strJSON = ""
    fun getJSON_ArrayObjects(context: Context, textView: TextView) {
        //1.Tao request
        val queue = Volley.newRequestQueue(context)

        //2.Url
        val url = "http://192.168.20.109/ajson/a.json"

        //3.goi request
        val request = JsonArrayRequest(url,
            Response.Listener {
                response ->  for (i in 0 until response.length()){
                    val person = response.getJSONObject(i)
                    val id = person.getString("id")
                    val name = person.getString("name")
                    val email = person.getString("email")
                    strJSON += "Id: $id\n"
                    strJSON += "Name: $name\n"
                    strJSON += "Email: $email\n"
                }
                textView.text = strJSON
            },
            Response.ErrorListener {
                error -> textView.text = error.message
            } )

        //4.Thuc thi resquest
        queue.add(request)
    }

}
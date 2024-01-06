package com.example.ltuddd_tlu.tuan4.tuan42_Java;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class tuan42VolleyFN {

    String strJSON = "";
    public void getJsonArrayOfObject(Context context, TextView textView){
        //1.Tao request
        RequestQueue queue = Volley.newRequestQueue(context);

        //2. Url
        //String url="https://github.com/hungnttg/android/blob/master/a.json";
        String url="http://192.168.20.109/ajson/a.json";

        //3. Goi Request

        //JsonArrayRequest(url, thanh cong, that bai)
        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //chuyển mảng sang các đối tượng
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject person = response.getJSONObject(i);
                                String id = person.getString("id");
                                String name = person.getString("name");
                                String email = person.getString("email");

                                strJSON += "ID: " + id + "\n";
                                strJSON += "Name: " + name + "\n";
                                strJSON += "Email: " + email + "\n";
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                                //throw new RuntimeException(e);
                            }
                            textView.setText(strJSON);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });

        //4. thuc thi request
        queue.add(request);
    }

}

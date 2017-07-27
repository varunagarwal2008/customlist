package com.example.varun.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.android.volley.VolleyLog.TAG;

public class MainActivity extends AppCompatActivity {
    JSONObject jsonobject;
    Button b;
    ListView listview;
    TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);
        b = (Button) findViewById(R.id.button);
       // test=(TextView)findViewById(R.id.test);

b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.GET,"https://api.myjson.com/bins/f5p3x",jsonobject,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    ArrayList<Customlist> merchant = new ArrayList<Customlist>();
                    JSONArray jsonArray = response.getJSONArray("mydata");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        merchant.add(new Customlist(jsonArray.getJSONObject(i)));
                        Customlistadapter adapter = new Customlistadapter(MainActivity.this, merchant);
                        listview.setAdapter(adapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonObjectRequest);
    }


});
}
}

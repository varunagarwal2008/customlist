package com.example.varun.customlist;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kirti on 27-07-2017.
 */


public class Customlist {
    String name;
    String email;
    String number;
    public Customlist(JSONObject jsonObject)
    {
        try {
            this.name=jsonObject.getString("name");
            this.email=jsonObject.getString("email");
            this.number=jsonObject.getString("number");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

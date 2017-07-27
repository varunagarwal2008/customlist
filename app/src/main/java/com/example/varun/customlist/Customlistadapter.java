package com.example.varun.customlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kirti on 27-07-2017.
 */

public class Customlistadapter extends ArrayAdapter<Customlist>{
    public Customlistadapter(Context context, ArrayList<Customlist> merchant)
    {
        super(context,0,merchant);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Customlist merchant=getItem(position);
        if(convertView==null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listrow, parent, false);
        }
        TextView name=(TextView)convertView.findViewById(R.id.name);
        TextView email=(TextView)convertView.findViewById(R.id.email);
        TextView number=(TextView)convertView.findViewById(R.id.number);
        name.setText(merchant.name);
        email.setText(merchant.email);
        number.setText(merchant.number);
        return convertView;
    }
}

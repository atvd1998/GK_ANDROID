package com.example.gk_android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutID;

    public MyArrayAdapter(Activity context, int textViewResourceId, ArrayList<NhanVien> objects)
    {
        super(context, textViewResourceId, objects);

        this.context = context;
        this.layoutID = textViewResourceId;
        this.myArray = objects;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutID, null);

        if(myArray.size() > 0 && position >= 0)
        {
            final TextView txtDisplay  = (TextView)convertView.findViewById(R.id.tv_item);
            final NhanVien nv = myArray.get(position);
            txtDisplay.setText(nv.toString());

        }
        return convertView;
    }
}

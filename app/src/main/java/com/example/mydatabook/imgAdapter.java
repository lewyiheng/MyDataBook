package com.example.mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class imgAdapter extends ArrayAdapter<String> {
    private String[] nav;
    private Context context;
    private TextView tv;
    private ImageView img;

    public imgAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        nav = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.icon_row, parent, false);

        tv = rowView.findViewById(R.id.tv);
        img = rowView.findViewById(R.id.img);

        String currentNav = nav[position];
        tv.setText(currentNav);

        if (currentNav.equals("Bio")){
            img.setImageResource(R.drawable.ic_action_info);
        } else if (currentNav.equals("Vaccination")){
            img.setImageResource(R.drawable.ic_action_pencil);
        } else if (currentNav.equals("Anniversary")){
            img.setImageResource(R.drawable.ic_action_date);
        } else {
            img.setImageResource(R.drawable.ic_action_star);
        }
        return rowView;
    }
}
package com.example.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Contact> arrayList;
    private int layout;

    public ContactAdapter(Context context, ArrayList<Contact> arrayList, int layout) {
        this.context = context;
        this.arrayList = arrayList;
        this.layout = layout;
    }



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);

        TextView textViewName = convertView.findViewById(R.id.txt_name);
        TextView textViewPhoneNumber = convertView.findViewById(R.id.txt_phone_number);
        ImageView avt = convertView.findViewById(R.id.img_avt);

        Contact contact = arrayList.get(position);

        if(contact.getPhoto() != null) {
            avt.setImageBitmap(contact.getPhoto());
        } else {
            avt.setImageResource(R.drawable.avt);
        }

        textViewName.setText(contact.getName());
        textViewPhoneNumber.setText(contact.getPhone());

        return convertView;


    }
}

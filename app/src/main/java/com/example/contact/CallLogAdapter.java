package com.example.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CallLogAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<mCallLog> mCallLogArrayList;
    private int layout;

    public CallLogAdapter(Context context, ArrayList<mCallLog> mCallLogArrayList, int layout) {
        this.context = context;
        this.mCallLogArrayList = mCallLogArrayList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return mCallLogArrayList.size();
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

        TextView textViewPhone = convertView.findViewById(R.id.txt_call_log_phone);
        TextView textViewTimeDate = convertView.findViewById(R.id.txt_call_log_date_time);

        mCallLog mCallLog = mCallLogArrayList.get(position);

        textViewPhone.setText(mCallLog.getPhoneNumber());
        textViewTimeDate.setText(mCallLog.getTimeDate());
        return convertView;
    }
}

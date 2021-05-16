package com.example.contact;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class CallLogFragment extends Fragment {
    private View mView;
    private ListView listViewCallLog;
    private CallLogAdapter callLogAdapter;
    private ArrayList<mCallLog> mCallLogArrayList;
    private MainActivity mainActivity;
    public CallLogFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_call_log, container, false);
        listViewCallLog = mView.findViewById(R.id.lv_call_log);
        mainActivity = (MainActivity) getActivity();
        mCallLogArrayList = mainActivity.getCallLog();
        callLogAdapter = new CallLogAdapter(this.getContext(), mCallLogArrayList, R.layout.call_log_item);
        listViewCallLog.setAdapter(callLogAdapter);
        return mView;
    }
}
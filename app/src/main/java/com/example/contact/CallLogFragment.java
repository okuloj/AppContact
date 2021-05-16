package com.example.contact;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CallLogFragment extends Fragment {
    View mView;
    MainActivity mainActivity;
    public CallLogFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_call_log, container, false);
        mainActivity = (MainActivity) getActivity();
        mainActivity.getCallLog();
        return mView;
    }
}
package com.example.contact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ContactFragment extends Fragment {
    private View mView;
    private ListView listViewContact;
    private ArrayList<Contact> contactArrayList;
    private ContactAdapter contactAdapter;
    private MainActivity mainActivity;

    public ContactFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_contact, container, false);
        listViewContact = mView.findViewById(R.id.lv_contact);

        contactArrayList = new ArrayList<>();

        //contactArrayList.add(new Contact("Nguyen Van A", "12345678", null));
        mainActivity = (MainActivity) getActivity();
        contactArrayList = mainActivity.getContact();

        contactAdapter = new ContactAdapter(this.getContext(), contactArrayList, R.layout.contact_item);

        listViewContact.setAdapter(contactAdapter);




        return mView;
    }

}
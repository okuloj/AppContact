package com.example.contact;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);



    }

    public ArrayList getContact() {
        ArrayList<Contact> contactArrayList = new ArrayList<>();
        String contactId = "";
        String displayName = "";
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {
                    contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    Cursor phoneCursor = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{contactId},
                            null);
                    // on below line we are moving our cursor to next position.
                    if (phoneCursor.moveToNext()) {
                        // on below line we are getting the phone number for our users and then adding the name along with phone number in array list.
                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        String name = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        String photoUri = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));

                        Bitmap bitmap = getPhotoFromUri(photoUri);

                        contactArrayList.add(new Contact(name, phoneNumber, bitmap));
                    }
                    phoneCursor.close();
                }
            }
        }
        cursor.close();
        return contactArrayList;
    }

    private Bitmap getPhotoFromUri(String photoUri) {
        if(photoUri!=null) {
            try {
                return MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.parse(photoUri));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void getCallLog() {
        String stringOutput = "";
        Uri uriCallLogs = Uri.parse("content://call_log/calls");
        Cursor cursorCallLogs = getContentResolver().query(uriCallLogs, null,null,null);
        cursorCallLogs.moveToFirst();
        do {
            String stringNumber = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.NUMBER));
            String stringDuration = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.DURATION));
            String stringDate = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.DATE));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a");
            String date = simpleDateFormat.format(cursorCallLogs.get(cursorCallLogs.getColumnIndex(CallLog.Calls.DATE)));
            stringOutput = stringOutput + "Number: " + stringNumber
                    + "\nDuration: " + stringDuration
                    + "\n Date: " + date
                    + "\n\n";
        }while (cursorCallLogs.moveToNext());
        Toast.makeText(this, stringOutput, Toast.LENGTH_SHORT).show();
    }
}
package com.twilio.contextualcommunicationsdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import uk.co.ribot.easyadapter.EasyAdapter;
import uk.co.ribot.easyadapter.ItemViewHolder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MonkeyPhone phone = new MonkeyPhone(getApplicationContext());

        // Link viewholder
        ListView mListView = (ListView) findViewById(R.id.contact_entries);
        mListView.setAdapter(new EasyAdapter<Entry>(
                this,
                EntryViewHolder.class,
                DataProvider.getEntries()));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Intent intent;
                switch (position) {
                    case 0: // first one of the list
                        /*
                        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "1234567890"));
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                        startActivity(intent);
                        */
                        break;
                    case 1: // second one of the list.
                        phone.connect("+447590566866");
                        break;
                }
            }
        });
    }
}
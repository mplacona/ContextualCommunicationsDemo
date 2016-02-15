package com.twilio.contextualcommunicationsdemo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
                        Toast.makeText(getApplicationContext(), "Some mobile website", Toast.LENGTH_LONG).show();
                        break;
                    case 1: // second one of the list.
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Calling...")
                                .setCancelable(false)
                                .setPositiveButton("Hang-up", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        phone.disconnect();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();


                        phone.connect("+441522246325");
                        break;
                    case 2: // third one of the list
                        Toast.makeText(getApplicationContext(), "Another telephone number", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
}

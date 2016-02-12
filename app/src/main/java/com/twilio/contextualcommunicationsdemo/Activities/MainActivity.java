package com.twilio.contextualcommunicationsdemo.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.twilio.contextualcommunicationsdemo.Data.DataProvider;
import com.twilio.contextualcommunicationsdemo.DTO.Entry;
import com.twilio.contextualcommunicationsdemo.ViewHolder.EntryViewHolder;
import com.twilio.contextualcommunicationsdemo.Communication.MonkeyPhone;
import com.twilio.contextualcommunicationsdemo.R;

import uk.co.ribot.easyadapter.EasyAdapter;

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

                        phone.connect("+447590566866");

                        break;
                }
            }
        });
    }
}

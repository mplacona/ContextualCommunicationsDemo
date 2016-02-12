package com.twilio.contextualcommunicationsdemo;

import android.content.Context;
import android.util.Log;

import com.twilio.client.Connection;
import com.twilio.client.Device;
import com.twilio.client.Twilio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mplacona on 12/02/2016.
 */
public class MonkeyPhone implements Twilio.InitListener {
    private Device mDevice;
    private String TAG = "Monkey Phone";
    private Connection mConnection;
    private Context mContext;
    OkHttpClient client = new OkHttpClient();

    public MonkeyPhone(Context context)
    {
        this.mContext = context;
        Log.d(TAG, "Try to init the SDK");
        Twilio.initialize(context, this);
    }

    Call run(String url, Callback callback) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call response = client.newCall(request);
        response.enqueue(callback);
        return response;
    }

    @Override
    public void onInitialized(){
        Log.d(TAG, "Twilio SDK is ready");
        try {
            run(mContext.getString(R.string.app_capability_url), new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String token = response.body().string();
                    mDevice = Twilio.createDevice(token, null);
                    Log.d(TAG, "Capability token: " + token);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /* Twilio.InitListener method */
    @Override
    public void onError(Exception e) {
        Log.e(TAG, "Twilio SDK couldn't start: " + e.getLocalizedMessage());
    }

    public void connect(String phoneNumber)
    {
        Map<String, String> parameters = new HashMap<>();
        Log.d(TAG, "Capability token: " + mDevice.getCapabilityToken());
        parameters.put("To", phoneNumber);
        mConnection = mDevice.connect(parameters, null);
        if (mConnection == null)
            Log.w(TAG, "Failed to create new connection");
    }


    public void disconnect()
    {
        if (mConnection != null) {
            mConnection.disconnect();
            mConnection = null;
        }
    }

    @Override
    protected void finalize()
    {
        if (mDevice != null)
            mDevice.release();
    }
}
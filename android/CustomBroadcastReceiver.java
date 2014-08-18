package com.danielcwilson.plugins.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import android.net.http.AndroidHttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.HttpResponse;
import java.util.List;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.ClientProtocolException;
import java.io.IOException;

public class CustomBroadcastReceiver extends BroadcastReceiver {
    private String D_TAG = "Z-BROADCASTRECIEVER";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(D_TAG, "## CustomReceiver onReceive (context, intent)");
        try {
            Log.d(D_TAG, "## intent " + intent.toString());
            Log.d(D_TAG, "## referrer " + intent.getStringExtra("referrer"));
            Log.d(D_TAG, "## intent.getStringExtra('referrer') "
                + intent.getStringExtra("referrer"));
            String referrer = intent.getStringExtra("referrer");
            postData(referrer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postData(String referrer) {
        AndroidHttpClient httpclient = AndroidHttpClient.newInstance("referrer");
        HttpPost httppost = new HttpPost("http://192.168.1.132:3000/api/1/campaign");

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("referrer", referrer));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = httpclient.execute(httppost);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }
}


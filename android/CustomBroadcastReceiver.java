package com.danielcwilson.plugins.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CustomBroadcastReceiver extends BroadcastReceiver {
    private String D_TAG = "Z-BROADCASTRECIEVER";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(D_TAG, "## CustomReceiver onReceive (context, intent)");
        try {
            Log.d(D_TAG, "## intent " + intent.toString());
            Log.d(D_TAG, "## referrer " + intent.getStringExtra("referrer"));
            Log.d(D_TAG,
            "## intent.getStringExtra('referrer') "
            + intent.getStringExtra("referrer"));
            String referrer = intent.getStringExtra("referrer");
            postData(referrer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package com.example.root.broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends Activity {

    private MyReceiver mMyRecevier;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyRecevier=new MyReceiver();
        mIntentFilter=new IntentFilter();
        mIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED);//system action
        mIntentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);//system action
        mIntentFilter.addAction("com.example.root.sendbroadcast");//own app action

        registerReceiver(mMyRecevier,mIntentFilter);// if we use intent filter in mainactivity instead of in manifest we need to register here so these method is used
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMyRecevier);
    }
}

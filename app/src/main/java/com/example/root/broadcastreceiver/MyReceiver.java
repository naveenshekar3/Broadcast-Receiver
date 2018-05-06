package com.example.root.broadcastreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

        String title="Power Status";
        String text="";
        int id;

        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
        {
            Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
            text="Power Connected";
            id=5;
        }
        else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED))
        {
            Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
            text="Power Disconneted";
            id=6;
        }
        else
        {
            title=intent.getStringExtra("title");
            text=intent.getStringExtra("text");
            id=7;
        }

        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder=new Notification.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(title);
        builder.setContentText(text);
        notificationManager.notify(id,builder.build());

        //calling activity to do heavy task
//        Intent intent1=new Intent(context,MainActivity.class);
//        context.startActivity(intent1);

    }
}

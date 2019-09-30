package com.robertohuertas.endless;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

public class a00 extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private Notification createNotification(){
        NotificationChannel channel = createNotificationChannel();
        String channelId  = "ENDLESS SERVICE CHANNEL";

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
//                .setSmallIcon(R.drawable.bluetooth_black)
                .setContentTitle("BackgroundService")
                .setContentText("Communicates with Arduino in the background")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    NotificationChannel createNotificationChannel() {
        String name = "Foreground Channel";
        String description = "Used for displaying foreground notifications";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("1", name, importance);
        channel.setDescription(description);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
        }
        return channel;
    }
}

package com.soham.dixitinfotek.boundservice;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyNotification extends Application {

    // a constant fixed string channel
public static final String CHANNEL_ID = "my_music_player";

    @Override
    public void onCreate() {
        super.onCreate();
        createMyNotification();
    }

    private void createMyNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "MyMusicApp", NotificationManager.IMPORTANCE_DEFAULT);
            // use notification manager to get the system's service
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            // create the notification channel with the so created notification manager.
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}

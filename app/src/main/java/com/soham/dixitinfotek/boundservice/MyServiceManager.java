package com.soham.dixitinfotek.boundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import static com.soham.dixitinfotek.boundservice.MyNotification.CHANNEL_ID;

public class MyServiceManager extends Service {

    private MediaPlayer musicPlayer;
    public final int REQUEST_CODE = 0;
    public final int FLAG = 0;
    Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.buzz_song);
        context = this;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    // method called when the service is started everytime.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // start the music player.
        musicPlayer.start();
        Intent notificationIntent = new Intent(this, MainActivity.class);
        // pending intent for the notification intent created above with the application context, request code and flag.
        PendingIntent pendingIntent = PendingIntent.getActivity(context, REQUEST_CODE, notificationIntent, FLAG);
        // setting the title of notification, text, icon, and the intent associated with it is pending intent.
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Music Player")
                .setContentText("To play or stop my music click on this notification")
                .setSmallIcon(R.drawable.music_icon)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1, notification);

        // This mode makes sense for things that want to do some work as a
        // result of being started, but can be stopped when under memory pressure
        // and will explicit start themselves again later to do more work.
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        musicPlayer.release();
    }
}

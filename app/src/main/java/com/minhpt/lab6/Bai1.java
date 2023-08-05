package com.minhpt.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import java.util.Date;

public class Bai1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_send).setOnClickListener(v -> {
            Bitmap logo = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
            Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, ConfigNotification.CHANNEL_ID)
                    .setSmallIcon(R.drawable.notify)
                    .setContentTitle("Android 2")
                    .setContentText("Chào mừng đến với FPT Polytechnic")
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(logo)
                            .bigLargeIcon(null))
                    .setLargeIcon(icon)
                    .setColor(Color.RED)
                    .setAutoCancel(true);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                    == PackageManager.PERMISSION_GRANTED) {
                notificationManager.notify((int) new Date().getTime(), builder.build());
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 888);
            }
        });
    }
}
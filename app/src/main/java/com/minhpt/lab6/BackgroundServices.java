package com.minhpt.lab6;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BackgroundServices extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service bắt đầu chạy", Toast.LENGTH_SHORT).show();
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(BackgroundServices.this, "Đang chuyển", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("https://ap.poly.edu.vn/"));
                    intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent1);
                    stopSelf();
                }
            }, 5000);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
            stopSelf();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroy Services", Toast.LENGTH_SHORT).show();
    }
}

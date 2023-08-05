package com.minhpt.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Bai2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.btn_start).setOnClickListener(v -> {
            Intent intent = new Intent(Bai2.this, ForegroundService.class);
            startService(intent);
        });
        findViewById(R.id.btn_stop).setOnClickListener(v -> {
            Intent intent = new Intent(Bai2.this, ForegroundService.class);
            stopService(intent);
        });
    }
}
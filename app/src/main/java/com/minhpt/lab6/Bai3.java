package com.minhpt.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Bai3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        findViewById(R.id.btn_start).setOnClickListener(v -> {
            Intent intent = new Intent(Bai3.this, BackgroundServices.class);
            startService(intent);
        });
    }
}
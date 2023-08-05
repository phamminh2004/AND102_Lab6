package com.minhpt.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.content.Intent;
import android.os.Bundle;

public class Bai4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        findViewById(R.id.btn_start).setOnClickListener(v -> {
            Constraints constraints = new Constraints.Builder().setRequiresCharging(true).build();
            WorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class).setConstraints(constraints).build();
            WorkManager.getInstance(Bai4.this).enqueue(workRequest);
        });
    }
}
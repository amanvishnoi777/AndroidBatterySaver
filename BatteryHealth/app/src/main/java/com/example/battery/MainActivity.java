package com.example.battery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.battery.BroadCastReceiver.BroadcastReceiver;

import com.example.battery.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        BroadcastReceiver broadcast = new BroadcastReceiver();

        this.registerReceiver(broadcast, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


    }
}
package com.example.battery.BroadCastReceiver;

import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

import com.example.battery.BroadCastReceiver.Functions.*;
import com.example.battery.Data.MyDBHandler;
import com.example.battery.Model.BatteryStats;

import java.util.List;


public class BroadcastReceiver extends android.content.BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

//          Fetching the number of apps Running at the moment
            Apps_Running running;
            running = new Apps_Running();
            List<String> str = running.getActiveApps(context);

            getCurrentBatteryLevel Level = new getCurrentBatteryLevel();
            BatteryManager SystemService = (BatteryManager)context.getSystemService(Context.BATTERY_SERVICE);


//          Adding Data to Database
            MyDBHandler db = new MyDBHandler(context);
            BatteryStats stats1 = new BatteryStats();
            stats1.setBatteryPct(Level.getBatteryPct(intent));
            stats1.setChargingStatus(Level.getChargingStatus(intent));
            stats1.setChargingDischarging(Level.ChargingDischarging(intent));
            stats1.setBatteryTech(Level.BatteryTech(intent));
            stats1.setTemperature(String.valueOf(Level.Temperature(intent)));
            stats1.setVoltage(String.valueOf(Level.Voltage(intent)));
            stats1.setChargeCounter(String.valueOf(Level.Charge_Counter(SystemService)));
            stats1.setEnergyCounter(String.valueOf(Level.EnergyCounter(SystemService)));
            stats1.setCurrentNow(String.valueOf(Level.CurrentNow(SystemService)));
            stats1.setCurrentAvg(String.valueOf(Level.CurrentAvg(SystemService)));
            stats1.setOverallHealth(String.valueOf(Level.OverAllHealth(intent)));
            stats1.setAppsRunning(str);

            db.addData(stats1);


//          Showing saved data in the database

            List<BatteryStats> allStats = db.getStoredDetails();
            for (BatteryStats battery: allStats){
                Log.d("aman", "ID " + battery.getId() + " BatteryPct " + battery.getBatteryPct() + " ChargingStats " + battery.getChargingStatus()
                        + " Charging/Discharging " + battery.getChargingDischarging() + " BatteryTech " + battery.getBatteryTech() + " Temperature " + battery.getTemperature()
                + " Voltage " + battery.getVoltage() + " ChargeCounter " + battery.getChargeCounter()
                        + " EnergyCounter " + battery.getEnergyCounter() + " CurrentNow " + battery.getCurrentNow() + " CurrentAvg " +
                        battery.getCurrentAvg() + " Overall Health " + battery.getOverallHealth() + " Apps Running " + battery.getAppsRunning());
            }

        }
}


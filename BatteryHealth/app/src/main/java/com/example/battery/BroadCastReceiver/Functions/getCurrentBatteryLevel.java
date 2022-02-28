package com.example.battery.BroadCastReceiver.Functions;

import android.content.Intent;
import android.os.BatteryManager;

/*
This class is used to return the current Battery Percentage, Charging_Discharging_Status,
Charging_Via,
 */
public class getCurrentBatteryLevel {


    public String getBatteryPct(Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level * 100 / (float)scale;
        return String.valueOf(batteryPct);
    }

    public String getChargingStatus(Intent intent) {
        int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
        String str = "";
        if (usbCharge){
            str += "USB";
        }
        else{
            str += "AC";
        }
        return str;
    }

    public String ChargingDischarging(Intent intent){
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING;
        boolean full = status == BatteryManager.BATTERY_STATUS_FULL;
        String str = "";
        if (full){
            str += "full";
        }
        else if (isCharging){
            str += "charging";
        }
        else{
            str += "discharging";
        }
        return str;
    }


    public String BatteryTech(Intent intent){
        return intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
    }

    public int Temperature(Intent intent){
        return intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE ,-1);

    }

    public int Voltage(Intent intent){
        return intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
    }

    public Long Charge_Counter(BatteryManager SystemService){
        return SystemService.getLongProperty(BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER);
    }

    public Long EnergyCounter(BatteryManager SystemService){
        return SystemService.getLongProperty(BatteryManager.BATTERY_PROPERTY_ENERGY_COUNTER);
    }

    public Long CurrentNow(BatteryManager SystemService){
        return SystemService.getLongProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW);
    }

    public Long CurrentAvg(BatteryManager SystemService){
        return SystemService.getLongProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_AVERAGE);
    }

    public String OverAllHealth(Intent intent){
        int deviceHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);
        String str = "";
        if(deviceHealth == BatteryManager.BATTERY_HEALTH_COLD){
            str += "Cold";
        }

        if(deviceHealth == BatteryManager.BATTERY_HEALTH_DEAD){
            str += "Dead";
        }

        if (deviceHealth == BatteryManager.BATTERY_HEALTH_GOOD){
            str += "Good";
        }

        if(deviceHealth == BatteryManager.BATTERY_HEALTH_OVERHEAT){
            str += "OverHeat";
        }

        if (deviceHealth == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE){
            str += "Overvoltage";
        }

        if (deviceHealth == BatteryManager.BATTERY_HEALTH_UNKNOWN){
            str += "Unknown";
        }
        if (deviceHealth == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE){

            str += "Unspecified Failure";
        }
        return str;
    }

}

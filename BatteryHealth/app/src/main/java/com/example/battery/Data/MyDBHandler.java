package com.example.battery.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.battery.Model.BatteryStats;
import com.example.battery.params.Params;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {

    public MyDBHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create = "CREATE TABLE " + Params.TABLE_NAME + "("
                + Params.KEY_ID + " INTEGER PRIMARY KEY,"
                + Params.KEY_BATTERY_PCT + " TEXT, "
                + Params.KEY_CHARGING_STATUS + " TEXT, "
                + Params.KEY_CHARGING_DISCHARGING + " TEXT, "
                + Params.KEY_BATTERY_TECH + " TEXT, "
                + Params.KEY_TEMPERATURE +   " TEXT, "
                + Params.KEY_VOLTAGE + " TEXT, "
                + Params.KEY_CHARGE_COUNTER + " TEXT, "
                + Params.KEY_ENERGY_COUNTER + " TEXT, "
                + Params.KEY_CURRENT_NOW + " TEXT, "
                + Params.KEY_CURRENT_AVG + " TEXT, "
                + Params.KEY_OVERALL_HEALTH + " TEXT, "
                + Params.KEY_APPS_RUNNING + " TEXT" +
                ")";
        Log.d("aman", "Query Being Run is "+ create);
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void addData(BatteryStats stats){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Params.KEY_BATTERY_PCT, stats.getBatteryPct());
        values.put(Params.KEY_CHARGING_STATUS, stats.getChargingStatus());
        values.put(Params.KEY_CHARGING_DISCHARGING, stats.getChargingDischarging());
        values.put(Params.KEY_BATTERY_TECH, stats.getBatteryTech());
        values.put(Params.KEY_TEMPERATURE, stats.getTemperature());
        values.put(Params.KEY_VOLTAGE, stats.getVoltage());
        values.put(Params.KEY_CHARGE_COUNTER, stats.getChargeCounter());
        values.put(Params.KEY_ENERGY_COUNTER, stats.getEnergyCounter());
        values.put(Params.KEY_CURRENT_NOW, stats.getCurrentNow());
        values.put(Params.KEY_CURRENT_AVG, stats.getCurrentAvg());
        values.put(Params.KEY_OVERALL_HEALTH, stats.getOverallHealth());

        String apps = "";

        for (String s: stats.getAppsRunning()){
            apps += s + " ";
        }
        values.put(Params.KEY_APPS_RUNNING, apps);


        db.insert(Params.TABLE_NAME, null, values);
        Log.d("aman", "Successfully Inserted");
        db.close();
    }

    public List<BatteryStats> getStoredDetails(){
        List<BatteryStats> allStats = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
//        Generate the query to read from the database
        String select = "SELECT * FROM "+ Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

//        Loop through now
        if(cursor.moveToFirst()){
            do{
                BatteryStats stats = new BatteryStats();
                stats.setId(Integer.parseInt(cursor.getString(0)));
                stats.setBatteryPct(cursor.getString(1));
                stats.setChargingStatus(cursor.getString(2));
                stats.setChargingDischarging(cursor.getString(3));
                stats.setBatteryTech(cursor.getString(4));
                stats.setTemperature(cursor.getString(5));
                stats.setVoltage(cursor.getString(6));
                stats.setChargeCounter(cursor.getString(7));
                stats.setEnergyCounter(cursor.getString(8));
                stats.setCurrentNow(cursor.getString(9));
                stats.setCurrentAvg(cursor.getString(10));
                stats.setOverallHealth(cursor.getString(11));

                String[] tokens=cursor.getString(12).split(" ");
                List<String> temp = new ArrayList<>();
                Collections.addAll(temp, tokens);
                stats.setAppsRunning(temp);

//                Adding all the stats to a global list
                allStats.add(stats);
            }while(cursor.moveToNext());
        }
        return allStats;
    }

//    public void deleteStats(int id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(Params.TABLE_NAME, Params.KEY_ID+"=?", new String[]{String.valueOf(id)});
//        db.close();
//    }
}

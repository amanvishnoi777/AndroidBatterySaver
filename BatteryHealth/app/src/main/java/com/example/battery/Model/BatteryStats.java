package com.example.battery.Model;

import java.util.List;

public class BatteryStats {
    private int id;
    private String BatteryPct;
    private String ChargingStatus;
    private String ChargingDischarging;
    private String BatteryTech;
    private String Temperature;
    private String Voltage;
    private String ChargeCounter;
    private String EnergyCounter;
    private String CurrentNow;
    private String CurrentAvg;
    private String OverallHealth;
    private List<String> AppsRunning;

    public BatteryStats(String batteryPct, String chargingStatus, String chargingDischarging, String batteryTech, String temperature, String voltage, String chargeCounter, String energyCounter, String currentNow, String currentAvg, String overallHealth, List<String> appsRunning) {
        BatteryPct = batteryPct;
        ChargingStatus = chargingStatus;
        ChargingDischarging = chargingDischarging;
        BatteryTech = batteryTech;
        Temperature = temperature;
        Voltage = voltage;
        ChargeCounter = chargeCounter;
        EnergyCounter = energyCounter;
        CurrentNow = currentNow;
        CurrentAvg = currentAvg;
        OverallHealth = overallHealth;
        AppsRunning = appsRunning;
    }

    public BatteryStats() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatteryPct() {
        return BatteryPct;
    }

    public void setBatteryPct(String batteryPct) {
        BatteryPct = batteryPct;
    }

    public String getChargingStatus() {
        return ChargingStatus;
    }

    public void setChargingStatus(String chargingStatus) {
        ChargingStatus = chargingStatus;
    }

    public String getChargingDischarging() {
        return ChargingDischarging;
    }

    public void setChargingDischarging(String chargingDischarging) {
        ChargingDischarging = chargingDischarging;
    }

    public String getBatteryTech() {
        return BatteryTech;
    }

    public void setBatteryTech(String batteryTech) {
        BatteryTech = batteryTech;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    public String getVoltage() {
        return Voltage;
    }

    public void setVoltage(String voltage) {
        Voltage = voltage;
    }

    public String getChargeCounter() {
        return ChargeCounter;
    }

    public void setChargeCounter(String chargeCounter) {
        ChargeCounter = chargeCounter;
    }

    public String getEnergyCounter() {
        return EnergyCounter;
    }

    public void setEnergyCounter(String energyCounter) {
        EnergyCounter = energyCounter;
    }

    public String getCurrentNow() {
        return CurrentNow;
    }

    public void setCurrentNow(String currentNow) {
        CurrentNow = currentNow;
    }

    public String getCurrentAvg() {
        return CurrentAvg;
    }

    public void setCurrentAvg(String currentAvg) {
        CurrentAvg = currentAvg;
    }

    public String getOverallHealth() {
        return OverallHealth;
    }

    public void setOverallHealth(String overallHealth) {
        OverallHealth = overallHealth;
    }

    public List<String> getAppsRunning() {
        return AppsRunning;
    }

    public void setAppsRunning(List<String> appsRunning) {
        AppsRunning = appsRunning;
    }
}

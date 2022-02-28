package com.example.battery.BroadCastReceiver.Functions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

public class Apps_Running {


    public static List<String> getActiveApps(Context context) {
        PackageManager pm;
        pm = context.getPackageManager();
        @SuppressLint("QueryPermissionsNeeded") List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        String value = "Active_Apps\n";
        List<String> all_apps = new ArrayList<String>();

        for (ApplicationInfo packageInfo : packages) {

            all_apps.add(packageInfo.packageName);

        }

        return all_apps;
    }
}


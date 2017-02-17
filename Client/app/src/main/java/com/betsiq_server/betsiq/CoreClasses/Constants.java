package com.betsiq_server.betsiq.CoreClasses;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Jacob on 17/02/2017.
 */

public class Constants {

    public static void SetSharedPrefrences(Context currentContext, String preferenceField, String preferenceValue)
    {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(currentContext);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(preferenceField, preferenceValue);
        editor.commit();
    }

    public static String GetSharedPrefrences(Context currentContext, String preferenceField)
    {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(currentContext);
        return sharedPref.getString(preferenceField, "");
    }
}

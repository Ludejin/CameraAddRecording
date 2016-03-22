package com.creawor.addcamera.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jin_ on 2015/10/15.
 */
public class SharedPreferencesUtils {
    private final static String PREFERENCES_NAME = "PREFERENCES_NAME";

    public static void putString(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCES_NAME, 0).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getString(Context context, String key,String defStr) {
        SharedPreferences editor = context.getSharedPreferences(PREFERENCES_NAME, 0);
        if (editor.contains(key)) {
            String value = editor.getString(key, defStr);
            return value;
        }
        return defStr;
    }

}

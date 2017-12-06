package com.teamcookiemonsters.munch;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Justin Tse on 12/5/2017.
 */

public class KeyValueDB {
    private SharedPreferences sharedPreferences;
    private static String PREF_NAME = "prefs";

    public KeyValueDB() {
        // Blank
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static int getIntId(Context context) {
        return getPrefs(context).getInt("key", 20);
    }

    public static void setIntId(Context context, int input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putInt("key", input);
        editor.commit();
    }
}

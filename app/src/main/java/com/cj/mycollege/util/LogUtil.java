package com.cj.mycollege.util;

import android.util.Log;

/**
 * Created by Eason on 2016/4/12.
 */
public class LogUtil {
    private final static boolean DEBUG = true;

    public static void i(String tag, String message) {
        if (DEBUG) {
            Log.i(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (DEBUG) {
            Log.e(tag, message);
        }
    }
}

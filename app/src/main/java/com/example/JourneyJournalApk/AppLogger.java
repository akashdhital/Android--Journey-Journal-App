package com.example.JourneyJournalApk;

import android.util.Log;

/**
 * Created on 28/03/2022.
 */
public class AppLogger {
    private static final String TAG = "FunFacts";

    public static void log(String message) {
        if (!message.isEmpty()) {
            Log.i(TAG, message);
        }
    }
}
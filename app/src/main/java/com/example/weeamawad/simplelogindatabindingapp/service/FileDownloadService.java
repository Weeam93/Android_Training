package com.example.weeamawad.simplelogindatabindingapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Weeam Awad on 5/5/2018.
 */

public class FileDownloadService extends Service {
    private final String tag = getClass().getSimpleName();

    public FileDownloadService() {
        super();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(tag, "Starting Service");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        Log.d(tag, "Creating Service");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(tag, "Destroying Service");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

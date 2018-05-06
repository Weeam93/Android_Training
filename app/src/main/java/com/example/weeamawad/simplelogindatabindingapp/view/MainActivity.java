package com.example.weeamawad.simplelogindatabindingapp.view;

import android.Manifest;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.weeamawad.simplelogindatabindingapp.R;
import com.example.weeamawad.simplelogindatabindingapp.databinding.ActivityMainBinding;
import com.example.weeamawad.simplelogindatabindingapp.service.FileDownloadService;
import com.example.weeamawad.simplelogindatabindingapp.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private final String tag = getClass().getSimpleName();
    private MainViewModel mMainViewModel;

    private static final int WRITE_EXTERNAL_STORAGE_PERMISSION = 0;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case WRITE_EXTERNAL_STORAGE_PERMISSION:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.getFileDownLoadBtnClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                Log.d(tag, "Received Notification that FileButton Live Data Value has Changed");
                startFileDownloadService();
            }
        });
        binding.setMainViewModel(mMainViewModel);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        stopFileDownloadService();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void startFileDownloadService() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // No explanation needed; request the permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_PERMISSION);
            return;
        }
        Intent intent = new Intent(this, FileDownloadService.class);
        intent.putExtra(FileDownloadService.NOTIFICATION_TITLE_STRING_KEY, "Downloading File");
        intent.putExtra(FileDownloadService.NOTIFICATION_MESSAGE_STRING_KEY, "Download in Progress");
        intent.putExtra(FileDownloadService.NOTIFICATION_ICON_RESOURCE_KEY, R.drawable.ic_launcher_foreground);
        intent.putExtra(FileDownloadService.DOWNLOAD_FILE_URL, "https://c1.staticflickr.com/3/2905/13955816048_00740b46ff_h.jpg");
        startService(intent);
    }

    private void stopFileDownloadService() {
        stopService(new Intent(this, FileDownloadService.class));
    }
}

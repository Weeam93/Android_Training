package com.example.weeamawad.simplelogindatabindingapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.weeamawad.simplelogindatabindingapp.R;
import com.example.weeamawad.simplelogindatabindingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button downloadFileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        downloadFileBtn = binding.downloadFileServiceBtn;
        downloadFileBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.download_file_service_btn:
                break;
        }
    }
}

package com.example.weeamawad.simplelogindatabindingapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.weeamawad.simplelogindatabindingapp.R;
import com.example.weeamawad.simplelogindatabindingapp.databinding.ActivityLoginBinding;
import com.example.weeamawad.simplelogindatabindingapp.viewModel.LogInViewModel;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private final String tag = getClass().getSimpleName();
    private LogInViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mLoginViewModel = ViewModelProviders.of(this).get(LogInViewModel.class);
        binding.setLoginViewModel(mLoginViewModel);

        mLoginViewModel.getLogInBtnClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                Log.d(tag, "Received Notification that mLoginBtn Live Data Value has Changed");
                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        Log.d(tag, "Starting MainActivity");
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }

}


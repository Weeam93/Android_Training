package com.example.weeamawad.simplelogindatabindingapp.viewModel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.weeamawad.simplelogindatabindingapp.database.dataProvider.UserDataProvider;
import com.example.weeamawad.simplelogindatabindingapp.model.LoginCredentials;


/**
 * Created by Weeam Awad on 3/24/2018.
 */

public class LogInViewModel extends AndroidViewModel {
    private final String tag = getClass().getSimpleName();
    public LoginCredentials mLoginCredentials;

    private MutableLiveData<Boolean> mLogInBtnClicked;

    private final String correct_username = "Weeam";
    private final String correct_password = "password";


    public LogInViewModel(Application application) {
        super(application);
        this.mLoginCredentials = new LoginCredentials("", "");
    }

    public MutableLiveData<Boolean> getLogInBtnClicked() {
        if (mLogInBtnClicked == null) {
            mLogInBtnClicked = new MutableLiveData<>();
        }
        return mLogInBtnClicked;
    }

    public void setLogInBtnClicked(Boolean newValue) {
        this.mLogInBtnClicked.setValue(newValue);
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    public void attemptLogin_ClickEvent(View view) {
        //saveUser();
        // Store values at the time of the login attempt.
        if (isUsernameValid() && isPasswordValid()) {
            //notify View
            String loginLog = String.format("Attempting to Login, Username: {%s}, Password: {%s}", mLoginCredentials.getUserName(), mLoginCredentials.getPassword());
            Log.v(getClass().getSimpleName(), loginLog);
        } else {
            String loginLog = String.format("Invalid Login Credentials, Username: {%s}, Password: {%s}", mLoginCredentials.getUserName(), mLoginCredentials.getPassword());
            Log.v(getClass().getSimpleName(), loginLog);
        }
        setLogInBtnClicked(true);
    }

    private boolean isUsernameValid() {
        Log.d(tag, "Validating Username...");
        String userName = mLoginCredentials.getUserName();

        return userName != null && TextUtils.equals(userName.trim(), correct_username);

    }

    private boolean isPasswordValid() {
        Log.v(tag, "Validating Password...");
        String password = mLoginCredentials.getPassword();

        //TODO: Replace this with your own logic
        return password != null && TextUtils.equals(password.trim(), correct_password);

    }

    private void saveUser() {
        Log.v(tag, "Saving User in App Database");
        UserDataProvider provider = new UserDataProvider(this.getApplication().getApplicationContext());
        provider.insert(mLoginCredentials);
    }

    private void getAllSavedUsers() {
        Log.v(tag, "Retrieving all Users from App Database");
        UserDataProvider provider = new UserDataProvider(this.getApplication().getApplicationContext());
        for (LoginCredentials credentials : provider.getAll()) {
            Log.v(getClass().getSimpleName(), "Found User: " + credentials.getUserName());
        }
    }
}

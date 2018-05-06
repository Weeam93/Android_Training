package com.example.weeamawad.simplelogindatabindingapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Weeam Awad on 4/28/2018.
 */

public class LoginCredentials extends BaseObservable {
    private ObservableField<String> mUserName = new ObservableField<String>();
    private ObservableField<String> mPassword = new ObservableField<String>();
    ;

    public LoginCredentials(String mUserName, String mPassword) {
        this.mUserName.set(mUserName);
        this.mPassword.set(mPassword);
    }

    public String getUserName() {
        return mUserName.get();
    }

    public void setUserName(String mUserName) {
        this.mUserName.set(mUserName);
        //notifyPropertyChanged(BR.userName);

    }

    public String getPassword() {
        return mPassword.get();
    }

    public void setPassword(String mPassword) {
        this.mPassword.set(mPassword);
        //notifyPropertyChanged(BR.password);
    }
}

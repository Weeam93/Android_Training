package com.example.weeamawad.simplelogindatabindingapp.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

/**
 * Created by Weeam Awad on 5/5/2018.
 */

public class MainViewModel extends ViewModel {
    private MutableLiveData<Boolean> mFileDownLoadBtnClicked;


    public MutableLiveData<Boolean> getFileDownLoadBtnClicked() {
        if (mFileDownLoadBtnClicked == null) {
            mFileDownLoadBtnClicked = new MutableLiveData<>();
        }
        return mFileDownLoadBtnClicked;
    }

    public void setFileDownLoadBtnClicked(Boolean newValue) {
        if (mFileDownLoadBtnClicked == null) {
            getFileDownLoadBtnClicked();
        }
        mFileDownLoadBtnClicked.setValue(newValue);
    }

    public void downloadFile_ClickEvent(View view) {
        setFileDownLoadBtnClicked(true);
    }
}

package com.example.weeamawad.simplelogindatabindingapp.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

/**
 * Created by Weeam Awad on 5/5/2018.
 */

public class MainViewModel extends ViewModel {
    private MutableLiveData<Boolean> mFileDownLoadBtnClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> mShowRecyclerViewBtnClicked = new MutableLiveData<>();


    public MutableLiveData<Boolean> getFileDownLoadBtnClicked() {
        return mFileDownLoadBtnClicked;
    }

    public void setFileDownLoadBtnClicked(Boolean newValue) {
        mFileDownLoadBtnClicked.setValue(newValue);
    }

    public MutableLiveData<Boolean> getShowRecyclerViewBtnClicked() {
        return mShowRecyclerViewBtnClicked;
    }

    public void setShowRecyclerViewBtnClicked(Boolean newValue) {
        this.mShowRecyclerViewBtnClicked.setValue(newValue);
    }

    public void downloadFile_ClickEvent(View view) {
        setFileDownLoadBtnClicked(true);
    }

    public void showRecyclerView_ClickEvent(View view) {
        setShowRecyclerViewBtnClicked(true);
    }
}

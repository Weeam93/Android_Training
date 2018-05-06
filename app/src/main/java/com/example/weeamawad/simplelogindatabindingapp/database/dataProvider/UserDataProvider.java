package com.example.weeamawad.simplelogindatabindingapp.database.dataProvider;

import android.content.Context;
import android.provider.ContactsContract;

import com.example.weeamawad.simplelogindatabindingapp.database.DataBaseHelper;
import com.example.weeamawad.simplelogindatabindingapp.database.datamodel.DataModel;
import com.example.weeamawad.simplelogindatabindingapp.database.datamodel.UserDataModel;
import com.example.weeamawad.simplelogindatabindingapp.model.LoginCredentials;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weeam Awad on 4/28/2018.
 */

public class UserDataProvider implements DataProvider<LoginCredentials> {

    public DataBaseHelper<UserDataModel> mProvider;

    public UserDataProvider(Context context) {
        mProvider = DataBaseHelper.getInstance(context);
    }


    @Override
    public long insert(LoginCredentials object) {
        UserDataModel userDataModel = new UserDataModel();
        userDataModel.firstName = ((LoginCredentials) object).getUserName();
        userDataModel.password = ((LoginCredentials) object).getPassword();
        return mProvider.insertEntry(userDataModel);
    }

    @Override
    public int delete(String id) {
        mProvider.removeEntry(UserDataModel.class, id);
        return 0;
    }

    @Override
    public int update(LoginCredentials object) {
        return 0;
    }

    @Override
    public LoginCredentials get(String id) {
        UserDataModel dataModel = mProvider.getEntry(UserDataModel.class, id);
        return new LoginCredentials(dataModel.firstName, dataModel.password);
    }

    @Override
    public List<LoginCredentials> getAll() {
        List<LoginCredentials> objectList = new ArrayList<>();
        for (UserDataModel dataModel : mProvider.getAllEntries(UserDataModel.class)) {
            LoginCredentials credentials = new LoginCredentials(dataModel.firstName, dataModel.password);
            objectList.add(credentials);
        }
        return objectList;
    }
}

package com.example.weeamawad.simplelogindatabindingapp.database.datamodel;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.weeamawad.simplelogindatabindingapp.database.tableSchema.UserTableSchema;

/**
 * Created by Weeam Awad on 4/28/2018.
 */

public class UserDataModel implements DataModel {
    private String id;
    public String firstName;
    public String password;

    @Override
    public <T extends DataModel> T fromCursor(Cursor cursor) {
        if (cursor != null) {
            UserDataModel dataModel = new UserDataModel();
            dataModel.id = cursor.getString(cursor.getColumnIndex(UserTableSchema._ID));
            dataModel.firstName = cursor.getString(cursor.getColumnIndex(UserTableSchema.COLUMN_FIRST_NAME));
            dataModel.password = cursor.getString(cursor.getColumnIndex(UserTableSchema.COLUMN_PASSWORD));
            return (T) dataModel;
        }
        return null;
    }

    @Override
    public String[] getColumns() {
        return new String[]{
                UserTableSchema._ID,
                UserTableSchema.COLUMN_FIRST_NAME,
                UserTableSchema.COLUMN_PASSWORD
        };
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(UserTableSchema._ID, id);
        values.put(UserTableSchema.COLUMN_FIRST_NAME, firstName);
        values.put(UserTableSchema.COLUMN_PASSWORD, password);
        return values;
    }

    @Override
    public String getPrimaryKeyName() {
        return UserTableSchema._ID;
    }

    @Override
    public String getTableName() {
        return UserTableSchema.TABLE_NAME;
    }
}

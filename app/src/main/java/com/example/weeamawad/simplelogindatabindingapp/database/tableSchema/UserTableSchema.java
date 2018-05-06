package com.example.weeamawad.simplelogindatabindingapp.database.tableSchema;

import android.provider.BaseColumns;

import com.example.weeamawad.simplelogindatabindingapp.database.datamodel.DataModel;

/**
 * Created by Weeam Awad on 4/28/2018.
 */

public final class UserTableSchema implements BaseColumns {
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_PASSWORD = "password";

    private UserTableSchema() {
    }

    public static String createTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + TABLE_NAME + " (");
        sb.append(_ID + " INTEGER PRIMARY KEY, ");
        sb.append(COLUMN_FIRST_NAME + " TEXT,");
        sb.append(COLUMN_PASSWORD + " TEXT)");
        return sb.toString();
    }

    public static String dropTable() {
        return "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}

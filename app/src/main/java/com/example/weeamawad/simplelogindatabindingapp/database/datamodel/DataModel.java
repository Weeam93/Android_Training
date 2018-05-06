package com.example.weeamawad.simplelogindatabindingapp.database.datamodel;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by Weeam Awad on 4/28/2018.
 */

public interface DataModel {
    <T extends DataModel> T fromCursor(Cursor cursor);

    String[] getColumns();

    ContentValues getContentValues();

    String getPrimaryKeyName();

    String getTableName();

    String toString();
}

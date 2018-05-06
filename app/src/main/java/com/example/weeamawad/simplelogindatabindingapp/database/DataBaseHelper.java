package com.example.weeamawad.simplelogindatabindingapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.weeamawad.simplelogindatabindingapp.database.datamodel.DataModel;
import com.example.weeamawad.simplelogindatabindingapp.database.tableSchema.UserTableSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weeam Awad on 4/28/2018.
 */

public class DataBaseHelper<T extends DataModel> extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "appDatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static DataBaseHelper mDataBaseHelper;

    public synchronized static <T extends DataModel> DataBaseHelper<T> getInstance(Context context) {
        if (mDataBaseHelper == null) {
            mDataBaseHelper = new DataBaseHelper(context.getApplicationContext());
        }
        return mDataBaseHelper;
    }

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserTableSchema.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(UserTableSchema.dropTable());
        onCreate(sqLiteDatabase);
    }


    public long insertEntry(T model) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        return writableDatabase.insertWithOnConflict(model.getTableName(), null, model.getContentValues(), SQLiteDatabase.CONFLICT_REPLACE);
    }

    public long updateEntry(T model) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues values = model.getContentValues();
        String whereClause = model.getPrimaryKeyName() + " =?";
        String[] args = new String[]{String.valueOf(values.get(model.getPrimaryKeyName()))};
        return writableDatabase.update(model.getTableName(), model.getContentValues(), whereClause, args);
    }

    public long removeEntry(Class<T> cls, String id) {
        T model = getGenericModelInstance(cls);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String whereClause = model.getPrimaryKeyName() + " = " + model.getPrimaryKeyName();
        String[] args = new String[]{id};
        return writableDatabase.delete(model.getTableName(), whereClause, args);
    }

    public T getEntry(Class<T> cls, String id) {
        T model = getGenericModelInstance(cls);
        SQLiteDatabase readableDatabase = getReadableDatabase();
        String whereClause = model.getPrimaryKeyName() + " = " + id;
        Cursor cursor = readableDatabase.query(model.getTableName(), model.getColumns(), whereClause, null, null, null, null);
        cursor.close();
        return model.fromCursor(cursor);
    }

    public List<T> getAllEntries(Class<T> cls) {
        T model = getGenericModelInstance(cls);
        List<T> rows = new ArrayList<>();

        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = readableDatabase.query(model.getTableName(), model.getColumns(), null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            rows.add((T) model.fromCursor(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return rows;
    }


    private T getGenericModelInstance(Class<T> cls) {
        T model = null;
        try {
            model = cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}

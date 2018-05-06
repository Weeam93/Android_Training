package com.example.weeamawad.simplelogindatabindingapp.database.dataProvider;

import java.util.List;

/**
 * Created by Weeam Awad on 4/28/2018.
 */

public interface DataProvider<T> {

    long insert(T appModel);

    int delete(String id);

    int update(T appModel);

    T get(String id);

    List<T> getAll();
}

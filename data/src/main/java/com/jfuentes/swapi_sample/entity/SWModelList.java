package com.jfuentes.swapi_sample.entity;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jfuentesa on 17/11/2016.
 */

public class SWModelList<T> implements Serializable {

    public int count;
    public String next;
    public String previous;
    public ArrayList<T> results;

    public boolean hasMore() {
        return !TextUtils.isEmpty(next);
    }

    public ArrayList<T> getResults() {
        return results;
    }
}

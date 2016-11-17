package com.jfuentes.swapi_sample.executor;

/**
 * Created by jfuentesa on 16/11/2016.
 */

public interface PostThreadExecutor {

    void post(Runnable runnable);
}

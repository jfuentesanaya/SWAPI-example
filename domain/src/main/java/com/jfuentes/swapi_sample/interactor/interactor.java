package com.jfuentes.swapi_sample.interactor;

/**
 * Created by jfuentesa on 17/11/2016.
 */

public interface Interactor extends Runnable {
    /**
     * Everything inside this method will be executed asynchronously.
     */
    void run();
}

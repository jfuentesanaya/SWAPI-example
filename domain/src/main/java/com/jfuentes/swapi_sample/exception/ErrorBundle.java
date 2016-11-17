package com.jfuentes.swapi_sample.exception;

/**
 * Created by jfuentesa on 17/11/2016.
 */


/**
 * Interface to manage errors.
 */
public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}

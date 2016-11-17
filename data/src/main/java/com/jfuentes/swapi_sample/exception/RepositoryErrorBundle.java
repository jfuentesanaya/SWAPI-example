package com.jfuentes.swapi_sample.exception;

/**
 * Created by jfuentesa on 17/11/2016.
 */

public class RepositoryErrorBundle implements ErrorBundle {

    private final Exception exception;

    public RepositoryErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if(this.exception != null){
            message = this.exception.getMessage();
        }
        return message;
    }
}

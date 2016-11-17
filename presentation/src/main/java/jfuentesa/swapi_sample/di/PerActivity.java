package jfuentesa.swapi_sample.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by jfuentesa on 17/11/2016.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity  {
}

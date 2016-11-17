package jfuentesa.swapi_sample.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import jfuentesa.swapi_sample.di.PerActivity;

/**
 * Created by jfuentesa on 17/11/2016.
 */

@Module
public class ActivityModule {

    private final Activity activity;


    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity(){
        return this.activity;
    }
}

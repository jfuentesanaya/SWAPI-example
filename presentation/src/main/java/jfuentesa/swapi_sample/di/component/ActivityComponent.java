package jfuentesa.swapi_sample.di.component;

import android.app.Activity;

import dagger.Component;
import jfuentesa.swapi_sample.di.PerActivity;
import jfuentesa.swapi_sample.di.module.ActivityModule;

/**
 * Created by jfuentesa on 17/11/2016.
 */

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}

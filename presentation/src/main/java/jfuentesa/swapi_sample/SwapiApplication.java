package jfuentesa.swapi_sample;

import android.app.Application;

import com.facebook.stetho.Stetho;

import jfuentesa.swapi_sample.di.component.ApplicationComponent;
import jfuentesa.swapi_sample.di.component.DaggerApplicationComponent;
import jfuentesa.swapi_sample.di.module.ApplicationModule;
import timber.log.Timber;

/**
 * Created by jfuentesa on 15/11/2016.
 */

public class SwapiApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeDagger();
        initializeTimber();
        initializeStetho();
    }

    private void initializeTimber() {
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initializeStetho(){
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }

    private void initializeDagger(){
        this.applicationComponent = DaggerApplicationComponent.builder()
                              .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}

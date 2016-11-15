package jfuentesa.swapi_sample;

import android.app.Application;

import com.facebook.stetho.Stetho;

import timber.log.Timber;

/**
 * Created by jfuentesa on 15/11/2016.
 */

public class SwapiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

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
}

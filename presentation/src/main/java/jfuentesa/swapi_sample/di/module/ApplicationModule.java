package jfuentesa.swapi_sample.di.module;

import android.content.Context;

import com.jfuentes.swapi_sample.executor.JobExecutor;
import com.jfuentes.swapi_sample.executor.PostThreadExecutor;
import com.jfuentes.swapi_sample.executor.ThreadExecutor;
import com.jfuentes.swapi_sample.repository.PeopleDataRepository;
import com.jfuentes.swapi_sample.repository.PeopleRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jfuentesa.swapi_sample.SwapiApplication;
import jfuentesa.swapi_sample.UiThread;

/**
 * Created by jfuentesa on 15/11/2016.
 */

@Module
public class ApplicationModule {

    private final SwapiApplication swapiApplication;

    public ApplicationModule(SwapiApplication swapiApplication) {
        this.swapiApplication = swapiApplication;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return swapiApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor){
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostThreadExecutor providePostThreadExecutor(UiThread uiThread){
        return uiThread;
    }

    @Provides
    @Singleton
    PeopleRepository providePeopleRepository(PeopleDataRepository peopleDataRepository){
        return peopleDataRepository;
    }
}

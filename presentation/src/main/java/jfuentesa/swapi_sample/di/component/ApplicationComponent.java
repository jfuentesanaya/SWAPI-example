package jfuentesa.swapi_sample.di.component;

import android.content.Context;

import com.jfuentes.swapi_sample.executor.PostThreadExecutor;
import com.jfuentes.swapi_sample.executor.ThreadExecutor;
import com.jfuentes.swapi_sample.repository.PeopleRepository;

import javax.inject.Singleton;

import dagger.Component;
import jfuentesa.swapi_sample.di.module.ApplicationModule;
import jfuentesa.swapi_sample.ui.activity.BaseActivity;
import jfuentesa.swapi_sample.ui.presenter.SwListPresenter;

/**
 * Created by jfuentesa on 15/11/2016.
 */

@Singleton
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity activity);

    //Exposed to subgraphs
    Context context();
    ThreadExecutor threadExecutor();
    PostThreadExecutor postThreadExecutor();
    PeopleRepository peopleRepository();
}

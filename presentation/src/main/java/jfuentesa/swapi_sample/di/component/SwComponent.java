package jfuentesa.swapi_sample.di.component;

import dagger.Component;
import jfuentesa.swapi_sample.di.PerActivity;
import jfuentesa.swapi_sample.di.module.ActivityModule;
import jfuentesa.swapi_sample.di.module.SwModule;
import jfuentesa.swapi_sample.ui.fragment.PeopleDetailsFragment;
import jfuentesa.swapi_sample.ui.fragment.SwListFragment;

/**
 * Created by jfuentesa on 17/11/2016.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, SwModule.class})
public interface SwComponent extends ActivityComponent {

    void inject(SwListFragment swListFragment);
//    void inject(PeopleDetailsFragment peopleDetailsFragment);
}

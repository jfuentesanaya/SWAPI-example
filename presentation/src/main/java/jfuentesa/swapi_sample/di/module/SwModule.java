package jfuentesa.swapi_sample.di.module;

import com.jfuentes.swapi_sample.interactor.GetFilmUseCase;
import com.jfuentes.swapi_sample.interactor.GetFilmUseCaseImp;
import com.jfuentes.swapi_sample.interactor.GetPeopleListUseCase;
import com.jfuentes.swapi_sample.interactor.GetPeopleListUseCaseImp;

import dagger.Module;
import dagger.Provides;
import jfuentesa.swapi_sample.di.PerActivity;

/**
 * Created by jfuentesa on 17/11/2016.
 */

@Module
public class SwModule {

    @Provides @PerActivity
    GetPeopleListUseCase provideGetPeopleListUseCase (GetPeopleListUseCaseImp getPeopleListUseCaseImp){
        return getPeopleListUseCaseImp;
    }

    @Provides @PerActivity
    GetFilmUseCase provideGetFilmUseCase (GetFilmUseCaseImp getFilmUseCaseImp){
        return getFilmUseCaseImp;
    }

}

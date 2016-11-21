package com.jfuentes.swapi_sample.repository;

import com.jfuentes.swapi_sample.entity.FilmEntity;
import com.jfuentes.swapi_sample.entity.mapper.FilmEntityDataMapper;
import com.jfuentes.swapi_sample.exception.RepositoryErrorBundle;
import com.jfuentes.swapi_sample.repository.datasource.FilmDataStore;
import com.jfuentes.swapi_sample.repository.datasource.FilmStoreFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jfuentesa on 21/11/2016.
 */

@Singleton
public class FilmDataRepository implements FilmRepository, FilmDataStore.FilmDetailsDSCallback {

    private final FilmEntityDataMapper filmEntityDataMapper;
    private final FilmStoreFactory filmStoreFactory;
    private FilmDetailRepositoryCallback filmDetailRepositoryCallback;

    @Inject
    FilmDataRepository(FilmStoreFactory filmStoreFactory, FilmEntityDataMapper filmEntityDataMapper) {
        this.filmStoreFactory = filmStoreFactory;
        this.filmEntityDataMapper = filmEntityDataMapper;
    }

    @Override
    public void getFilmById(String filmId, FilmDetailRepositoryCallback filmRepositoryCallback) {
        this.filmDetailRepositoryCallback = filmRepositoryCallback;

        FilmDataStore filmDataStore = this.filmStoreFactory.createCloudFilmDataStore();
        filmDataStore.getFilmEntityDetails(filmId, this);
    }

    @Override
    public void onFilmEntityLoaded(FilmEntity filmEntity) {
        filmDetailRepositoryCallback.onFilmLoaded(filmEntityDataMapper.transform(filmEntity));
    }

    @Override
    public void onError(Exception exception) {
        filmDetailRepositoryCallback.onError(new RepositoryErrorBundle(exception));
    }
}

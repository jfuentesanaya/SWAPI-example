package com.jfuentes.swapi_sample.repository.datasource;

import com.jfuentes.swapi_sample.net.RestApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jfuentesa on 21/11/2016.
 */

@Singleton
public class FilmStoreFactory {

    private final RestApiService restApiService;

    @Inject
    public FilmStoreFactory(RestApiService restApiService) {
        this.restApiService = restApiService;
    }

    public FilmDataStore createCloudFilmDataStore(){
        return new FilmDataStoreImp(restApiService);
    }
}

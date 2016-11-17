package com.jfuentes.swapi_sample.repository.datasource;

import com.jfuentes.swapi_sample.net.RestApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jfuentesa on 17/11/2016.
 */

@Singleton
public class PeopleStoreFactory {

    private final RestApiService restApiService;

    @Inject
    PeopleStoreFactory(RestApiService restApiService) {
        this.restApiService = restApiService;
    }

    public PeopleDataStore createCloudPostDataStore(){
        return new PeopleDataStoreImp(restApiService);
    }
}

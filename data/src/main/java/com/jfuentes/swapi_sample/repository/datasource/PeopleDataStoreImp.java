package com.jfuentes.swapi_sample.repository.datasource;

import com.jfuentes.swapi_sample.entity.PeopleEntity;
import com.jfuentes.swapi_sample.entity.SWModelList;
import com.jfuentes.swapi_sample.net.RestApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jfuentesa on 17/11/2016.
 */

public class PeopleDataStoreImp implements PeopleDataStore {

    private static RestApiService restApiService;

    PeopleDataStoreImp(RestApiService restApiService) {
        this.restApiService = restApiService;
    }

    @Override
    public void getPeopleEntryList(final PeopleListDSCallback peopleListDSCallback) {
        restApiService.getAllPeople().enqueue(new Callback<SWModelList<PeopleEntity>>() {
            @Override
            public void onResponse(Call<SWModelList<PeopleEntity>> call, Response<SWModelList<PeopleEntity>> response) {

                SWModelList<PeopleEntity> dataEntity = response.body();
                peopleListDSCallback.onPeopleListLoaded(dataEntity.getResults());
            }

            @Override
            public void onFailure(Call<SWModelList<PeopleEntity>> call, Throwable t) {
                peopleListDSCallback.onError((Exception) t);
            }
        });
    }
}

package com.jfuentes.swapi_sample.repository.datasource;

import com.jfuentes.swapi_sample.entity.FilmEntity;
import com.jfuentes.swapi_sample.net.RestApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jfuentesa on 21/11/2016.
 */

public class FilmDataStoreImp implements FilmDataStore {

    private RestApiService restApiService;

    public FilmDataStoreImp(RestApiService restApiService) {
        this.restApiService = restApiService;
    }

    @Override
    public void getFilmEntityDetails(String id, final FilmDetailsDSCallback filmDetailsDSCallback) {
        restApiService.getFilmById(id).enqueue(new Callback<FilmEntity>() {
            @Override
            public void onResponse(Call<FilmEntity> call, Response<FilmEntity> response) {
                filmDetailsDSCallback.onFilmEntityLoaded(response.body());
            }

            @Override
            public void onFailure(Call<FilmEntity> call, Throwable t) {
                filmDetailsDSCallback.onError((Exception) t);
            }
        });
    }
}

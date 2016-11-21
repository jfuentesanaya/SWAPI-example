package com.jfuentes.swapi_sample.net;

import com.jfuentes.swapi_sample.entity.FilmEntity;
import com.jfuentes.swapi_sample.entity.PeopleEntity;
import com.jfuentes.swapi_sample.entity.SWModelList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jfuentesa on 17/11/2016.
 */

public interface RestApiService {

    @GET("people")
    Call<SWModelList<PeopleEntity>> getAllPeople();

    @GET("films/{id_film}")
    Call<FilmEntity> getFilmById(
            @Path("id_film") String idFilm);
}

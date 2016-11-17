package com.jfuentes.swapi_sample.net;

import com.jfuentes.swapi_sample.entity.PeopleEntity;
import com.jfuentes.swapi_sample.entity.SWModelList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jfuentesa on 17/11/2016.
 */

public interface RestApiService {

    @GET("people")
    Call<SWModelList<PeopleEntity>> getAllPeople();
}

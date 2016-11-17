package com.jfuentes.swapi_sample.repository;

import com.jfuentes.swapi_sample.People;
import com.jfuentes.swapi_sample.exception.ErrorBundle;

import java.util.Collection;

/**
 * Created by jfuentesa on 17/11/2016.
 */

public interface PeopleRepository {

    interface PeopleListRepositoryCallback{
        void onListLoaded(Collection<People> peopleCollection);
        void onError(ErrorBundle errorBundle);
    }

    /**
     *
     * @param peopleListRepositoryCallback
     */
    void getPeopleList(PeopleListRepositoryCallback peopleListRepositoryCallback);
}

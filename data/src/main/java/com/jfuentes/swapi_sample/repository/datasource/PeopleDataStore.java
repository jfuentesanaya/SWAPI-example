package com.jfuentes.swapi_sample.repository.datasource;

import com.jfuentes.swapi_sample.entity.PeopleEntity;

import java.util.Collection;

/**
 * Created by jfuentesa on 17/11/2016.
 */

public interface PeopleDataStore {

    interface PeopleListDSCallback{
        void onPeopleListLoaded(Collection<PeopleEntity> peopleEntityCollection);
        void onError(Exception exception);
    }

    /**
     * Get a collection of {@link com.jfuentes.swapi_sample.People}.
     *
     * @param peopleListDSCallback A {@link PeopleListDSCallback} used for notifying users.
     */
    void getPeopleEntryList(PeopleListDSCallback peopleListDSCallback);
}

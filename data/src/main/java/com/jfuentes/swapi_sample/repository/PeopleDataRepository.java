package com.jfuentes.swapi_sample.repository;

import com.jfuentes.swapi_sample.entity.mapper.PeopleEntityDataMapper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PeopleDataRepository implements PeopleRepository{

    private final PeopleEntityDataMapper peopleEntityDataMapper;

    @Inject
    public PeopleDataRepository(PeopleEntityDataMapper peopleEntityDataMapper) {
        this.peopleEntityDataMapper = peopleEntityDataMapper;
    }

    @Override
    public void getPeopleList(PeopleListRepositoryCallback peopleListRepositoryCallback) {

    }
}

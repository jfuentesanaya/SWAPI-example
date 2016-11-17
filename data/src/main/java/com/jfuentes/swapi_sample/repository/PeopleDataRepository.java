package com.jfuentes.swapi_sample.repository;

import com.jfuentes.swapi_sample.entity.PeopleEntity;
import com.jfuentes.swapi_sample.entity.mapper.PeopleEntityDataMapper;
import com.jfuentes.swapi_sample.exception.RepositoryErrorBundle;
import com.jfuentes.swapi_sample.repository.datasource.PeopleDataStore;
import com.jfuentes.swapi_sample.repository.datasource.PeopleStoreFactory;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PeopleDataRepository implements PeopleRepository, PeopleDataStore.PeopleListDSCallback{

    private final PeopleEntityDataMapper peopleEntityDataMapper;
    private final PeopleStoreFactory peopleStoreFactory;
    private PeopleListRepositoryCallback peopleListRepositoryCallback;

    @Inject
    PeopleDataRepository(PeopleEntityDataMapper peopleEntityDataMapper, PeopleStoreFactory peopleStoreFactory) {
        this.peopleEntityDataMapper = peopleEntityDataMapper;
        this.peopleStoreFactory = peopleStoreFactory;
    }

    @Override
    public void getPeopleList(PeopleListRepositoryCallback peopleListRepositoryCallback) {
        this.peopleListRepositoryCallback = peopleListRepositoryCallback;

        PeopleDataStore peopleDataStore = this.peopleStoreFactory.createCloudPostDataStore();
        peopleDataStore.getPeopleEntryList(this);
    }

    @Override
    public void onPeopleListLoaded(Collection<PeopleEntity> peopleEntityCollection) {
        peopleListRepositoryCallback.onListLoaded(peopleEntityDataMapper.transform(peopleEntityCollection));
    }

    @Override
    public void onError(Exception exception) {
        peopleListRepositoryCallback.onError(new RepositoryErrorBundle(exception));
    }
}

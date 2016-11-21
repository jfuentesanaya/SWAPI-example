package com.jfuentes.swapi_sample.entity.mapper;

import com.jfuentes.swapi_sample.People;
import com.jfuentes.swapi_sample.entity.PeopleEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jfuentesa on 17/11/2016.
 */

@Singleton
public class PeopleEntityDataMapper {

    @Inject
    public PeopleEntityDataMapper() {}

    /**
     * Transform a Collection of {@link PeopleEntity} into a Collection of {@link People}.
     *
     * @param peopleEntityCollection Object to be transformed.
     * @return {@link Collection<People>}
     */
    public Collection<People> transform (Collection<PeopleEntity> peopleEntityCollection){
        List<People> peopleList = new ArrayList<>();
        People people;
        for (PeopleEntity peopleEntity : peopleEntityCollection) {
            people = transform(peopleEntity);
            if (people != null) {
                peopleList.add(people);
            }
        }

        return peopleList;
    }

    /**
     * Transform a {@link PeopleEntity} into an {@link People}.
     *
     * @param peopleEntity Object to be transformed
     * @return {@Link People}
     */
    private People transform(PeopleEntity peopleEntity){
        People people = null;
        if(peopleEntity != null){
            people = new People();
            people.setName(peopleEntity.getName());
            people.setHeight(peopleEntity.getHeight());
            people.setGender(peopleEntity.getGender());
            people.setFilmsUrl(peopleEntity.getFilmsUrls());
        }
        return people;
    }
}

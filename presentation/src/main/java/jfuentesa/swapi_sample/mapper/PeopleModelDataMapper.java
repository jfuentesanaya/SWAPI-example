package jfuentesa.swapi_sample.mapper;

/**
 * Created by jfuentesa on 18/11/2016.
 */

import com.jfuentes.swapi_sample.People;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import jfuentesa.swapi_sample.di.PerActivity;
import jfuentesa.swapi_sample.model.PeopleModel;

/**
 * Mapper class used to transform {@link com.jfuentes.swapi_sample.People} (in the domain layer) to {@link jfuentesa.swapi_sample.model.PeopleModel} in the
 * presentation layer.
 */

@PerActivity
public class PeopleModelDataMapper {

    @Inject
    public PeopleModelDataMapper() { }


    /**
     * Transform a {@link People} into an {@link PeopleModel}.
     *
     * @param people Object to be transformed.
     * @return {@link PeopleModel}.
     */
    public PeopleModel transform (People people){
        if(people == null){
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        PeopleModel peopleModel = new PeopleModel();
        peopleModel.setName(people.getName());
        peopleModel.setHeight(people.getHeight());

        return peopleModel;
    }

    public Collection<PeopleModel> transform (Collection<People> peopleCollection){
        Collection<PeopleModel> peopleModelCollection;

        if(peopleCollection != null && !peopleCollection.isEmpty()){
            peopleModelCollection = new ArrayList<>();

            for(People people : peopleCollection){
                peopleModelCollection.add(transform(people));
            }

        }else {
            peopleModelCollection = Collections.emptyList();
        }

        return peopleModelCollection;
    }

}

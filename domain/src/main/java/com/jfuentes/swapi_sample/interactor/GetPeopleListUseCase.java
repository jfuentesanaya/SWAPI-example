package com.jfuentes.swapi_sample.interactor;

import com.jfuentes.swapi_sample.People;
import com.jfuentes.swapi_sample.exception.ErrorBundle;

import java.util.Collection;

/**
 * Created by jfuentesa on 17/11/2016.
 */

public interface GetPeopleListUseCase extends Interactor {

    /**
     * Callback used to be notified when either a people collection has been loaded or an error happened.
     */
    interface Callback {
        void onPeopleListLoaded(Collection<People> peopleCollection);
        void onError(ErrorBundle errorBundle);
    }

    /**
     * Executes this user case.
     *
     * @param callback A {@link GetPeopleListUseCase.Callback} used to notify the client.
     */
    void execute(Callback callback);
}

package com.jfuentes.swapi_sample.interactor;

import com.jfuentes.swapi_sample.People;
import com.jfuentes.swapi_sample.exception.ErrorBundle;
import com.jfuentes.swapi_sample.executor.PostThreadExecutor;
import com.jfuentes.swapi_sample.executor.ThreadExecutor;
import com.jfuentes.swapi_sample.repository.PeopleRepository;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by jfuentesa on 17/11/2016.
 */

public class GetPeopleListUseCaseImp implements GetPeopleListUseCase {

    private final PeopleRepository peopleRepository;
    private final ThreadExecutor threadExecutor;
    private final PostThreadExecutor postThreadExecutor;
    private Callback callback;

    @Inject
    public GetPeopleListUseCaseImp(PeopleRepository peopleRepository, ThreadExecutor threadExecutor, PostThreadExecutor postThreadExecutor) {
        this.peopleRepository = peopleRepository;
        this.threadExecutor = threadExecutor;
        this.postThreadExecutor = postThreadExecutor;
    }

    @Override
    public void execute(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Interactor callback cannot be null!!!");
        }
        this.callback = callback;
        this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        this.peopleRepository.getPeopleList(repositoryCallback);
    }



    private final PeopleRepository.PeopleListRepositoryCallback repositoryCallback = new PeopleRepository.PeopleListRepositoryCallback() {
        @Override
        public void onListLoaded(Collection<People> peopleCollection) {
            notifyGetPeopleListSuccessfully(peopleCollection);
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            notifyGetPeopleListError(errorBundle);
        }
    };

    private void notifyGetPeopleListSuccessfully(final Collection<People> peopleCollection){
        this.postThreadExecutor.post(new Runnable() {
            @Override
            public void run() {
                callback.onPeopleListLoaded(peopleCollection);
            }
        });
    }

    private void notifyGetPeopleListError(final ErrorBundle errorBundle){
        this.postThreadExecutor.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(errorBundle);
            }
        });
    }
}

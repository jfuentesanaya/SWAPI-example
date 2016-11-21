package com.jfuentes.swapi_sample.interactor;

import com.jfuentes.swapi_sample.executor.PostThreadExecutor;
import com.jfuentes.swapi_sample.executor.ThreadExecutor;
import com.jfuentes.swapi_sample.repository.FilmRepository;

import javax.inject.Inject;

/**
 * Created by jfuentesa on 21/11/2016.
 */

public class FilmUseCaseFactory {
    private FilmRepository filmRepository;
    private ThreadExecutor threadExecutor;
    private PostThreadExecutor postThreadExecutor;

    @Inject
    FilmUseCaseFactory(FilmRepository filmRepository, ThreadExecutor threadExecutor, PostThreadExecutor postThreadExecutor) {
        this.filmRepository = filmRepository;
        this.threadExecutor = threadExecutor;
        this.postThreadExecutor = postThreadExecutor;
    }

    public GetFilmUseCaseImp getNewFilmUseCase(){
        return new GetFilmUseCaseImp(filmRepository, threadExecutor, postThreadExecutor);
    }
}

package com.jfuentes.swapi_sample.interactor;

import com.jfuentes.swapi_sample.Film;
import com.jfuentes.swapi_sample.exception.ErrorBundle;
import com.jfuentes.swapi_sample.executor.PostThreadExecutor;
import com.jfuentes.swapi_sample.executor.ThreadExecutor;
import com.jfuentes.swapi_sample.repository.FilmRepository;

import javax.inject.Inject;

/**
 * Created by jfuentesa on 21/11/2016.
 */

public class GetFilmUseCaseImp implements GetFilmUseCase {

    private final FilmRepository filmRepository;
    private final ThreadExecutor threadExecutor;
    private final PostThreadExecutor postThreadExecutor;
    private GetFilmUseCase.Callback callbackUseCase;

    private String filmId;

    @Inject
    public GetFilmUseCaseImp(FilmRepository filmRepository, ThreadExecutor threadExecutor, PostThreadExecutor postThreadExecutor) {
        this.filmRepository = filmRepository;
        this.threadExecutor = threadExecutor;
        this.postThreadExecutor = postThreadExecutor;
    }

    @Override
    public void execute(String filmId, Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Interactor callback cannot be null!");
        }
        this.filmId = filmId;
        this.callbackUseCase = callback;
        this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        this.filmRepository.getFilmById(filmId, filmDetailRepositoryCallback);
    }


    private final FilmRepository.FilmDetailRepositoryCallback filmDetailRepositoryCallback = new FilmRepository.FilmDetailRepositoryCallback() {
        @Override
        public void onFilmLoaded(Film film) {
            notifyGetFilmSuccessfully(film);
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            notifyGetFilmError(errorBundle);
        }
    };


    private void notifyGetFilmSuccessfully(final Film film){
        this.postThreadExecutor.post(new Runnable() {
            @Override
            public void run() {
                callbackUseCase.onFilmLoaded(film);
            }
        });
    }

    private void notifyGetFilmError(final ErrorBundle errorBundle){
        this.postThreadExecutor.post(new Runnable() {
            @Override
            public void run() {
                callbackUseCase.onError(errorBundle);
            }
        });
    }
}

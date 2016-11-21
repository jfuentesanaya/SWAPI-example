package com.jfuentes.swapi_sample.repository;

import com.jfuentes.swapi_sample.Film;
import com.jfuentes.swapi_sample.exception.ErrorBundle;

/**
 * Created by jfuentesa on 21/11/2016.
 */

public interface FilmRepository {

    interface FilmDetailRepositoryCallback{
        void onFilmLoaded(Film film);
        void onError(ErrorBundle errorBundle);
    }

    /**
     * Get an {@link Film} by id.
     *
     * @param filmId The fil id used to retrieve film data.
     * @param filmRepositoryCallback A {@link FilmDetailRepositoryCallback} used for notifying clients.
     */
    void getFilmById(String filmId, FilmDetailRepositoryCallback filmRepositoryCallback);
}

package com.jfuentes.swapi_sample.interactor;

import com.jfuentes.swapi_sample.Film;
import com.jfuentes.swapi_sample.exception.ErrorBundle;


/**
 * Created by jfuentesa on 21/11/2016.
 */

public interface GetFilmUseCase extends Interactor {

    /**
     * Callback used to be notified when either a film has been loaded or an error happened.
     */
    interface Callback {
        void onFilmLoaded(Film film);
        void onError(ErrorBundle errorBundle);
    }

    /**
     * Executes this user case.
     *
     * @param filmId The film id to retrieve.
     * @param callback A {@link GetFilmUseCase.Callback} used to notify the client.
     */
    void execute(String filmId, GetFilmUseCase.Callback callback);
}

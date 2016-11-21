package com.jfuentes.swapi_sample.repository.datasource;

import com.jfuentes.swapi_sample.entity.FilmEntity;

/**
 * Created by jfuentesa on 21/11/2016.
 */

public interface FilmDataStore {

    /**
     * Callback used for clients to be notified when either film data has been retrieved successfully
     * or any error occurred.
     */
    interface FilmDetailsDSCallback {
        void onFilmEntityLoaded(FilmEntity filmEntity);

        void onError(Exception exception);
    }

    /**
     * Get a {@link FilmEntity} by its id.
     *
     * @param id The id to retrieve film data.
     * @param filmDetailsDSCallback A {@link FilmDetailsDSCallback} for notifications.
     */
    void getFilmEntityDetails(String id, FilmDetailsDSCallback filmDetailsDSCallback);
}

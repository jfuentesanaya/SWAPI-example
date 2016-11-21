package com.jfuentes.swapi_sample.entity.mapper;

import com.jfuentes.swapi_sample.Film;
import com.jfuentes.swapi_sample.entity.FilmEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jfuentesa on 21/11/2016.
 */

@Singleton
public class FilmEntityDataMapper {

    @Inject
    public FilmEntityDataMapper() { }

    /**
     * Transform a Collection of {@link FilmEntity} into a Collection of {@link Film}.
     *
     * @param filmEntityCollection Object to be transformed.
     * @return {@link Collection<Film>}
     */
    public Collection<Film> transform (Collection<FilmEntity> filmEntityCollection){
        List<Film> filmList = new ArrayList<>();
        Film film;
        for (FilmEntity filmEntity : filmEntityCollection) {
            film = transform(filmEntity);
            if (film != null) {
                filmList.add(film);
            }
        }

        return filmList;
    }

    /**
     * Transform a {@link FilmEntity} into an {@link Film}.
     *
     * @param filmEntity Object to be transformed
     * @return {@Link Film}
     */
    public Film transform(FilmEntity filmEntity){
        Film film = null;
        if(filmEntity != null){
            film = new Film();
            film.setTitle(filmEntity.getTitle());
            film.setDirector(filmEntity.getDirector());
            film.setEpisodeId(filmEntity.getEpisodeId());
        }
        return film;
    }
}

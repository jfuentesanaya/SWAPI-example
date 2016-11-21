package jfuentesa.swapi_sample.mapper;

import com.jfuentes.swapi_sample.Film;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import jfuentesa.swapi_sample.di.PerActivity;
import jfuentesa.swapi_sample.model.FilmModel;

/**
 * Created by jfuentesa on 21/11/2016.
 */


/**
 * Mapper class used to transform {@link com.jfuentes.swapi_sample.Film} (in the domain layer) to {@link jfuentesa.swapi_sample.model.FilmModel} in the
 * presentation layer.
 */
@PerActivity
public class FilmModelDataMapper {

    @Inject
    public FilmModelDataMapper() { }

    /**
     * Transform a {@link Film} into an {@link FilmModel}.
     *
     * @param film Object to be transformed.
     * @return {@link FilmModel}.
     */
    public FilmModel transform (Film film){
        if(film == null){
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        FilmModel filmModel = new FilmModel();
        filmModel.setTitle(film.getTitle());
        filmModel.setEpisodeId(film.getEpisodeId());
        filmModel.setDirector(film.getDirector());

        return filmModel;
    }

    public Collection<FilmModel> transform (Collection<Film> filmCollection){
        Collection<FilmModel> filmModelCollection;

        if(filmCollection != null && !filmCollection.isEmpty()){
            filmModelCollection = new ArrayList<>();

            for(Film people : filmCollection){
                filmModelCollection.add(transform(people));
            }

        }else {
            filmModelCollection = Collections.emptyList();
        }

        return filmModelCollection;
    }
}

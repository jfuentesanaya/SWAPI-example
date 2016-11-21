package jfuentesa.swapi_sample.ui.presenter;

import android.support.annotation.NonNull;

import com.jfuentes.swapi_sample.Film;
import com.jfuentes.swapi_sample.exception.ErrorBundle;
import com.jfuentes.swapi_sample.interactor.GetFilmUseCase;

import javax.inject.Inject;

import jfuentesa.swapi_sample.di.PerActivity;
import jfuentesa.swapi_sample.mapper.FilmModelDataMapper;
import jfuentesa.swapi_sample.model.FilmModel;
import jfuentesa.swapi_sample.ui.view.PeopleDetailsView;

/**
 * Created by jfuentesa on 18/11/2016.
 */
@PerActivity
public class PeopleDetailsPresenter implements PresenterBase {

    private PeopleDetailsView detailsView;
    private GetFilmUseCase getFilmUseCase;
    private FilmModelDataMapper filmModelDataMapper;

    @Inject
    PeopleDetailsPresenter(GetFilmUseCase getFilmUseCase, FilmModelDataMapper filmModelDataMapper) {
        this.getFilmUseCase = getFilmUseCase;
        this.filmModelDataMapper = filmModelDataMapper;
    }

    public void setView(@NonNull PeopleDetailsView view){
        this.detailsView = view;
    }

    /**
     * Loads all people
     */
    public void loadFilms() {
        detailsView.showLoading();
        getFilmsById();
    }

    private void getFilmsById(){
        getFilmUseCase.execute("1",getFilmUseCaseCallback);
    }

    private void showFilmInView(Film film){
        FilmModel filmModel = this.filmModelDataMapper.transform(film);
//        this.detailsView.renderList(filmModel);

    }

    GetFilmUseCase.Callback getFilmUseCaseCallback = new GetFilmUseCase.Callback() {
        @Override
        public void onFilmLoaded(Film film) {

        }

        @Override
        public void onError(ErrorBundle errorBundle) {

        }
    };
}

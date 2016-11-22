package jfuentesa.swapi_sample.ui.presenter;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.jfuentes.swapi_sample.Film;
import com.jfuentes.swapi_sample.exception.ErrorBundle;
import com.jfuentes.swapi_sample.interactor.GetFilmUseCase;
import com.jfuentes.swapi_sample.interactor.GetFilmUseCaseImp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

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
    private FilmModelDataMapper filmModelDataMapper;
    private List<String> filmsUrl;
    private List<String> titleFilms = new ArrayList<>();
    //Provider executes Factory method for execute different instances
    private Provider<GetFilmUseCaseImp> getFilmUseCaseImpProvider;

    @Inject
    PeopleDetailsPresenter(FilmModelDataMapper filmModelDataMapper, Provider<GetFilmUseCaseImp> getFilmUseCaseImpProvider) {
        this.getFilmUseCaseImpProvider = getFilmUseCaseImpProvider;
        this.filmModelDataMapper = filmModelDataMapper;
    }

    public void setView(@NonNull PeopleDetailsView view){
        this.detailsView = view;
    }

    /**
     * Loads all people
     */
    public void loadFilms(List<String> filmsUrl) {
        if(!filmsUrl.isEmpty()) {
            this.filmsUrl = filmsUrl;
            detailsView.showLoading();
            getFilmsById(filmsUrl);
        }else{
            detailsView.hideLoading();
        }
    }

    private void getFilmsById(List<String> filmsUrl){
        for(String filmUrl : filmsUrl){
            Uri uri = Uri.parse(filmUrl);
            String filmId = uri.getLastPathSegment();
            getFilmUseCaseImpProvider.get().execute(filmId, getFilmUseCaseCallback  );
        }
    }

    private void showFilmInView(final Film film){

        FilmModel filmModel = this.filmModelDataMapper.transform(film);
        this.titleFilms.add(filmModel.getTitle());

        if(this.filmsUrl.size() == this.titleFilms.size()){
            String filmsToShow = "";
            for(String title : titleFilms){
                filmsToShow += (title+"\n");
            }
            detailsView.hideLoading();
            this.detailsView.showFilms(filmsToShow);
        }
    }

    private GetFilmUseCase.Callback getFilmUseCaseCallback = new GetFilmUseCase.Callback() {
        @Override
        public void onFilmLoaded(Film film) {
            showFilmInView(film);
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            detailsView.hideLoading();
            detailsView.showError(errorBundle.getErrorMessage());
        }
    };
}

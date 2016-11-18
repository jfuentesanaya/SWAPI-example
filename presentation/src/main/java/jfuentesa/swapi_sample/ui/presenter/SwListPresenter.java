package jfuentesa.swapi_sample.ui.presenter;

import android.support.annotation.NonNull;

import com.jfuentes.swapi_sample.People;
import com.jfuentes.swapi_sample.exception.ErrorBundle;
import com.jfuentes.swapi_sample.interactor.GetPeopleListUseCase;

import java.util.Collection;

import javax.inject.Inject;

import jfuentesa.swapi_sample.di.PerActivity;
import jfuentesa.swapi_sample.mapper.PeopleModelDataMapper;
import jfuentesa.swapi_sample.model.PeopleModel;
import jfuentesa.swapi_sample.ui.view.SwListView;

/**
 * Created by jfuentesa on 16/11/2016.
 */

@PerActivity
public class SwListPresenter implements PresenterBase {

    private SwListView view;
    private GetPeopleListUseCase getPeopleListUseCase;
    private PeopleModelDataMapper peopleModelDataMapper;

    @Inject
    SwListPresenter(GetPeopleListUseCase getPeopleListUseCase, PeopleModelDataMapper peopleModelDataMapper) {
        this.getPeopleListUseCase = getPeopleListUseCase;
        this.peopleModelDataMapper = peopleModelDataMapper;
    }

    public void setView(@NonNull SwListView view){
        this.view = view;
    }

    /**
     * Loads all people
     */
    public void loadPeopleList() {
        view.showLoading();
        getPeopleAPI();
    }

    private void getPeopleAPI(){
        getPeopleListUseCase.execute(getPeopleListUseCaseCallback);
    }

    private void showPeopleCollectionInView(Collection<People> peopleCollection){
        Collection<PeopleModel> peopleModelCollection = this.peopleModelDataMapper.transform(peopleCollection);
        this.view.renderList(peopleModelCollection);

    }

    GetPeopleListUseCase.Callback getPeopleListUseCaseCallback =  new GetPeopleListUseCase.Callback() {
        @Override
        public void onPeopleListLoaded(Collection<People> peopleCollection) {
            showPeopleCollectionInView(peopleCollection);
            view.hideLoading();
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            view.hideLoading();
            view.showError(errorBundle.getErrorMessage());
        }
    };
}

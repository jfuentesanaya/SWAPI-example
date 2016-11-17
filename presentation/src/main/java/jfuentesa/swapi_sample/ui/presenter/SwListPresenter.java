package jfuentesa.swapi_sample.ui.presenter;

import android.support.annotation.NonNull;

import com.jfuentes.swapi_sample.People;
import com.jfuentes.swapi_sample.exception.ErrorBundle;
import com.jfuentes.swapi_sample.interactor.GetPeopleListUseCase;

import java.util.Collection;

import javax.inject.Inject;

import jfuentesa.swapi_sample.di.PerActivity;
import jfuentesa.swapi_sample.ui.view.SwListView;

/**
 * Created by jfuentesa on 16/11/2016.
 */

@PerActivity
public class SwListPresenter implements PresenterBase {

    private SwListView view;
    private GetPeopleListUseCase getPeopleListUseCase;

    @Inject
    public SwListPresenter(GetPeopleListUseCase getPeopleListUseCase) {
        this.getPeopleListUseCase = getPeopleListUseCase;
    }

    public void setView(@NonNull SwListView view){
        this.view = view;
    }

    public void getPeopleAPI(){
        getPeopleListUseCase.execute(getPeopleListUseCaseCallback);
    }

    GetPeopleListUseCase.Callback getPeopleListUseCaseCallback =  new GetPeopleListUseCase.Callback() {
        @Override
        public void onPeopleListLoaded(Collection<People> peopleCollection) {
            //TODO set recyclerview
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            //TODO set show messageerror
        }
    };
}

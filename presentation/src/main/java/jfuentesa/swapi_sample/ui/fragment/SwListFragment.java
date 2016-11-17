package jfuentesa.swapi_sample.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import jfuentesa.swapi_sample.R;
import jfuentesa.swapi_sample.di.component.SwComponent;
import jfuentesa.swapi_sample.ui.presenter.SwListPresenter;
import jfuentesa.swapi_sample.ui.view.SwListView;

/**
 * Created by jfuentesa on 16/11/2016.
 */

public class SwListFragment extends BaseFragment implements SwListView {

    @Inject
    SwListPresenter swListPresenter;

    public SwListFragment() {
        super();
    }


    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_sw_list, container, true);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        swListPresenter.getPeopleAPI();
    }

    private void initialize() {
        this.getComponent(SwComponent.class).inject(this);
        this.swListPresenter.setView(this);
    }



    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String message) {

    }
}

package jfuentesa.swapi_sample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import jfuentesa.swapi_sample.R;
import jfuentesa.swapi_sample.di.component.SwComponent;
import jfuentesa.swapi_sample.model.PeopleModel;
import jfuentesa.swapi_sample.ui.presenter.PeopleDetailsPresenter;
import jfuentesa.swapi_sample.ui.view.PeopleDetailsView;

/**
 * Created by jfuentesa on 18/11/2016.
 */

public class PeopleDetailsFragment extends BaseFragment implements PeopleDetailsView {

    private PeopleModel peopleModel;
    private static final String TAG_SELECTED = "TAG_SELECTED";

    @Inject
    PeopleDetailsPresenter peopleDetailsPresenter;

    @BindView(R.id.fragm_character_detail_txt_name)
    TextView txtName;
    @BindView(R.id.fragm_character_detail_txt_height)
    TextView txtHeight;
    @BindView(R.id.fragm_character_detail_txt_gender)
    TextView txtGender;
    @BindView(R.id.fragm_character_detail_txt_films)
    TextView txtFilms;
    @BindView(R.id.fragm_character_progressbar_films)
    ProgressBar progressBarFilms;

    public PeopleDetailsFragment() {super();}

    public static PeopleDetailsFragment newInstance(PeopleModel peopleSelected) {
        PeopleDetailsFragment userDetailsFragment = new PeopleDetailsFragment();

        Bundle argumentsBundle = new Bundle();
        argumentsBundle.putParcelable(TAG_SELECTED, peopleSelected);
        userDetailsFragment.setArguments(argumentsBundle);

        return userDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        peopleModel = getArguments().getParcelable(TAG_SELECTED);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_character_details, container, false);
        ButterKnife.bind(this,fragmentView);
        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        loadCharacterSelected();
        peopleDetailsPresenter.loadFilms();
    }

    private void initialize() {
//        this.getComponent(SwComponent.class).inject(this);
        this.peopleDetailsPresenter.setView(this);
    }

    @Override
    public void loadCharacterSelected() {
        txtName.setText(peopleModel.getName());
        txtHeight.setText(peopleModel.getHeight());
        txtGender.setText(peopleModel.getGender());
    }

    @Override
    public void showLoading() {
        progressBarFilms.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBarFilms.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String message) {
        showToastMessage(message);
    }
}

package jfuentesa.swapi_sample.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import jfuentesa.swapi_sample.R;
import jfuentesa.swapi_sample.di.component.SwComponent;
import jfuentesa.swapi_sample.model.PeopleModel;
import jfuentesa.swapi_sample.ui.adapter.PeopleAdapter;
import jfuentesa.swapi_sample.ui.presenter.SwListPresenter;
import jfuentesa.swapi_sample.ui.view.SwListView;

/**
 * Created by jfuentesa on 16/11/2016.
 */

public class SwListFragment extends BaseFragment implements SwListView {

    /**
     * Interface for listening people list events.
     */
    public interface PeopleListListener {
        void onPeopleClicked(final PeopleModel peopleModel);
    }

    @Inject
    SwListPresenter swListPresenter;

    @BindView(R.id.fragm_sw_list_rv)
    RecyclerView rv_people;
    @BindView(R.id.fragm_sw_list_progressBar)
    ProgressBar progressBar;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private PeopleAdapter peopleAdapter;
    private PeopleListListener peopleListListener;

    public SwListFragment() {
        super();
    }

    @Override public void onAttach(Context activity) {
        super.onAttach(activity);
        if (activity instanceof PeopleListListener) {
            this.peopleListListener = (PeopleListListener) activity;
        }
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_sw_list, container, true);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();

        return fragmentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        swListPresenter.loadPeopleList();
        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
    }

    private void initialize() {
        this.getComponent(SwComponent.class).inject(this);
        this.swListPresenter.setView(this);
    }

    private void setupRecyclerView(){
        rv_people.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String message) {
        showToastMessage(message);
        if(swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void renderList(Collection<PeopleModel> peopleModelCollection) {
        if(peopleModelCollection != null){
            if(this.peopleAdapter == null){
                this.peopleAdapter = new PeopleAdapter(getActivity(), peopleModelCollection);
            }else{
                this.peopleAdapter.setPeopleCollection(peopleModelCollection);
            }
            rv_people.setAdapter(peopleAdapter);
            this.peopleAdapter.setOnItemClickListener(onItemClickListener);
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void viewPeopleDetails(PeopleModel peopleModel) {
        if (this.peopleListListener != null) {
            this.peopleListListener.onPeopleClicked(peopleModel);
        }
    }


    private PeopleAdapter.OnItemClickListener onItemClickListener = new PeopleAdapter.OnItemClickListener(){
        @Override
        public void onPeopleItemClicked(PeopleModel peopleModel) {
            if (SwListFragment.this.swListPresenter != null && peopleModel != null) {
                SwListFragment.this.swListPresenter.onPeopleClicked(peopleModel);
            }
        }
    };



    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            swListPresenter.loadPeopleList();
        }
    };
}

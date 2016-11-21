package jfuentesa.swapi_sample.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import jfuentesa.swapi_sample.R;
import jfuentesa.swapi_sample.di.HasComponent;
import jfuentesa.swapi_sample.di.component.DaggerSwComponent;
import jfuentesa.swapi_sample.di.component.SwComponent;
import jfuentesa.swapi_sample.model.PeopleModel;
import jfuentesa.swapi_sample.ui.fragment.SwListFragment;

public class SwListActivity extends BaseActivity implements HasComponent<SwComponent>, SwListFragment.PeopleListListener {

    private SwComponent swComponent;

    public static Intent getCallingIntent(Context context){
        return new Intent(context, SwListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initializeInjector();
    }

    private void initializeInjector(){
        this.swComponent = DaggerSwComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule()).build();
    }

    @Override
    public SwComponent getComponent() {
        return this.swComponent;
    }

    @Override
    public void onPeopleClicked(PeopleModel peopleModel) {
        navigator.navigateToPeopleDetails(SwListActivity.this, peopleModel);
    }
}

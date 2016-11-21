package jfuentesa.swapi_sample.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import jfuentesa.swapi_sample.R;
import jfuentesa.swapi_sample.di.HasComponent;
import jfuentesa.swapi_sample.di.component.DaggerSwComponent;
import jfuentesa.swapi_sample.di.component.SwComponent;
import jfuentesa.swapi_sample.model.PeopleModel;
import jfuentesa.swapi_sample.ui.fragment.PeopleDetailsFragment;

public class PeopleDetailsActivity extends BaseActivity implements HasComponent<SwComponent>{

    private static final String INTENT_EXTRA_PARAM_PEOPLE = "EXTRA_INTEND_PEOPLE";
    private static final String INTENT_STATE_PARAM_PEOPLE = "STATE_INTEND_PEOPLE";

    private SwComponent swComponent;
    private PeopleModel peopleSelected;

    public static Intent getCallingIntent(Context context, PeopleModel personSelected){
        Intent callingIntent = new Intent(context, PeopleDetailsActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_PEOPLE, personSelected);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_details);
        initializeInjector();
        initializeActivity(savedInstanceState);
    }

    private void initializeActivity(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            this.peopleSelected = getIntent().getParcelableExtra(INTENT_EXTRA_PARAM_PEOPLE);
            addFragment(R.id.people_details_fragment, PeopleDetailsFragment.newInstance(this.peopleSelected));
        } else {
            this.peopleSelected = savedInstanceState.getParcelable(INTENT_STATE_PARAM_PEOPLE);
        }
    }

    private void initializeInjector(){
        this.swComponent = DaggerSwComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule()).build();
    }

    @Override
    public SwComponent getComponent() {
        return swComponent;
    }
}

package jfuentesa.swapi_sample.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import jfuentesa.swapi_sample.SwapiApplication;
import jfuentesa.swapi_sample.di.component.ApplicationComponent;
import jfuentesa.swapi_sample.di.module.ActivityModule;
import jfuentesa.swapi_sample.navigator.Navigator;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return ((SwapiApplication) getApplication()).getApplicationComponent();
    }

    public ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    protected void addFragment(int containerViewId, Fragment fragment){
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId,fragment);
        fragmentTransaction.commit();
    }
}

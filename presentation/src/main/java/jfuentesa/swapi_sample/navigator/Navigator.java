package jfuentesa.swapi_sample.navigator;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import jfuentesa.swapi_sample.ui.activity.SwListActivity;

/**
 * Created by jfuentesa on 15/11/2016.
 */

@Singleton
public class Navigator {

    @Inject
    Navigator(){}


    public void navigateToList(Context context) {
        if (context != null) {
            context.startActivity(SwListActivity.getCallingIntent(context));
        }
    }
}

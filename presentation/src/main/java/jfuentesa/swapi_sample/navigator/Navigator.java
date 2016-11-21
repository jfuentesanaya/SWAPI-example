package jfuentesa.swapi_sample.navigator;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import jfuentesa.swapi_sample.model.PeopleModel;
import jfuentesa.swapi_sample.ui.activity.PeopleDetailsActivity;
import jfuentesa.swapi_sample.ui.activity.SwListActivity;

/**
 * Created by jfuentesa on 15/11/2016.
 */

@Singleton
public class Navigator {

    @Inject
    Navigator(){}

    /**
     * Goes to the list activity
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigateToList(Context context) {
        if (context != null) {
            context.startActivity(SwListActivity.getCallingIntent(context));
        }
    }

    /**
     * Goes to the details activity
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigateToPeopleDetails(Context context, PeopleModel peopleModel) {
        if (context != null) {
            Intent intentToLaunch = PeopleDetailsActivity.getCallingIntent(context, peopleModel);
            context.startActivity(intentToLaunch);
        }
    }
}

package jfuentesa.swapi_sample.ui.view;

import java.util.Collection;

import jfuentesa.swapi_sample.model.PeopleModel;

/**
 * Created by jfuentesa on 16/11/2016.
 */

public interface SwListView extends LoadDataView {
    void renderList(Collection<PeopleModel> peopleModelCollection);

    void viewPeopleDetails(PeopleModel peopleModel);
}

package jfuentesa.swapi_sample.ui.view;

import android.content.Context;

/**
 * Created by jfuentesa on 16/11/2016.
 */

public interface LoadDataView {
    void showLoading();

    void hideLoading();

    void showError(String message);

    Context getContext();
}

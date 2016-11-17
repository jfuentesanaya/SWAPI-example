package jfuentesa.swapi_sample.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

import jfuentesa.swapi_sample.di.HasComponent;

/**
 * Created by jfuentesa on 16/11/2016.
 */

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    protected void showToastMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>)getActivity()).getComponent());
    }

}

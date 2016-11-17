package jfuentesa.swapi_sample.ui.activity;

import android.os.Bundle;

import butterknife.OnClick;
import jfuentesa.swapi_sample.R;

/**
 * Created by jfuentesa on 15/11/2016.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @OnClick(R.id.main_btn_enter)
    protected void navigateToList(){
        navigator.navigateToList(LoginActivity.this);
    }
}

package jfuentesa.swapi_sample.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jfuentesa.swapi_sample.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

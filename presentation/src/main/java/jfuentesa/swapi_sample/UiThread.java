package jfuentesa.swapi_sample;

import android.os.Handler;
import android.os.Looper;

import com.jfuentes.swapi_sample.executor.PostThreadExecutor;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jfuentesa on 16/11/2016.
 */

@Singleton
public class UiThread implements PostThreadExecutor {

    private final Handler handler;

    @Inject
    public UiThread() {
        // Defines a Handler object that's attached to the UI thread
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}

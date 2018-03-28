package com.instanect.aksrestvolley.application;

import android.app.Application;

import com.instanect.aksrestvolley.di.AppComponent;

/**
 * Created by AKS on 3/27/2018.
 */

public class MainApplication extends Application {

    AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent().create();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

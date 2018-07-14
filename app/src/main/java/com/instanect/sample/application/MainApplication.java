package com.instanect.sample.application;

import android.app.Application;

import com.instanect.aksrestvolley.newNetwork.di.AKSRestVolleyModule;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.VolleyRequestQueueCompositionWrapper;
import com.instanect.sample.di.AppComponent;
import com.instanect.sample.di.DaggerAppComponent;

/**
 * Created by AKS on 3/27/2018.
 */

public class MainApplication extends Application {

    AppComponent appComponent;
    CurieResolver curieResolver = new CurieResolver();
    ApiUriDeclaration apiUriDeclaration = new ApiUriDeclaration();

    @Override
    public void onCreate() {
        super.onCreate();

        VolleyRequestQueueCompositionWrapper
                volleyRequestQueueCompositionWrapper =
                VolleyRequestQueueCompositionWrapper
                        .getInstance(getApplicationContext());

        appComponent = DaggerAppComponent.builder()
                .aKSRestVolleyModule(new AKSRestVolleyModule(
                        getApplicationContext(),
                        curieResolver,
                        apiUriDeclaration,
                        volleyRequestQueueCompositionWrapper
                ))
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

package com.instanect.aksrestvolley.application;

import android.app.Application;

import com.instanect.aksrestvolley.di.AppComponent;
import com.instanect.aksrestvolley.di.DaggerAppComponent;
import com.instanect.aksrestvolley.newNetwork.common.api.di.RESTNetworkApiModule;
import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderModule;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.RequestQueueModule;

/**
 * Created by AKS on 3/27/2018.
 */

public class MainApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .requestQueueModule(new RequestQueueModule(getApplicationContext()))
                .uriHttpClientRequestBuilderModule(
                        new UriHttpClientRequestBuilderModule(getApplicationContext())).rESTNetworkApiModule(new RESTNetworkApiModule(getApplicationContext()))
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

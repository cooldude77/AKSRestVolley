package com.instanect.sample.application;

import android.app.Application;

import com.instanect.aksrestvolley.newNetwork.common.api.di.RESTNetworkApiModule;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.di.TravellerNodeHandlerBuilderModule;
import com.instanect.aksrestvolley.newNetwork.common.handler.service.di.TravelNodeHandlerServiceModule;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.di.ScenarioExecutorBuilderModule;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.di.ScenarioBuilderModule;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.di.InternetConnectionCheckerModule;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di.ScenarioServiceModule;
import com.instanect.aksrestvolley.newNetwork.common.traveller.builder.di.TravellerBuilderModule;
import com.instanect.aksrestvolley.newNetwork.di.AKSRestVolleyModule;
import com.instanect.aksrestvolley.newNetwork.volley.api.di.VolleyApiModule;
import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderModule;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.RequestQueueModule;
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

        appComponent = DaggerAppComponent.builder()
                .requestQueueModule(new RequestQueueModule(getApplicationContext()))
                .uriHttpClientRequestBuilderModule(
                        new UriHttpClientRequestBuilderModule(getApplicationContext()))
                .rESTNetworkApiModule(new RESTNetworkApiModule(getApplicationContext()))
                .volleyApiModule(new VolleyApiModule())
                .travellerBuilderModule(new TravellerBuilderModule())
                .travellerNodeHandlerBuilderModule(new TravellerNodeHandlerBuilderModule(
                        curieResolver,
                        apiUriDeclaration
                ))
                .travelNodeHandlerServiceModule(new TravelNodeHandlerServiceModule())
                .internetConnectionCheckerModule(
                        new InternetConnectionCheckerModule(apiUriDeclaration)
                )
                .scenarioBuilderModule(new ScenarioBuilderModule())
                .scenarioServiceModule(new ScenarioServiceModule())
                .scenarioExecutorBuilderModule(new ScenarioExecutorBuilderModule())
                .aKSRestVolleyModule(new AKSRestVolleyModule())
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

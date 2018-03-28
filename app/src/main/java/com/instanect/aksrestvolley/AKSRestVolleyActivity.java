package com.instanect.aksrestvolley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.instanect.aksrestvolley.application.MainApplication;
import com.instanect.aksrestvolley.newNetwork.common.api.RESTNetworkApi;
import com.instanect.aksrestvolley.newNetwork.common.api.di.DaggerRESTNetworkApiComponent;
import com.instanect.aksrestvolley.newNetwork.volley.api.di.DaggerVolleyApiComponent;
import com.instanect.aksrestvolley.newNetwork.volley.api.di.VolleyApiComponent;
import com.instanect.aksrestvolley.newNetwork.volley.client.di.DaggerUriHttpClientRequestBuilderComponent;
import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderComponent;
import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderModule;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.DaggerRequestQueueComponent;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.RequestQueueComponent;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.RequestQueueModule;

import javax.inject.Inject;

/**
 * Created by AKS on 3/27/2018.
 */

public class AKSRestVolleyActivity extends AppCompatActivity {

    @Inject
    RESTNetworkApi restNetworkApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getApplication())
                .getAppComponent().inject(this);

        DaggerRESTNetworkApiComponent.builder().build();

    }
}

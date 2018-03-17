package com.instanect.aksrestvolley.newNetwork.volley.test;

import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderModule;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.RequestQueueModule;

import dagger.Component;

/**
 * Created by AKS on 10/16/2017.
 */

@Component(modules = {RequestQueueModule.class, UriHttpClientRequestBuilderModule.class})
public interface TestApiComponent {
    void inject(TestApiModule testApiModule);
}



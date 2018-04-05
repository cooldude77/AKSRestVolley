package com.instanect.aksrestvolley.newNetwork.volley.request.di;

import com.instanect.aksrestvolley.newNetwork.volley.api.di.VolleyApiModule;

import dagger.Component;

/**
 * Created by AKS on 10/25/2017.
 */
@Component(modules = {RequestQueueModule.class})
public interface RequestQueueComponent {
    void inject(VolleyApiModule volleyApiModule);
}

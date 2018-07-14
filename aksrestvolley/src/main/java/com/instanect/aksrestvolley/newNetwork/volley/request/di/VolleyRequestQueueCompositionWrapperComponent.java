package com.instanect.aksrestvolley.newNetwork.volley.request.di;

import com.instanect.aksrestvolley.newNetwork.volley.api.di.VolleyApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by AKS on 10/25/2017.
 */

@Component(modules = {VolleyRequestQueueCompositionWrapperModule.class})
public interface VolleyRequestQueueCompositionWrapperComponent {
    void inject(VolleyApiModule volleyApiModule);
}

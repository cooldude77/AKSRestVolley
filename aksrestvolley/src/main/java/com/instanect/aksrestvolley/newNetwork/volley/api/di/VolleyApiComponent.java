package com.instanect.aksrestvolley.newNetwork.volley.api.di;

import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderComponent;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.VolleyRequestQueueCompositionWrapperComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by AKS on 10/16/2017.
 */
@Component(modules = {VolleyApiModule.class},
        dependencies = {
                UriHttpClientRequestBuilderComponent.class,
                VolleyRequestQueueCompositionWrapperComponent.class
        })
public interface VolleyApiComponent {
}



package com.instanect.aksrestvolley.newNetwork.di;

import com.instanect.aksrestvolley.newNetwork.common.api.RESTNetworkApi;
import com.instanect.aksrestvolley.newNetwork.volley.api.VolleyApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 3/28/2018.
 */
@Module
public class AKSRestVolleyModule {

    @Provides
    public RESTNetworkApi provideRESTNetworkApi(VolleyApi volleyApi) {
        return new RESTNetworkApi(volleyApi);
    }

}

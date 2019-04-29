package com.instanect.aksrestvolley.newNetwork.common.api.di;

import android.content.Context;

import com.instanect.aksrestvolley.newNetwork.common.api.RESTNetworkApi;
import com.instanect.aksrestvolley.newNetwork.volley.api.VolleyApi;
import com.instanect.aksrestvolley.newNetwork.volley.api.di.VolleyApiModule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/14/2017.
 */

@Module(includes = {VolleyApiModule.class})
public class RESTNetworkApiModule {


    @Provides
    public RESTNetworkApi provideRESTNetworkApi(VolleyApi volleyApi) {

        return new RESTNetworkApi(volleyApi);
    }


}

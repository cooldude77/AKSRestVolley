package com.instanect.aksrestvolley.newNetwork.common.api.di;

import android.content.Context;

import com.instanect.aksrestvolley.newNetwork.common.api.RESTNetworkApi;
import com.instanect.aksrestvolley.newNetwork.volley.api.VolleyApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/14/2017.
 */

@Module
public class RESTNetworkApiModule {

    private Context context;

    public RESTNetworkApiModule(Context context) {

        this.context = context;
    }

    @Provides
    public RESTNetworkApi provideRESTNetworkApi(VolleyApi volleyApi) {
        return new RESTNetworkApi(volleyApi);
    }


}

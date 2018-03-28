package com.instanect.aksrestvolley.newNetwork.volley.api.di;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.instanect.aksrestvolley.newNetwork.volley.api.VolleyApi;
import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderModule;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.RequestQueueModule;
import com.instanect.aksrestvolley.newNetwork.volley.requests.builder.UriHttpClientRequestBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/16/2017.
 */
@Module(includes = {RequestQueueModule.class, UriHttpClientRequestBuilderModule.class})
public class VolleyApiModule {

    @Provides
    VolleyApi provideApiModule(RequestQueue requestQueue,
                               UriHttpClientRequestBuilder uriHttpClientRequestBuilder) {

        return new VolleyApi(uriHttpClientRequestBuilder, requestQueue);
    }
}

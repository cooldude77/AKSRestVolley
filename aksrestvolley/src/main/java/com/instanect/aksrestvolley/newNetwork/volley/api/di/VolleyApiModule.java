package com.instanect.aksrestvolley.newNetwork.volley.api.di;

import com.android.volley.RequestQueue;
import com.instanect.aksrestvolley.network.http.requests.json.UriHttpClientRequestBuilder;
import com.instanect.aksrestvolley.newNetwork.volley.api.VolleyApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/16/2017.
 */
@Module
public class VolleyApiModule {

    @Provides
    VolleyApi provideApiModule(UriHttpClientRequestBuilder
                                       uriHttpClientRequestBuilder,
                               RequestQueue requestQueue) {
        return new VolleyApi(
                uriHttpClientRequestBuilder, requestQueue);
    }
}

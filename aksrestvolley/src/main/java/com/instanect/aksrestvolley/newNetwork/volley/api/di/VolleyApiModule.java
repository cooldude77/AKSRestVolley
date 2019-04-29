package com.instanect.aksrestvolley.newNetwork.volley.api.di;

import com.instanect.aksrestvolley.newNetwork.volley.api.VolleyApi;
import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderModule;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.VolleyRequestQueueCompositionWrapper;
import com.instanect.aksrestvolley.newNetwork.volley.requests.builder.UriHttpClientRequestBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/16/2017.
 */
@Module(includes = {UriHttpClientRequestBuilderModule.class})
public class VolleyApiModule {
    private VolleyRequestQueueCompositionWrapper compositionWrapper;

    public VolleyApiModule(VolleyRequestQueueCompositionWrapper compositionWrapper) {
        this.compositionWrapper = compositionWrapper;
    }

    @Provides
    VolleyApi provideApiModule(UriHttpClientRequestBuilder uriHttpClientRequestBuilder) {

        return new VolleyApi(uriHttpClientRequestBuilder, compositionWrapper);
    }

}

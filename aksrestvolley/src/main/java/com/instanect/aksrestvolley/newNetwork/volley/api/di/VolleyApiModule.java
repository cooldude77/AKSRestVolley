package com.instanect.aksrestvolley.newNetwork.volley.api.di;

import com.android.volley.RequestQueue;
import com.instanect.aksrestvolley.newNetwork.volley.api.VolleyApi;
import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderModule;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.VolleyRequestQueueCompositionWrapper;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.VolleyRequestQueueCompositionWrapperModule;
import com.instanect.aksrestvolley.newNetwork.volley.requests.builder.UriHttpClientRequestBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/16/2017.
 */
@Module(includes = {UriHttpClientRequestBuilderModule.class,
        VolleyRequestQueueCompositionWrapperModule.class})
public class VolleyApiModule {

    @Provides
    VolleyApi provideApiModule(UriHttpClientRequestBuilder uriHttpClientRequestBuilder,
                               VolleyRequestQueueCompositionWrapper
                                       volleyRequestQueueCompositionWrapper) {

        return new VolleyApi(uriHttpClientRequestBuilder, volleyRequestQueueCompositionWrapper);
    }

}

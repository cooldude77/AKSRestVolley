package com.instanect.aksrestvolley.newNetwork.volley.test;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.instanect.aksrestvolley.network.http.requests.json.UriHttpClientRequestBuilder;
import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderModule;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.RequestQueueModule;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/16/2017.
 */
@Module
public class TestApiModule {
    @Inject
    RequestQueue requestQueue;
    @Inject
    UriHttpClientRequestBuilder uriHttpClientRequestBuilder;

    public TestApiModule(Context context) {

        DaggerTestApiComponent.builder()
                .requestQueueModule(new RequestQueueModule(context))
                .uriHttpClientRequestBuilderModule(new UriHttpClientRequestBuilderModule(context))
                .build().inject(this);
    }

    @Provides
    TestApi provideApiModule() {
        return new TestApi(requestQueue);
    }
}

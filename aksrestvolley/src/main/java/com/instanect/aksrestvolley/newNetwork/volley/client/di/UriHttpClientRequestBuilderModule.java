package com.instanect.aksrestvolley.newNetwork.volley.client.di;

import android.content.Context;


import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientRequestBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/16/2017.
 */
@Module
public class UriHttpClientRequestBuilderModule {

    private Context context;

    public UriHttpClientRequestBuilderModule(Context context) {
        this.context = context;
    }

    @Provides
    UriHttpClientRequestBuilder provideUriHttpClientRequestBuilder() {
        return new UriHttpClientRequestBuilder(context);
    }
}

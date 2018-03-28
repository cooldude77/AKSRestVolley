package com.instanect.aksrestvolley.newNetwork.volley.requests.builder.di;

import android.content.Context;

import com.instanect.aksrestvolley.newNetwork.volley.requests.builder.UriHttpClientRequestBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 3/27/2018.
 */
@Module
public class UriHttpClientRequestBuilderModule {

    private final Context context;

    public UriHttpClientRequestBuilderModule(Context context){

        this.context = context;
    }
    @Provides
    UriHttpClientRequestBuilder provideUriHttpClientRequestBuilder(){

        return  new UriHttpClientRequestBuilder(context);
    }
}

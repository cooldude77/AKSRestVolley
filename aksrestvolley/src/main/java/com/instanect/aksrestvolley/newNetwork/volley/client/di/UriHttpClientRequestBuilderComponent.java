package com.instanect.aksrestvolley.newNetwork.volley.client.di;


import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientRequestBuilder;

import dagger.Component;

/**
 * Created by AKS on 10/25/2017.
 */

@Component(modules = {UriHttpClientRequestBuilderModule.class})
public interface UriHttpClientRequestBuilderComponent {

    UriHttpClientRequestBuilder getUriHttpClientRequestBuilder();
}

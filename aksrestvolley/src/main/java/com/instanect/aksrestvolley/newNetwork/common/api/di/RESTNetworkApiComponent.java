package com.instanect.aksrestvolley.newNetwork.common.api.di;

import com.instanect.aksrestvolley.newNetwork.common.api.RESTNetworkApi;
import com.instanect.aksrestvolley.newNetwork.volley.api.di.VolleyApiComponent;

import dagger.Component;

/**
 * Created by AKS on 10/16/2017.
 */

@Component(modules = {RESTNetworkApiModule.class})
public interface RESTNetworkApiComponent {

}

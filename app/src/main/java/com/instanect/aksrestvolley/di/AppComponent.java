package com.instanect.aksrestvolley.di;

import com.instanect.aksrestvolley.AKSRestVolleyActivity;
import com.instanect.aksrestvolley.newNetwork.common.api.RESTNetworkApi;
import com.instanect.aksrestvolley.newNetwork.common.api.di.RESTNetworkApiModule;

import dagger.Component;

/**
 * Created by AKS on 3/27/2018.
 */
@Component(modules = {RESTNetworkApiModule.class})
public interface AppComponent {

    public void inject(AKSRestVolleyActivity aksRestVolleyActivity);
}

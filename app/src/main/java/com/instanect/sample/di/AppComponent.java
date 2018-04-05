package com.instanect.sample.di;

import com.instanect.aksrestvolley.newNetwork.di.AKSRestVolleyModule;
import com.instanect.sample.AKSRestVolleyActivity;

import dagger.Component;

/**
 * Created by AKS on 3/27/2018.
 */
@Component(modules = {AKSRestVolleyModule.class})
public interface AppComponent {

    void inject(AKSRestVolleyActivity aksRestVolleyActivity);
}

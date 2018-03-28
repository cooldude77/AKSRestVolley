package com.instanect.aksrestvolley.di;

import com.instanect.aksrestvolley.AKSRestVolleyActivity;

import dagger.Component;

/**
 * Created by AKS on 3/27/2018.
 */
@Component
public interface AppComponent {

    public void inject(AKSRestVolleyActivity aksRestVolleyActivity);
}

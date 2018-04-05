package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di;

import com.instanect.aksrestvolley.newNetwork.di.AKSRestVolleyModule;

import dagger.Component;

@Component(modules = {ScenarioServiceModule.class})
public interface ScenarioServiceComponent {
    void inject(AKSRestVolleyModule aksRestVolleyModule);
}

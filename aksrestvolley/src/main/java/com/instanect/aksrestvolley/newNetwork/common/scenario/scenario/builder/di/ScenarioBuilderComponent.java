package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.di;

import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.ScenarioBuilder;

import dagger.Component;

/**
 * Created by AKS on 10/25/2017.
 */

@Component(modules = {ScenarioBuilderModule.class})
public interface ScenarioBuilderComponent {

    ScenarioBuilder getScenarioBuilder();
}

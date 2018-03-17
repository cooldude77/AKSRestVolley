package com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.di;

import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.ScenarioExecutorBuilder;
import com.instanect.aksrestvolley.newNetwork.common.traveller.builder.di.TravellerBuilderComponent;

import dagger.Component;

/**
 * Created by AKS on 10/16/2017.
 */

@Component(modules = {ScenarioExecutorBuilderModule.class},
        dependencies = {TravellerBuilderComponent.class})
public interface ScenarioExecutorBuilderComponent {
    ScenarioExecutorBuilder getScenarioExecutorBuilder();
}

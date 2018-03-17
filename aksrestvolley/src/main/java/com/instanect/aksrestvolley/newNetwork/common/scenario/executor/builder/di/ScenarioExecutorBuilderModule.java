package com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.di;

import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.ScenarioExecutorBuilder;
import com.instanect.aksrestvolley.newNetwork.common.traveller.builder.TravellerBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/14/2017.
 */

@Module
public class ScenarioExecutorBuilderModule {

    @Provides
    ScenarioExecutorBuilder provideScenarioExecutorBuilder(TravellerBuilder travellerBuilder) {

        return new ScenarioExecutorBuilder(travellerBuilder);
    }
}

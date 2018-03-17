package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.di;

import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.ScenarioBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/14/2017.
 */

@Module
public class ScenarioBuilderModule {

    @Provides
    public ScenarioBuilder provideScenarioBuilder() {
        return new ScenarioBuilder();
    }
}

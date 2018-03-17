package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di;

import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.ScenarioExecutorBuilder;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.ScenarioBuilder;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.ScenarioService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/16/2017.
 */
@Module
public class ScenarioServiceModule {


    @Provides
    ScenarioService provideScenarioService(
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            ScenarioBuilder scenarioBuilder,
            ScenarioExecutorBuilder scenarioExecutorBuilder,
            InternetConnectionChecker internetConnectionChecker) {
        return new ScenarioService(apiUriDeclarationInterface, scenarioBuilder,
                scenarioExecutorBuilder, internetConnectionChecker);
    }
}

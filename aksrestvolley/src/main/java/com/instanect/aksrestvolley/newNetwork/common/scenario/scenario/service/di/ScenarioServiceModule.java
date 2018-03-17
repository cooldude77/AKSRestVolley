package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di;

import com.instanect.aksrestvolley.business.declarations.uri.ApiUriDeclaration;
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
            ApiUriDeclaration apiUriDeclaration,
            ScenarioBuilder scenarioBuilder,
            ScenarioExecutorBuilder scenarioExecutorBuilder,
            InternetConnectionChecker internetConnectionChecker) {
        return new ScenarioService(apiUriDeclaration, scenarioBuilder,
                scenarioExecutorBuilder, internetConnectionChecker);
    }
}

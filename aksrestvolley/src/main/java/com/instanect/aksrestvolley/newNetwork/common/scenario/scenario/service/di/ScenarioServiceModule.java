package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di;

import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.ScenarioExecutorBuilder;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.di.ScenarioExecutorBuilderModule;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.ScenarioBuilder;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.di.ScenarioBuilderModule;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.InternetConnectionCheckerInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.interfaces.InternetConnectionChecker;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.ScenarioService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/16/2017.
 */
@Module(includes = {
        ScenarioBuilderModule.class,
        ScenarioExecutorBuilderModule.class,
        InternetConnectionCheckerInterface.class})
public class ScenarioServiceModule {


    @Provides
    ScenarioService provideScenarioService(
            ScenarioBuilder scenarioBuilder,
            ScenarioExecutorBuilder scenarioExecutorBuilder,
            InternetConnectionChecker internetConnectionChecker) {
        return new ScenarioService(
                scenarioBuilder,
                scenarioExecutorBuilder,
                internetConnectionChecker);
    }
}

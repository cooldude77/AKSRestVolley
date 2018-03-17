package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di;

import com.instanect.aksrestvolley.business.declarations.uri.di.ApiUriDeclarationComponent;
import com.instanect.aksrestvolley.business.mvp.interactors.network.builder.InternetConnectionCheckerComponent;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.di.ScenarioExecutorBuilderComponent;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.di.ScenarioBuilderComponent;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.ScenarioService;

import dagger.Component;

/**
 * Created by AKS on 10/25/2017.
 */

@Component(modules = ScenarioServiceModule.class,
        dependencies = {ApiUriDeclarationComponent.class,
                ScenarioBuilderComponent.class,
                ScenarioExecutorBuilderComponent.class,
                InternetConnectionCheckerComponent.class})
public interface ScenarioServiceComponent {
    ScenarioService getScenarioService();
}

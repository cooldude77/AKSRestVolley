package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service;

import com.instanect.aksrestvolley.newNetwork.LogTagGenerator;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.InternetConnectionCheckerInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.ScenarioExecutor;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.ScenarioExecutorBuilder;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.interfaces.ScenarioExecutionResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.ScenarioBuilder;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.ScenarioInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di.InternetConnectionCheckerResponseInterface;

/**
 * Created by AKS on 10/16/2017.
 */

public class ScenarioService
        implements InternetConnectionCheckerResponseInterface {

    private final ScenarioBuilder scenarioBuilder;
    private final ScenarioExecutorBuilder scenarioExecutorBuilder;
    private ApiUriDeclarationInterface apiUriDeclarationInterface;
    private InternetConnectionCheckerInterface internetConnectionCheckerInterface;
    private ScenarioInterface scenarioInterface;
    private ScenarioExecutionResponseInterface scenarioExecutionResponseInterface;
    private boolean abortExecution = false;

    private String TAG = LogTagGenerator.getTag(ScenarioService.class);
    private ScenarioExecutor scenarioExecutor;

    public ScenarioService(
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            ScenarioBuilder scenarioBuilder,
            ScenarioExecutorBuilder scenarioExecutorBuilder,
            InternetConnectionCheckerInterface internetConnectionCheckerInterface) {
        this.apiUriDeclarationInterface = apiUriDeclarationInterface;

        this.scenarioBuilder = scenarioBuilder;
        this.scenarioExecutorBuilder = scenarioExecutorBuilder;
        this.internetConnectionCheckerInterface = internetConnectionCheckerInterface;
    }

    public void execute(
            ScenarioInterface scenarioInterface,
            ScenarioExecutionResponseInterface scenarioExecutionResponseInterface) {
        this.scenarioInterface = scenarioInterface;
        this.scenarioExecutionResponseInterface = scenarioExecutionResponseInterface;

        internetConnectionCheckerInterface.checkInternetAvailable(
                apiUriDeclarationInterface.getHomeUri(),
                this
        );

    }

    public ScenarioBuilder getScenarioBuilder() {
        return scenarioBuilder;
    }


    @Override
    public void onInternetConnectionNotAvailable() {

        scenarioExecutionResponseInterface.onInternetNotAvailable();
    }

    @Override
    public void onAdditionalUrlNotAvailable(String messageOnNotAvailable) {

        scenarioExecutionResponseInterface.onAdditionalUrlNotAvailable(messageOnNotAvailable);
    }

    @Override
    public void onAllChecksSuccess() {

        scenarioExecutor = scenarioExecutorBuilder
                .getInstance(scenarioInterface, scenarioExecutionResponseInterface);
        scenarioExecutor.execute();

    }

    @Override
    public void onAllInternetChecksAbort() {
        scenarioExecutionResponseInterface
                .onScenarioExecutionAbort();
    }

    public void tryAbort() {
        if (internetConnectionCheckerInterface != null)
            internetConnectionCheckerInterface.tryAbort();
        if (scenarioExecutor != null)
            scenarioExecutor.tryAbort();
    }
}

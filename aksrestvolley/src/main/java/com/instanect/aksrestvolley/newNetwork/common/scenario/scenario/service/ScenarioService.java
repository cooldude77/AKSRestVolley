package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service;

import com.instanect.aksrestvolley.newNetwork.LogTagGenerator;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.ScenarioExecutor;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.ScenarioExecutorBuilder;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.interfaces.ScenarioExecutionResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.ScenarioBuilder;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.ScenarioInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.InternetConnectionCheckerInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.interfaces.InternetConnectionCheckerResponseInterface;

/**
 * Created by AKS on 10/16/2017.
 */

public class ScenarioService
        implements InternetConnectionCheckerResponseInterface {

    private final ScenarioBuilder scenarioBuilder;
    private final ScenarioExecutorBuilder scenarioExecutorBuilder;
    private InternetConnectionCheckerInterface internetConnectionCheckerInterface;
    private ScenarioInterface scenarioInterface;
    private ScenarioExecutionResponseInterface scenarioExecutionResponseInterface;
    private boolean abortExecution = false;

    private String TAG = LogTagGenerator.getTag(ScenarioService.class);
    private ScenarioExecutor scenarioExecutor;

    public ScenarioService(
            ScenarioBuilder scenarioBuilder,
            ScenarioExecutorBuilder scenarioExecutorBuilder,
            InternetConnectionCheckerInterface internetConnectionCheckerInterface) {

        this.scenarioBuilder = scenarioBuilder;
        this.scenarioExecutorBuilder = scenarioExecutorBuilder;
        this.internetConnectionCheckerInterface = internetConnectionCheckerInterface;
    }

    public void execute(
            ScenarioInterface scenarioInterface,
            ScenarioExecutionResponseInterface scenarioExecutionResponseInterface,
            String tag) {
        this.scenarioInterface = scenarioInterface;
        this.scenarioExecutionResponseInterface = scenarioExecutionResponseInterface;

        internetConnectionCheckerInterface.checkInternetAvailable(this);

    }

    public void execute(
            ScenarioInterface scenarioInterface,
            ScenarioExecutionResponseInterface scenarioExecutionResponseInterface) {
        execute(scenarioInterface, scenarioExecutionResponseInterface,null);
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

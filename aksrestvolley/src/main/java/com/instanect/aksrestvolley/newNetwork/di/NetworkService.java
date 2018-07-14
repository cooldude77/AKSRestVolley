package com.instanect.aksrestvolley.newNetwork.di;

import com.instanect.aksrestvolley.newNetwork.NetworkRequestCancellableInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.interfaces.ScenarioExecutionResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.ScenarioBuilder;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.ScenarioInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.ScenarioService;
import com.instanect.networkcommon.NetworkInterface;

import static org.junit.Assert.assertNotNull;

public class NetworkService implements NetworkInterface {

    private ScenarioService scenarioService;
    private NetworkRequestCancellableInterface networkRequestCancellableInterface;

    public NetworkService(ScenarioService scenarioService) {

        this.scenarioService = scenarioService;
    }

    public NetworkService(ScenarioService scenarioService,
                          NetworkRequestCancellableInterface networkRequestCancellableInterface) {

        this.scenarioService = scenarioService;
        this.networkRequestCancellableInterface = networkRequestCancellableInterface;
    }

    public ScenarioBuilder getBuilder() {
        return scenarioService.getScenarioBuilder();
    }

    public void execute(ScenarioInterface scenarioInterface,
                        ScenarioExecutionResponseInterface scenarioExecutionResponseInterface) {

        scenarioService.execute(scenarioInterface, scenarioExecutionResponseInterface);

    }

    public void execute(ScenarioInterface scenarioInterface, ScenarioExecutionResponseInterface
            scenarioExecutionResponseInterface, String tag) {

        scenarioService.execute(scenarioInterface, scenarioExecutionResponseInterface, null);

    }

    @Override
    public void tryAbort() {

        scenarioService.tryAbort();
    }

    public void cancelAll(String tag) {
        assertNotNull(networkRequestCancellableInterface);
        networkRequestCancellableInterface.cancelAll(tag);
    }
}

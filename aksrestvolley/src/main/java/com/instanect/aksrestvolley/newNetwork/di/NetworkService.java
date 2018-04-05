package com.instanect.aksrestvolley.newNetwork.di;

import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.interfaces.ScenarioExecutionResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.ScenarioBuilder;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.ScenarioInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.ScenarioService;
import com.instanect.networkcommon.NetworkInterface;

public class NetworkService implements NetworkInterface {

    private final ScenarioService scenarioService;

    public NetworkService(ScenarioService scenarioService) {

        this.scenarioService = scenarioService;
    }


    public ScenarioBuilder getBuilder() {
        return scenarioService.getScenarioBuilder();
    }

    public void execute(ScenarioInterface scenarioInterface, ScenarioExecutionResponseInterface
            scenarioExecutionResponseInterface) {

        scenarioService.execute(scenarioInterface, scenarioExecutionResponseInterface);
    }
}

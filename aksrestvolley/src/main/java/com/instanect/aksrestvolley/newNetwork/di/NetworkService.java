package com.instanect.aksrestvolley.newNetwork.di;

import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.ScenarioService;

public class NetworkService {

    private final ScenarioService scenarioService;

    public NetworkService(ScenarioService scenarioService) {


        this.scenarioService = scenarioService;
    }

}

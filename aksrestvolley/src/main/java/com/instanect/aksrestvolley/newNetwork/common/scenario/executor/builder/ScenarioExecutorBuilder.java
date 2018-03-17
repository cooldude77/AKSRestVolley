package com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder;

import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.ScenarioExecutor;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.interfaces.ScenarioExecutionResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.ScenarioInterface;
import com.instanect.aksrestvolley.newNetwork.common.traveller.builder.TravellerBuilder;

/**
 * Created by AKS on 10/5/2017.
 */

public class ScenarioExecutorBuilder {


    private TravellerBuilder travellerBuilder;

    public ScenarioExecutorBuilder(TravellerBuilder travellerBuilder) {

        this.travellerBuilder = travellerBuilder;
    }

    public ScenarioExecutor getInstance(
            ScenarioInterface scenarioInterface,
            ScenarioExecutionResponseInterface responseInterface
    ) {
        return new ScenarioExecutor(scenarioInterface, travellerBuilder, responseInterface);
    }
}

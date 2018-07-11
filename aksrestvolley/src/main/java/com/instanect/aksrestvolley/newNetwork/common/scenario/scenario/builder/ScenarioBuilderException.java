package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder;

class ScenarioBuilderException extends Exception {
    public ScenarioBuilderException() {
        super("It seems that Uri is set and scenarioInterface " +
                "is not an instance of ScenarioUrlInterface");
    }
}

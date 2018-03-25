package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder;

import com.instanect.accountcommon.account.authorization.AuthorizationHeaderInterface;
import com.instanect.aksrestvolley.newNetwork.common.TravelMapBuilder;
import com.instanect.aksrestvolley.newNetwork.common.TravelMapListBuilder;
import com.instanect.aksrestvolley.newNetwork.common.node.factory.TravelNodeFactory;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.ScenarioInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by AKS on 10/6/2017.
 */

public class ScenarioBuilder {
    private Class<? extends ScenarioInterface> scenarioInterfaceClass;
    private AuthorizationHeaderInterface authorizationHeaderInterface;
    private HashMap<String, String> postOrPutBody;
    private String query;

    public ScenarioBuilder builder() {
        return this;
    }


    public ScenarioBuilder setScenarioClass(
            Class<? extends ScenarioInterface> scenarioInterfaceClass) {
        this.scenarioInterfaceClass = scenarioInterfaceClass;
        return this;
    }

    public ScenarioBuilder setPostOrPutBody(HashMap<String, String> postOrPutBody) {
        this.postOrPutBody = postOrPutBody;
        return this;
    }

    public ScenarioBuilder setAuthorizationHeaderInterface(AuthorizationHeaderInterface authorizationHeaderInterface) {
        this.authorizationHeaderInterface = authorizationHeaderInterface;
        return this;
    }

    public ScenarioBuilder setQuery(String query) {
        this.query = query;
        return this;
    }


    public ScenarioInterface build() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class[] arguments = new Class[6];

        arguments[0] = TravelMapBuilder.class;
        arguments[1] = TravelNodeFactory.class;
        arguments[2] = TravelMapListBuilder.class;
        arguments[3] = AuthorizationHeaderInterface.class;
        arguments[4] = String.class;
        arguments[5] = HashMap.class;


        return scenarioInterfaceClass.getDeclaredConstructor(arguments)
                .newInstance(
                        new TravelMapBuilder(),
                        new TravelNodeFactory(),
                        new TravelMapListBuilder(),
                        authorizationHeaderInterface,
                        query,
                        postOrPutBody
                );
    }
}

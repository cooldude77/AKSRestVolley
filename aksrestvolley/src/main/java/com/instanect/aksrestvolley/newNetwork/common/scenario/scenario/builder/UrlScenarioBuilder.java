package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder;

import android.net.Uri;

import com.instanect.accountcommon.account.authorization.AuthorizationHeaderInterface;
import com.instanect.aksrestvolley.newNetwork.common.TravelMapBuilder;
import com.instanect.aksrestvolley.newNetwork.common.TravelMapListBuilder;
import com.instanect.aksrestvolley.newNetwork.common.node.factory.TravelNodeFactory;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.UrlScenarioInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by AKS on 10/6/2017.
 */

public class UrlScenarioBuilder extends ScenarioBuilder {

    private Uri uri;

    public UrlScenarioBuilder setUri(Uri uri) {
        this.uri = uri;
        return this;
    }

    @Override
    public UrlScenarioInterface build() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Class[] argumentsForScenarioUrlInterface = new Class[7];

        argumentsForScenarioUrlInterface[0] = TravelMapBuilder.class;
        argumentsForScenarioUrlInterface[1] = TravelNodeFactory.class;
        argumentsForScenarioUrlInterface[2] = TravelMapListBuilder.class;
        argumentsForScenarioUrlInterface[3] = AuthorizationHeaderInterface.class;
        argumentsForScenarioUrlInterface[4] = String.class;
        argumentsForScenarioUrlInterface[5] = HashMap.class;
        argumentsForScenarioUrlInterface[6] = Uri.class;

        return (UrlScenarioInterface) getScenarioInterfaceClass()
                .getDeclaredConstructor(argumentsForScenarioUrlInterface)
                .newInstance(
                        new TravelMapBuilder(),
                        new TravelNodeFactory(),
                        new TravelMapListBuilder(),
                        getAuthorizationHeaderInterface(),
                        getQuery(),
                        getPostOrPutBody(),
                        uri
                );
    }
}

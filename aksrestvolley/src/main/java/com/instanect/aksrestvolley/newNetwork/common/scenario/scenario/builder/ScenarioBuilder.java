package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder;

import android.net.Uri;

import com.instanect.accountcommon.account.authorization.AuthorizationHeaderInterface;
import com.instanect.aksrestvolley.newNetwork.common.TravelMapBuilder;
import com.instanect.aksrestvolley.newNetwork.common.TravelMapListBuilder;
import com.instanect.aksrestvolley.newNetwork.common.node.factory.TravelNodeFactory;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.ScenarioInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.UrlScenarioInterface;

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
    private Uri uri;

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

    public ScenarioBuilder setUri(Uri uri) {

        this.uri = uri;
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


        ScenarioInterface scenarioInterface = null;
        try {
            scenarioInterface = scenarioInterfaceClass
                    .getDeclaredConstructor(arguments)
                    .newInstance(
                            new TravelMapBuilder(),
                            new TravelNodeFactory(),
                            new TravelMapListBuilder(),
                            authorizationHeaderInterface,
                            query,
                            postOrPutBody
                    );
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {

            if (scenarioInterface == null) {


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


        return scenarioInterface;

    }

    public Class<? extends ScenarioInterface> getScenarioInterfaceClass() {
        return scenarioInterfaceClass;
    }

    public AuthorizationHeaderInterface getAuthorizationHeaderInterface() {
        return authorizationHeaderInterface;
    }

    public HashMap<String, String> getPostOrPutBody() {
        return postOrPutBody;
    }

    public String getQuery() {
        return query;
    }
}

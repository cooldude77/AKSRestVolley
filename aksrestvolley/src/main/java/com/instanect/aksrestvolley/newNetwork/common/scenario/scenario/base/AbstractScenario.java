package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.base;

import com.instanect.accountcommon.AuthorizationHeaderInterface;
import com.instanect.aksrestvolley.newNetwork.common.TravelMapBuilder;
import com.instanect.aksrestvolley.newNetwork.common.TravelMapListBuilder;
import com.instanect.aksrestvolley.newNetwork.common.node.factory.TravelNodeFactory;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.ScenarioInterface;
import com.instanect.aksrestvolley.newNetwork.common.traveller.map.TravelMap;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by AKS on 10/4/2017.
 */

abstract public class AbstractScenario implements ScenarioInterface {

    protected final TravelMapBuilder travelMapBuilder;
    protected final TravelNodeFactory travelNodeFactory;
    protected final AuthorizationHeaderInterface authorizationHeaderInterface;
    protected final String query;
    protected final HashMap<String, String> postBody;
    protected LinkedList<TravelMap> travelMaps;


    public AbstractScenario(
            TravelMapBuilder travelMapBuilder,
            TravelNodeFactory travelNodeFactory,
            TravelMapListBuilder travelMapListBuilder,
            AuthorizationHeaderInterface authorizationHeaderInterface,
            String query, HashMap<String, String> postBody) {

        this.travelMapBuilder = travelMapBuilder;
        this.travelNodeFactory = travelNodeFactory;
        this.authorizationHeaderInterface = authorizationHeaderInterface;
        travelMaps = travelMapListBuilder.getList();
        this.query = query;
        this.postBody = postBody;
    }

    protected void addMap(TravelMap travelMap) {
        travelMaps.add(travelMap);
    }

    public TravelMap getNext() {
        if (travelMaps.size() > 0) return travelMaps.remove();
        return null;
    }

}

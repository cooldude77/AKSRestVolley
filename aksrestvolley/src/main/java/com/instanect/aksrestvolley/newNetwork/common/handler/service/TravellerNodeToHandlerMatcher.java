package com.instanect.aksrestvolley.newNetwork.common.handler.service;

import com.instanect.aksrestvolley.newNetwork.common.handler.implementations.KeyTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.implementations.RootTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.implementations.UriTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.KeyGETTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.KeyPOSTTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.KeyPUTTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes.UriGETTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes.UriPUTTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.implementations.RootTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.interfaces.TravelNodeInterface;

/**
 * Created by AKS on 10/17/2017.
 */

public class TravellerNodeToHandlerMatcher {

    public Class<? extends TravelNodeHandlerInterface>
    getMatchingHandlerClass(Class<? extends TravelNodeInterface> travelNodeInterfaceClass) {

        if (travelNodeInterfaceClass.equals(RootTravelNode.class))
            return RootTravelNodeHandler.class;
        else if (travelNodeInterfaceClass.equals(KeyGETTravelNode.class)
                || travelNodeInterfaceClass.equals(KeyPUTTravelNode.class)
                || travelNodeInterfaceClass.equals(KeyPOSTTravelNode.class))
            return KeyTravelNodeHandler.class;
        else if (travelNodeInterfaceClass.equals(UriGETTravelNode.class)
                || travelNodeInterfaceClass.equals(UriPUTTravelNode.class)
                || travelNodeInterfaceClass.equals(UriPUTTravelNode.class))
            return UriTravelNodeHandler.class;


        throw new IllegalArgumentException("Unknown travel node type");

    }
}

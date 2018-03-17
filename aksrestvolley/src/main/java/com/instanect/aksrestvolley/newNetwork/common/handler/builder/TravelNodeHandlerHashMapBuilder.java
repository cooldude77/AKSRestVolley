package com.instanect.aksrestvolley.newNetwork.common.handler.builder;

import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;

import java.util.HashMap;

/**
 * Created by AKS on 10/14/2017.
 */

public class TravelNodeHandlerHashMapBuilder {

    public HashMap<Class<? extends AbstractTravelNode>, Class<? extends TravelNodeHandlerInterface>>
    getInstance() {

        return new HashMap<>();
    }
}

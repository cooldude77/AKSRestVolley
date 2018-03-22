package com.instanect.aksrestvolley.newNetwork.common.handler.service;

import com.instanect.accountcommon.network.NetworkResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.TravelNodeHandlerBuilder;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;

/**
 * Connect nodes to handlers
 * In future can accept custom nodes too
 */

public class TravelNodeHandlerService {

    private final TravellerNodeToHandlerMatcher travellerNodeToHandlerMatcher;
    private TravelNodeHandlerBuilder handlerBuilder;

    public TravelNodeHandlerService(TravelNodeHandlerBuilder handlerBuilder,
                                    TravellerNodeToHandlerMatcher travellerNodeToHandlerMatcher) {

        this.handlerBuilder = handlerBuilder;
        this.travellerNodeToHandlerMatcher = travellerNodeToHandlerMatcher;
    }

    public <T> TravelNodeHandlerInterface getHandler(
            AbstractTravelNode travelNode,
            NetworkResponseInterface<T> networkResponse,
            TravelNodeHandlerResponseInterface travelNodeHandlerResponseInterface) {


        Class<? extends TravelNodeHandlerInterface>
                classHandler = travellerNodeToHandlerMatcher.getMatchingHandlerClass(
                travelNode.getClass());

        if (classHandler == null)
            throw new IllegalArgumentException("travelNodeClass not found");

        return handlerBuilder.build(classHandler,
                travelNode,
                networkResponse,
                travelNodeHandlerResponseInterface);


    }

    /*
    public void registerHandlers(Class<? extends AbstractTravelNode> classTravelNode,
                                 Class<? extends TravelNodeHandlerInterface> classHandler) {

        if (travelNodeHandlerMatcher.containsKey(classTravelNode))
            throw new IllegalArgumentException("The key already exists");

        travelNodeHandlerMatcher.put(classTravelNode, classHandler);

    }
    */
}

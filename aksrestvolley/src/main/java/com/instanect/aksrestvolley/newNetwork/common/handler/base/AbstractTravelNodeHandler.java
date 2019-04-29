package com.instanect.aksrestvolley.newNetwork.common.handler.base;

import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;
import com.instanect.networkcommon.NetworkResponseInterface;

/**
 * Stores reference to Rest interface
 * Rest interface supplies objects to make calls to network for e.g volley
 */

abstract public class AbstractTravelNodeHandler implements TravelNodeHandlerInterface {
    protected final AbstractTravelNode abstractTravelNode;
    protected final NetworkResponseInterface networkResponseInterface;
    protected final TravelNodeHandlerResponseInterface handlerResponseInterface;
    protected final ApiUriDeclarationInterface apiUriDeclarationInterface;
    private String tag;
    protected final RESTNetworkInterface restNetworkInterface;


    public <T> AbstractTravelNodeHandler(
            RESTNetworkInterface restNetworkInterface,
            AbstractTravelNode abstractTravelNode,
            NetworkResponseInterface<T> networkResponseInterface,
            TravelNodeHandlerResponseInterface handlerResponseInterface,
            ApiUriDeclarationInterface apiUriDeclarationInterface) {

        this.restNetworkInterface = restNetworkInterface;
        this.abstractTravelNode = abstractTravelNode;
        this.networkResponseInterface = networkResponseInterface;
        this.handlerResponseInterface = handlerResponseInterface;
        this.apiUriDeclarationInterface = apiUriDeclarationInterface;
    }

    public <T> AbstractTravelNodeHandler(
            RESTNetworkInterface restNetworkInterface,
            AbstractTravelNode abstractTravelNode,
            NetworkResponseInterface<T> networkResponseInterface,
            TravelNodeHandlerResponseInterface handlerResponseInterface,
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            String tag) {

        this(restNetworkInterface,abstractTravelNode,networkResponseInterface,handlerResponseInterface,apiUriDeclarationInterface);

        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public AbstractTravelNode getTravelNode() {
        return abstractTravelNode;
    }
}

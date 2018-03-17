package com.instanect.aksrestvolley.newNetwork.common.handler.base;

import com.instanect.aksrestvolley.business.declarations.uri.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.responseObject.NetworkResponse;

/**
 * Stores reference to Rest interface
 * Rest interface supplies objects to make calls to network for e.g volley
 */

abstract public class AbstractTravelNodeHandler implements TravelNodeHandlerInterface {
    protected final AbstractTravelNode abstractTravelNode;
    protected final NetworkResponse networkResponse;
    protected final TravelNodeHandlerResponseInterface handlerResponseInterface;
    protected final ApiUriDeclarationInterface apiUriDeclarationInterface;
    protected final RESTNetworkInterface restNetworkInterface;


    public <T> AbstractTravelNodeHandler(
            RESTNetworkInterface restNetworkInterface,
            AbstractTravelNode abstractTravelNode,
            NetworkResponse<T> networkResponse,
            TravelNodeHandlerResponseInterface handlerResponseInterface,
            ApiUriDeclarationInterface apiUriDeclarationInterface) {

        this.restNetworkInterface = restNetworkInterface;
        this.abstractTravelNode = abstractTravelNode;
        this.networkResponse = networkResponse;
        this.handlerResponseInterface = handlerResponseInterface;
        this.apiUriDeclarationInterface = apiUriDeclarationInterface;
    }


}

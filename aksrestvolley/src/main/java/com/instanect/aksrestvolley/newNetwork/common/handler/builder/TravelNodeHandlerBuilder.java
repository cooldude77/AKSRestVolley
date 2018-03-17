package com.instanect.aksrestvolley.newNetwork.common.handler.builder;

import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.implementations.KeyTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.implementations.RootTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.base.AbstractKeyTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.implementations.RootTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.responseObject.NetworkResponse;

/**
 * Builds Node Handlers
 */

public class TravelNodeHandlerBuilder {


    private final RESTNetworkInterface restNetworkApiInterface;
    private final CurieResolverInterface curieResolverInterface;
    private final ApiUriDeclarationInterface apiUriDeclarationInterface;

    public TravelNodeHandlerBuilder(RESTNetworkInterface restNetworkInterface,
                                    CurieResolverInterface curieResolverInterface,
                                    ApiUriDeclarationInterface apiUriDeclarationInterface) {

        this.restNetworkApiInterface = restNetworkInterface;
        this.curieResolverInterface = curieResolverInterface;
        this.apiUriDeclarationInterface = apiUriDeclarationInterface;
    }

    public <T> TravelNodeHandlerInterface build(
            Class<? extends TravelNodeHandlerInterface> travelNodeHandlerClass,
            AbstractTravelNode travelNode,
            NetworkResponse<T> networkResponse,
            TravelNodeHandlerResponseInterface travelNodeHandlerResponseInterface) {

        if (travelNodeHandlerClass.equals(RootTravelNodeHandler.class)) {

            return new RootTravelNodeHandler(
                    restNetworkApiInterface,
                    apiUriDeclarationInterface,
                    (RootTravelNode) travelNode,
                    networkResponse,
                    travelNodeHandlerResponseInterface);
        } else if (travelNodeHandlerClass.equals(KeyTravelNodeHandler.class)) {

            return new KeyTravelNodeHandler(
                    restNetworkApiInterface,
                    apiUriDeclarationInterface,
                    curieResolverInterface,
                    (AbstractKeyTravelNode) travelNode,
                    networkResponse,
                    travelNodeHandlerResponseInterface

            );
        }

        throw new IllegalArgumentException("Handler class unknown");
    }
}

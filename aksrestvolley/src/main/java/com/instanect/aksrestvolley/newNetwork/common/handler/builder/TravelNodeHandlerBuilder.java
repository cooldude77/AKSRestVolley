package com.instanect.aksrestvolley.newNetwork.common.handler.builder;

import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.implementations.KeyTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.implementations.RootTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.implementations.UriTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.base.AbstractKeyTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes.base.AbstractUriTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.implementations.RootTravelNode;
import com.instanect.networkcommon.NetworkResponseInterface;

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
            NetworkResponseInterface<T> networkResponseInterface,
            TravelNodeHandlerResponseInterface travelNodeHandlerResponseInterface) {

        return build(travelNodeHandlerClass, travelNode,
                networkResponseInterface, travelNodeHandlerResponseInterface, null);
    }

    public <T> TravelNodeHandlerInterface build(
            Class<? extends TravelNodeHandlerInterface> travelNodeHandlerClass,
            AbstractTravelNode travelNode,
            NetworkResponseInterface<T> networkResponseInterface,
            TravelNodeHandlerResponseInterface travelNodeHandlerResponseInterface,
            String tag) {

        if (travelNodeHandlerClass.equals(RootTravelNodeHandler.class)) {
            return new RootTravelNodeHandler(
                    apiUriDeclarationInterface,
                    networkResponseInterface,
                    restNetworkApiInterface,
                    (RootTravelNode) travelNode,
                    tag,
                    travelNodeHandlerResponseInterface
            );
        } else if (travelNodeHandlerClass.equals(KeyTravelNodeHandler.class)) {
            return new KeyTravelNodeHandler(
                    (AbstractKeyTravelNode) travelNode,
                    apiUriDeclarationInterface,
                    curieResolverInterface,
                    networkResponseInterface,
                    restNetworkApiInterface,
                    tag, travelNodeHandlerResponseInterface
            );
        } else if (travelNodeHandlerClass.equals(UriTravelNodeHandler.class)) {
            return new UriTravelNodeHandler(
                    restNetworkApiInterface,
                    (AbstractUriTravelNode) travelNode,
                    networkResponseInterface,
                    travelNodeHandlerResponseInterface,
                    apiUriDeclarationInterface,
                    tag);
        }

        throw new IllegalArgumentException("Handler class unknown");
    }
}

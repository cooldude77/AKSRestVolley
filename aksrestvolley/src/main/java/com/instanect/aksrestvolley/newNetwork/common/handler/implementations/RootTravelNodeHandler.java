package com.instanect.aksrestvolley.newNetwork.common.handler.implementations;

import android.net.Uri;

import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.base.AbstractTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.implementations.RootTravelNode;
import com.instanect.networkcommon.NetworkResponseInterface;

/**
 * Created by AKS on 10/4/2017.
 */

public class RootTravelNodeHandler
        extends AbstractTravelNodeHandler
        implements RESTNetworkResponseInterface {


    public <T> RootTravelNodeHandler(
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            NetworkResponseInterface<T> networkResponse,
            RESTNetworkInterface restNetworkInterface,
            RootTravelNode rootTravelNode,
            TravelNodeHandlerResponseInterface handlerResponseInterface) {
        this(
                apiUriDeclarationInterface,
                networkResponse,
                restNetworkInterface,
                rootTravelNode,
                null,
                handlerResponseInterface);
    }

    public <T> RootTravelNodeHandler(
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            NetworkResponseInterface<T> networkResponseInterface,
            RESTNetworkInterface restNetworkApiInterface,
            RootTravelNode rootTravelNode,
            String tag,
            TravelNodeHandlerResponseInterface travelNodeHandlerResponseInterface
    ) {
        super(restNetworkApiInterface,
                rootTravelNode, networkResponseInterface,
                travelNodeHandlerResponseInterface,
                apiUriDeclarationInterface, tag);

    }


    @Override
    public <T> void handle() {

        Uri uri = Uri.parse(apiUriDeclarationInterface.getHomeUri());
        restNetworkInterface.setResponseInterface(this);
        restNetworkInterface.execute(
                0,
                uri,
                ((RootTravelNode)getTravelNode()).getMethod(),
                ((RootTravelNode)getTravelNode()).getHeader(),
                null,
                ((RootTravelNode)getTravelNode()).getReturnType(),
                getTag()
        );

    }

    @Override
    public <T> void onSuccess(NetworkResponseInterface<T> response, int requestId) {
        handlerResponseInterface.onSuccess(response);
    }

    @Override
    public void onError(String error, int code, int requestId) {
        handlerResponseInterface.onError(error, code);
    }
}



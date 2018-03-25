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


    private final RootTravelNode rootTravelNode;

    public <T> RootTravelNodeHandler(
            RESTNetworkInterface restNetworkInterface,
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            RootTravelNode rootTravelNode,
            NetworkResponseInterface<T> networkResponse,
            TravelNodeHandlerResponseInterface handlerResponseInterface) {
        super(
                restNetworkInterface,
                rootTravelNode,
                networkResponse,
                handlerResponseInterface,
                apiUriDeclarationInterface);
        this.rootTravelNode = rootTravelNode;
    }


    @Override
    public <T> void handle() {

        Uri uri = Uri.parse(apiUriDeclarationInterface.getHomeUri());
        restNetworkInterface.setResponseInterface(this);
        restNetworkInterface.execute(
                0,
                uri,
                rootTravelNode.getMethod(),
                rootTravelNode.getHeader(),
                null,
                rootTravelNode.getReturnType()
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



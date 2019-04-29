package com.instanect.aksrestvolley.newNetwork.common.handler.implementations;

import android.net.Uri;

import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.base.AbstractTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.CurieResolverInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.base.AbstractKeyTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes.base.AbstractUriTravelNode;
import com.instanect.networkcommon.NetworkResponseInterface;

import org.json.JSONObject;

/**
 * Key Travel Node Handler
 */

public class UriTravelNodeHandler extends AbstractTravelNodeHandler
        implements RESTNetworkResponseInterface {

    public <T> UriTravelNodeHandler(
            AbstractUriTravelNode abstractUriTravelNode,
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            NetworkResponseInterface<T> networkResponse,
            RESTNetworkInterface restNetworkInterface,
            TravelNodeHandlerResponseInterface handlerResponseInterface) {
        this(abstractUriTravelNode,
                apiUriDeclarationInterface,
                networkResponse,
                restNetworkInterface,
                null,
                handlerResponseInterface);
    }

    public <T> UriTravelNodeHandler(
            AbstractUriTravelNode abstractTravelNode,
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            NetworkResponseInterface<T> networkResponseInterface,
            RESTNetworkInterface restNetworkInterface,
            String tag,
            TravelNodeHandlerResponseInterface handlerResponseInterface
    ) {
        super(restNetworkInterface, abstractTravelNode,
                networkResponseInterface, handlerResponseInterface, apiUriDeclarationInterface
                , tag);
    }

    public <T> UriTravelNodeHandler(
            RESTNetworkInterface restNetworkApiInterface,
            AbstractUriTravelNode travelNode,
            NetworkResponseInterface<T> networkResponseInterface,
            TravelNodeHandlerResponseInterface travelNodeHandlerResponseInterface,
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            String tag) {
        super(restNetworkApiInterface, travelNode,
                networkResponseInterface, travelNodeHandlerResponseInterface,
                apiUriDeclarationInterface, tag);
    }

    @Override
    public void handle() {

        Uri uri = ((AbstractUriTravelNode) abstractTravelNode).getUri();
        String query;
        if ((query = abstractTravelNode.getQuery()) != null) {
            String uriString = uri.toString();
            uri = Uri.parse(uriString + "?" + query);
        }
        restNetworkInterface.setResponseInterface(this);
        restNetworkInterface.execute(
                0, uri,
                abstractTravelNode.getMethod(),
                abstractTravelNode.getHeader(),
                abstractTravelNode.getBody(),
                abstractTravelNode.getReturnType(),
                getTag());
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

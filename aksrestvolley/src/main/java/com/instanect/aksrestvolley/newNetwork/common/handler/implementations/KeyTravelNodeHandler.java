package com.instanect.aksrestvolley.newNetwork.common.handler.implementations;

import android.net.Uri;
import android.util.Log;

import com.instanect.aksrestvolley.newNetwork.LogTagGenerator;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.base.AbstractTravelNodeHandler;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.CurieResolverInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.CurieResolverKeyNotFoundException;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.base.AbstractKeyTravelNode;
import com.instanect.networkcommon.NetworkResponseInterface;

import org.json.JSONObject;

/**
 * Key Travel Node Handler
 */

public class KeyTravelNodeHandler extends AbstractTravelNodeHandler
        implements RESTNetworkResponseInterface {
    private CurieResolverInterface curieResolverInterface;
    private String TAG = LogTagGenerator.getTag(KeyTravelNodeHandler.class);

    public <T> KeyTravelNodeHandler(
            AbstractKeyTravelNode abstractKeyTravelNode,
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            CurieResolverInterface curieResolverInterface,
            NetworkResponseInterface<T> networkResponse,
            RESTNetworkInterface restNetworkInterface,
            TravelNodeHandlerResponseInterface handlerResponseInterface) {
        this(abstractKeyTravelNode, apiUriDeclarationInterface,
                curieResolverInterface,
                networkResponse,
                restNetworkInterface,
                null,
                handlerResponseInterface);
    }

    public <T> KeyTravelNodeHandler(
            AbstractKeyTravelNode abstractKeyTravelNode,
            ApiUriDeclarationInterface apiUriDeclarationInterface,
            CurieResolverInterface curieResolverInterface,
            NetworkResponseInterface<T> networkResponse,
            RESTNetworkInterface restNetworkInterface,
            String tag,
            TravelNodeHandlerResponseInterface handlerResponseInterface
    ) {
        super(restNetworkInterface,
                abstractKeyTravelNode,
                networkResponse,
                handlerResponseInterface,
                apiUriDeclarationInterface,
                tag);
        this.curieResolverInterface = curieResolverInterface;
    }

    @Override
    public void handle() {


        String key = ((AbstractKeyTravelNode) abstractTravelNode)
                .getNextIdentifierKey();

        Uri uri = null;
        try {
            uri = Uri.parse(findUri(key));
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
        } catch (CurieResolverKeyNotFoundException e) {
            Log.d(TAG, Log.getStackTraceString(e));
        }

    }

    private String findUri(
            String key) throws CurieResolverKeyNotFoundException {
        String uri = null;
        if (key != null)
            uri = apiUriDeclarationInterface.getHomeUri()
                    + curieResolverInterface.getUri(key,
                    (JSONObject) this.networkResponseInterface.getResponse());
        return uri;
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

package com.instanect.aksrestvolley.newNetwork.common.api;

import android.net.Uri;

import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.external.ExternalNetworkLibraryInterface;
import com.instanect.aksrestvolley.newNetwork.common.external.ExternalNetworkLibraryResponseInterface;
import com.instanect.networkcommon.NetworkResponseInterface;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;

/**
 * Bridge between External library like volley and app rest module
 */

public class RESTNetworkApi implements RESTNetworkInterface,
        ExternalNetworkLibraryResponseInterface {

    private ExternalNetworkLibraryInterface externalNetworkLibraryInterface;
    private RESTNetworkResponseInterface restNetworkResponseInterface;
    private int requestId;

    public RESTNetworkApi(
            ExternalNetworkLibraryInterface externalNetworkLibraryInterface) {
        this.externalNetworkLibraryInterface = externalNetworkLibraryInterface;
    }


    @Override
    public void execute(
            int requestId,
            Uri uri,
            int method,
            HashMap<String, String> header,
            HashMap<String, String> body,
            int returnType) {

        execute(requestId, uri, method, header, body, returnType, null);
    }

    @Override
    public void execute(
            int requestId,
            Uri uri,
            int method,
            HashMap<String, String> header,
            HashMap<String, String> body,
            int returnType,
            String tag) {
        this.requestId = requestId;

        externalNetworkLibraryInterface
                .execute(
                        uri,
                        method,
                        header,
                        body,
                        returnType,
                        this,
                        tag);

    }

    @Override
    public void setResponseInterface(RESTNetworkResponseInterface responseInterface) {
        assertNotNull(responseInterface);
        this.restNetworkResponseInterface = responseInterface;
    }

    @Override
    public <T> void onSuccess(NetworkResponseInterface<T> networkResponse) {
        assertNotNull(restNetworkResponseInterface);
        restNetworkResponseInterface.onSuccess(networkResponse, requestId);

    }

    @Override
    public void onError(String error, int errorCode) {
        assertNotNull(restNetworkResponseInterface);
        restNetworkResponseInterface.onError(error, errorCode, requestId);
    }

    @Override
    public void tryAbort() {
        externalNetworkLibraryInterface.tryAbort();
    }
}

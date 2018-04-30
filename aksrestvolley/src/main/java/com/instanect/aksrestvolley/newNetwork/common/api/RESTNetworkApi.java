package com.instanect.aksrestvolley.newNetwork.common.api;

import android.net.Uri;

import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.external.ExternalNetworkLibraryInterface;
import com.instanect.aksrestvolley.newNetwork.common.external.ExternalNetworkLibraryResponseInterface;
import com.instanect.networkcommon.NetworkResponseInterface;

import junit.framework.Assert;

import java.util.HashMap;

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
        this.requestId = requestId;

        externalNetworkLibraryInterface
                .execute(
                        uri,
                        method,
                        header,
                        body,
                        returnType,
                        this);

    }

    @Override
    public void setResponseInterface(RESTNetworkResponseInterface responseInterface) {
        Assert.assertNotNull(responseInterface);
        this.restNetworkResponseInterface = responseInterface;
    }

    @Override
    public <T> void onSuccess(NetworkResponseInterface<T> networkResponse) {
        Assert.assertNotNull(restNetworkResponseInterface);
        restNetworkResponseInterface.onSuccess(networkResponse, requestId);

    }

    @Override
    public void onError(String error, int errorCode) {
        Assert.assertNotNull(restNetworkResponseInterface);
        restNetworkResponseInterface.onError(error, errorCode, requestId);
    }

    @Override
    public void tryAbort() {
        externalNetworkLibraryInterface.tryAbort();
    }
}

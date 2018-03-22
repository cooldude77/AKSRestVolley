package com.instanect.aksrestvolley.newNetwork.common.api.interfaces;

import com.instanect.accountcommon.network.NetworkResponseInterface;

/**
 * Created by AKS on 10/12/2017.
 */

public interface RESTNetworkResponseInterface {

    <T> void onSuccess(NetworkResponseInterface<T> response, int requestId);

    void onError(String error, int code, int requestId);
}

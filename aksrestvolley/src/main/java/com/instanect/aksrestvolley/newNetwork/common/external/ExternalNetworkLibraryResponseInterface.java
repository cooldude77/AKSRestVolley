package com.instanect.aksrestvolley.newNetwork.common.external;


import com.instanect.networkcommon.NetworkResponseInterface;

/**
 * Created by AKS on 10/12/2017.
 */

public interface ExternalNetworkLibraryResponseInterface {

    <T> void onSuccess(NetworkResponseInterface<T> networkResponse);

    void onError(String error, int errorCode);
}

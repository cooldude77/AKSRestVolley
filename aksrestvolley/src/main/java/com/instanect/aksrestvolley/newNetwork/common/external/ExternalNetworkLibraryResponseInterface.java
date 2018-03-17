package com.instanect.aksrestvolley.newNetwork.common.external;

import com.instanect.aksrestvolley.newNetwork.common.responseObject.NetworkResponse;

/**
 * Created by AKS on 10/12/2017.
 */

public interface ExternalNetworkLibraryResponseInterface {

    <T> void onSuccess(NetworkResponse<T> networkResponse);

    void onError(String error, int errorCode);
}

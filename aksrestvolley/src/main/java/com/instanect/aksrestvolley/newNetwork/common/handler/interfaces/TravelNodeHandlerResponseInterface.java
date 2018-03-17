package com.instanect.aksrestvolley.newNetwork.common.handler.interfaces;

import com.instanect.aksrestvolley.newNetwork.common.responseObject.NetworkResponse;

/**
 * Created by AKS on 10/4/2017.
 */

public interface TravelNodeHandlerResponseInterface {
    <T> void onSuccess(NetworkResponse<T> networkResponse);

    void onError(String error, int errorCode);

}

package com.instanect.aksrestvolley.newNetwork.common.traveller.interfaces;

import com.instanect.aksrestvolley.newNetwork.common.responseObject.NetworkResponse;

/**
 * Created by AKS on 10/4/2017.
 */

public interface TravellerResponseInterface {

    <T> void onSuccess(NetworkResponse<T> networkResponse);

    void onError(String errorMessage, int errorCode);

    void onTravellerAbort();
}

package com.instanect.aksrestvolley.newNetwork.common.traveller.interfaces;


import com.instanect.networkcommon.NetworkResponseInterface;

/**
 * Created by AKS on 10/4/2017.
 */

public interface TravellerResponseInterface {

    <T> void onSuccess(NetworkResponseInterface<T> networkResponse);

    void onError(String errorMessage, int errorCode);

    void onTravellerAbort();
}

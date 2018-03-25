package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces;


import com.instanect.networkcommon.NetworkResponseInterface;

/**
 * Created by AKS on 10/5/2017.
 */

public interface ScenarioResponseInterface {

    <T> void onSuccess(NetworkResponseInterface<T> networkResponse);

    void onError(String errorMessage, int errorCode);
}

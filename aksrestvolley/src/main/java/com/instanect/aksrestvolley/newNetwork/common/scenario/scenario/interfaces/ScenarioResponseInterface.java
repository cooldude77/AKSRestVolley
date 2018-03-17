package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces;

import com.instanect.aksrestvolley.newNetwork.common.responseObject.NetworkResponse;

/**
 * Created by AKS on 10/5/2017.
 */

public interface ScenarioResponseInterface {

    <T> void onSuccess(NetworkResponse<T> networkResponse);

    void onError(String errorMessage, int errorCode);
}

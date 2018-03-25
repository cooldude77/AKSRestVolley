package com.instanect.aksrestvolley.newNetwork.common.scenario.executor.interfaces;

import com.instanect.networkcommon.NetworkResponseInterface;

/**
 * Created by AKS on 10/5/2017.
 */

public interface ScenarioExecutionResponseInterface {
    <T> void onSuccess(NetworkResponseInterface<T> networkResponse);

    void onError(String error, int errorCode);

    void onInternetNotAvailable();

    void onAdditionalUrlNotAvailable(String messageOnNotAvailable);

    void onScenarioExecutionAbort();

}

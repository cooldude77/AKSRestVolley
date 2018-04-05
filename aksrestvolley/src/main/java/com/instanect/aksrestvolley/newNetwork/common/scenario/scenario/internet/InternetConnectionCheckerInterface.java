package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet;

import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.interfaces.InternetConnectionCheckerResponseInterface;

/**
 * Created by AKS on 10/11/2017.
 */

public interface InternetConnectionCheckerInterface {

    void checkInternetAvailable(InternetConnectionCheckerResponseInterface internetConnectionCheckerResponseInterface);

    void tryAbort();
}

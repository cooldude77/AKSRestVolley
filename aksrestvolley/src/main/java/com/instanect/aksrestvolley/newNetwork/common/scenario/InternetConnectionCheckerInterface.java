package com.instanect.aksrestvolley.newNetwork.common.scenario;

import android.net.Uri;

import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di.InternetConnectionCheckerResponseInterface;

/**
 * Created by AKS on 10/11/2017.
 */

public interface InternetConnectionCheckerInterface {

    void checkInternetAvailable(
            String additionalUriToCheck,
            InternetConnectionCheckerResponseInterface internetConnectionCheckerResponseInterface);

    void tryAbort();
}

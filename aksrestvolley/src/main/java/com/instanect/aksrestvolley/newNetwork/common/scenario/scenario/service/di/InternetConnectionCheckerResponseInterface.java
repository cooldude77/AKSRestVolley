package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di;

/**
 * Created by AKS on 10/16/2017.
 */

public interface InternetConnectionCheckerResponseInterface {

    void onInternetConnectionNotAvailable();

    void onAdditionalUrlNotAvailable(String messageOnNotAvailable);

    void onAllChecksSuccess();

    void onAllInternetChecksAbort();

}

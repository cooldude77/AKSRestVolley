package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di;

import android.net.Uri;
import android.util.Log;

import com.instanect.accountcommon.network.NetworkResponse;
import com.instanect.accountcommon.network.NetworkResponseInterface;
import com.instanect.aksrestvolley.newNetwork.LogTagGenerator;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.network.HTTPMethods;
import com.instanect.aksrestvolley.newNetwork.common.node.constants.NetworkCallReturnType;
import com.instanect.aksrestvolley.newNetwork.common.scenario.InternetConnectionCheckerInterface;

/**
 * InternetConnectionChecker
 */

public class InternetConnectionChecker
        implements InternetConnectionCheckerInterface, RESTNetworkResponseInterface {

    static final int GOOGLE_REQUEST_ID = 0;
    private static final int ADDITIONAL_URI_REQUEST_ID = 1;

    private String TAG = LogTagGenerator.getTag(InternetConnectionChecker.class);

    private RESTNetworkInterface restNetworkInterface;

    private String additionalUriToCheck;

    private Uri googleUri = Uri.parse("http://www.google.com");

    private InternetConnectionCheckerResponseInterface internetConnectionCheckerResponseInterface;
    private boolean abortExecution = false;

    public InternetConnectionChecker(RESTNetworkInterface restNetworkInterface) {

        this.restNetworkInterface = restNetworkInterface;
    }


    @Override
    public void checkInternetAvailable(
            String additionalUriToCheck,
            InternetConnectionCheckerResponseInterface internetConnectionCheckerResponseInterface) {

        this.additionalUriToCheck = additionalUriToCheck;
        this.internetConnectionCheckerResponseInterface = internetConnectionCheckerResponseInterface;

        restNetworkInterface.setResponseInterface(this);
        resetAbortFlag();
        startChecksInternal();
    }

    private void startChecksInternal() {

        Log.d(TAG, "Google check started...");

        restNetworkInterface.execute(
                GOOGLE_REQUEST_ID,
                googleUri,
                HTTPMethods.GET,
                null,
                null,
                NetworkCallReturnType.STRING
        );

    }

    @Override
    public <T> void onSuccess(NetworkResponseInterface<T> response, int requestId) {

        // Google call was successful
        if (requestId == GOOGLE_REQUEST_ID) {

            if (abortExecution) {
                Log.d(TAG, "Aborting internet check");
                resetAbortFlag();
                internetConnectionCheckerResponseInterface
                        .onAllInternetChecksAbort();

            } else {
                Log.d(TAG, "Instanect/additional URL check started...");
                restNetworkInterface.execute(
                        ADDITIONAL_URI_REQUEST_ID,
                        Uri.parse(additionalUriToCheck),
                        HTTPMethods.GET,
                        null,
                        null,
                        NetworkCallReturnType.STRING
                );
            }
        } else if (requestId == ADDITIONAL_URI_REQUEST_ID) {
            internetConnectionCheckerResponseInterface.onAllChecksSuccess();
        }

    }

    @Override
    public void onError(String error, int code, int requestId) {

        if (requestId == GOOGLE_REQUEST_ID)
            internetConnectionCheckerResponseInterface.onInternetConnectionNotAvailable();
        else if (requestId == ADDITIONAL_URI_REQUEST_ID)
            internetConnectionCheckerResponseInterface.onAdditionalUrlNotAvailable(
                    additionalUriToCheck.toString() + " " + "is not available");
    }

    private void resetAbortFlag() {
        abortExecution = false;
    }

    @Override
    public void tryAbort() {

        abortExecution = true;
    }


    InternetConnectionCheckerResponseInterface getInternetConnectionCheckerResponseInterface() {
        return internetConnectionCheckerResponseInterface;
    }


}

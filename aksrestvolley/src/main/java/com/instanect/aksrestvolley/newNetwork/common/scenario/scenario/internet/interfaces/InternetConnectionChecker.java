package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.interfaces;

import android.net.Uri;
import android.util.Log;

import com.instanect.aksrestvolley.newNetwork.LogTagGenerator;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkInterface;
import com.instanect.aksrestvolley.newNetwork.common.api.interfaces.RESTNetworkResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.network.HTTPMethods;
import com.instanect.aksrestvolley.newNetwork.common.node.constants.NetworkCallReturnType;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.InternetConnectionCheckerInterface;
import com.instanect.networkcommon.NetworkResponseInterface;

/**
 * InternetConnectionChecker
 */

public class InternetConnectionChecker
        implements InternetConnectionCheckerInterface, RESTNetworkResponseInterface {

    static final int GOOGLE_REQUEST_ID = 0;
    private static final int ADDITIONAL_URI_REQUEST_ID = 1;

    private String TAG = LogTagGenerator.getTag(InternetConnectionChecker.class);

    private RESTNetworkInterface restNetworkInterface;
    private final ApiUriDeclarationInterface apiUriDeclarationInterface;


    private Uri googleUri = Uri.parse("http://www.google.com");

    private InternetConnectionCheckerResponseInterface internetConnectionCheckerResponseInterface;
    private boolean abortExecution = false;

    public InternetConnectionChecker(
            RESTNetworkInterface restNetworkInterface,
            ApiUriDeclarationInterface apiUriDeclarationInterface) {

        this.restNetworkInterface = restNetworkInterface;
        this.apiUriDeclarationInterface = apiUriDeclarationInterface;
    }


    @Override
    public void checkInternetAvailable(
            InternetConnectionCheckerResponseInterface internetConnectionCheckerResponseInterface) {

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
                        Uri.parse(apiUriDeclarationInterface.getAdditionalUri()),
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
                    apiUriDeclarationInterface.getAdditionalUri() + " " + "is not available");
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

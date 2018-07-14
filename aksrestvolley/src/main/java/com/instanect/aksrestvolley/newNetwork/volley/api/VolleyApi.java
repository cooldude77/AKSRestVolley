package com.instanect.aksrestvolley.newNetwork.volley.api;

import android.net.Uri;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.instanect.aksrestvolley.newNetwork.LogTagGenerator;
import com.instanect.aksrestvolley.newNetwork.common.external.ExternalNetworkLibraryInterface;
import com.instanect.aksrestvolley.newNetwork.common.external.ExternalNetworkLibraryResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.node.constants.NetworkCallReturnType;
import com.instanect.aksrestvolley.newNetwork.volley.request.di.VolleyRequestQueueCompositionWrapper;
import com.instanect.aksrestvolley.newNetwork.volley.requests.builder.UriHttpClientRequestBuilder;
import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientJsonArrayRequest;
import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientJsonObjectRequest;
import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientStringRequest;
import com.instanect.networkcommon.NetworkResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.HashMap;

/**
 * Created by AKS on 10/12/2017.
 */

public class VolleyApi
        implements ExternalNetworkLibraryInterface {

    private static String TAG = LogTagGenerator.getTag(VolleyApi.class);
    private VolleyResponseFromServerHandler volleyResponseFromServerHandler = new VolleyResponseFromServerHandler();
    private ExternalNetworkLibraryResponseInterface responseInterface;
    private VolleyRequestQueueCompositionWrapper volleyRequestQueueCompositionWrapper;
    private UriHttpClientRequestBuilder uriHttpClientRequestBuilder;
    private int method;
    private HashMap<String, String> header;
    private HashMap<String, String> body;
    private int returnType;

    public VolleyApi(UriHttpClientRequestBuilder uriHttpClientRequestBuilder,
                     VolleyRequestQueueCompositionWrapper volleyRequestQueueCompositionWrapper) {
        this.uriHttpClientRequestBuilder = uriHttpClientRequestBuilder;
        this.volleyRequestQueueCompositionWrapper = volleyRequestQueueCompositionWrapper;
    }

    public void setResponseInterface(ExternalNetworkLibraryResponseInterface responseInterface) {
        this.responseInterface = responseInterface;
    }


    @Override
    public void execute(Uri uri,
                        int method,
                        HashMap<String, String> header,
                        HashMap<String, String> body,
                        int returnType,
                        final ExternalNetworkLibraryResponseInterface responseInterface,
                        String requestTag) {

        this.method = method;
        this.header = header;
        this.body = body;
        this.returnType = returnType;
        this.responseInterface = responseInterface;


        Log.d(TAG, "Starting request...");
        Log.d(TAG, "Uri= " + uri);
        Log.d(TAG, "Using header...");
        if (header != null)
            Log.d(TAG, header.toString());
        else {
            Log.d(TAG, "Header is null");
        }
        if (body != null) {
            Log.d(TAG, "And Body...");
            Log.d(TAG, body.toString());
        }
        if (requestTag != null) {
            Log.d(TAG, "And request tag...");
            Log.d(TAG, requestTag);

        }
        switch (returnType) {

            case NetworkCallReturnType.JSON_OBJECT:

                UriHttpClientJsonObjectRequest request = uriHttpClientRequestBuilder.getJsonObjectInstance(
                        method,
                        uri,
                        header,
                        body,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                volleyResponseFromServerHandler.handleSuccess(response, responseInterface);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                volleyResponseFromServerHandler.handle(error, responseInterface);

                            }
                        }
                );
                if (requestTag != null)
                    request.setTag(requestTag);

                process(request);
                break;
            case NetworkCallReturnType.JSON_ARRAY:
                UriHttpClientJsonArrayRequest requestArray
                        = uriHttpClientRequestBuilder.getJsonArrayInstance(
                        method,
                        uri,
                        header,
                        body,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                volleyResponseFromServerHandler.handleSuccess(response, responseInterface);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                volleyResponseFromServerHandler.handle(error, responseInterface);
                            }
                        }
                );

                if (requestTag != null)
                    requestArray.setTag(requestTag);
                process(requestArray);

                break;
            case NetworkCallReturnType.STRING:

                UriHttpClientStringRequest stringRequest
                        = uriHttpClientRequestBuilder.getStringInstance(
                        method,
                        uri,
                        body,
                        header,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                volleyResponseFromServerHandler.handleSuccess(response, responseInterface);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                volleyResponseFromServerHandler.handle(error, responseInterface);
                            }
                        }
                );


                if (requestTag != null)
                    stringRequest.setTag(requestTag);

                process(stringRequest);
                break;
            default:
                throw new IllegalArgumentException("Wrong network returnType");
        }
    }


    @Override
    public void execute(Uri uri,
                        int method,
                        HashMap<String, String> header,
                        HashMap<String, String> body,
                        int returnType,
                        final ExternalNetworkLibraryResponseInterface responseInterface) {

        execute(uri, method, header, body, returnType, responseInterface,
                null);
    }

    @Override
    public void tryAbort() {
        // todo later
        // volleyRequestQueueCompositionWrapper.cancelAll();
    }


    class VolleyResponseFromServerHandler {

        public void handle(VolleyError error,
                           ExternalNetworkLibraryResponseInterface responseInterface) {

            if (error != null && error.networkResponse != null) {
                String message = new String(error.networkResponse.data);

                Log.d(TAG, "Error Occurred...");
                Log.d(TAG, message);
                Log.d(TAG, "With code...");
                Log.d(TAG, "Error Occurred..");
                Log.d(TAG, Integer.toString(error.networkResponse.statusCode));


                if (error.networkResponse.statusCode == 307
                        || error.networkResponse.statusCode == HttpURLConnection.HTTP_MOVED_TEMP
                        || error.networkResponse.statusCode == 308) {
                    final String location = error.networkResponse.headers.get("Location");

                    execute(
                            Uri.parse(location),
                            method,
                            header,
                            body,
                            returnType,
                            responseInterface
                    );


                } else

                    responseInterface.onError(message, error.networkResponse.statusCode);
            } else
                responseInterface.onError("Unspecified Error", 500);
        }

        public <T> void handleSuccess(T response,
                                      ExternalNetworkLibraryResponseInterface responseInterface) {

            Log.d(TAG, "Successful response...");
            Log.d(TAG, response.toString());

            NetworkResponse<T> networkResponse
                    = new NetworkResponse<>();
            networkResponse.setResponse(response);
            responseInterface.onSuccess(networkResponse);
        }
    }


    private <T> void process(Request<T> request) {
        int noOfTries = DefaultRetryPolicy.DEFAULT_MAX_RETRIES;

        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                noOfTries,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        );
        request.setRetryPolicy(policy);
        volleyRequestQueueCompositionWrapper.getRequestQueue().add(request);
    }

}

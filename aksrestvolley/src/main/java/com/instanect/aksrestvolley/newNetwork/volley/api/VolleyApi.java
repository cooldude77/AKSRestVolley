package com.instanect.aksrestvolley.newNetwork.volley.api;

import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.instanect.aksrestvolley.newNetwork.LogTagGenerator;
import com.instanect.aksrestvolley.newNetwork.common.external.ExternalNetworkLibraryInterface;
import com.instanect.aksrestvolley.newNetwork.common.external.ExternalNetworkLibraryResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.network.HTTPMethods;
import com.instanect.aksrestvolley.newNetwork.common.node.constants.NetworkCallReturnType;
import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientJsonArrayRequest;
import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientJsonObjectRequest;
import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientRequestBuilder;
import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientStringRequest;
import com.instanect.networkcommon.NetworkResponse;
import com.instanect.networkcommon.NetworkResponseInterface;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by AKS on 10/12/2017.
 */

public class VolleyApi<T>
        implements ExternalNetworkLibraryInterface {

    private static String TAG = LogTagGenerator.getTag(VolleyApi.class);
    VolleyResponseFromServerHandler volleyResponseFromServerHandler = new VolleyResponseFromServerHandler();
    private ExternalNetworkLibraryResponseInterface responseInterface;
    private RequestQueue requestQueue;
    private UriHttpClientRequestBuilder uriHttpClientRequestBuilder;

    public VolleyApi(UriHttpClientRequestBuilder uriHttpClientRequestBuilder,
                     RequestQueue requestQueue) {
        this.uriHttpClientRequestBuilder = uriHttpClientRequestBuilder;
        this.requestQueue = requestQueue;
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
                        final ExternalNetworkLibraryResponseInterface responseInterface) {


        Log.d(TAG, "Starting request...");
        Log.d(TAG, "Uri= " + uri);
        Log.d(TAG, "Using header...");
        if (header != null)
            Log.d(TAG, header.toString());
        if (body != null) {
            Log.d(TAG, "And Body...");
            Log.d(TAG, body.toString());
        }

        switch (returnType) {

            case NetworkCallReturnType.JSON_OBJECT:

                UriHttpClientJsonObjectRequest request = uriHttpClientRequestBuilder.getJsonObjectInstance(
                        method,
                        uri,
                        header,
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

                if (method == HTTPMethods.POST)
                    request.post(body, 1);
                else if (method == HTTPMethods.PUT)
                    request.put(body, 1);
                else
                    request.get(1);
                break;
            case NetworkCallReturnType.JSON_ARRAY:
                UriHttpClientJsonArrayRequest requestArray
                        = uriHttpClientRequestBuilder.getJsonArrayInstance(
                        method,
                        uri,
                        header,
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
                if (method == HTTPMethods.POST)
                    requestArray.post(body, 1);
                else if (method == HTTPMethods.PUT)
                    requestArray.put(body, 1);
                else
                    requestArray.get(1);
                break;
            case NetworkCallReturnType.STRING:

                UriHttpClientStringRequest stringRequest
                        = uriHttpClientRequestBuilder.getStringInstance(
                        method,
                        uri,
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
                if (method == HTTPMethods.POST)
                    stringRequest.post(body, 1);
                else if (method == HTTPMethods.PUT)
                    stringRequest.put(body, 1);
                else
                    stringRequest.get(1);
                break;
            default:
                throw new IllegalArgumentException("Wrong network returnType");
        }
    }

    public void cancelAll() {
        requestQueue.cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> request) {
                return true;
            }
        });
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
            responseInterface.onSuccess((NetworkResponseInterface)networkResponse);
        }
    }
}

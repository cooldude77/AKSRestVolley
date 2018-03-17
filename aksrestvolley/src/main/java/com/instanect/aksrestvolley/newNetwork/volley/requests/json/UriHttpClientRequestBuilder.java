package com.instanect.aksrestvolley.newNetwork.volley.requests.json;

import android.content.Context;
import android.net.Uri;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by AKS on 3/9/2017.
 */

public class UriHttpClientRequestBuilder {

    private Context context;

    public UriHttpClientRequestBuilder(Context context) {

        this.context = context;
    }

    public static JSONObject getJsonInstanceRx(
            Context context,
            int method,
            final Uri uri,
            final HashMap<String, String> headers
    ) throws InterruptedException, ExecutionException, TimeoutException {


        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request =
                new JsonObjectRequest(
                        method,
                        uri.toString(),
                        null, future, future) {

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return headers;
                    }

                };

        RequestQueue queue = Volley.newRequestQueue(context);

        // Very IMPORTANT:
        // if we don't add this policy, we will get timeout errors
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);

        queue.add(request);

        return future.get(30, TimeUnit.SECONDS);
        // Block thread, waiting for response, timeout after 30 seconds
    }


    public UriHttpClientJsonObjectRequest getJsonObjectInstance(
            int method,
            Uri uri,
            HashMap<String, String> headers,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener
    ) {

        return new UriHttpClientJsonObjectRequest(
                context,
                method,
                uri.toString(),
                headers,
                listener,
                errorListener
        );
    }

    public UriHttpClientJsonArrayRequest getJsonArrayInstance(
            int method,
            Uri uri,
            HashMap<String, String> headers,
            Response.Listener<JSONArray> listener,
            Response.ErrorListener errorListener
    ) {

        return new UriHttpClientJsonArrayRequest(
                context,
                method,
                uri.toString(),
                headers,
                listener,
                errorListener
        );
    }

    public UriHttpClientStringRequest getStringInstance(
            int method,
            Uri uri,
            HashMap<String, String> headers,
            Response.Listener<String> listener,
            Response.ErrorListener errorListener
    ) {

        return new UriHttpClientStringRequest(
                context,
                method,
                uri.toString(),
                headers,
                listener,
                errorListener
        );
    }
}
package com.instanect.aksrestvolley.newNetwork.volley.requests.json;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Please add comments 6/6/2015.
 */

public class UriHttpClientJsonObjectRequest extends Request<JSONObject> {
    private final Response.Listener<JSONObject> listener;
    private final Response.ErrorListener errorListener;
    private final Context context;
    private final HashMap<String, String> headers;
    private HashMap<String, String> postOrPutBody;

    // constructor
    public UriHttpClientJsonObjectRequest(Context context,
                                          int method,
                                          String uri,// in case of GET, pass the parameters attached in the URL itself
                                          HashMap<String, String> headers,
                                          Response.Listener<JSONObject> listener,
                                          Response.ErrorListener errorListener
    ) {
        super(method, uri, errorListener);
        this.listener = listener;
        this.context = context;
        this.headers = headers;
        this.errorListener = errorListener;
    }

    @Override
    protected void deliverResponse(JSONObject response) {
        listener.onResponse(response);
    }

    @Override
    public void deliverError(VolleyError error) {
        String url = getUrl();
        Log.d("Instanect-Debug", url);
        errorListener.onErrorResponse(error);

    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString =
                    new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public Map<String, String> getParams() {

        return postOrPutBody;
    }

    public void post(HashMap<String, String> postBody, Integer noOfTries) {

        this.postOrPutBody = postBody;
        process(noOfTries);
    }

    public void put(HashMap<String, String> putBody, Integer noOfTries) {

        this.postOrPutBody = putBody;
        process(noOfTries);
    }

    public void get(Integer noOfTries) {
        Log.d("Instanect-Debug:", getUrl());
        if (headers != null)
            Log.d("Instanect-Debug", this.headers.toString());
        process(noOfTries);
    }

    private void process(Integer noOfTries) {
        // if (noOfTries == null) {
        noOfTries = DefaultRetryPolicy.DEFAULT_MAX_RETRIES;
        //}

        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                noOfTries,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        );
        this.setRetryPolicy(policy);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(this);
    }

    public void delete(int i) {
        process(i);
    }
}


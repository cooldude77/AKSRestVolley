package com.instanect.aksrestvolley.newNetwork.volley.requests.builder;

import android.content.Context;
import android.net.Uri;

import com.android.volley.Response;
import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientJsonArrayRequest;
import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientJsonObjectRequest;
import com.instanect.aksrestvolley.newNetwork.volley.requests.json.UriHttpClientStringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by AKS on 3/9/2017.
 */

public class UriHttpClientRequestBuilder {

    private Context context;

    public UriHttpClientRequestBuilder(Context context) {

        this.context = context;
    }


    public UriHttpClientJsonObjectRequest getJsonObjectInstance(
            int method,
            Uri uri,
            HashMap<String, String> headers,
            HashMap<String, String> body,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener
    ) {

        return new UriHttpClientJsonObjectRequest(
                context,
                method,
                uri.toString(),
                headers,
                body,
                listener,
                errorListener
        );
    }

    public UriHttpClientJsonArrayRequest getJsonArrayInstance(
            int method,
            Uri uri,
            HashMap<String, String> headers,
            HashMap<String, String> body,
            Response.Listener<JSONArray> listener,
            Response.ErrorListener errorListener
    ) {

        return new UriHttpClientJsonArrayRequest(
                context,
                method,
                uri.toString(),
                headers,
                body,
                listener,
                errorListener
        );
    }

    public UriHttpClientStringRequest getStringInstance(
            int method,
            Uri uri,
            HashMap<String, String> headers,
            HashMap<String, String> body,
            Response.Listener<String> listener,
            Response.ErrorListener errorListener
    ) {

        return new UriHttpClientStringRequest(
                context,
                method,
                uri.toString(),
                headers,
                body,
                listener,
                errorListener
        );
    }
}
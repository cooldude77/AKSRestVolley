package com.instanect.aksrestvolley.newNetwork.volley.requests;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;

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
    private final HashMap<String, String> headers;
    private final HashMap<String, String> body;
    private final int method;
    private final String uri;
    private HashMap<String, String> postOrPutBody;

    // constructor
    public UriHttpClientJsonObjectRequest(
            int method,
            String uri,// in case of GET, pass the parameters attached in the URL itself
            HashMap<String, String> headers,
            HashMap<String, String> body,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener
    ) {
        super(method, uri, errorListener);

        this.method = method;
        this.uri = uri;
        this.headers = headers;
        this.body = body;
        this.listener = listener;
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


}


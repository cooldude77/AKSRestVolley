package com.instanect.aksrestvolley.newNetwork.volley.requests.json;

import android.content.Context;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Please add comments 6/6/2015.
 */

public class UriHttpClientJsonArrayRequest extends Request<JSONArray> {
    private final HashMap<String, String> body;
    private final Response.Listener<JSONArray> listener;
    private final Response.ErrorListener errorListener;
    private final Context context;
    private final HashMap<String, String> headers;
    private HashMap<String, String> postOrPutBody;

    // constructor
    public UriHttpClientJsonArrayRequest(Context context,
                                         int method,
                                         String uri,// in case of GET, pass the parameters attached in the URL itself
                                         HashMap<String, String> headers,
                                         HashMap<String, String> body,
                                         Response.Listener<JSONArray> listener,
                                         Response.ErrorListener errorListener
    ) {
        super(method, uri, errorListener);
        this.body = body;
        this.listener = listener;
        this.context = context;
        this.headers = headers;
        this.errorListener = errorListener;
    }

    @Override
    protected void deliverResponse(JSONArray response) {
        listener.onResponse(response);
    }

    @Override
    public void deliverError(VolleyError error) {
        String url = getUrl();
        Log.d("Instanect-Debug", url);
        errorListener.onErrorResponse(error);

    }

    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString =
                    new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONArray(jsonString),
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


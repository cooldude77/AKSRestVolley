package com.instanect.aksrestvolley.newNetwork.volley.requests.json;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AKS on 1/10/2017.
 */

public class UriHttpClientStringRequest extends StringRequest {


    private final Context context;
    private final int method;
    private final String url;
    private final Response.Listener<String> listener;
    private final Response.ErrorListener errorListener;
    private RequestQueue requestQueue;
    private Map<String, String> headers = new HashMap<>();
    private HashMap<String, String> postOrPutBody;


    public UriHttpClientStringRequest(Context context,
                                      int method,
                                      String url,
                                      HashMap<String, String> headers,
                                      HashMap<String, String> postOrPutBody,
                                      Response.Listener<String> listener,
                                      Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);


        this.context = context;
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.postOrPutBody = postOrPutBody;
        this.listener = listener;
        this.errorListener = errorListener;
    }

    @Override
    protected Map<String, String> getParams() {
        return postOrPutBody;
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null && headers.isEmpty() ? headers : super.getHeaders();
    }


}

package com.instanect.aksrestvolley.newNetwork.volley.request.di;

import com.android.volley.RequestQueue;
import com.instanect.aksrestvolley.newNetwork.NetworkRequestCancellableInterface;

public class VolleyRequestQueueCompositionWrapper implements NetworkRequestCancellableInterface {

    private RequestQueue requestQueue;

    public VolleyRequestQueueCompositionWrapper(RequestQueue requestQueue) {

        this.requestQueue = requestQueue;
    }

    @Override
    public void cancelAll(String tag) {
        requestQueue.cancelAll(tag);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}

package com.instanect.aksrestvolley.newNetwork.volley.request.di;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.instanect.aksrestvolley.newNetwork.NetworkRequestCancellableInterface;

public class VolleyRequestQueueCompositionWrapper implements NetworkRequestCancellableInterface {

    private RequestQueue requestQueue;

    private static VolleyRequestQueueCompositionWrapper instance;

    private VolleyRequestQueueCompositionWrapper(Context context) {
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public static synchronized VolleyRequestQueueCompositionWrapper getInstance(Context context) {
        if (instance == null)
            instance = new VolleyRequestQueueCompositionWrapper(context);

        return instance;

    }

    @Override
    public void cancelAll(String tag) {
        requestQueue.cancelAll(tag);
    }


    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}

package com.instanect.aksrestvolley.newNetwork.volley.request.di;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/14/2017.
 */

@Module
public class RequestQueueModule {

    private Context context;

    public RequestQueueModule(Context context) {

        this.context = context;
    }

    @Provides
    public RequestQueue provideRequestQueue() {
        return Volley.newRequestQueue(context);
    }

}

package com.instanect.aksrestvolley.newNetwork.volley.request.di;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/14/2017.
 */

@Module
public class VolleyRequestQueueCompositionWrapperModule {

    private Context context;

    public VolleyRequestQueueCompositionWrapperModule(Context context) {

        this.context = context;
    }

    @Provides
    public VolleyRequestQueueCompositionWrapper provideRequestQueue() {
        return
                new VolleyRequestQueueCompositionWrapper(Volley.newRequestQueue(context));
    }

}

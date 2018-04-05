package com.instanect.aksrestvolley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.instanect.aksrestvolley.application.MainApplication;
import com.instanect.aksrestvolley.newNetwork.common.api.di.DaggerRESTNetworkApiComponent;
import com.instanect.aksrestvolley.newNetwork.di.NetworkService;

import javax.inject.Inject;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by AKS on 3/27/2018.
 */

public class AKSRestVolleyActivity extends AppCompatActivity {

    @Inject
    NetworkService networkService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getApplication())
                .getAppComponent().inject(this);

        DaggerRESTNetworkApiComponent.builder().build();

        assertNotNull(networkService);
    }
}

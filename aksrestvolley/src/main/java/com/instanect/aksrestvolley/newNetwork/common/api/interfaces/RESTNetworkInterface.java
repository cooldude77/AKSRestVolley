package com.instanect.aksrestvolley.newNetwork.common.api.interfaces;

import android.net.Uri;

import com.instanect.networkcommon.NetworkInterface;

import java.util.HashMap;

/**
 * Created by AKS on 10/5/2017.
 */

public interface RESTNetworkInterface extends NetworkInterface{

    void execute(
            int requestId,
            Uri uri,
            int method,
            HashMap<String, String> header,
            HashMap<String, String> body,
            int returnType);

    void setResponseInterface(RESTNetworkResponseInterface responseInterface);
}

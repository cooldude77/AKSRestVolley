package com.instanect.aksrestvolley.newNetwork.common.node.implementations;

import android.util.Log;

import com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes.UriGETTravelNode;

import java.util.HashMap;

/**
 * Created by AKS on 10/4/2017.
 */

public class RootTravelNode extends UriGETTravelNode {

    public RootTravelNode(HashMap<String, String> header,
                          String query,
                          int returnType) {

        super(null,null, header, returnType);
        Log.d("RootTravelNode", "Created");
    }

}

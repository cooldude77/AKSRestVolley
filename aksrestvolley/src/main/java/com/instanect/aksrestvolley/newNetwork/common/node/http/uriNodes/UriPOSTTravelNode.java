package com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes;

import android.net.Uri;

import com.instanect.aksrestvolley.newNetwork.common.network.HTTPMethods;
import com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes.base.AbstractUriTravelNode;

import java.util.HashMap;

/**
 * Created by AKS on 10/4/2017.
 */

public class UriPOSTTravelNode extends AbstractUriTravelNode {
    public UriPOSTTravelNode(Uri uri,
                             String query,
                             HashMap<String, String> header,
                             HashMap<String, String> body,
                             int returnType) {
        super(uri, query,HTTPMethods.POST, header, body, returnType);
    }
}

package com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes.base;

import android.net.Uri;

import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;

import java.util.HashMap;

/**
 * Created by AKS on 10/5/2017.
 */

public class AbstractUriTravelNode extends AbstractTravelNode {
    private Uri uri;

    public AbstractUriTravelNode(Uri uri,
                                 String query,
                                 int method,
                                 HashMap<String, String> header,
                                 HashMap<String, String> body,
                                 int returnType) {
        super(method, query,header, body, returnType);

        this.uri = uri;
    }

    public AbstractUriTravelNode(Uri uri,
                                 String query,
                                 int method,
                                 HashMap<String, String> header,
                                 int returnType) {
        this(uri,query, method, header, null, returnType);

    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}

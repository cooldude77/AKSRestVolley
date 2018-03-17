package com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.base;

import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;

import java.util.HashMap;

/**
 * Created by AKS on 10/5/2017.
 */

public class AbstractKeyTravelNode extends AbstractTravelNode {
    private final String nextIdentifierKey;

    public <T> AbstractKeyTravelNode(String nextIdentifierKey,
                                     int method,
                                     String query,
                                     HashMap<String, String> header,
                                     HashMap<String, String> body,
                                     int returnType) {
        super(method,query, header, body, returnType);

        this.nextIdentifierKey = nextIdentifierKey;
    }

    public String getNextIdentifierKey() {
        return nextIdentifierKey;
    }
}

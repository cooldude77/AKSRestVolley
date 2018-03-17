package com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased;

import com.instanect.aksrestvolley.newNetwork.common.network.HTTPMethods;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.base.AbstractKeyTravelNode;

import java.util.HashMap;

/**
 * Created by AKS on 10/5/2017.
 */

public class KeyPOSTTravelNode extends AbstractKeyTravelNode {

    private String key;

    public <T> KeyPOSTTravelNode(String nextIdentifierKey,
                                 String query,
                                 HashMap<String, String> header,
                                 HashMap<String, String> body,
                                 int returnType) {
        super(nextIdentifierKey, HTTPMethods.POST,  query, header, body, returnType);

    }

}

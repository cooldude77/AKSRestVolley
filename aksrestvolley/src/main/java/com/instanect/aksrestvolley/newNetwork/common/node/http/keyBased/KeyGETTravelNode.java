package com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased;

import com.instanect.aksrestvolley.newNetwork.common.network.HTTPMethods;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.base.AbstractKeyTravelNode;

import java.util.HashMap;

/**
 * Created by AKS on 10/5/2017.
 */

public class KeyGETTravelNode extends AbstractKeyTravelNode {

    private final String nextIdentifierKey;

    public <T> KeyGETTravelNode(String nextIdentifierKey,
                                String query,
                                HashMap<String, String> header,
                                int returnType) {
        super(nextIdentifierKey,  HTTPMethods.GET,query, header, null, returnType);

        this.nextIdentifierKey = nextIdentifierKey;
    }

    public String getNextIdentifierKey() {
        return nextIdentifierKey;
    }
}

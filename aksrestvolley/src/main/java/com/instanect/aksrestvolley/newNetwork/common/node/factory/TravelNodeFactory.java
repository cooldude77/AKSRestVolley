package com.instanect.aksrestvolley.newNetwork.common.node.factory;


import android.net.Uri;

import com.instanect.aksrestvolley.newNetwork.common.node.constants.NetworkCallReturnType;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.KeyDELETETravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.KeyGETTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.KeyPOSTTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.keyBased.KeyPUTTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes.UriGETTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes.UriPOSTTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.http.uriNodes.UriPUTTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.implementations.RootTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.node.interfaces.TravelNodeInterface;

import java.util.HashMap;

/**
 * Created by AKS on 5/2/2016.
 */
public class TravelNodeFactory {
    public TravelNodeInterface getInstance(
            Class<? extends TravelNodeInterface> travelNodeClass,
            Uri uri,
            String uriQuery,
            String key,
            HashMap<String, String> header,
            HashMap<String, String> body,
            int returnType) {

        if (travelNodeClass.equals(RootTravelNode.class))
            return new RootTravelNode(header, uriQuery, NetworkCallReturnType.JSON_OBJECT);
        else if (travelNodeClass.equals(KeyGETTravelNode.class))
            return new KeyGETTravelNode(key, uriQuery, header, returnType);
        else if (travelNodeClass.equals(KeyPOSTTravelNode.class))
            return new KeyPOSTTravelNode(key, uriQuery, header, body, returnType);
        else if (travelNodeClass.equals(KeyPUTTravelNode.class))
            return new KeyPUTTravelNode(key, uriQuery, header, body, returnType);
        else if (travelNodeClass.equals(KeyDELETETravelNode.class))
            return new KeyDELETETravelNode(key, uriQuery, header, body, returnType);
        else if (travelNodeClass.equals(UriGETTravelNode.class))
            return new UriGETTravelNode(uri, uriQuery, header, returnType);
        else if (travelNodeClass.equals(UriPUTTravelNode.class))
            return new UriPUTTravelNode(uri, uriQuery, header, body, returnType);
        else if (travelNodeClass.equals(UriPOSTTravelNode.class))
            return new UriPOSTTravelNode(uri, uriQuery, header, body, returnType);

        throw new IllegalArgumentException("No such travel Interface class");
    }
/*
    public


    new PagedTravelNode(    // paged travel node
                            "usersDisconnectedSince",
                                    new SaveDisconnectedUsersProcessor(getContext(),

    public AbstractTravelNode getRootTravelNode(String homeUri) {
        return  new RootTravelNode(homeUri);
    }

    public AbstractTravelNode getTravelNode(String connections, BaseTravelProcessor processor, int get, String queryString) {
        new AbstractTravelNode("connections", processor,Request.Method.GET, queryString);
        return null;
    }

    public AbstractTravelNode getPagedTravelNode(String usersDisconnectedSince, SaveRegisteredUserProcessor processor, int get, Object o, Object o1) {
        return null;
    }

    modelFactory
    ),
    Request.Method.GET,
    query,
            null
            )
*/
}

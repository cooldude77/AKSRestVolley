package com.instanect.aksrestvolley.newNetwork.common.node.base;

import com.instanect.aksrestvolley.newNetwork.common.node.interfaces.TravelNodeInterface;

import java.util.HashMap;

/**
 * Abstract class for all travel Nodes
 */

public abstract class AbstractTravelNode implements TravelNodeInterface {
    private final HashMap<String, String> header;
    private HashMap<String, String> body;
    private int returnType;
    private int method;
    private String query;

    public AbstractTravelNode(
            int method,
            String query,
            HashMap<String, String> header,
            int returnType) {

        this(method, query,header, null, returnType);
    }

    public AbstractTravelNode(
            int method,
            String query,
            HashMap<String, String> header,
            HashMap<String, String> body,
            int returnType) {

        this.method = method;
        this.query = query;
        this.header = header;
        this.body = body;
        this.returnType = returnType;
    }


    public HashMap<String, String> getHeader() {
        return header;
    }

    public int getMethod() {
        return method;
    }

    public HashMap<String, String> getBody() {
        return body;
    }

    public int getReturnType() {
        return returnType;
    }


    public String getQuery() {
        return query;
    }
}

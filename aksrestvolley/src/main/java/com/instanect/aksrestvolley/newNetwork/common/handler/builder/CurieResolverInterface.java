package com.instanect.aksrestvolley.newNetwork.common.handler.builder;

import org.json.JSONObject;

/**
 * Created by AKS on 10/17/2017.
 */

public interface CurieResolverInterface {

    String getUri(String key, JSONObject jsonObject) throws CurieResolverKeyNotFoundException;
}

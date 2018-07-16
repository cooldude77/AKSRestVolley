package com.instanect.sample.application;

import com.instanect.aksrestvolley.newNetwork.common.handler.builder.CurieResolverInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.CurieResolverKeyNotFoundException;

import org.json.JSONObject;

class CurieResolver implements CurieResolverInterface {
    @Override
    public String getUri(String key, JSONObject jsonObject) throws CurieResolverKeyNotFoundException {
        return null;
    }
}

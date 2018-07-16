package com.instanect.aksrestvolley.newNetwork.common.handler.builder;

public class CurieResolverKeyNotFoundException extends Exception {

    CurieResolverKeyNotFoundException(String key) {

        super(key + "not found in the result value ");
    }
}

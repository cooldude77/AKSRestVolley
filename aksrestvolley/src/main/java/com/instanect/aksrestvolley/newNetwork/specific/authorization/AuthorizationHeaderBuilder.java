package com.instanect.aksrestvolley.newNetwork.specific.authorization;

import com.instanect.aksrestvolley.newNetwork.common.authorization.AuthorizationHeaderInterface;

/**
 * Created by AKS on 10/5/2017.
 */

public class AuthorizationHeaderBuilder {

    public AuthorizationHeaderInterface getInstanceWithDetails(
            String username,
            String password,
            String token
    ) {
        return new AuthorizationHeader(username, password, token);
    }

    public AuthorizationHeaderInterface getInstanceWithToken(
            String email, String token
    ) {
        return new AuthorizationHeader(email, null, token);
    }
    public AuthorizationHeaderInterface getInstance() {
        return new AuthorizationHeader();
    }
}

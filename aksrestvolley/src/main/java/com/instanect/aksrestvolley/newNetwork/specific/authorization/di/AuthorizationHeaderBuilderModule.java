package com.instanect.aksrestvolley.newNetwork.specific.authorization.di;


import com.instanect.aksrestvolley.newNetwork.specific.authorization.AuthorizationHeaderBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/6/2017.
 */

@Module
public class AuthorizationHeaderBuilderModule {

    @Provides
    public AuthorizationHeaderBuilder provideAuthorizationHeaderBuilder() {
        return new AuthorizationHeaderBuilder();
    }

}

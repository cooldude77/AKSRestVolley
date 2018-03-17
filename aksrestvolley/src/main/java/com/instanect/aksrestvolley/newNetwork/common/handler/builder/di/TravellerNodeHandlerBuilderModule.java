package com.instanect.aksrestvolley.newNetwork.common.handler.builder.di;

import com.instanect.aksrestvolley.business.declarations.uri.ApiUriDeclaration;
import com.instanect.aksrestvolley.network.rest.resolver.CurieResolver;
import com.instanect.aksrestvolley.newNetwork.common.api.RESTNetworkApi;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.TravelNodeHandlerBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/25/2017.
 */
@Module
public class TravellerNodeHandlerBuilderModule {

    @Provides
    TravelNodeHandlerBuilder provideTravelNodeHandlerBuilder(
            RESTNetworkApi restNetwork,
            CurieResolver curieResolver,
            ApiUriDeclaration apiDeclaration) {
        return new TravelNodeHandlerBuilder(
                restNetwork,
                curieResolver,
                apiDeclaration
        );
    }
}

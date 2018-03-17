package com.instanect.aksrestvolley.newNetwork.common.handler.builder.di;

import com.instanect.aksrestvolley.newNetwork.common.api.RESTNetworkApi;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.CurieResolverInterface;
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
            CurieResolverInterface curieResolverInterface,
            ApiUriDeclarationInterface apiUriDeclarationInterface) {
        return new TravelNodeHandlerBuilder(
                restNetwork,
                curieResolverInterface,
                apiUriDeclarationInterface
        );
    }
}

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


    private RESTNetworkApi restNetwork;
    private CurieResolverInterface curieResolverInterface;
    private ApiUriDeclarationInterface apiUriDeclarationInterface;

    public TravellerNodeHandlerBuilderModule(CurieResolverInterface curieResolverInterface, ApiUriDeclarationInterface apiUriDeclarationInterface) {
        this.curieResolverInterface = curieResolverInterface;
        this.apiUriDeclarationInterface = apiUriDeclarationInterface;
    }

    @Provides
    TravelNodeHandlerBuilder provideTravelNodeHandlerBuilder(
            RESTNetworkApi restNetwork) {
        return new TravelNodeHandlerBuilder(
                restNetwork,
                curieResolverInterface,
                apiUriDeclarationInterface
        );
    }
}

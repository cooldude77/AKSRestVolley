package com.instanect.aksrestvolley.newNetwork.common.handler.builder.di;

import com.instanect.aksrestvolley.business.declarations.uri.di.ApiUriDeclarationComponent;
import com.instanect.aksrestvolley.network.rest.resolver.di.CurieResolverComponent;
import com.instanect.aksrestvolley.newNetwork.common.api.di.RESTNetworkApiComponent;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.TravelNodeHandlerBuilder;

import dagger.Component;

/**
 * Created by AKS on 10/25/2017.
 */

@Component(modules = TravellerNodeHandlerBuilderModule.class,
        dependencies =
                {ApiUriDeclarationComponent.class,
                        CurieResolverComponent.class,
                        RESTNetworkApiComponent.class})
public interface TravellerNodeHandlerBuilderComponent {

    TravelNodeHandlerBuilder getTravelNodeHandlerBuilder();
}

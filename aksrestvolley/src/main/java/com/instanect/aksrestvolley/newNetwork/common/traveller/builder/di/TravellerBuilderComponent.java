package com.instanect.aksrestvolley.newNetwork.common.traveller.builder.di;

import com.instanect.aksrestvolley.newNetwork.common.handler.service.di.TravelNodeHandlerServiceComponent;
import com.instanect.aksrestvolley.newNetwork.common.traveller.builder.TravellerBuilder;

import dagger.Component;

/**
 * Created by AKS on 10/16/2017.
 */

@Component(modules = {TravellerBuilderModule.class},
        dependencies = {TravelNodeHandlerServiceComponent.class})
public interface TravellerBuilderComponent {
    TravellerBuilder getTravellerBuilder();
}

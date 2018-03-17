package com.instanect.aksrestvolley.newNetwork.common.handler.service.di;

import com.instanect.aksrestvolley.newNetwork.common.handler.builder.di.TravellerNodeHandlerBuilderComponent;
import com.instanect.aksrestvolley.newNetwork.common.handler.service.TravelNodeHandlerService;

import dagger.Component;

/**
 * Created by AKS on 10/25/2017.
 */

@Component(modules = TravelNodeHandlerServiceModule.class,
        dependencies = {TravellerNodeHandlerBuilderComponent.class})
public interface TravelNodeHandlerServiceComponent {

    TravelNodeHandlerService getTravelNodeHandlerService();
}

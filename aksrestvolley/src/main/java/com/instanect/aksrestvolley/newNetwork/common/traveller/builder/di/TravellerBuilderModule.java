package com.instanect.aksrestvolley.newNetwork.common.traveller.builder.di;

import com.instanect.aksrestvolley.newNetwork.common.api.di.RESTNetworkApiModule;
import com.instanect.aksrestvolley.newNetwork.common.handler.service.TravelNodeHandlerService;
import com.instanect.aksrestvolley.newNetwork.common.traveller.builder.TravellerBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/16/2017.
 */
@Module(includes = {RESTNetworkApiModule.class})
public class TravellerBuilderModule {


    @Provides
    TravellerBuilder provideTravellerBuilderModule(TravelNodeHandlerService travelNodeHandlerService) {

        return new TravellerBuilder(travelNodeHandlerService);
    }
}

package com.instanect.aksrestvolley.newNetwork.common.handler.service.di;

import com.instanect.aksrestvolley.newNetwork.common.handler.builder.TravelNodeHandlerBuilder;
import com.instanect.aksrestvolley.newNetwork.common.handler.service.TravelNodeHandlerService;
import com.instanect.aksrestvolley.newNetwork.common.handler.service.TravellerNodeToHandlerMatcher;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/16/2017.
 */
@Module
public class TravelNodeHandlerServiceModule {


    @Provides
    public TravelNodeHandlerService provideTravelNodeHandlerService(
            TravelNodeHandlerBuilder travelNodeHandlerBuilder,
            TravellerNodeToHandlerMatcher travellerNodeToHandlerMatcher
    ) {

        return new TravelNodeHandlerService(travelNodeHandlerBuilder, travellerNodeToHandlerMatcher);
    }

    @Provides
    TravellerNodeToHandlerMatcher provideTravellerNodeToHandlerMatcher() {
        return new TravellerNodeToHandlerMatcher();
    }

}

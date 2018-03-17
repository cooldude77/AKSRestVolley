package com.instanect.aksrestvolley.newNetwork.common.traveller.builder;

import com.instanect.aksrestvolley.newNetwork.common.handler.service.TravelNodeHandlerService;
import com.instanect.aksrestvolley.newNetwork.common.traveller.Traveller;
import com.instanect.aksrestvolley.newNetwork.common.traveller.interfaces.TravellerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.traveller.map.TravelMap;

/**
 * Created by AKS on 10/5/2017.
 */

public class TravellerBuilder {

    private TravelNodeHandlerService travelNodeHandlerService;

    public TravellerBuilder(TravelNodeHandlerService travelNodeHandlerService) {

        this.travelNodeHandlerService = travelNodeHandlerService;
    }

    public Traveller getInstance(
            TravelMap travelMap,
            TravellerResponseInterface travellerResponseInterface
    ) {
        return new Traveller(travelMap,
                travelNodeHandlerService,
                travellerResponseInterface);
    }
}

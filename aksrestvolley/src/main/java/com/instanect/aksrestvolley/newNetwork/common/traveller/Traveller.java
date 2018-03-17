package com.instanect.aksrestvolley.newNetwork.common.traveller;

import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.interfaces.TravelNodeHandlerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.service.TravelNodeHandlerService;
import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;
import com.instanect.aksrestvolley.newNetwork.common.responseObject.NetworkResponse;
import com.instanect.aksrestvolley.newNetwork.common.traveller.interfaces.TravellerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.traveller.map.TravelMap;

/**
 * Traveller
 */

public class Traveller implements
        TravelNodeHandlerResponseInterface {

    private boolean abortTravel = false;
    private TravelMap travelMap;
    private TravelNodeHandlerService travelNodeHandlerService;
    private TravellerResponseInterface travellerResponseInterface;

    public Traveller(
            TravelMap travelMap,
            TravelNodeHandlerService travelNodeHandlerService,
            TravellerResponseInterface travellerResponseInterface) {

        this.travelMap = travelMap;
        this.travelNodeHandlerService = travelNodeHandlerService;
        this.travellerResponseInterface = travellerResponseInterface;
        abortTravel = false;
    }

    public <T> void travel(NetworkResponse<T> networkResponse) {

        if (abortTravel) {
            resetAbortTravelFlag();
            travellerResponseInterface.onTravellerAbort();
            return;
        }

        AbstractTravelNode travelNode = travelMap.getNextTravelNode();

        if (travelNode == null) {
            travellerResponseInterface.onSuccess(networkResponse);
            return;
        }

        // get handler
        TravelNodeHandlerInterface travelNodeHandlerInterface
                = travelNodeHandlerService.getHandler(travelNode, networkResponse, this);

        // handle
        travelNodeHandlerInterface.handle();

    }

    private void resetAbortTravelFlag() {
        abortTravel = false;
    }

    @Override
    public void onError(String errorMessage, int errorCode) {
        travellerResponseInterface.onError(errorMessage, errorCode);
    }

    @Override
    public <T> void onSuccess(NetworkResponse<T> networkResponse) {
        travel(networkResponse);
    }

    public void abort() {
        abortTravel = true;
    }
}

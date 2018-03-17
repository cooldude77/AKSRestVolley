package com.instanect.aksrestvolley.newNetwork.common.traveller.map;

import com.instanect.aksrestvolley.newNetwork.common.node.base.AbstractTravelNode;

import java.util.LinkedList;

/**
 * Please add comments 8/21/2015.
 */
public class TravelMap {

    private final LinkedList<AbstractTravelNode> listTravelNode = new LinkedList<>();

    public void addTravelNode(AbstractTravelNode travelNode) {
        listTravelNode.add(travelNode);
    }

    public AbstractTravelNode getNextTravelNode() {
        if (!listTravelNode.isEmpty())
            return listTravelNode.remove();

        return null;

    }

}

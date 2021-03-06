package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.base;

import android.net.Uri;

import com.instanect.accountcommon.account.authorization.AuthorizationHeaderInterface;
import com.instanect.aksrestvolley.newNetwork.common.TravelMapBuilder;
import com.instanect.aksrestvolley.newNetwork.common.TravelMapListBuilder;
import com.instanect.aksrestvolley.newNetwork.common.node.factory.TravelNodeFactory;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.UrlScenarioInterface;

import java.util.HashMap;

/**
 * Created by AKS on 10/4/2017.
 */

abstract public class AbstractUrlScenario extends AbstractScenario implements UrlScenarioInterface {


    private final Uri uri;

    public AbstractUrlScenario(
            TravelMapBuilder travelMapBuilder,
            TravelNodeFactory travelNodeFactory,
            TravelMapListBuilder travelMapListBuilder,
            AuthorizationHeaderInterface authorizationHeaderInterface,
            String query,
            HashMap<String, String> postBody,
            Uri uri) {
        super(travelMapBuilder, travelNodeFactory, travelMapListBuilder, authorizationHeaderInterface, query, postBody);
        this.uri = uri;
    }

    public Uri getUri() {
        return uri;
    }
}

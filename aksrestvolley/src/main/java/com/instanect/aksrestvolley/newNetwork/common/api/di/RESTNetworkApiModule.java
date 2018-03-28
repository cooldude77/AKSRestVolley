package com.instanect.aksrestvolley.newNetwork.common.api.di;

import com.instanect.aksrestvolley.newNetwork.common.api.RESTNetworkApi;
import com.instanect.aksrestvolley.newNetwork.common.external.ExternalNetworkLibraryInterface;
import com.instanect.aksrestvolley.newNetwork.volley.api.di.VolleyApiModule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 10/14/2017.
 */

@Module(includes = {VolleyApiModule.class})
public class RESTNetworkApiModule {

    @Provides
    public RESTNetworkApi provideRESTNetworkApi(
            ExternalNetworkLibraryInterface externalNetworkLibraryInterface) {

        return new RESTNetworkApi(externalNetworkLibraryInterface);
    }


}

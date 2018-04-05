package com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.di;

import com.instanect.aksrestvolley.newNetwork.common.api.RESTNetworkApi;
import com.instanect.aksrestvolley.newNetwork.common.api.di.RESTNetworkApiModule;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.interfaces.InternetConnectionChecker;

import dagger.Module;
import dagger.Provides;

@Module(includes = {RESTNetworkApiModule.class})
public class InternetConnectionCheckerModule {

    private final ApiUriDeclarationInterface apiUriDeclarationInterface;

    public InternetConnectionCheckerModule(ApiUriDeclarationInterface apiUriDeclarationInterface) {

        this.apiUriDeclarationInterface = apiUriDeclarationInterface;
    }

    @Provides
    InternetConnectionChecker provideInternetConnectionChecker(RESTNetworkApi restNetworkApi) {

        return new InternetConnectionChecker(restNetworkApi, apiUriDeclarationInterface);
    }
}

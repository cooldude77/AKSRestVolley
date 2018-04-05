package com.instanect.aksrestvolley.newNetwork.di;

import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.CurieResolverInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.ScenarioService;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di.ScenarioServiceModule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 3/28/2018.
 */
@Module(includes = {ScenarioServiceModule.class})
public class AKSRestVolleyModule {


    private final CurieResolverInterface curieResolverInterface;
    private final ApiUriDeclarationInterface apiUriDeclarationInterface;

    public AKSRestVolleyModule(CurieResolverInterface curieResolverInterface,
                               ApiUriDeclarationInterface apiUriDeclarationInterface) {
        this.curieResolverInterface = curieResolverInterface;
        this.apiUriDeclarationInterface = apiUriDeclarationInterface;
    }

    @Provides
    public NetworkService provideNetworkService(ScenarioService scenarioService) {

        return new NetworkService(scenarioService, curieResolverInterface,
                apiUriDeclarationInterface);
    }

    // Do not delete

    /*
    ScenarioService scenarioService = new ScenarioService(
            new ScenarioBuilder(),
            new ScenarioExecutorBuilder(
                    new TravellerBuilder(
                            new TravelNodeHandlerService(
                                    new TravelNodeHandlerBuilder(
                                            new RESTNetworkApi(new VolleyApi(
                                                    new UriHttpClientRequestBuilder(context),
                                                    Volley.newRequestQueue(context)
                                            ),
                                                    new CurieResolverInterface(),
                                                    new ApiUriDeclarationInterface()
                                            )
                                    )
                            )
                    ),
                    new InternetConnectionChecker()
            );
    */
}

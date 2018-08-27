package com.instanect.aksrestvolley.newNetwork.di;


import android.content.Context;

import com.instanect.aksrestvolley.newNetwork.common.api.di.RESTNetworkApiModule;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.ApiUriDeclarationInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.CurieResolverInterface;
import com.instanect.aksrestvolley.newNetwork.common.handler.builder.di.TravellerNodeHandlerBuilderModule;
import com.instanect.aksrestvolley.newNetwork.common.handler.service.di.TravelNodeHandlerServiceModule;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.builder.di.ScenarioExecutorBuilderModule;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.builder.di.ScenarioBuilderModule;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.internet.di.InternetConnectionCheckerModule;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.ScenarioService;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di.DaggerScenarioServiceComponent;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.service.di.ScenarioServiceModule;
import com.instanect.aksrestvolley.newNetwork.common.traveller.builder.di.TravellerBuilderModule;
import com.instanect.aksrestvolley.newNetwork.volley.api.di.VolleyApiModule;
import com.instanect.aksrestvolley.newNetwork.volley.client.di.UriHttpClientRequestBuilderModule;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 3/28/2018.
 */
@Module
public class AKSRestVolleyModule {
    @Inject
    ScenarioService scenarioService;
    private Context context;
    private CurieResolverInterface curieResolver;
    private ApiUriDeclarationInterface apiUriDeclaration;

    public AKSRestVolleyModule(Context context, CurieResolverInterface curieResolver, ApiUriDeclarationInterface apiUriDeclaration) {
        this.context = context;
        this.curieResolver = curieResolver;
        this.apiUriDeclaration = apiUriDeclaration;
    }

    @Provides
    public NetworkService provideNetworkService() {

        DaggerScenarioServiceComponent.builder()
                .uriHttpClientRequestBuilderModule(
                        new UriHttpClientRequestBuilderModule(context))
                .rESTNetworkApiModule(new RESTNetworkApiModule(context))
                .volleyApiModule(new VolleyApiModule())
                .travellerBuilderModule(new TravellerBuilderModule())
                .travellerNodeHandlerBuilderModule(new TravellerNodeHandlerBuilderModule(
                        curieResolver,
                        apiUriDeclaration
                ))
                .travelNodeHandlerServiceModule(new TravelNodeHandlerServiceModule())
                .internetConnectionCheckerModule(
                        new InternetConnectionCheckerModule(apiUriDeclaration)
                )
                .scenarioBuilderModule(new ScenarioBuilderModule())
                .scenarioServiceModule(new ScenarioServiceModule())
                .scenarioExecutorBuilderModule(new ScenarioExecutorBuilderModule())
                .build().inject(this);

        return new NetworkService(scenarioService);
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

package com.instanect.aksrestvolley.newNetwork.common.scenario.executor;

import android.util.Log;

import com.instanect.aksrestvolley.newNetwork.LogTagGenerator;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.interfaces.ScenarioExecutionResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.executor.interfaces.ScenarioExecutorInterface;
import com.instanect.aksrestvolley.newNetwork.common.scenario.scenario.interfaces.ScenarioInterface;
import com.instanect.aksrestvolley.newNetwork.common.traveller.Traveller;
import com.instanect.aksrestvolley.newNetwork.common.traveller.builder.TravellerBuilder;
import com.instanect.aksrestvolley.newNetwork.common.traveller.interfaces.TravellerResponseInterface;
import com.instanect.aksrestvolley.newNetwork.common.traveller.map.TravelMap;
import com.instanect.networkcommon.NetworkResponseInterface;

import java.util.LinkedList;

/**
 * Scenario executor executes a scenario using travellers for
 * multiple travel maps and returns
 * the result
 */

public class ScenarioExecutor
        implements
        ScenarioExecutorInterface,
        TravellerResponseInterface {

    private final ScenarioInterface scenarioInterface;
    private final ScenarioExecutionResponseInterface scenarioExecutionResponseInterface;
    private final String TAG = LogTagGenerator.getTag(ScenarioExecutor.class);
    private TravellerBuilder travellerBuilder;
    private LinkedList<TravelMap> travelMaps;
    private Traveller traveller;
    private boolean abortExecution = false;

    public ScenarioExecutor(ScenarioInterface scenarioInterface,
                            TravellerBuilder travellerBuilder,
                            ScenarioExecutionResponseInterface
                                    scenarioExecutionResponseInterface) {

        this.scenarioInterface = scenarioInterface;
        this.travellerBuilder = travellerBuilder;
        this.scenarioExecutionResponseInterface = scenarioExecutionResponseInterface;
    }

    /**
     * Always called by external
     * resets abort flag so that last abort does not have an impact
     * internally calls executeNext
     */
    public void execute() {
        resetAbortExecutionFlag();
        executeNext(null);
    }

    public void execute(String tag) {
        resetAbortExecutionFlag();
        executeNext(null, tag);
    }

    private void executeNext(NetworkResponseInterface networkResponse) {

        executeNext(networkResponse, null);

    }

    private void executeNext(NetworkResponseInterface networkResponse, String tag) {


        travelMaps = scenarioInterface.getTravelMapList();

        TravelMap travelMap = travelMaps.remove();
        traveller = travellerBuilder
                .getInstance(travelMap, this);

        if (!abortExecution) {
            Log.d(TAG, "Scenario Execution Traveller Started...");
            traveller.travel(networkResponse, tag);
        } else {
            resetAbortExecutionFlag();
            scenarioExecutionResponseInterface.onScenarioExecutionAbort();
        }

    }

    private void resetAbortExecutionFlag() {
        abortExecution = false;
    }

    @Override
    public void onError(String errorMessage, int errorCode) {
        scenarioExecutionResponseInterface.onError(errorMessage, errorCode);
    }

    @Override
    public void onTravellerAbort() {
        Log.d(TAG, "Scenario Execution Traveller Aborted ...");
        scenarioExecutionResponseInterface.onScenarioExecutionAbort();
    }

    @Override
    public <T> void onSuccess(NetworkResponseInterface<T> networkResponse) {

        if (travelMaps.size() == 0)
            scenarioExecutionResponseInterface.onSuccess(networkResponse);
        else {
            executeNext(networkResponse);
        }
    }

    public void tryAbort() {

        if (traveller != null) {
            traveller.abort();

        }
        abortExecution = true;
    }
}

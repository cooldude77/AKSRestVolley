package com.instanect.aksrestvolley.newNetwork.common.external;

import android.net.Uri;

import java.util.HashMap;

/**
 * Created by AKS on 10/12/2017.
 */

public interface ExternalNetworkLibraryInterface {
    void execute(Uri uri,
                 int method,
                 HashMap<String, String> header,
                 HashMap<String, String> body,
                 int returnType,
                 ExternalNetworkLibraryResponseInterface responseInterface);

    void execute(Uri uri,
                 int method,
                 HashMap<String, String> header,
                 HashMap<String, String> body,
                 int returnType,
                 ExternalNetworkLibraryResponseInterface responseInterface,
                 String tag);

    void tryAbort();
}

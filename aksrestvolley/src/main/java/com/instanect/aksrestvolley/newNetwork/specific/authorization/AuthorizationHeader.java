package com.instanect.aksrestvolley.newNetwork.specific.authorization;

import android.util.Log;

import com.instanect.aksrestvolley.newNetwork.common.authorization.AuthorizationHeaderInterface;

import java.util.HashMap;

/**
 * Authorization Header creator class
 */
public class AuthorizationHeader implements AuthorizationHeaderInterface {

    private String username;
    private String password;
    private String token;

    public AuthorizationHeader(String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public AuthorizationHeader(String username, String password) {

        this(username, password, "");

    }

    public AuthorizationHeader() {

    }


    private HashMap<String, String> getAuthorizationHeaderMap(Boolean useToken) {

        String passwordOrToken = useToken ? token : password;
        Boolean isRaw = !useToken; // reverse of usetoken

        // string genericAlertDialogBuilder
        StringBuilder sb = new StringBuilder();

        sb.append("UsernameToken")
                .append(" ").append("Username=" + "\"").append(username).append("\"")
                .append(", ").append("Password=" + "\"").append(passwordOrToken).append("\"");

        if (isRaw) {
            sb.append(", ")
                    .append("isRaw=" + "\"" + true + "\"");
        }
        HashMap<String, String> map = new HashMap<>();

        map.put("X-WSSE", sb.toString());
        Log.w("AppMsg-X-WSSE", sb.toString());
        return map;

    }

    @Override
    public HashMap<String, String> getAuthorizationHeaderMapWithToken() {

        return getAuthorizationHeaderMap(true);
    }

    @Override
    public HashMap<String, String> getAuthorizationHeaderMapWithPassword() {

        return getAuthorizationHeaderMap(false);
    }

    @Override
    public HashMap<String, String> getDummyHeader() {

        HashMap<String, String> header = new HashMap<>();
        header.put("DUMMY", "LOGIN");

        return header;
    }


}

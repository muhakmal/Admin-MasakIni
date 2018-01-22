package com.baskom.miadmin.request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akmalmuhamad on 03/01/18.
 */

public class MasukAdminRequest extends StringRequest{
    private static final String LOGIN_ADMIN_REQUEST = "http://masakini.xyz/masakiniapi/LoginAdmin.php";
    private static Map<String,String> params;

    public MasukAdminRequest(String email, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_ADMIN_REQUEST, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }

    public static String getEmail(){
        return params.get("email");
    }
}
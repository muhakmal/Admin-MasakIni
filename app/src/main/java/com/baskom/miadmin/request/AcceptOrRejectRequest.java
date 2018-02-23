package com.baskom.miadmin.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lil G on 2/23/2018.
 */

public class AcceptOrRejectRequest extends StringRequest {
    Map<String, String> parameters = new HashMap<String, String>();

    public AcceptOrRejectRequest(String idTransaksi, String statusTransaksi, Response.Listener<String> listener) {
        super(Method.POST, "http://masakini.xyz/masakiniapi/AcceptOrRejectTransaksi.php", listener, null);
        parameters.put("nomorPesanan", idTransaksi);
        parameters.put("statusTransaksi", statusTransaksi);
    }

    @Override
    protected Map<String, String> getParams() {
        return parameters;
    }
}

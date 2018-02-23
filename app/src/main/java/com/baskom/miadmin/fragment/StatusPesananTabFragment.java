package com.baskom.miadmin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baskom.miadmin.R;
import com.baskom.miadmin.adapter.StatusPesananCardAdapter;
import com.baskom.miadmin.model.StatusPesanan;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class StatusPesananTabFragment extends android.support.v4.app.Fragment {

    RecyclerView recyclerView;
    StatusPesananCardAdapter adapter;
    private List<StatusPesanan> statusPesananList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_status_pesanan, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view_video);
        adapter = new StatusPesananCardAdapter(statusPesananList, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getStatusPesanan();
        return rootView;
    }

    public void getStatusPesanan() {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JsonArray jsonResponse = new JsonParser().parse(response).getAsJsonArray();
                Type listType = new TypeToken<List<StatusPesanan>>() {
                }.getType();
                statusPesananList = new Gson().fromJson(jsonResponse, listType);
                adapter.setStatusPesananList(statusPesananList);
                adapter.notifyDataSetChanged();
                //progressBar.setVisibility(View.GONE);
            }
        };
        StringRequest request = new StringRequest(Request.Method.GET,
                "http://masakini.xyz/masakiniapi/ItemTransaksiAdminStatusPesanan.php",
                responseListener, null);
        Volley.newRequestQueue(getContext().getApplicationContext()).add(request);
    }
}

    /*public void getStatusPesanan() {
        statusPesananList = new ArrayList<>();

        StatusPesanan statusPesanan = new StatusPesanan(
                "00001",
                "90's Cake",
                "5 Paket",
                "Jalan Manunggal II No.14 Kelurahan Rambutan, Kecamatan Ciracas, Jakarta Timur",
                "120000",
                "DITERIMA"
        );
        statusPesananList.add(statusPesanan);

        StatusPesanan statusPesanan1 = new StatusPesanan(
                "00001",
                "90's Cake",
                "5 Paket",
                "Jalan Manunggal II No.14 Kelurahan Rambutan, Kecamatan Ciracas, Jakarta Timur",
                "120000",
                "DITOLAK"

        );
        statusPesananList.add(statusPesanan1);

        adapter = new StatusPesananCardAdapter(statusPesananList);
        recyclerView.setAdapter(adapter);
    }*/

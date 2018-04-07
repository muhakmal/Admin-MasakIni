package com.baskom.miadmin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_status_pesanan, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view_video);
        swipeRefreshLayout = rootView.findViewById(R.id.swipeContainer_status_pesanan);
        adapter = new StatusPesananCardAdapter(statusPesananList, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getStatusPesanan();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getStatusPesanan();
                Toast.makeText(getContext(), "Data status pesanan telah diperbaharui.", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
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

package com.baskom.miadmin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baskom.miadmin.R;
import com.baskom.miadmin.adapter.DalamProsesCardAdapter;
import com.baskom.miadmin.model.DalamProses;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class DalamProsesTabFragment extends android.support.v4.app.Fragment {
    List<DalamProses> dalamProsesList = new ArrayList<>();
    RecyclerView recyclerView;
    DalamProsesCardAdapter adapter;
    ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dalam_proses, container, false);
        progressBar = rootView.findViewById(R.id.progressBar_dalam_proses);
        swipeRefreshLayout = rootView.findViewById(R.id.swipeContainer);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = rootView.findViewById(R.id.recycler_view_dalam_proses);
        adapter = new DalamProsesCardAdapter(dalamProsesList, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getDalamProsesList();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDalamProsesList();
                Toast.makeText(getContext(), "Data dalam proses telah diperbaharui.", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return rootView;
    }

    public void getDalamProsesList(){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JsonArray jsonResponse = new JsonParser().parse(response).getAsJsonArray();
                Type listType = new TypeToken<List<DalamProses>>(){}.getType();
                dalamProsesList = new Gson().fromJson(jsonResponse,listType);
                adapter.setDalamProsesList(dalamProsesList);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        };
        StringRequest request = new StringRequest(Request.Method.GET,
                "http://masakini.xyz/masakiniapi/ItemTransaksiAdminDalamProses.php",
                responseListener,null);
        Volley.newRequestQueue(getContext().getApplicationContext()).add(request);
    }


}

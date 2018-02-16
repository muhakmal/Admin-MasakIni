package com.baskom.miadmin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.miadmin.R;
import com.baskom.miadmin.adapter.StatusPesananCardAdapter;
import com.baskom.miadmin.model.StatusPesanan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class StatusPesananTabFragment extends android.support.v4.app.Fragment {

    RecyclerView recyclerView;
    StatusPesananCardAdapter adapter;
    private List<StatusPesanan> statusPesananList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_status_pesanan, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view_video);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        getVideoList();
        return rootView;
    }

    public void getVideoList() {
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
    }
}
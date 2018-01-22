package com.baskom.miadmin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.miadmin.R;
import com.baskom.miadmin.adapter.DalamProsesCardAdapter;
import com.baskom.miadmin.model.DalamProses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class DalamProsesTabFragment extends android.support.v4.app.Fragment {
    List<DalamProses> dalamProsesList = new ArrayList<>();
    RecyclerView recyclerView;
    DalamProsesCardAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dalam_proses, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view_dalam_proses);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        getDalamProsesList();
        return rootView;
    }

    public void getDalamProsesList() {
        dalamProsesList = new ArrayList<>();
        DalamProses dalamProses = new DalamProses(
                "00001",
                "90's Cake",
                "5 Paket",
                "Jalan Manunggal II No.14 Kelurahan Rambutan, Kecamatan Ciracas, Jakarta Timur",
                "120000"
        );
        dalamProsesList.add(dalamProses);

        DalamProses dalamProses2 = new DalamProses(
                "00001",
                "90's Cake",
                "5 Paket",
                "Jalan Manunggal II No.14 Kelurahan Rambutan, Kecamatan Ciracas, Jakarta Timur",
                "120000"
        );
        dalamProsesList.add(dalamProses2);
        adapter = new DalamProsesCardAdapter(dalamProsesList);
        recyclerView.setAdapter(adapter);
    }
}

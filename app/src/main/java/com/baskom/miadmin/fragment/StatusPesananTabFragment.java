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
                "90's Cake - MasakTV",
                "http://masakini.xyz/masakiniapi/video_thumbnail/90'scake_video_thumbnail.jpg",
                "https://youtu.be/ec3As5G7Tm0?list=PLoaIzBdYD0wYxJ9F5UaqihIb2cszbuUbu"
        );
        statusPesananList.add(statusPesanan);

        StatusPesanan statusPesanan1 = new StatusPesanan(
                "Ayam Goreng Saos Padang - MasakTV",
                "http://masakini.xyz/masakiniapi/video_thumbnail/ayamgorengpadang_video_thumbnail.jpg",
                "https://youtu.be/R5xg9jB3njo?list=PLoaIzBdYD0wYxJ9F5UaqihIb2cszbuUbu"

        );
        statusPesananList.add(statusPesanan1);

        StatusPesanan statusPesanan2 = new StatusPesanan(
                "Gulai Balungan - MasakTV",
                "http://masakini.xyz/masakiniapi/video_thumbnail/gulaibalungan__video_thumbnail.jpg",
                "https://youtu.be/q4e1ZHMaLQg?list=PLoaIzBdYD0wYxJ9F5UaqihIb2cszbuUbu"
        );
        statusPesananList.add(statusPesanan2);

        StatusPesanan statusPesanan3 = new StatusPesanan(
                "Gurame Saos Lemon - MasakTV",
                "http://masakini.xyz/masakiniapi/video_thumbnail/guramelemon_video_thumbnail.jpg",
                "https://youtu.be/KtcazjQdtbA?list=PLoaIzBdYD0wYxJ9F5UaqihIb2cszbuUbu"
        );
        statusPesananList.add(statusPesanan3);

        StatusPesanan statusPesanan4 = new StatusPesanan(
                "Nasi Bakar Bumbu Jontor",
                "http://masakini.xyz/masakiniapi/video_thumbnail/nasbakar_video_thumbnail.jpg",
                "https://youtu.be/dAa6bHXAMcw?list=PLoaIzBdYD0wYxJ9F5UaqihIb2cszbuUbu"
        );
        statusPesananList.add(statusPesanan4);

        adapter = new StatusPesananCardAdapter(statusPesananList);
        recyclerView.setAdapter(adapter);
    }
}
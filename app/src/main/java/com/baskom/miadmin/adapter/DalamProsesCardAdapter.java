package com.baskom.miadmin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.DalamProses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 23/11/17.
 */

public class DalamProsesCardAdapter extends RecyclerView.Adapter{

    private List<DalamProses> dalamProsesList = new ArrayList<>();

    public DalamProsesCardAdapter(List<DalamProses> dalamProsesList) {
        this.dalamProsesList.addAll(dalamProsesList);
    }

    public List<DalamProses> getDalamProsesList() {
        return dalamProsesList;
    }

    public void setDalamProsesList(List<DalamProses> dalamProsesList) {
        this.dalamProsesList = dalamProsesList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate new view when creating new items in recyclerview
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_dalam_proses, parent, false);
        return new DalamProsesCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if(holder.getItemViewType() == R.layout.card_dalam_proses){
            ((DalamProsesCardViewHolder) holder).bindData(dalamProsesList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dalamProsesList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.card_dalam_proses;
    }
}

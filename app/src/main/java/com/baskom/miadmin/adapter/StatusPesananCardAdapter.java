package com.baskom.miadmin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.StatusPesanan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 29/11/17.
 */

public class StatusPesananCardAdapter extends RecyclerView.Adapter {

    private List<StatusPesanan> statusPesananList = new ArrayList<>();
    Context context;

    public StatusPesananCardAdapter(List<StatusPesanan> statusPesananList, final Context context) {
        this.statusPesananList = statusPesananList;
        this.context = context;
    }

    public void setStatusPesananList(List<StatusPesanan> statusPesananList){
        this.statusPesananList = statusPesananList;
    }
    public List<StatusPesanan> getStatusPesananList(){return statusPesananList;}



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_status_pesanan, parent, false);
        return new StatusPesananCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder.getItemViewType() == R.layout.card_status_pesanan) {
            ((StatusPesananCardViewHolder) holder).bindData(statusPesananList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return statusPesananList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.card_status_pesanan;
    }
}

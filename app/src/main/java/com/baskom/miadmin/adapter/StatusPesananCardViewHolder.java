package com.baskom.miadmin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.StatusPesanan;

/**
 * Created by akmalmuhamad on 27/12/17.
 */

public class StatusPesananCardViewHolder extends RecyclerView.ViewHolder{
    private TextView tvNomorPesanan;
    private TextView tvNamaBahan;
    private TextView tvJumlahPesanan;
    private TextView tvStatus;
    public StatusPesananCardViewHolder(View itemView) {
        super(itemView);
        tvNomorPesanan = itemView.findViewById(R.id.tv_nomor_pesanan);
        tvNamaBahan = itemView.findViewById(R.id.tv_pesanan);
        tvJumlahPesanan = itemView.findViewById(R.id.tv_card_jumlahPaket);
        tvStatus = itemView.findViewById(R.id.tv_status_pesanan);
    }

    public void bindData(final StatusPesanan statusPesanan){
        tvNomorPesanan.setText(statusPesanan.getNomorPesanan());
        tvNamaBahan.setText(statusPesanan.getNamaBahan());
        tvJumlahPesanan.setText(statusPesanan.getJumlahBahan());
        tvStatus.setText(statusPesanan.getStatusPesanan());
    }
}
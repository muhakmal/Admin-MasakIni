package com.baskom.miadmin.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.StatusPesanan;
import com.bumptech.glide.Glide;

/**
 * Created by akmalmuhamad on 27/12/17.
 */

public class StatusPesananCardViewHolder extends RecyclerView.ViewHolder{
    private TextView nomorPesanan;
    private TextView namaBahanMasakan;
    private TextView jumlahPesanan;
    private TextView alamatPengiriman;
    private TextView harga;
    private TextView status;
    
    private CardView cardViewStatusPesanan;

    public StatusPesananCardViewHolder(View itemView) {
        super(itemView);
        nomorPesanan = itemView.findViewById(R.id.tv_card_noorder_status_pesanan);
        namaBahanMasakan = itemView.findViewById(R.id.tv_card_namaBahanMasakan_status_pesanan);
        jumlahPesanan = itemView.findViewById(R.id.tv_card_alamatPengiriman_status_pesanan);
        alamatPengiriman = itemView.findViewById(R.id.tv_card_alamatPengiriman_status_pesanan);
        harga = itemView.findViewById(R.id.tv_card_harga_status_pesanan);
        status = itemView.findViewById(R.id.tv_status_pesanan);
    }

    public void bindData(final StatusPesanan statusPesanan){
        nomorPesanan.setText(statusPesanan.getNomorPesanan());
        namaBahanMasakan.setText(statusPesanan.getNamaBahanMasakan());
        jumlahPesanan.setText(statusPesanan.getJumlahPesanan());
        alamatPengiriman.setText(statusPesanan.getAlamatPengiriman());
        harga.setText(statusPesanan.getHarga());
        if (statusPesanan.getStatus().contains("DITOLAK")){
            status.setText(statusPesanan.getStatus());
            status.setTextColor(Color.RED);
        }else {
            status.setText(statusPesanan.getStatus());
        }
    }
}

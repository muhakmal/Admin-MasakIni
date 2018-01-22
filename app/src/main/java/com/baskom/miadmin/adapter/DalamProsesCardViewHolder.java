package com.baskom.miadmin.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.DalamProses;

/**
 * Created by Castor on 12/5/2017.
 */

public class DalamProsesCardViewHolder extends RecyclerView.ViewHolder {
    private TextView tvNomorPesanan;
    private TextView tvNamaBahanMasakan;
    private TextView tvJumlahPesanan;
    private TextView tvAlamatPengiriman;
    private TextView tvHarga;
    private CardView cardView;
    private Button btnTolakPesanan;
    private Button btnTerimaPesanan;

    public DalamProsesCardViewHolder(View itemView) {
        super(itemView);
        tvNomorPesanan = itemView.findViewById(R.id.tv_card_noorder);
        tvNamaBahanMasakan = itemView.findViewById(R.id.tv_card_namaBahanMasakan);
        tvJumlahPesanan = itemView.findViewById(R.id.tv_card_jumlahPaket);
        tvAlamatPengiriman = itemView.findViewById(R.id.tv_card_alamatPengiriman);
        tvHarga = itemView.findViewById(R.id.tv_card_harga);
        cardView = itemView.findViewById(R.id.card_view_dalam_proses);
        btnTolakPesanan = itemView.findViewById(R.id.btn_tolak_pesanan);
        btnTerimaPesanan = itemView.findViewById(R.id.btn_terima_pesanan);
    }

    public void bindData(final DalamProses dalamProses) {
        tvNomorPesanan.setText(dalamProses.getNomorPesanan());
        tvNamaBahanMasakan.setText(dalamProses.getNamaBahanMasakan());
        tvJumlahPesanan.setText(dalamProses.getJumlahPesanan());
        tvAlamatPengiriman.setText(dalamProses.getAlamatPengiriman());
        tvHarga.setText(dalamProses.getHarga());
    }
}
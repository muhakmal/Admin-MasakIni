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
    private TextView nomorPesanan;
    private TextView namaBahanMasakan;
    private TextView jumlahPesanan;
    private TextView alamatPengiriman;
    private TextView harga;

    private CardView cardView;

    private Button tolakPesanan;
    private Button terimaPesanan;

    public DalamProsesCardViewHolder(View itemView) {
        super(itemView);
        nomorPesanan = itemView.findViewById(R.id.tv_card_noorder);
        namaBahanMasakan = itemView.findViewById(R.id.tv_card_namaBahanMasakan);
        jumlahPesanan = itemView.findViewById(R.id.tv_card_jumlahPaket);
        alamatPengiriman = itemView.findViewById(R.id.tv_card_alamatPengiriman);
        harga = itemView.findViewById(R.id.tv_card_harga);

        cardView = itemView.findViewById(R.id.card_view_dalam_proses);

        tolakPesanan = itemView.findViewById(R.id.btn_tolak_pesanan);
        terimaPesanan = itemView.findViewById(R.id.btn_terima_pesanan);
    }

    public void bindData(final DalamProses dalamProses) {
        nomorPesanan.setText(dalamProses.getNomorPesanan());
        String judulPesanan = "";
        for(int i = 0; i < dalamProses.getIsiPesanan().size(); i++){
            judulPesanan += " "+dalamProses.getIsiPesanan().get(i).getJudulResep();
        }
        namaBahanMasakan.setText(judulPesanan);
        jumlahPesanan.setText(Integer.toString(dalamProses.getIsiPesanan().size()));
        alamatPengiriman.setText(dalamProses.getPemesan().getAlamatLengkap());
        harga.setText("Rp "+Integer.toString(dalamProses.getTotalEstimasi()+20000));
    }



}

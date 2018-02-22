package com.baskom.miadmin.adapter;

import android.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.DalamProses;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.zip.Inflater;

/**
 * Created by Castor on 12/5/2017.
 */

public class DalamProsesCardViewHolder extends RecyclerView.ViewHolder {
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
    protected TextView nomorPesanan;
    protected TextView namaBahanMasakan;
    protected TextView jumlahPesanan;
    protected TextView alamatPengiriman;
    protected TextView harga;
    protected CardView cardView;
    protected Button btnTolakPesanan;
    protected Button btnTerimaPesanan;
    protected LayoutInflater inflater;

    public DalamProsesCardViewHolder(View itemView) {
        super(itemView);
        nomorPesanan = itemView.findViewById(R.id.tv_card_noorder);
        namaBahanMasakan = itemView.findViewById(R.id.tv_card_namaBahanMasakan);
        jumlahPesanan = itemView.findViewById(R.id.tv_card_jumlahPaket);
        alamatPengiriman = itemView.findViewById(R.id.tv_card_alamatPengiriman);
        harga = itemView.findViewById(R.id.tv_card_harga);
        cardView = itemView.findViewById(R.id.card_view_dalam_proses);
        btnTolakPesanan = itemView.findViewById(R.id.btn_tolak_pesanan);
        btnTerimaPesanan = itemView.findViewById(R.id.btn_terima_pesanan);
        inflater = LayoutInflater.from(itemView.getContext());
    }

    public void bindData(final DalamProses dalamProses) {
        nomorPesanan.setText(dalamProses.getNomorPesanan());
        String judulPesanan = "";
        for (int i = 0; i < dalamProses.getIsiPesanan().size(); i++) {
            judulPesanan += " " + dalamProses.getIsiPesanan().get(i).getJudulResep();
        }
        namaBahanMasakan.setText(judulPesanan);
        jumlahPesanan.setText(Integer.toString(dalamProses.getIsiPesanan().size())+ " Paket");
        alamatPengiriman.setText(dalamProses.getPemesan().getAlamatLengkap());
        harga.setText(formatRupiah.format(dalamProses.getTotalEstimasi()+ 20000));
    }


}

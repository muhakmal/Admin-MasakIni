package com.baskom.miadmin.adapter;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.baskom.miadmin.R;
import com.baskom.miadmin.model.StatusPesanan;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by akmalmuhamad on 27/12/17.
 */

public class StatusPesananCardViewHolder extends RecyclerView.ViewHolder{
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
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
        String judulPesanan = "";
        for (int i = 0; i < statusPesanan.getIsiPesanan().size();i++){
            judulPesanan += " " +statusPesanan.getIsiPesanan().get(i).getJudulResep();
        }
        namaBahanMasakan.setText(judulPesanan);
        jumlahPesanan.setText(Integer.toString(statusPesanan.getIsiPesanan().size())+ " Paket");
        alamatPengiriman.setText(statusPesanan.getPemesan().getAlamatLengkap());
        harga.setText(formatRupiah.format(statusPesanan.getTotalEstimasi()+20000));
        if (statusPesanan.getStatusPesanan().contains("Ditolak")){
            status.setText(statusPesanan.getStatusPesanan());
            status.setTextColor(Color.RED);
        }else {
            status.setText(statusPesanan.getStatusPesanan());
        }
    }
}

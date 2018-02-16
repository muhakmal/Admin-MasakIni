package com.baskom.miadmin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 01/01/18.
 */

public class DalamProses implements Serializable {
    private String nomorPesanan;
    private String statusPesanan;
    private List<ItemKeranjang> isiPesanan = new ArrayList<>();
    private Pemesan pemesan;

    public DalamProses(String nomorPesanan, String statusPesanan, List<ItemKeranjang> isiPesanan, Pemesan pemesan) {
        this.nomorPesanan = nomorPesanan;
        this.statusPesanan = statusPesanan;
        this.isiPesanan = isiPesanan;
        this.pemesan = pemesan;
    }

    public String getNomorPesanan() {
        return nomorPesanan;
    }

    public void setNomorPesanan(String nomorPesanan) {
        this.nomorPesanan = nomorPesanan;
    }

    public String getStatusPesanan() {
        return statusPesanan;
    }

    public void setStatusPesanan(String statusPesanan) {
        this.statusPesanan = statusPesanan;
    }

    public List<ItemKeranjang> getIsiPesanan() {
        return isiPesanan;
    }

    public void setIsiPesanan(List<ItemKeranjang> isiPesanan) {
        this.isiPesanan = isiPesanan;
    }

    public Pemesan getPemesan() {
        return pemesan;
    }

    public void setPemesan(Pemesan pemesan) {
        this.pemesan = pemesan;
    }

    public int getTotalEstimasi(){
        int totalEstimasi = 0;
        for (int i = 0; i < isiPesanan.size(); i++){
            totalEstimasi += isiPesanan.get(i).getTotalHarga();
        }
        return totalEstimasi;
    }
}

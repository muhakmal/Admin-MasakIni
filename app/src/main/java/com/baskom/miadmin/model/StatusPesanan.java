package com.baskom.miadmin.model;

/**
 * Created by akmalmuhamad on 01/01/18.
 */

public class StatusPesanan {
    private String nomorPesanan;
    private String namaBahan;
    private String jumlahBahan;
    private String statusPesanan;

    public StatusPesanan(String nomorPesanan, String namaBahan, String jumlahBahan, String statusPesanan) {
        this.nomorPesanan = nomorPesanan;
        this.namaBahan = namaBahan;
        this.jumlahBahan = jumlahBahan;
        this.statusPesanan = statusPesanan;
    }

    public String getNomorPesanan() {
        return nomorPesanan;
    }

    public void setNomorPesanan(String nomorPesanan) {
        this.nomorPesanan = nomorPesanan;
    }

    public String getNamaBahan() {
        return namaBahan;
    }

    public void setNamaBahan(String namaBahan) {
        this.namaBahan = namaBahan;
    }

    public String getJumlahBahan() {
        return jumlahBahan;
    }

    public void setJumlahBahan(String jumlahBahan) {
        this.jumlahBahan = jumlahBahan;
    }

    public String getStatusPesanan() {
        return statusPesanan;
    }

    public void setStatusPesanan(String statusPesanan) {
        this.statusPesanan = statusPesanan;
    }
}
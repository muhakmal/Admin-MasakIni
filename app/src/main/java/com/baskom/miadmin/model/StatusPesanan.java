package com.baskom.miadmin.model;

/**
 * Created by akmalmuhamad on 01/01/18.
 */

public class StatusPesanan {
    private String nomorPesanan;
    private String namaBahanMasakan;
    private String jumlahPesanan;
    private String alamatPengiriman;
    private String harga;
    private String status;

    public StatusPesanan(String nomorPesanan, String namaBahanMasakan, String jumlahPesanan, String alamatPengiriman, String harga, String status) {
        this.nomorPesanan = nomorPesanan;
        this.namaBahanMasakan = namaBahanMasakan;
        this.jumlahPesanan = jumlahPesanan;
        this.alamatPengiriman = alamatPengiriman;
        this.harga = harga;
        this.status = status;
    }

    public String getNomorPesanan() {

        return nomorPesanan;
    }

    public void setNomorPesanan(String nomorPesanan) {
        this.nomorPesanan = nomorPesanan;
    }

    public String getNamaBahanMasakan() {
        return namaBahanMasakan;
    }

    public void setNamaBahanMasakan(String namaBahanMasakan) {
        this.namaBahanMasakan = namaBahanMasakan;
    }

    public String getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(String jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }

    public String getAlamatPengiriman() {
        return alamatPengiriman;
    }

    public void setAlamatPengiriman(String alamatPengiriman) {
        this.alamatPengiriman = alamatPengiriman;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
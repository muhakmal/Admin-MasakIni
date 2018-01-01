package com.baskom.miadmin.model;

/**
 * Created by akmalmuhamad on 01/01/18.
 */

public class StatusPesanan1 {
    private String nomorPesanan;
    private String[] statusFlag={"DITERIMA","DITOLAK"};

    public StatusPesanan1(String nomorPesanan, String[] statusFlag) {
        this.nomorPesanan = nomorPesanan;
        this.statusFlag = statusFlag;
    }

    public String getNomorPesanan() {
        return nomorPesanan;
    }

    public void setNomorPesanan(String nomorPesanan) {
        this.nomorPesanan = nomorPesanan;
    }

    public String[] getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(String[] statusFlag) {
        this.statusFlag = statusFlag;
    }
}

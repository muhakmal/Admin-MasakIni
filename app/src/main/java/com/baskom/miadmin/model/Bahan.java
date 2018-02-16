package com.baskom.miadmin.model;

import java.io.Serializable;

/**
 * Created by akmalmuhamad on 16/02/18.
 */

public class Bahan implements Serializable {
    private String nama;
    private String takaran;

    public Bahan(String nama, String takaran) {
        this.nama = nama;
        this.takaran = takaran;
    }

    public String getNama() {

        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTakaran() {
        return takaran;
    }

    public void setTakaran(String takaran) {
        this.takaran = takaran;
    }
}

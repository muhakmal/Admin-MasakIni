package com.baskom.miadmin.model;

import java.io.Serializable;

/**
 * Created by akmalmuhamad on 19/01/18.
 */

public class KelolaResep implements Serializable{
    private String urlImage;
    private String judulResep;

    public KelolaResep(String urlImage, String judulResep) {
        this.urlImage = urlImage;
        this.judulResep = judulResep;
    }

    public String getUrlImage() {

        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getJudulResep() {
        return judulResep;
    }

    public void setJudulResep(String judulResep) {
        this.judulResep = judulResep;
    }
}

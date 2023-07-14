package com.kelompok1.aplikasitanamanhias.model;

import java.io.Serializable;

/**
 * Created by Kelompok 1 on 2023
 */

public class ModelMain implements Serializable {

    String nama;
    String image;
    String deskripsi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}

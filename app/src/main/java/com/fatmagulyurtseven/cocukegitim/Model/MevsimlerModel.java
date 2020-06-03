package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 12.12.2018.
 */

public class MevsimlerModel {
    private int mevsimId;
    private String mevsimAdi;
    private String mevsimResim;
    private String mevsimSes;

    public MevsimlerModel(){

    }

    public MevsimlerModel(int mevsimId, String mevsimAdi, String mevsimResim, String mevsimSes) {
        this.mevsimId = mevsimId;
        this.mevsimAdi = mevsimAdi;
        this.mevsimResim = mevsimResim;
        this.mevsimSes = mevsimSes;
    }

    public int getMevsimId( ) {
        return mevsimId;
    }

    public void setMevsimId(int mevsimId) {
        this.mevsimId = mevsimId;
    }

    public String getMevsimAdi( ) {
        return mevsimAdi;
    }

    public void setMevsimAdi(String mevsimAdi) {
        this.mevsimAdi = mevsimAdi;
    }

    public String getMevsimResim( ) {
        return mevsimResim;
    }

    public void setMevsimResim(String mevsimResim) {
        this.mevsimResim = mevsimResim;
    }

    public String getMevsimSes( ) {
        return mevsimSes;
    }

    public void setMevsimSes(String mevsimSes) {
        this.mevsimSes = mevsimSes;
    }
}

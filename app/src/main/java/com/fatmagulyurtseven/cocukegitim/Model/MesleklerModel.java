package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 12.12.2018.
 */

public class MesleklerModel {
    private int meslekId;
    private String meslekAdi;
    private String meslekResmi;
    private String meslekSes;

    public MesleklerModel(){}

    public MesleklerModel(int meslekId, String meslekAdi, String meslekResmi, String meslekSes) {
        this.meslekId = meslekId;
        this.meslekAdi = meslekAdi;
        this.meslekResmi = meslekResmi;
        this.meslekSes = meslekSes;
    }

    public int getMeslekId( ) {
        return meslekId;
    }

    public void setMeslekId(int meslekId) {
        this.meslekId = meslekId;
    }

    public String getMeslekAdi( ) {
        return meslekAdi;
    }

    public void setMeslekAdi(String meslekAdi) {
        this.meslekAdi = meslekAdi;
    }

    public String getMeslekResmi( ) {
        return meslekResmi;
    }

    public void setMeslekResmi(String meslekResmi) {
        this.meslekResmi = meslekResmi;
    }

    public String getMeslekSes( ) {
        return meslekSes;
    }

    public void setMeslekSes(String meslekSes) {
        this.meslekSes = meslekSes;
    }
}

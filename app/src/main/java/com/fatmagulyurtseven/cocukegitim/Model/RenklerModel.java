package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 12.12.2018.
 */

public class RenklerModel {
    private int renkId;
    private String renkAdi;
    private String renkResmi;
    private String renkSes;

    public RenklerModel(){}

    public RenklerModel(int renkId, String renkAdi, String renkResmi, String renkSes) {
        this.renkId = renkId;
        this.renkAdi = renkAdi;
        this.renkResmi = renkResmi;
        this.renkSes = renkSes;
    }

    public int getRenkId( ) {
        return renkId;
    }

    public void setRenkId(int renkId) {
        this.renkId = renkId;
    }

    public String getRenkAdi( ) {
        return renkAdi;
    }

    public void setRenkAdi(String renkAdi) {
        this.renkAdi = renkAdi;
    }

    public String getRenkResmi( ) {
        return renkResmi;
    }

    public void setRenkResmi(String renkResmi) {
        this.renkResmi = renkResmi;
    }

    public String getRenkSes( ) {
        return renkSes;
    }

    public void setRenkSes(String renkSes) {
        this.renkSes = renkSes;
    }

}

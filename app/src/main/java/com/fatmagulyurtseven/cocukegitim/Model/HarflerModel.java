package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 12.12.2018.
 */

public class HarflerModel {
    private int harfId;
    private String harf;
    private String harfResmi;
    private String harfSesi;

    public HarflerModel(){

    }
    public HarflerModel(int harfId, String harf, String harfResmi, String harfSesi) {
        this.harfId = harfId;
        this.harf = harf;
        this.harfResmi = harfResmi;
        this.harfSesi = harfSesi;
    }

    public int getHarfId( ) {
        return harfId;
    }

    public void setHarfId(int harfId) {
        this.harfId = harfId;
    }

    public String getHarf( ) {
        return harf;
    }

    public void setHarf(String harf) {
        this.harf = harf;
    }

    public String getHarfResmi( ) {
        return harfResmi;
    }

    public void setHarfResmi(String harfResmi) {
        this.harfResmi = harfResmi;
    }

    public String getHarfSesi( ) {
        return harfSesi;
    }

    public void setHarfSesi(String harfSesi) {
        this.harfSesi = harfSesi;
    }
}

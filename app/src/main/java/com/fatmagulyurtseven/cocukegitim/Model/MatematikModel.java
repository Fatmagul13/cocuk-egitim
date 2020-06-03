package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 16.12.2018.
 */

public class MatematikModel {
    private int matId;
    private String islem;
    private String islemResmi;
    private String islemSes;

    public MatematikModel(){}

    public MatematikModel(int matId, String islem, String islemResmi, String islemSes) {
        this.matId = matId;
        this.islem = islem;
        this.islemResmi = islemResmi;
        this.islemSes = islemSes;
    }

    public int getMatId( ) {
        return matId;
    }

    public void setMatId(int matId) {
        this.matId = matId;
    }

    public String getIslem( ) {
        return islem;
    }

    public void setIslem(String islem) {
        this.islem = islem;
    }

    public String getIslemResmi( ) {
        return islemResmi;
    }

    public void setIslemResmi(String islemResmi) {
        this.islemResmi = islemResmi;
    }

    public String getIslemSes( ) {
        return islemSes;
    }

    public void setIslemSes(String islemSes) {
        this.islemSes = islemSes;
    }
}

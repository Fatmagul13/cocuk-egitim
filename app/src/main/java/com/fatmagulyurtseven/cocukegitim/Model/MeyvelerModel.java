package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 12.12.2018.
 */

public class MeyvelerModel {
    private int meyveId;
    private String meyveAdi;
    private String meyveResmi;
    private String meyveSes;

    public MeyvelerModel(){}

    public MeyvelerModel(int meyveId, String meyveAdi, String meyveResmi, String meyveSes) {
        this.meyveId = meyveId;
        this.meyveAdi = meyveAdi;
        this.meyveResmi = meyveResmi;
        this.meyveSes = meyveSes;
    }

    public int getMeyveId( ) {
        return meyveId;
    }

    public void setMeyveId(int meyveId) {
        this.meyveId = meyveId;
    }

    public String getMeyveAdi( ) {
        return meyveAdi;
    }

    public void setMeyveAdi(String meyveAdi) {
        this.meyveAdi = meyveAdi;
    }

    public String getMeyveResmi( ) {
        return meyveResmi;
    }

    public void setMeyveResmi(String meyveResmi) {
        this.meyveResmi = meyveResmi;
    }

    public String getMeyveSes( ) {
        return meyveSes;
    }

    public void setMeyveSes(String meyveSes) {
        this.meyveSes = meyveSes;
    }
}

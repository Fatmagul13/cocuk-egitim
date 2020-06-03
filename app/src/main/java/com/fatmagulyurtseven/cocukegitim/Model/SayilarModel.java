package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 11.12.2018.
 */

public class SayilarModel {
    private  int sayiId;
    private String sayiAdi;
    private int sayiNo;
    private String sayiOkunus;

    public  SayilarModel(){

    }

    public SayilarModel(int sayiId, String sayiAdi, int sayiNo, String sayiOkunus) {
        this.sayiId = sayiId;
        this.sayiAdi = sayiAdi;
        this.sayiNo = sayiNo;
        this.sayiOkunus = sayiOkunus;
    }

    public int getSayiId( ) {
        return sayiId;
    }

    public void setSayiId(int sayiId) {
        this.sayiId = sayiId;
    }

    public String getSayiAdi( ) {
        return sayiAdi;
    }

    public void setSayiAdi(String sayiAdi) {
        this.sayiAdi = sayiAdi;
    }

    public int getSayiNo( ) {
        return sayiNo;
    }

    public void setSayiNo(int sayiNo) {
        this.sayiNo = sayiNo;
    }

    public String getSayiOkunus( ) {
        return sayiOkunus;
    }

    public void setSayiOkunus(String sayiOkunus) {
        this.sayiOkunus = sayiOkunus;
    }
}

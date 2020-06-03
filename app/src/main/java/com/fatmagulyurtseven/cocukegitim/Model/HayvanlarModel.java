package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 12.12.2018.
 */

public class HayvanlarModel {
    private int hayvanId;
    private String hayvanAdi;
    private String hayvanResim;
    private String hayvanSes;

    public HayvanlarModel() {
    }

    public HayvanlarModel(int hayvanId, String hayvanAdi, String hayvanResim, String hayvanSes) {
        this.hayvanId = hayvanId;
        this.hayvanAdi = hayvanAdi;
        this.hayvanResim = hayvanResim;
        this.hayvanSes = hayvanSes;
    }

    public int getHayvanId() {
        return hayvanId;
    }

    public void setHayvanId(int hayvanId) {
        this.hayvanId = hayvanId;
    }

    public String getHayvanAdi() {
        return hayvanAdi;
    }

    public void setHayvanAdi(String hayvanAdi) {
        this.hayvanAdi = hayvanAdi;
    }

    public String getHayvanResim() {
        return hayvanResim;
    }

    public void setHayvanResim(String hayvanResim) {
        this.hayvanResim = hayvanResim;
    }

    public String getHayvanSes() {
        return hayvanSes;
    }

    public void setHayvanSes(String hayvanSes) {
        this.hayvanSes = hayvanSes;
    }
}

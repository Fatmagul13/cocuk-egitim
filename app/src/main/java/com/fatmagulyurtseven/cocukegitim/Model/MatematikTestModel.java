package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 19.12.2018.
 */

public class MatematikTestModel {
    private int matTestId;
    private String sonuc;
    private String matTestResim;

    public MatematikTestModel(){

    }

    public MatematikTestModel(int matTestId, String sonuc, String matTestResim) {
        this.matTestId = matTestId;
        this.sonuc = sonuc;
        this.matTestResim = matTestResim;
    }

    public int getMatTestId( ) {
        return matTestId;
    }

    public void setMatTestId(int matTestId) {
        this.matTestId = matTestId;
    }

    public String getSonuc( ) {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public String getMatTestResim( ) {
        return matTestResim;
    }

    public void setMatTestResim(String matTestResim) {
        this.matTestResim = matTestResim;
    }
}

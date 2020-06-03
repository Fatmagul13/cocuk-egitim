package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 17.12.2018.
 */

public class NumbersModel {
    private  int numberId;
    private int number;
    private String numberName;
    private String numberSound;

    public NumbersModel(){}

    public NumbersModel(int numberId, int number, String numberName, String numberSound) {
        this.numberId = numberId;
        this.number = number;
        this.numberName = numberName;
        this.numberSound = numberSound;
    }

    public int getNumberId( ) {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public int getNumber( ) {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNumberName( ) {
        return numberName;
    }

    public void setNumberName(String numberName) {
        this.numberName = numberName;
    }

    public String getNumberSound( ) {
        return numberSound;
    }

    public void setNumberSound(String numberSound) {
        this.numberSound = numberSound;
    }
}

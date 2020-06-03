package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 17.12.2018.
 */

public class DrinksModel {
    private  int drinkId;
    private String drinkName;
    private String drinkImage;
    private String drinkSound;

    public DrinksModel(){}

    public DrinksModel(int drinkId, String drinkName, String drinkImage, String drinkSound) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkImage = drinkImage;
        this.drinkSound = drinkSound;
    }

    public int getDrinkId( ) {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName( ) {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkImage( ) {
        return drinkImage;
    }

    public void setDrinkImage(String drinkImage) {
        this.drinkImage = drinkImage;
    }

    public String getDrinkSound( ) {
        return drinkSound;
    }

    public void setDrinkSound(String drinkSound) {
        this.drinkSound = drinkSound;
    }
}

package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 17.12.2018.
 */

public class ColorsModel {
    private  int colorId;
    private String colorName;
    private String colorImage;
    private String colorSound;

    public ColorsModel(){}

    public ColorsModel(int colorId, String colorName, String colorImage, String colorSound) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.colorImage = colorImage;
        this.colorSound = colorSound;
    }

    public int getColorId( ) {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName( ) {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorImage( ) {
        return colorImage;
    }

    public void setColorImage(String colorImage) {
        this.colorImage = colorImage;
    }

    public String getColorSound( ) {
        return colorSound;
    }

    public void setColorSound(String colorSound) {
        this.colorSound = colorSound;
    }
}

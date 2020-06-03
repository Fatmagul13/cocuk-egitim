package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 17.12.2018.
 */

public class FruitsModel {
    private  int fruitId;
    private String fruitName;
    private String fruitImage;
    private String fruitSound;

    public FruitsModel(){}

    public FruitsModel(int fruitId, String fruitName, String fruitImage, String fruitSound) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.fruitImage = fruitImage;
        this.fruitSound = fruitSound;
    }

    public int getFruitId( ) {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName( ) {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitImage( ) {
        return fruitImage;
    }

    public void setFruitImage(String fruitImage) {
        this.fruitImage = fruitImage;
    }

    public String getFruitSound( ) {
        return fruitSound;
    }

    public void setFruitSound(String fruitSound) {
        this.fruitSound = fruitSound;
    }
}

package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 17.12.2018.
 */

public class AnimalsModel {
    private  int animalId;
    private String animalName;
    private String animalImage;
    private String animalSound;

    public AnimalsModel(){}

    public AnimalsModel(int animalId, String animalName, String animalImage, String animalSound) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalImage = animalImage;
        this.animalSound = animalSound;
    }

    public int getAnimalId( ) {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName( ) {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalImage( ) {
        return animalImage;
    }

    public void setAnimalImage(String animalImage) {
        this.animalImage = animalImage;
    }

    public String getAnimalSound( ) {
        return animalSound;
    }

    public void setAnimalSound(String animalSound) {
        this.animalSound = animalSound;
    }
}

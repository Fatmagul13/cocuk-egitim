package com.fatmagulyurtseven.cocukegitim.Model;

/**
 * Created by Fatmagul on 17.12.2018.
 */

public class ObjectsModel {
    private  int objectId;
    private String objectName;
    private String objectImage;
    private String objectSound;

    public ObjectsModel(){

    }

    public ObjectsModel(int objectId, String objectName, String objectImage, String objectSound) {
        this.objectId = objectId;
        this.objectName = objectName;
        this.objectImage = objectImage;
        this.objectSound = objectSound;
    }

    public int getObjectId( ) {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public String getObjectName( ) {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectImage( ) {
        return objectImage;
    }

    public void setObjectImage(String objectImage) {
        this.objectImage = objectImage;
    }

    public String getObjectSound( ) {
        return objectSound;
    }

    public void setObjectSound(String objectSound) {
        this.objectSound = objectSound;
    }
}

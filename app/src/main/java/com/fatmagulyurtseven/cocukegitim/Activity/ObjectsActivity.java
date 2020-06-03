package com.fatmagulyurtseven.cocukegitim.Activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.fatmagulyurtseven.cocukegitim.Helper.DatabaseHelper;
import com.fatmagulyurtseven.cocukegitim.Model.ColorsModel;
import com.fatmagulyurtseven.cocukegitim.Model.ObjectsModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class ObjectsActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<ObjectsModel> objects;
    ImageView objectImage;
    TextView objectName;
    ImageButton backObject,nextObject,imgbtnsesObject;
    MediaPlayer objectSound;
    int objectIndis = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objects);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        backObject=findViewById(R.id.imgbtnGeriObjects);
        nextObject=findViewById(R.id.imgbtnIleriObjects);
        objectName = findViewById(R.id.txtIsimObjects);
        objectImage = (ImageView ) findViewById(R.id.imgResimObjects);
        imgbtnsesObject=findViewById(R.id.imgbtnSesObjects);

        backObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectSound.pause();
                if (objectIndis > 0) {
                    objectIndis--;
                    objectSounds();
                    objectInformation();

                }
                else if(objectIndis==0){
                    objectIndis=objects.size()-1;
                    objectSounds();
                    objectInformation();

                }
                else if(objectIndis<0){
                    objectIndis=objects.size()-1;
                    --objectIndis;
                    objectSounds();
                    objectInformation();

                }
            }
        });

        nextObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectSound.pause();
                if (objectIndis < objects.size()-1) {
                    objectIndis++;

                    objectSounds();
                    objectInformation();
                }
                else if (objectIndis == objects.size()-1) {
                    objectIndis = 0;
                    objectSounds();
                    objectInformation();

                }
            }
        });
        imgbtnsesObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                objectSounds();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        objects = dbHelper.getObjects();
        objectSounds();
        objectInformation();
    }

    public void objectInformation(){
        String s=objects.get(objectIndis).getObjectName();
        objectName.setText(s);
        int imgId = getResources().getIdentifier(objects.get(objectIndis).getObjectImage(), "drawable", this.getPackageName());
        objectImage.setImageResource(imgId);
    }
    public void objectSounds(){
        int renksesId=getResources().getIdentifier(objects.get(objectIndis).getObjectSound(),"raw",this.getPackageName());
        objectSound= MediaPlayer.create(ObjectsActivity.this,renksesId);
        objectSound.start();
    }
}

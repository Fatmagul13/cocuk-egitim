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
import com.fatmagulyurtseven.cocukegitim.Model.AnimalsModel;
import com.fatmagulyurtseven.cocukegitim.Model.HayvanlarModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class AnimalsActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<AnimalsModel> animals;
    ImageView animalsImage;
    ImageButton nextAnimals, backAnimals,imgbtnsesAnimals;
    TextView animalsName;
    int animalsIndis = 0;
    MediaPlayer ses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        backAnimals = findViewById(R.id.imgbtnGeriAnimals);
        nextAnimals = findViewById(R.id.imgbtnIleriAnimals);
        animalsName = findViewById(R.id.txtIsimAnimals);
        animalsImage = findViewById(R.id.imgResimAnimals);
        imgbtnsesAnimals = findViewById(R.id.imgbtnSesAnimals);

        backAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (animalsIndis > 0) {
                    animalsIndis--;
                    AnimalsSound();
                    AnimalInformation();



                }
                else if(animalsIndis==0){
                    animalsIndis=animals.size()-1;
                    AnimalsSound();
                    AnimalInformation();


                }
                else if(animalsIndis<0){
                    animalsIndis=animals.size()-1;
                    --animalsIndis;
                    AnimalsSound();
                    AnimalInformation();


                }
            }
        });
        nextAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (animalsIndis < animals.size()-1) {
                    animalsIndis++;
                    AnimalsSound();
                    AnimalInformation();



                }
                else if (animalsIndis == animals.size()-1) {
                    animalsIndis = 0;
                    AnimalsSound();
                    AnimalInformation();


                }
            }
        });
imgbtnsesAnimals.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AnimalsSound();
    }
});
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        animals = dbHelper.getAnimals();
        AnimalInformation();
        AnimalsSound();
    }
    public void AnimalInformation( ) {
        String s=animals.get(animalsIndis).getAnimalName();
        animalsName.setText(s);
        int imgId = getResources().getIdentifier(animals.get(animalsIndis).getAnimalImage(), "drawable", this.getPackageName());
        animalsImage.setImageResource(imgId);


    }
    public void AnimalsSound(){
        int hayvansesId=getResources().getIdentifier(animals.get(animalsIndis).getAnimalSound(),"raw",this.getPackageName());
        ses= MediaPlayer.create(AnimalsActivity.this,hayvansesId);
        ses.start();
    }
}

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
import com.fatmagulyurtseven.cocukegitim.Model.FruitsModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class FruitsActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    ArrayList<FruitsModel> fruits;
    ImageView fruitImage;
    TextView fruitName;
    ImageButton backFruit,nextFruit,imgbtnsesFruit;
    MediaPlayer fruitSound;
    int fruitIndis = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        backFruit=findViewById(R.id.imgbtnGeriFruits);
        nextFruit=findViewById(R.id.imgbtnIleriFruits);
        fruitName = findViewById(R.id.txtFruits);
        fruitImage = (ImageView ) findViewById(R.id.imgFruits);
        imgbtnsesFruit=findViewById(R.id.imgbtnSesFruits);

        backFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fruitSound.pause();
                if (fruitIndis > 0) {
                    fruitIndis--;
                    fruitSounds();
                    fruitInformation();


                }
                else if(fruitIndis==0){
                    fruitIndis=fruits.size()-1;
                    fruitSounds();
                    fruitInformation();

                }
                else if(fruitIndis<0){
                    fruitIndis=fruits.size()-1;
                    --fruitIndis;
                    fruitSounds();
                    fruitInformation();

                }
            }
        });
        nextFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fruitSound.pause();
                if (fruitIndis < fruits.size()-1) {
                    fruitIndis++;
                    fruitSounds();
                    fruitInformation();
                }
                else if (fruitIndis == fruits.size()-1) {
                    fruitIndis = 0;
                    fruitSounds();
                    fruitInformation();

                }
            }
        });
        imgbtnsesFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fruitSounds();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        fruits = dbHelper.getFruits();
        fruitSounds();
        fruitInformation();
    }

    public void fruitInformation(){
        String s=fruits.get(fruitIndis).getFruitName();
        fruitName.setText(s);
        int imgId = getResources().getIdentifier(fruits.get(fruitIndis).getFruitImage(), "drawable", this.getPackageName());
        fruitImage.setImageResource(imgId);
    }
    public void fruitSounds(){
        int renksesId=getResources().getIdentifier(fruits.get(fruitIndis).getFruitSound(),"raw",this.getPackageName());
        fruitSound= MediaPlayer.create(FruitsActivity.this,renksesId);
        fruitSound.start();
        fruitSound.start();
    }
}

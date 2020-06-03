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
import com.fatmagulyurtseven.cocukegitim.Model.DrinksModel;
import com.fatmagulyurtseven.cocukegitim.Model.HayvanlarModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<DrinksModel> drinks;
    ImageView drinksImage;
    ImageButton btnNextDrinks, btnBackDrinks,btnSesDrinks;
    TextView drinkName;
    int drinkIndis = 0;
    MediaPlayer ses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnBackDrinks = findViewById(R.id.imgbtnGeriDrinks);
        btnNextDrinks = findViewById(R.id.imgbtnIleriDrinks);
        drinkName = findViewById(R.id.txtIsimDrinks);
        drinksImage = findViewById(R.id.imgResimDrinks);
        btnSesDrinks = findViewById(R.id.imgbtnSesDrinks);
        btnBackDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (drinkIndis > 0) {
                    drinkIndis--;
                    DrinkSound();
                    DrinkInformation();



                }
                else if(drinkIndis==0){
                    drinkIndis=drinks.size()-1;
                    DrinkSound();
                    DrinkInformation();


                }
                else if(drinkIndis<0){
                    drinkIndis=drinks.size()-1;
                    --drinkIndis;
                    DrinkSound();
                    DrinkInformation();


                }
            }
        });
        btnNextDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (drinkIndis < drinks.size()-1) {
                    drinkIndis++;
                    DrinkSound();
                    DrinkInformation();



                }
                else if (drinkIndis == drinks.size()-1) {
                    drinkIndis = 0;
                    DrinkSound();
                    DrinkInformation();


                }
            }
        });
        btnSesDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DrinkSound();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        drinks = dbHelper.getDrinks();
        DrinkSound();
        DrinkInformation();
    }
    public void DrinkInformation( ) {
        String s=drinks.get(drinkIndis).getDrinkName();
        drinkName.setText(s);
        int imgId = getResources().getIdentifier(drinks.get(drinkIndis).getDrinkImage(), "drawable", this.getPackageName());
        drinksImage.setImageResource(imgId);


    }
    public void DrinkSound(){
        int sesId=getResources().getIdentifier(drinks.get(drinkIndis).getDrinkSound(),"raw",this.getPackageName());
        ses= MediaPlayer.create(DrinksActivity.this,sesId);
        ses.start();
    }

}

package com.fatmagulyurtseven.cocukegitim.Activity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.fatmagulyurtseven.cocukegitim.Helper.DatabaseHelper;
import com.fatmagulyurtseven.cocukegitim.Model.HayvanlarModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class HayvanlarActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<HayvanlarModel> hayvanlar;
    ImageView Resim;
    ImageButton btnIleriHayvanlar, btnGeriHayvanlar,btnSesHayvanlar;
    TextView hayvanAd;
    int hayvanIndis = 0;
    MediaPlayer ses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvanlar);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnGeriHayvanlar = findViewById(R.id.imgbtnGeriHayvan);
        btnIleriHayvanlar = findViewById(R.id.imgbtnIleriHayvan);
        hayvanAd = findViewById(R.id.txtIsimHayvanlar);
        Resim = findViewById(R.id.imgResimHayvanlar);
        btnSesHayvanlar = findViewById(R.id.imgbtnSesHayvan);

        btnSesHayvanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hayvansesleri();
            }
        });

        btnGeriHayvanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (hayvanIndis > 0) {
                    hayvanIndis--;
                    Hayvansesleri();
                    HayvanBilgisiGetir();



                }
                else if(hayvanIndis==0){
                    hayvanIndis=hayvanlar.size()-1;
                    Hayvansesleri();
                    HayvanBilgisiGetir();


                }
                else if(hayvanIndis<0){
                    hayvanIndis=hayvanlar.size()-1;
                    --hayvanIndis;
                    Hayvansesleri();
                    HayvanBilgisiGetir();


                }
            }
        });

        btnIleriHayvanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (hayvanIndis < hayvanlar.size()-1) {
                    hayvanIndis++;
                    Hayvansesleri();
                    HayvanBilgisiGetir();



                }
                else if (hayvanIndis == hayvanlar.size()-1) {
                    hayvanIndis = 0;
                    Hayvansesleri();
                    HayvanBilgisiGetir();


                }
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        hayvanlar = dbHelper.getHayvanlar();
        HayvanBilgisiGetir();
        Hayvansesleri();
    }
    public void HayvanBilgisiGetir( ) {
        String s=hayvanlar.get(hayvanIndis).getHayvanAdi();
        hayvanAd.setText(s);
        int imgId = getResources().getIdentifier(hayvanlar.get(hayvanIndis).getHayvanResim(), "drawable", this.getPackageName());
        Resim.setImageResource(imgId);


    }
    public void Hayvansesleri(){
        int hayvansesId=getResources().getIdentifier(hayvanlar.get(hayvanIndis).getHayvanSes(),"raw",this.getPackageName());
        ses= MediaPlayer.create(HayvanlarActivity.this,hayvansesId);
        ses.start();
    }
}

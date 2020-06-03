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
import com.fatmagulyurtseven.cocukegitim.Model.RenklerModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class RenklerActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<RenklerModel> renkler;
    ImageView RenkResmi;
    TextView renkAd;
    ImageButton geriRenkler,ileriRenkler,imgbtnsesRenk;
    MediaPlayer renkSes;
    int renkIndis = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renkler);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       imgbtnsesRenk=findViewById(R.id.imgbtnSesRenk);
        geriRenkler=findViewById(R.id.imgbtnGeriRenk);
        ileriRenkler=findViewById(R.id.imgbtnIleriRenk);
        renkAd = findViewById(R.id.txtRenkIsim);
        RenkResmi = (ImageView ) findViewById(R.id.imgRenkResim);
        imgbtnsesRenk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Renksesleri();
            }
        });

        geriRenkler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                renkSes.pause();
                if (renkIndis > 0) {
                    renkIndis--;
                    Renksesleri();
                    renkBilgisiGetir();


                }
                else if(renkIndis==0){
                    renkIndis=renkler.size()-1;
                    Renksesleri();
                    renkBilgisiGetir();

                }
                else if(renkIndis<0){
                    renkIndis=renkler.size()-1;
                    --renkIndis;
                    Renksesleri();
                    renkBilgisiGetir();

                }
            }
        });

        ileriRenkler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                renkSes.pause();
                if (renkIndis < renkler.size()-1) {
                    renkIndis++;

                    Renksesleri();
                    renkBilgisiGetir();
                }
                else if (renkIndis == renkler.size()-1) {
                    renkIndis = 0;
                    Renksesleri();
                    renkBilgisiGetir();

                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        renkler = dbHelper.getRenkler();
        renkBilgisiGetir();
        Renksesleri();

    }
    public void renkBilgisiGetir(){
        String s=renkler.get(renkIndis).getRenkAdi();
        renkAd.setText(s);
        int imgId = getResources().getIdentifier(renkler.get(renkIndis).getRenkResmi(), "drawable", this.getPackageName());
        RenkResmi.setImageResource(imgId);
    }
    public void Renksesleri(){
        int renksesId=getResources().getIdentifier(renkler.get(renkIndis).getRenkSes(),"raw",this.getPackageName());
        renkSes= MediaPlayer.create(RenklerActivity.this,renksesId);
        renkSes.start();
    }

}

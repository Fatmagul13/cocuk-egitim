package com.fatmagulyurtseven.cocukegitim.Activity;

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
import com.fatmagulyurtseven.cocukegitim.Model.MevsimlerModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class MevsimlerActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<MevsimlerModel> mevsimler;
    ImageView mevsimResmi;
    ImageButton btnMevsimIleri, btnMevsimGeri,btnSesMevsim;
    TextView mevsimAd;
    int mevsimIndis = 0;
    MediaPlayer ses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mevsimler);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnMevsimGeri =  findViewById(R.id.imgbtnGeriMevsim);
        btnMevsimIleri = findViewById(R.id.imgbtnIleriMevsim);
        mevsimAd =   findViewById(R.id.txtMevsimIsim);
        mevsimResmi =   findViewById(R.id.imgMevsim);
        btnSesMevsim = findViewById(R.id.imgbtnSesMevsim);
        btnSesMevsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MevsimSesleri();
            }
        });


        btnMevsimGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (mevsimIndis > 0) {
                    mevsimIndis--;
                    MevsimSesleri();
                    mevsimBilgisiGetir();


                }
                else if(mevsimIndis==0){
                    mevsimIndis=mevsimler.size()-1;
                    MevsimSesleri();
                    mevsimBilgisiGetir();

                }
                else if(mevsimIndis<0){
                    mevsimIndis=mevsimler.size()-1;
                    --mevsimIndis;
                    MevsimSesleri();
                    mevsimBilgisiGetir();

                }
            }
        });

        btnMevsimIleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (mevsimIndis < mevsimler.size()-1) {
                    mevsimIndis++;
                    MevsimSesleri();
                    mevsimBilgisiGetir();
                }
                else if (mevsimIndis == mevsimler.size()-1) {
                    mevsimIndis = 0;
                    MevsimSesleri();
                    mevsimBilgisiGetir();

                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       /* FloatingActionButton fab = ( FloatingActionButton ) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });*/

        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        mevsimler = dbHelper.getMevsimler();
        mevsimBilgisiGetir();
        MevsimSesleri();


    }
    public void mevsimBilgisiGetir(){
        String s=mevsimler.get(mevsimIndis).getMevsimAdi();
        mevsimAd.setText(s);
        int imgId = getResources().getIdentifier(mevsimler.get(mevsimIndis).getMevsimResim(), "drawable", this.getPackageName());
        mevsimResmi.setImageResource(imgId);
    }
    public void MevsimSesleri(){
        int mevsimsesId=getResources().getIdentifier(mevsimler.get(mevsimIndis).getMevsimSes(),"raw",this.getPackageName());
        ses= MediaPlayer.create(MevsimlerActivity.this,mevsimsesId);
        ses.start();
    }
}

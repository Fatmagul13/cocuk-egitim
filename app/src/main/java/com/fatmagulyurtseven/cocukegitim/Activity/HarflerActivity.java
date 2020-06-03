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
import com.fatmagulyurtseven.cocukegitim.Model.HarflerModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class HarflerActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    ArrayList<HarflerModel> harfler;
    ImageView HarfResim;
    ImageButton btnIleriHarfler, btnGeriHarfler,btnSesHarfler;
    TextView harfAd;
    int harfIndis = 0;
    Toolbar toolbar;
    MediaPlayer ses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harfler);
        toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnIleriHarfler = findViewById(R.id.imgbtnIleriHarfler);
        btnGeriHarfler = findViewById(R.id.imgbtnGeriHarfler);
        HarfResim = findViewById(R.id.imgHarfResim);
        btnSesHarfler = findViewById(R.id.imgbtnSesHarfler);

        btnSesHarfler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HarfSesleri();
            }
        });



        btnGeriHarfler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (harfIndis > 0) {
                    harfIndis--;
                    HarfSesleri();
                    HarfBilgisiGetir();
                }
                else if(harfIndis==0){
                    harfIndis=harfler.size()-1;
                    HarfSesleri();
                    HarfBilgisiGetir();
                }
                else if(harfIndis<0){
                    harfIndis=harfler.size()-1;
                    --harfIndis;
                    HarfSesleri();
                    HarfBilgisiGetir();
                }

            }
        });
        btnIleriHarfler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (harfIndis < harfler.size()-1) {
                    harfIndis++;
                    HarfSesleri();
                    HarfBilgisiGetir();
                }
                else if (harfIndis == harfler.size()-1) {
                    harfIndis = 0;
                    HarfSesleri();
                    HarfBilgisiGetir();
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        harfler = dbHelper.getHarfler();
        HarfBilgisiGetir();
        HarfSesleri();
    }
    public void HarfBilgisiGetir( ) {

        int imgharfId = getResources().getIdentifier(harfler.get(harfIndis).getHarfResmi(), "drawable", this.getPackageName());
        HarfResim.setImageResource(imgharfId);
    }
    public void HarfSesleri(){
        int harfsesId=getResources().getIdentifier(harfler.get(harfIndis).getHarfSesi(),"raw",this.getPackageName());
        ses= MediaPlayer.create(HarflerActivity.this,harfsesId);
        ses.start();
    }
}

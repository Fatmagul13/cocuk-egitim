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
import com.fatmagulyurtseven.cocukegitim.Model.MesleklerModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class MesleklerActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<MesleklerModel> meslekler;
    ImageView meslekResmi;
    ImageButton btnMeslekIleri, btnMeslekGeri,btnSesMeslek;
    TextView meslekAd;
    int meslekIndis = 0;
    MediaPlayer ses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meslekler);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnMeslekGeri = findViewById(R.id.imgbtnGeriMeslek);
        btnMeslekIleri = findViewById(R.id.imgbtnIleriMeslek);
        meslekAd = findViewById(R.id.txtMeslekIsim);
        meslekResmi = findViewById(R.id.imgMeslek);
        btnSesMeslek = findViewById(R.id.imgbtnSesMeslek);
        btnSesMeslek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeslekSesleri();
            }
        });

        btnMeslekGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (meslekIndis > 0) {
                    meslekIndis--;
                    MeslekSesleri();
                    meslekBilgisiGetir();


                }
                else if(meslekIndis==0){
                    meslekIndis=meslekler.size()-1;
                    MeslekSesleri();
                    meslekBilgisiGetir();

                }
                else if(meslekIndis<0){
                    meslekIndis=meslekler.size()-1;
                    --meslekIndis;
                    MeslekSesleri();
                    meslekBilgisiGetir();

                }
            }
        });
        btnMeslekIleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ses.pause();
                if (meslekIndis < meslekler.size()-1) {
                    meslekIndis++;
                    MeslekSesleri();
                    meslekBilgisiGetir();
                }
                else if (meslekIndis == meslekler.size()-1) {
                    meslekIndis = 0;
                    MeslekSesleri();
                    meslekBilgisiGetir();

                }
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        meslekler = dbHelper.getMeslekler();
        meslekBilgisiGetir();
        MeslekSesleri();
    }
    public void meslekBilgisiGetir(){
        String s=meslekler.get(meslekIndis).getMeslekAdi();
        meslekAd.setText(s);
        int imgId = getResources().getIdentifier(meslekler.get(meslekIndis).getMeslekResmi(), "drawable", this.getPackageName());
        meslekResmi.setImageResource(imgId);
    }
    public void MeslekSesleri(){
        int mesleksesıd=getResources().getIdentifier(meslekler.get(meslekIndis).getMeslekSes(),"raw",this.getPackageName());
        ses= MediaPlayer.create(MesleklerActivity.this,mesleksesıd);
        ses.start();
    }

}

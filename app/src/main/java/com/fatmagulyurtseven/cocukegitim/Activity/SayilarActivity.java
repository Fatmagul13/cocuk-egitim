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
import android.widget.TextView;
import android.widget.Toast;

import com.fatmagulyurtseven.cocukegitim.Helper.DatabaseHelper;
import com.fatmagulyurtseven.cocukegitim.Model.SayilarModel;

import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class SayilarActivity extends AppCompatActivity {
    int sayi=0;
    DatabaseHelper dbHelper;
    ArrayList<SayilarModel> sayilar;
    TextView txtSayi ;
    TextView txtYazilis;
    MediaPlayer ses;
    ImageButton geriSayilar,ileriSayilar,imgbtnses;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayilar);
        toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        geriSayilar=findViewById(R.id.imgbtnGeriSayi);
        ileriSayilar=findViewById(R.id.imgbtnIleriSayi);
        imgbtnses=findViewById(R.id.imgbtnSesSayi);
        txtSayi = findViewById(R.id.txtSayi);
        txtYazilis = findViewById(R.id.txtSayiYazilis);

          imgbtnses.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  sesler();
              }
          });

          geriSayilar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  ses.pause();
                  if (sayi > 0) {
                      --sayi;
                      txtSayi.setText(String.valueOf(sayi));
                      sesler();
                      sayiYaz();

                  } else if (sayi == 0) {
                      sayi = 20;
                      txtSayi.setText(String.valueOf(sayi));
                      sesler();
                      sayiYaz();

                  } else if (sayi < 0) {
                      sayi = 20;
                      --sayi;
                      txtSayi.setText(String.valueOf(sayi));
                      sesler();
                      sayiYaz();

                  }
              }
          });
          ileriSayilar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  ses.pause();
                  if (sayi < 20) {
                      ++sayi;
                      txtSayi.setText(String.valueOf(sayi));
                      sesler();
                      sayiYaz();

                  } else if (sayi == 20) {
                      sayi = 0;
                      txtSayi.setText(String.valueOf(sayi));
                      sesler();
                      sayiYaz();

                  }
              }
          });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        try
        {
            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }

        sayilar = dbHelper.getSayilar();

        sayiYaz();
        sesler();


        }

   public void sayiYaz(){
        String s=sayilar.get(sayi).getSayiAdi();
        txtYazilis.setText(s);
    }

    public void sesler(){
        int sesId=getResources().getIdentifier(sayilar.get(sayi).getSayiOkunus(),"raw",this.getPackageName());
        ses= MediaPlayer.create(SayilarActivity.this,sesId);
        ses.start();
    }

}

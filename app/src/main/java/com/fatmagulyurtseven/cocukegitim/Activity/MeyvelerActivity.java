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
import com.fatmagulyurtseven.cocukegitim.Model.MeyvelerModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;

public class MeyvelerActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<MeyvelerModel> meyveler;
    ImageView meyveResmi;
    ImageButton btnMeyveIleri, btnMeyveGeri,btnSesMeyve;
    TextView meyveAd;
    int meyveIndis = 0;
    MediaPlayer ses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meyveler);
        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnMeyveGeri = findViewById(R.id.imgbtnGeriMeyve);
        btnMeyveIleri = findViewById(R.id.imgbtnIleriMeyve);
        meyveAd = findViewById(R.id.txtMeyveIsim);
        meyveResmi = findViewById(R.id.imgMeyve);
        btnSesMeyve = findViewById(R.id.imgbtnSesMeyve);
        btnSesMeyve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeyveSesleri();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

     btnMeyveGeri.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             ses.pause();
             if (meyveIndis > 0) {
                 meyveIndis--;
                 MeyveSesleri();
                 meyveBilgisiGetir();
             }
             else if(meyveIndis==0){
                 meyveIndis=meyveler.size()-1;
                 MeyveSesleri();
                 meyveBilgisiGetir();
             }
             else if(meyveIndis<0){
                 meyveIndis=meyveler.size()-1;
                 --meyveIndis;
                 MeyveSesleri();
                 meyveBilgisiGetir();
             }
         }
     });

       btnMeyveIleri.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ses.pause();
               if (meyveIndis < meyveler.size()-1) {
                   meyveIndis++;
                   MeyveSesleri();
                   meyveBilgisiGetir();
               }
               else if (meyveIndis == meyveler.size()-1) {
                   meyveIndis = 0;
                   MeyveSesleri();
                   meyveBilgisiGetir();
               }
           }
       });
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        meyveler = dbHelper.getMeyveler();
        meyveBilgisiGetir();
        MeyveSesleri();
    }
    public void meyveBilgisiGetir(){
        String s=meyveler.get(meyveIndis).getMeyveAdi();
        meyveAd.setText(s);
        int imgId = getResources().getIdentifier(meyveler.get(meyveIndis).getMeyveResmi(), "drawable", this.getPackageName());
        meyveResmi.setImageResource(imgId);
    }
    public void  MeyveSesleri(){
        int meyvesesId=getResources().getIdentifier(meyveler.get(meyveIndis).getMeyveSes(),"raw",this.getPackageName());
        ses= MediaPlayer.create(MeyvelerActivity.this,meyvesesId);
        ses.start();
    }

}

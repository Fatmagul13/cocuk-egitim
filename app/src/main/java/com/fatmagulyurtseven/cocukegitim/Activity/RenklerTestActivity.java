package com.fatmagulyurtseven.cocukegitim.Activity;

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
import android.widget.Toast;

import com.fatmagulyurtseven.cocukegitim.Helper.DatabaseHelper;
import com.fatmagulyurtseven.cocukegitim.Model.MeyvelerModel;
import com.fatmagulyurtseven.cocukegitim.Model.RenklerModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RenklerTestActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<RenklerModel> renkler;
    ImageView renklerResim;
    ImageButton ileriSoruRenk, geriSoruRenk;
    Button secenekA,secenekB,secenekC,secenekD;
    int renkIndis = 0;
    String cevap;
    Random rnd = new Random();
    int uretilenSayi1 = rnd.nextInt(11);
    int uretilenSayi2 = rnd.nextInt(11);
    int uretilenSayi3 = rnd.nextInt(11);
    int uretilenSayi4 =rnd.nextInt(11);
    String a,b,c,d;
    TextView txtPuan;
    int puan=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_renkler_test );
        Toolbar toolbar = ( Toolbar ) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        secenekA = findViewById(R.id.btnRenklerA);
        secenekB = findViewById(R.id.btnRenklerB);
        secenekC = findViewById(R.id.btnRenklerC);
        secenekD = findViewById(R.id.btnRenklerD);
        renklerResim = findViewById(R.id.testRenklerRes);
        ileriSoruRenk=findViewById(R.id.ileriSoruRenkler);
        txtPuan = findViewById(R.id.txtPuanRenk);

        ileriSoruRenk.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secenekA.setBackgroundResource(R.color.colorTest);
                secenekB.setBackgroundResource(R.color.colorTest);
                secenekC.setBackgroundResource(R.color.colorTest);
                secenekD.setBackgroundResource(R.color.colorTest);

                secenekA.setEnabled( true );
                secenekB.setEnabled( true );
                secenekC.setEnabled( true );
                secenekD.setEnabled( true );

                if (renkIndis < renkler.size()-1) {
                    renkIndis++;
                    RenkBilgisiGetir();
                    secenekAta();

                }
                if (renkIndis == renkler.size()-1) {
                    //renkIndis = 0;
                    RenkBilgisiGetir();
                    secenekAta();

                        Toast.makeText( getApplicationContext(), "TEBRİKLER! TESTİ TAMAMLADINIZ.. PUANINIZ :" + puan, Toast.LENGTH_LONG ).show();


                }
            }
        } );
        secenekA.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secenekB.setEnabled( false );
                secenekC.setEnabled( false );
                secenekD.setEnabled( false );


                if (a== cevap ) {
                    secenekA.setBackgroundResource(R.color.green);
                    puan+=10;
                    txtPuan.setText(Integer.toString(puan));
                }
                else {
                    secenekA.setBackgroundResource(R.color.red);
                    if(puan>0){
                        puan-=10;
                    }
                    txtPuan.setText(Integer.toString(puan));
                }
            }
        } );
        secenekB.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secenekA.setEnabled( false );
                secenekC.setEnabled( false );
                secenekD.setEnabled( false );
                if (b== cevap ) {
                    secenekB.setBackgroundResource(R.color.green);
                    puan+=10;
                    txtPuan.setText(Integer.toString(puan));
                }
                else{
                    secenekB.setBackgroundResource(R.color.red);
                    if(puan>0){
                        puan-=10;
                    }
                    txtPuan.setText(Integer.toString(puan));
                }

            }
        } );
        secenekC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secenekB.setEnabled( false );
                secenekA.setEnabled( false );
                secenekD.setEnabled( false );
                if (c== cevap ) {
                    secenekC.setBackgroundResource(R.color.green);
                    puan+=10;
                    txtPuan.setText(Integer.toString(puan));
                }
                else  {
                    secenekC.setBackgroundResource(R.color.red);
                    if(puan>0){
                        puan-=10;
                    }
                    txtPuan.setText(Integer.toString(puan));
                }
            }
        } );
        secenekD.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secenekB.setEnabled( false );
                secenekC.setEnabled( false );
                secenekA.setEnabled( false );
                if(d==cevap ) {
                    secenekD.setBackgroundResource(R.color.green);
                    puan+=10;
                    txtPuan.setText(Integer.toString(puan));
                }
                else {
                    secenekD.setBackgroundResource(R.color.red);
                    if(puan>0){
                        puan-=10;
                    }
                    txtPuan.setText(Integer.toString(puan));
                }
            }
        } );
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        renkler = dbHelper.getRenkler();
        RenkBilgisiGetir();
        secenekAta();


        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }
    public void RenkBilgisiGetir( ) {

        String s=renkler.get(renkIndis).getRenkAdi();
        cevap= s.toString();
        int imgId = getResources().getIdentifier(renkler.get(renkIndis).getRenkResmi(), "drawable", this.getPackageName());
        renklerResim.setImageResource(imgId);

    }
    public void secenekAta(){


        sayiKontrol();

        a=renkler.get(uretilenSayi1).getRenkAdi();
        b=renkler.get(uretilenSayi2).getRenkAdi();
        c=renkler.get(uretilenSayi3).getRenkAdi();
        d=renkler.get(uretilenSayi4).getRenkAdi();

        while (a!=cevap && b!=cevap && c!=cevap && d!=cevap ) {
            uretilenSayi1 = rnd.nextInt(11);
            uretilenSayi2 = rnd.nextInt(11);
            uretilenSayi3 = rnd.nextInt(11);
            uretilenSayi4 =rnd.nextInt(11);
            sayiKontrol();
            a=renkler.get(uretilenSayi1).getRenkAdi();
            b=renkler.get(uretilenSayi2).getRenkAdi();
            c=renkler.get(uretilenSayi3).getRenkAdi();
            d=renkler.get(uretilenSayi4).getRenkAdi();
        }

        secenekA.setText(a);
        secenekB.setText(b);
        secenekC.setText(c);
        secenekD.setText(d);

    }
    public void sayiKontrol(){
        if(uretilenSayi1==uretilenSayi2){
            uretilenSayi2 = rnd.nextInt(11);
        }
        if(uretilenSayi1==uretilenSayi3||uretilenSayi2==uretilenSayi3){
            uretilenSayi3 = rnd.nextInt(11);
        }
        if(uretilenSayi1==uretilenSayi4||uretilenSayi2==uretilenSayi4||uretilenSayi3==uretilenSayi4){
            uretilenSayi4=rnd.nextInt(11);
        }
    }

}

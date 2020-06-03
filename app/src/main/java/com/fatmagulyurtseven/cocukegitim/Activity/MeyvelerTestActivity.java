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
import com.fatmagulyurtseven.cocukegitim.Model.ObjectsModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MeyvelerTestActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<MeyvelerModel> meyve;
    ImageView meyveResim;
    ImageButton ileriSoruMeyve;
    Button secenekA,secenekB,secenekC,secenekD;
    int meyveIndis = 0;
    String cevap;

    Random rnd = new Random();
    int uretilenSayi1 = rnd.nextInt(14);
    int uretilenSayi2 = rnd.nextInt(14);
    int uretilenSayi3 = rnd.nextInt(14);
    int uretilenSayi4 =rnd.nextInt(14);
    String a,b,c,d;
    TextView txtPuan;
    int puan=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_meyveler_test );
        Toolbar toolbar = ( Toolbar ) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        secenekA = findViewById(R.id.btnMeyvelerA);
        secenekB = findViewById(R.id.btnMeyvelerB);
        secenekC = findViewById(R.id.btnMeyvelerC);
        secenekD = findViewById(R.id.btnMeyvelerD);
        meyveResim = findViewById(R.id.testMeyveRes);
        ileriSoruMeyve=findViewById(R.id.ileriSoruMeyve);
        txtPuan = findViewById(R.id.txtPuanMeyve);
        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        meyve = dbHelper.getMeyveler();
        MeyveBilgisiGetir();
        secenekAta();
        ileriSoruMeyve.setOnClickListener( new View.OnClickListener() {
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

                if (meyveIndis < meyve.size()-1) {
                    meyveIndis++;
                    MeyveBilgisiGetir();
                    secenekAta();

                }
                if (meyveIndis == meyve.size()-1) {
                    //meyveIndis = 0;
                    MeyveBilgisiGetir();
                    secenekAta();
                    Toast.makeText(getApplicationContext(),"TEBRİKLER! TESTİ TAMAMLADINIZ.. PUANINIZ :"+puan, Toast.LENGTH_LONG).show();

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



        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }
    public void MeyveBilgisiGetir( ) {

        String s=meyve.get(meyveIndis).getMeyveAdi();
        cevap= s.toString();
        int imgId = getResources().getIdentifier(meyve.get(meyveIndis).getMeyveResmi(), "drawable", this.getPackageName());
        meyveResim.setImageResource(imgId);

    }
    public void secenekAta(){

        sayiKontrol();

        a=meyve.get(uretilenSayi1).getMeyveAdi();
        b=meyve.get(uretilenSayi2).getMeyveAdi();
        c=meyve.get(uretilenSayi3).getMeyveAdi();
        d=meyve.get(uretilenSayi4).getMeyveAdi();

        while (a!=cevap && b!=cevap && c!=cevap && d!=cevap ) {
            uretilenSayi1 = rnd.nextInt(14);
            uretilenSayi2 = rnd.nextInt(14);
            uretilenSayi3 = rnd.nextInt(14);
            uretilenSayi4 =rnd.nextInt(14);
            sayiKontrol();
            a=meyve.get(uretilenSayi1).getMeyveAdi();
            b=meyve.get(uretilenSayi2).getMeyveAdi();
            c=meyve.get(uretilenSayi3).getMeyveAdi();
            d=meyve.get(uretilenSayi4).getMeyveAdi();
        }

        secenekA.setText(a);
        secenekB.setText(b);
        secenekC.setText(c);
        secenekD.setText(d);

    }
    public void sayiKontrol(){
        if(uretilenSayi1==uretilenSayi2){
            uretilenSayi2 = rnd.nextInt(14);
        }
        if(uretilenSayi1==uretilenSayi3||uretilenSayi2==uretilenSayi3){
            uretilenSayi3 = rnd.nextInt(14);
        }
        if(uretilenSayi1==uretilenSayi4||uretilenSayi2==uretilenSayi4||uretilenSayi3==uretilenSayi4){
            uretilenSayi4=rnd.nextInt(14);
        }
    }

}

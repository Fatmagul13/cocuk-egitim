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
import com.fatmagulyurtseven.cocukegitim.Model.HayvanlarModel;
import com.fatmagulyurtseven.cocukegitim.Model.MatematikTestModel;
import com.fatmagulyurtseven.cocukegitim.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MatematikTestActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ArrayList<MatematikTestModel> matTest;
    ImageView matResim;
    ImageButton ileriSoruMat, geriSoruMat;
    Button secenekA,secenekB,secenekC,secenekD;
    int matIndis = 0;
    String cevap;
    Random rnd = new Random();
    int uretilenSayi1 = rnd.nextInt(10);
    int uretilenSayi2 = rnd.nextInt(10);
    int uretilenSayi3 = rnd.nextInt(10);
    int uretilenSayi4 =rnd.nextInt(10);
    String a,b,c,d;
    TextView txtPuan;
    int puan=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_matematik_test );
        Toolbar toolbar = ( Toolbar ) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        secenekA = findViewById(R.id.btnMatTestA);
        secenekB = findViewById(R.id.btnMatTestB);
        secenekC = findViewById(R.id.btnMatTestC);
        secenekD = findViewById(R.id.btnMatTestD);
        matResim = findViewById(R.id.testMatTestRes);
        ileriSoruMat=findViewById(R.id.ileriSoruMatTest);
        txtPuan = findViewById(R.id.txtPuanMat);

        try {

            dbHelper = new DatabaseHelper(getApplicationContext());

        } catch (IOException e) {
            e.printStackTrace();
        }
        matTest = dbHelper.getMatematikTest();
        MatTestBilgisiGetir();
        secenekAta();
        ileriSoruMat.setOnClickListener( new View.OnClickListener() {
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

                if (matIndis < matTest.size()-1) {
                    matIndis++;
                    MatTestBilgisiGetir();
                    secenekAta();

                }
                if (matIndis == matTest.size()-1) {
                    //matIndis = 0;
                    MatTestBilgisiGetir();
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
    public void MatTestBilgisiGetir( ) {
        String s=matTest.get(matIndis).getSonuc();
        cevap= s.toString();

        int imgId = getResources().getIdentifier(matTest.get(matIndis).getMatTestResim(), "drawable", this.getPackageName());
        matResim.setImageResource(imgId);


    }
    public void secenekAta(){


        sayiKontrol();

        a=matTest.get(uretilenSayi1).getSonuc();
        b=matTest.get(uretilenSayi2).getSonuc();
        c=matTest.get(uretilenSayi3).getSonuc();
        d=matTest.get(uretilenSayi4).getSonuc();

        while (a!=cevap && b!=cevap && c!=cevap && d!=cevap ) {
            uretilenSayi1 = rnd.nextInt(10);
            uretilenSayi2 = rnd.nextInt(10);
            uretilenSayi3 = rnd.nextInt(10);
            uretilenSayi4 =rnd.nextInt(10);
            sayiKontrol();
            a=matTest.get(uretilenSayi1).getSonuc();
            b=matTest.get(uretilenSayi2).getSonuc();
            c=matTest.get(uretilenSayi3).getSonuc();
            d=matTest.get(uretilenSayi4).getSonuc();
        }


        secenekA.setText(a);
        secenekB.setText(b);
        secenekC.setText(c);
        secenekD.setText(d);



    }
    public void sayiKontrol(){
        if(uretilenSayi1==uretilenSayi2){
            uretilenSayi2 = rnd.nextInt(10);
        }
        if(uretilenSayi1==uretilenSayi3||uretilenSayi2==uretilenSayi3){
            uretilenSayi3 = rnd.nextInt(10);
        }
        if(uretilenSayi1==uretilenSayi4||uretilenSayi2==uretilenSayi4||uretilenSayi3==uretilenSayi4){
            uretilenSayi4=rnd.nextInt(10);
        }
    }



}
